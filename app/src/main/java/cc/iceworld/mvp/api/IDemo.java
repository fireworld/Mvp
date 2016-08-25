package cc.iceworld.mvp.api;

import android.support.annotation.NonNull;

import cc.iceworld.mvp.bean.User;


public interface IDemo {
    /**
     * Created by cxx on 16-6-24.
     * xx.ch@outlook.com
     */
    interface Presenter extends IBase.Presenter {

        void toLogin();
    }

    interface View extends IBase.View<Presenter> {

        String getUsername();

        String getPassword();

        void setSubmitEnabled(boolean enabled);

        void setUsernameError(@NonNull String tip);

        void setPasswordError(@NonNull String tip);

        void onLoginSuccess(@NonNull User user);

        void onLoginFailure(String msg);
    }
}
