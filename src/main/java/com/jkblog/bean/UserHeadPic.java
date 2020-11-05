package com.jkblog.bean;

public class UserHeadPic {

    private Integer userId;

    private byte[] userHeaderPic;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public byte[] getUserHeaderPic() {
        return userHeaderPic;
    }

    public void setUserHeaderPic(byte[] userHeaderPic) {
        this.userHeaderPic = userHeaderPic;
    }
}
