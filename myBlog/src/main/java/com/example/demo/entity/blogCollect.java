package com.example.demo.entity;

// 博客收藏表
public class blogCollect {
    public int collectBlogId;   // 博客收藏ID
    public String createTime;      // 收藏创建时间
    public int blogId;         // 被收藏博客ID
    public int userId;         // 收藏用户ID

    public int getCollectBlogId() {
        return collectBlogId;
    }

    public void setCollectBlogId(int collectBlogId) {
        this.collectBlogId = collectBlogId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
