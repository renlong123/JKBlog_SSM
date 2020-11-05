package com.jkblog.mapper;

import com.jkblog.bean.UserHeadPic;

import java.io.InputStream;

public interface UserHeaderMapper {

    UserHeadPic getUserHeadPicById(Integer userId);

    int insetUserHeadPic(UserHeadPic userHeadPic);

    int updateUserHeadPic(UserHeadPic userHeadPic);

    int insertOrUpdate(UserHeadPic userHeadPic);
}
