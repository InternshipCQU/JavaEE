package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;

public interface userfavoritesService {
    void Init(HttpServletRequest request);

    String getallfavorites(HttpServletRequest request);

    void cancelFavorites(int blogId, int userId);

}
