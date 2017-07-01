package com.shuichan.pojo;

import java.util.Date;

public class Article {
	
	private Integer articleId;
	
	private String title;
	
	private String category;
	
	private Date publishTime;
	
	private Integer isAuditing;
	
	private String author;
	
	private Integer readCount;
	
	private String description;
	
	private String articleContent;
	
	private String titleImg;
	
	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}
	
	public Integer getIsAuditing() {
		return isAuditing;
	}

	public void setIsAuditing(Integer isAuditing) {
		this.isAuditing = isAuditing;
	}
	

}
