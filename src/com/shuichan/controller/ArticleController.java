package com.shuichan.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shuichan.pojo.Article;
import com.shuichan.pojo.User;
import com.shuichan.service.ArticleService;
import com.shuichan.service.impl.ArticleServiceImpl;


@Controller
@RequestMapping("/zhishiku")
public class ArticleController {
	
	public static java.sql.Date sqlCurrentTime(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String time = format.format(new Date());  
	    java.sql.Date timePara  = null; 
	    try {
			timePara = new java.sql.Date(format.parse(time).getTime());
	    } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    System.out.println(timePara);
	    return timePara;
	}

	@Resource
	private ArticleService articleService;
	
	@RequestMapping("/insertPage")
	public String insertPage(){
		return "insertArticle";
	}
	
	@RequestMapping("/auditPage")
	public String auditPage(HttpServletRequest request, Model model){
		List<Article> auditedArticles = articleService.selectArticleByIsAuditing(1);
		List<Article> auditingArticles = articleService.selectArticleByIsAuditing(0);
		model.addAttribute("auditedArticles", auditedArticles);
		model.addAttribute("auditingArticles", auditingArticles);
		return "isAuditing";
	}
	
	@RequestMapping("/articlePage")
	public String articlePage(HttpServletRequest request, Model model){
		List<Article> articles = articleService.selectArticleByIsAuditing(1);
		if(articles == null){
			model.addAttribute("articles","数据库没有文件");
			return "showArticle";
		}else{
			model.addAttribute("articles",articles);
			return "showArticle";
		}
	}
	
	@RequestMapping("/insertArticle")
	public String insertArticle(HttpServletRequest request, Model model){
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		Date publishTime = sqlCurrentTime();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String author = user.getUserName();
		String description = request.getParameter("description");
		String articleContent = request.getParameter("articleContent");
		Integer isAuditing = 0;
		
		Article article = new Article();
		article.setTitle(title);
		article.setCategory(category);
		article.setPublishTime(publishTime);
		article.setAuthor(author);
		article.setDescription(description);
		article.setArticleContent(articleContent);
		article.setIsAuditing(isAuditing);
		
		ArticleServiceImpl.printArticle(article);
		
		int result = articleService.insertArticleSelective(article);
		if(result == -1){
			model.addAttribute("result","插入失败"+result);
			return "shouye";
		}else{
			model.addAttribute("result","插入成功"+result);
			return "shouye";
		}
		
	}
	
	
	@RequestMapping(value="/isAuditing/{articleId}",method=RequestMethod.POST)
	public String isAuditing(@PathVariable Integer articleId, HttpServletRequest request, Model model){
		Article article = this.articleService.selectByPrimaryKey(articleId);
		if(article != null){
			article.setIsAuditing(1);
			int result = this.articleService.updateArticleIsAduiting(article);
			
			if(result == -1){
				model.addAttribute("result",article.getTitle()+"审核失败"+result);		
			}else{
				model.addAttribute("result",article.getTitle()+"审核成功"+result);
			}
		}	
		return "forward:/zhishiku/auditPage";
	}
	
	

}
