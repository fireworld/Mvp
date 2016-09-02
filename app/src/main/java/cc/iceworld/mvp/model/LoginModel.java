package cc.iceworld.mvp.model;

import android.os.AsyncTask;
import android.os.SystemClock;

import cc.iceworld.mvp.api.ILoginModel;
import cc.iceworld.mvp.bean.User;
import cc.iceworld.mvp.toolbox.net.Callback;


/**
 * Created by cxx on 16/7/13.
 * xx.ch@outlook.com
 */
public class LoginModel implements ILoginModel {
    public static final String USER_NAME = "cxx";
    public static final String USER_PASSWORD = "123456";

    public void login(final String username, final String password, final Callback<User> callback) {
        new AsyncTask<String, Void, Boolean>() {
            @Override
            protected void onPreExecute() {
                callback.onStart();
            }

            @Override
            protected Boolean doInBackground(String... strings) {
                SystemClock.sleep(1500);
                return USER_NAME.equals(strings[0]) && USER_PASSWORD.equals(strings[1]);
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                if (aBoolean) {
                    callback.onSuccess(new User(username, password));
                } else {
                    callback.onFailure(-1, "username or password error");
                }
                callback.onFinish();
            }
        }.execute(username, password);
    }
}
