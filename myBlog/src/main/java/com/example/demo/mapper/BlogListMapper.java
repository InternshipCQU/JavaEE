package com.example.demo.mapper;

public interface BlogListMapper {
    void deletecollect(Integer blogId,Integer userId);
    void deletebloglike(Integer blogId,Integer userId);
    void deleteblogcomment(Integer blogId,Integer userId);
    void deleteblogforward(Integer blogId,Integer userId);
    void deletetagbloginfo(Integer blogId,Integer userId);
    void deletebloginfo(Integer blogId,Integer userId);
}
