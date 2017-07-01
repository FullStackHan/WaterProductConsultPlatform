package com.shuichan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shuichan.dao.ArticleDao;
import com.shuichan.pojo.Article;
import com.shuichan.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleDao articleDao;
	
	public static StringBuffer printArticle(Article article){
		StringBuffer strBuf= new StringBuffer();
		if(article.getArticleId()!=null){
			strBuf.append("articleId: " + article.getArticleId());
		}
		strBuf.append(",title：" + article.getTitle());
		strBuf.append(",category：" + article.getCategory());
		strBuf.append(",author：" + article.getAuthor());
		strBuf.append(",publishTime：" + article.getPublishTime());
		strBuf.append(",description：" + article.getDescription());
		strBuf.append(",articleContent：" + article.getArticleContent());
		System.out.println(strBuf.toString());
		return strBuf;
	}
	
	@Override
	public Article selectByPrimaryKey(Integer articleId) {
		Article article = this.articleDao.selectByPrimaryKey(articleId);
		printArticle(article);
		if(article != null){
			return article;
		}else{
			return null;
		}	
	}

	@Override
	public List<Article> selectArticles() {
		List<Article> articles = this.articleDao.selectArticles();
		if(articles != null){
			return articles;
		}else{
			return null;
		}
	}

	@Override
	public List<Article> selectByTitle(String selectInfo) {
		List<Article> articlesByTitle = this.articleDao.selectByTitle(selectInfo);
		if(articlesByTitle != null){
			return articlesByTitle;
		}else{
			return null;
		}
	}

	@Override
	public List<Article> selectByCategory(String category) {
		List<Article> articlesByCategory = this.articleDao.selectByCategory(category);
		if(articlesByCategory != null){
			return articlesByCategory;
		}else{
			return null;
		}
	}

	@Override
	public List<Article> selectByReadCountDesc() {
		List<Article> articlesByReadCountDesc = this.articleDao.selectByReadCountDesc();
		if(articlesByReadCountDesc != null){
			return articlesByReadCountDesc;
		}else{
			return null;
		}
	}

	@Override
	public List<Article> selectByCategoryAndReadCountDesc(String category) {
		List<Article> articlesByCategoryAndReadCountDesc = this.articleDao.selectByCategory(category);
		if(articlesByCategoryAndReadCountDesc != null){
			return articlesByCategoryAndReadCountDesc;
		}else{
			return null;
		}
	}
	
	
	@Override
	public List<Article> selectArticleByIsAuditing(Integer isAuditing) {
		List<Article> articlesByIsAuditing= this.articleDao.selectArticleByIsAuditing(isAuditing);
		if(articlesByIsAuditing != null){
			return articlesByIsAuditing;
		}else{
			return null;
		}
	}
	
	
	@Override
	public int insertArticle(Article article) {
			int result = this.articleDao.insertArticle(article);
			return result;
		
	}

	@Override
	public int insertArticleSelective(Article article) {
			int result = this.articleDao.insertArticle(article);
			return result;
	}

	@Override
	public int deleteArticleByPrimaryKey(Integer articleId) {
		if(this.selectByPrimaryKey(articleId) == null){
			System.out.println("不存在该文章");
			return -1;
		}else{
			int result = this.articleDao.deleteArticleByPrimaryKey(articleId);
			return result;
		}
	}

	@Override
	public int updateArticleByPrimaryKey(Article article) {
		if(this.selectByPrimaryKey(article.getArticleId()) == null){
			System.out.println("不存在该文章");
			return -1;
		}else{
			int result = this.articleDao.updateArticleByPrimaryKey(article);
			return result;
		}
	}

	@Override
	public int updateArticleByPrimaryKeySelective(Article article) {
		if(this.selectByPrimaryKey(article.getArticleId()) == null){
			System.out.println("不存在该文章");
			return -1;
		}else{
			int result = this.articleDao.updateArticleByPrimaryKeySelective(article);
			return result;
		}
	}

	@Override
	public int updateArticleIsAduiting(Article article) {
		if(this.selectByPrimaryKey(article.getArticleId()) == null){
			System.out.println("不存在该文章");
			return -1;
		}else{
			int result = this.articleDao.updateArticleIsAduiting(article);
			return result;
		}
	}

}
