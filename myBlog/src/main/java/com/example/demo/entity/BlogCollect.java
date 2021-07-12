package com.example.demo.entity;

// 博客收藏表
public class BlogCollect {
    public Integer collectBlogId;   // 博客收藏ID
    public String createTime;      // 收藏创建时间
    public Integer blogId;         // 被收藏博客ID
    public Integer userId;         // 收藏用户ID

    public Integer getCollectBlogId() {
        return collectBlogId;
    }

    public void setCollectBlogId(Integer collectBlogId) {
        this.collectBlogId = collectBlogId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
