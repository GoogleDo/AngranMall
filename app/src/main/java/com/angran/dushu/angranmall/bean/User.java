package com.angran.dushu.angranmall.bean;

/**
 * author: Create By dushu on 2019/2/24 13:14
 * email : dushu@bytedance.com
 */
public class User {

    private String user_id;
    private String user_name;
    private String user_password;
    private String user_phone_numer;
    private String user_label;//标签
    private String user_company;//公司
    private String user_post;//职务
    private boolean user_authentication_status;//实名认证状态

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_phone_numer() {
        return user_phone_numer;
    }

    public void setUser_phone_numer(String user_phone_numer) {
        this.user_phone_numer = user_phone_numer;
    }

    public String getUser_label() {
        return user_label;
    }

    public void setUser_label(String user_label) {
        this.user_label = user_label;
    }

    public String getUser_company() {
        return user_company;
    }

    public void setUser_company(String user_company) {
        this.user_company = user_company;
    }

    public String getUser_post() {
        return user_post;
    }

    public void setUser_post(String user_post) {
        this.user_post = user_post;
    }

    public boolean isUser_authentication_status() {
        return user_authentication_status;
    }

    public void setUser_authentication_status(boolean user_authentication_status) {
        this.user_authentication_status = user_authentication_status;
    }
}
