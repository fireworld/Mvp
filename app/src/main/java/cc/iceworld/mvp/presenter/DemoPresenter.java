package cc.iceworld.mvp.presenter;

import android.support.annotation.NonNull;

import cc.iceworld.mvp.api.IDemo;
import cc.iceworld.mvp.api.ILoginModel;
import cc.iceworld.mvp.bean.User;
import cc.iceworld.mvp.model.LoginModel;
import cc.iceworld.mvp.toolbox.TextTools;
import cc.iceworld.mvp.toolbox.net.WeakCallback;


/**
 * Created by cxx on 16-6-24.
 * xx.ch@outlook.com
 */
public class DemoPresenter extends BasePresenter<IDemo.View> implements IDemo.Presenter {
    private ILoginModel mModel = new LoginModel();
    private String mUsername;
    private String mPassword;

    public DemoPresenter(@NonNull IDemo.View view) {
        super(view);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // no data need init
    }

    @Override
    public void toLogin() {
        if (!checkToLogin()) return;
        mModel.login(mUsername, mPassword, new WeakCallback<IDemo.View, User>(mView) {
            @Override
            public void onStart(@NonNull IDemo.View view) {
                view.toast("login...");
                view.setSubmitEnabled(false);
            }

            @Override
            public void onSuccess(@NonNull IDemo.View view, @NonNull User user) {
                view.onLoginSuccess(user);
            }

            @Override
            public void onFailure(@NonNull IDemo.View view, int code, @NonNull String msg) {
                view.onLoginFailure(msg);
            }

            @Override
            public void onFinish(@NonNull IDemo.View view) {
                view.setSubmitEnabled(true);
            }
        });
    }

    private boolean checkToLogin() {
        boolean result = true;
        String username = mView.getUsername();
        if (TextTools.isEmpty(username)) {
            mView.setUsernameError("empty");
            result = false;
        }
        String password = mView.getPassword();
        if (TextTools.isEmpty(password) || password.length() < 6) {
            mView.setPasswordError("less than 6");
            result = false;
        }
        if (result) {
            mUsername = username;
            mPassword = password;
        }
        return result;
    }
}
