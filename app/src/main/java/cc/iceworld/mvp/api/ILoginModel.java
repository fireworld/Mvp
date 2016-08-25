package cc.iceworld.mvp.api;


import cc.iceworld.mvp.bean.User;
import cc.iceworld.mvp.net.Callback;

/**
 * Created by cxx on 16/7/13.
 * xx.ch@outlook.com
 */
public interface ILoginModel {

    void login(String username, String password, Callback<User> callback);
}
