package com.shuichan.dao;

import java.util.List;

import com.shuichan.pojo.Article;

public interface ArticleDao {

	int insertArticle(Article article);
	
	int insertArticleSelective(Article article);
	
	int deleteArticleByPrimaryKey(Integer articleId);
	
	int updateArticleByPrimaryKey(Article article);
	
	int updateArticleIsAduiting(Article article);
	
	int updateArticleByPrimaryKeySelective(Article article);
	
	Article selectByPrimaryKey(Integer articleId);
	
	List<Article> selectArticleByIsAuditing(Integer isAuditing);
	
	List<Article> selectArticles();
	
	List<Article> selectByTitle(String selectInfo);
	
	List<Article> selectByCategory(String category);
	
	List<Article> selectByReadCountDesc();
	
	List<Article> selectByCategoryAndReadCountDesc(String category);
	
}
