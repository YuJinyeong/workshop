package com.ssafy.webex.model;

public class UserDao {
    // singleton design pattern
    private static UserDao dao = new UserDao();

    private UserDao() {}

    public static UserDao getDao() {
        return dao;
    }

    public boolean login(String id, String pass) {
        // 원래는 DB 가고 싶었어요...
        return "ssafy".equals(id) && "1234".equals(pass);
    }
}
