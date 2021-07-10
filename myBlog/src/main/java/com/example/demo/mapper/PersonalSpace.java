package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.entity.blogInfo;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Mapper
public interface PersonalSpace {
    // 显示粉丝
    List<User> showFans(int userId);

    // 显示所有博客
    List<blogInfo> showUsersBlog(int userId);

    // 【数据可视化】类似github的日历热度图展示
    List<blogInfo> showCalendarFigure(int userId);

    // 【数据可视化】各标签博客数量统计图（可用饼状图展示）
    // 【暂定5个标签，可再加】
    // 标签1
    List<blogInfo> showTag1Blogs(int userId);

    // 标签2
    List<blogInfo> showTag2Blogs(int userId);

    // 标签3
    List<blogInfo> showTag3Blogs(int userId);

    // 标签4
    List<blogInfo> showTag4Blogs(int userId);

    // 标签5
    List<blogInfo> showTag5Blogs(int userId);
}
