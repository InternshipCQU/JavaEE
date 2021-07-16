package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.entity.view.CommentView;
import com.example.demo.mapper.BlogDetailsMapper;
import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.profileMapper;
import com.example.demo.service.BlogService;
import com.example.demo.utils.GetTime;
import com.example.demo.utils.TagMap;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
@Service("BlogService")
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Resource
    profileMapper profileMapper;

    @Resource
    BlogDetailsMapper blogDetailsMapper;

    @Override
    public BlogInfo getBlog(int blogId) {
        return blogMapper.getBlog(blogId);
    }

    @Override
    public String like(int blogId) {
        blogMapper.like(blogId);
        return "点赞成功";
    }

    @Override
    public void writelikerecord(int blogId,int userId){
        blogMapper.writelikerecord(blogId,userId);
    }

    @Override
    public void deletelikerecord(int blogId,int userId){
        blogMapper.deletelikerecord(blogId,userId);
    }

    @Override
    public boolean isliked(int blogId,int userId){
        Integer f=blogMapper.isliked(blogId,userId);
        if (f==0){
            return false;
        }
        else return true;

    }
    @Override
    public void cancelLike(int blogId) {
        blogMapper.cancelLike(blogId);
    }

    @Override
    public String comment(int blogId, int userId, String comment) {
        GetTime getTime = new GetTime();
        System.out.println(getTime.getCurrentTime());
        blogMapper.comment(blogId, userId, getTime.getCurrentTime(), comment);
        return "评论成功";
    }

    @Override
    public String forward(int blogId, int userId) {
        GetTime getTime = new GetTime();
        blogMapper.forward(blogId, userId, getTime.getCurrentTime());
        return "转发成功";
    }

    @Override
    public String collect(int blogId, int userId) {
        GetTime getTime = new GetTime();
        blogMapper.collect(blogId, userId, getTime.getCurrentTime());
        return "收藏成功";
    }

    @Override
    public List<BlogLike> searchLikeBlog(int userId) {
        return blogMapper.searchLikeBlog(userId);
    }

    @Override
    public void updateMarkWhenLike(int tagId, int userId) {
        TagMap map = new TagMap();
        blogMapper.updateMarkWhenLike(map.getTagName(tagId), userId);
    }

    @Override
    public void updateMarkWhenCancelLike(int tagId, int userId) {
        TagMap map = new TagMap();
        blogMapper.updateMarkWhenCancelLike(map.getTagName(tagId), userId);
    }

    @Override
    public void updateMarkWhenComment(int tagId, int userId) {
        TagMap map = new TagMap();
        blogMapper.updateMarkWhenComment(map.getTagName(tagId), userId);
    }

    @Override
    public void updateMarkWhenForward(int tagId, int userId) {
        TagMap map = new TagMap();
        blogMapper.updateMarkWhenForward(map.getTagName(tagId), userId);
    }

    @Override
    public void updateMarkWhenCollect(int tagId, int userId) {
        TagMap map = new TagMap();
        blogMapper.updateMarkWhenCollect(map.getTagName(tagId), userId);
    }

    @Override
    public String getAuthorName(int userId, Model model) {
        User user = profileMapper.getUser(userId);
        model.addAttribute("AuthorName",user.getUsername());
        return null;
    }

    @Override
    public String giveTheCommentsToBlog(int blogId, HttpServletRequest request) {

        List<BlogCommentVo> commentList = blogDetailsMapper.showBlogComment(blogId);

        if(commentList == null){
            return "{\"noMore\" : \"True\"}";
        }

        //====生成comment json
        String comments = "";
        String comment = "";
        int commentCount = 0;

        if(commentList != null){
            for (BlogCommentVo cv : commentList) {

                if (commentCount == 3) {
                    break;
                }
                comment = "\"username\":" + "\"" + cv.getUsername() + "\"" + "," + "\"commentContent\":" + "\"" + cv.getCommentContext() + "\""+ "," + "\"commentTime\":" + "\"" + cv.getCreateTime() + "\""+ "," + "\"userAvatar\":" + "\"" + cv.getAvatar() + "\"";
                comment = "{" + comment + "}";
                if (commentCount == 0) {
                    comments = comments + comment;
                } else {
                    comments = comments + "," + comment;
                }
                commentCount++;
            }
        }
        comments = "[" + comments + "]";


        return  "{\"comments\":" + comments + "}";
    }


}
