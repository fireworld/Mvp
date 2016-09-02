package cc.iceworld.mvp.toolbox.net;

import android.support.annotation.NonNull;

/**
 * Created by cxx on 16/7/13.
 * xx.ch@outlook.com
 */
public interface Callback<T> {

    void onStart();

    void onSuccess(@NonNull T t);

    void onFailure(int code, @NonNull String msg);

    void onFinish();
}
