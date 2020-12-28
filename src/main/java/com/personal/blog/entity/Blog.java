package com.personal.blog.entity;

import java.util.Date;

/**
 * blog
 * 
 * @author bianj
 * @version 1.0.0 2020-12-18
 */
public class Blog implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -4137236294456461729L;

    /* This code was generated by TableGo tools, mark 1 begin. */

    /** id */
    private Integer id;

    /** title */
    private String title;

    /** summary */
    private String summary;

    /** content */
    private String content;

    /** publishDate */
    private Date publishDate;

    /** columnId */
    private Integer columnId;

    /** views */
    private Integer views;

    /** tags */
    private String tags;

    /** comments */
    private String comments;

    /** blogImg */
    private String blogImg;

    /** blogState */
    private Integer blogState;

    /** admireState */
    private Integer admireState;

    /** commentState */
    private Integer commentState;

    /** recommendState */
    private Integer recommendState;

    /** reprintState */
    private Integer reprintState;

    /** createTime */
    private Date createTime;

    private Date updateTime;

    /* This code was generated by TableGo tools, mark 1 end. */

    /* This code was generated by TableGo tools, mark 2 begin. */

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                ", columnId=" + columnId +
                ", views=" + views +
                ", tags='" + tags + '\'' +
                ", comments='" + comments + '\'' +
                ", blogImg='" + blogImg + '\'' +
                ", blogState=" + blogState +
                ", admireState=" + admireState +
                ", commentState=" + commentState +
                ", recommendState=" + recommendState +
                ", reprintState=" + reprintState +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    /**
     * 获取id
     * 
     * @return id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置id
     * 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取title
     * 
     * @return title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置title
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取summary
     * 
     * @return summary
     */
    public String getSummary() {
        return this.summary;
    }

    /**
     * 设置summary
     * 
     * @param summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 获取content
     * 
     * @return content
     */
    public String getContent() {
        return this.content;
    }

    /**
     * 设置content
     * 
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取publishDate
     * 
     * @return publishDate
     */
    public Date getPublishDate() {
        return this.publishDate;
    }

    /**
     * 设置publishDate
     * 
     * @param publishDate
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 获取columnId
     * 
     * @return columnId
     */
    public Integer getColumnId() {
        return this.columnId;
    }

    /**
     * 设置columnId
     * 
     * @param columnId
     */
    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    /**
     * 获取views
     * 
     * @return views
     */
    public Integer getViews() {
        return this.views;
    }

    /**
     * 设置views
     * 
     * @param views
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     * 获取tags
     * 
     * @return tags
     */
    public String getTags() {
        return this.tags;
    }

    /**
     * 设置tags
     * 
     * @param tags
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * 获取comments
     * 
     * @return comments
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * 设置comments
     * 
     * @param comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * 获取blogImg
     * 
     * @return blogImg
     */
    public String getBlogImg() {
        return this.blogImg;
    }

    /**
     * 设置blogImg
     * 
     * @param blogImg
     */
    public void setBlogImg(String blogImg) {
        this.blogImg = blogImg;
    }

    /**
     * 获取blogState
     * 
     * @return blogState
     */
    public Integer getBlogState() {
        return this.blogState;
    }

    /**
     * 设置blogState
     * 
     * @param blogState
     */
    public void setBlogState(Integer blogState) {
        this.blogState = blogState;
    }

    /**
     * 获取admireState
     * 
     * @return admireState
     */
    public Integer getAdmireState() {
        return this.admireState;
    }

    /**
     * 设置admireState
     * 
     * @param admireState
     */
    public void setAdmireState(Integer admireState) {
        this.admireState = admireState;
    }

    /**
     * 获取commentState
     * 
     * @return commentState
     */
    public Integer getCommentState() {
        return this.commentState;
    }

    /**
     * 设置commentState
     * 
     * @param commentState
     */
    public void setCommentState(Integer commentState) {
        this.commentState = commentState;
    }

    /**
     * 获取recommendState
     * 
     * @return recommendState
     */
    public Integer getRecommendState() {
        return this.recommendState;
    }

    /**
     * 设置recommendState
     * 
     * @param recommendState
     */
    public void setRecommendState(Integer recommendState) {
        this.recommendState = recommendState;
    }

    /**
     * 获取reprintState
     * 
     * @return reprintState
     */
    public Integer getReprintState() {
        return this.reprintState;
    }

    /**
     * 设置reprintState
     * 
     * @param reprintState
     */
    public void setReprintState(Integer reprintState) {
        this.reprintState = reprintState;
    }

    /**
     * 获取createTime
     * 
     * @return createTime
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置createTime
     * 
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /* This code was generated by TableGo tools, mark 2 end. */

    /**
     * 获取updateTime
     *
     * @return
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置updateTime
     *
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}