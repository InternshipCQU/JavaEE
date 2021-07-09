package com.example.demo.entity;

// 博客收藏表
public class blogCollect {
    public String collectBlogId;   // 博客收藏ID
    public String createTime;      // 收藏创建时间
    public String blogId;         // 被收藏博客ID
    public String userId;         // 收藏用户ID

    public String getCollectBlogId() {
        return collectBlogId;
    }

    public void setCollectBlogId(String collectBlogId) {
        this.collectBlogId = collectBlogId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
