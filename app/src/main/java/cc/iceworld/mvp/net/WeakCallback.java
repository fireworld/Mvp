package cc.iceworld.mvp.net;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

import cc.iceworld.mvp.api.IBase;


/**
 * Created by cxx on 16/7/13.
 * xx.ch@outlook.com
 */
public abstract class WeakCallback<V extends IBase.View, T> implements Callback<T> {
    private WeakReference<V> ref;

    public WeakCallback(V view) {
        this.ref = new WeakReference<>(view);
    }

    @Nullable
    private V getView() {
        return ref != null ? ref.get() : null;
    }

    private static boolean isEnable(IBase.View v) {
        return v != null && v.isActive();
    }

    @Override
    public final void onStart() {
        V v = getView();
        if (isEnable(v)) {
            onStart(v);
        }
    }

    @Override
    public final void onSuccess(@NonNull T t) {
        V v = getView();
        if (isEnable(v)) {
            onSuccess(v, t);
        }
    }

    @Override
    public final void onFailure(int code, @NonNull String msg) {
        V v = getView();
        if (isEnable(v)) {
            onFailure(v, code, msg);
        }
    }

    @Override
    public final void onFinish() {
        V v = getView();
        if (isEnable(v)) {
            onFinish(v);
        }
    }

    public void onStart(@NonNull V view) {

    }

    public abstract void onSuccess(@NonNull V view, @NonNull T t);

    public abstract void onFailure(@NonNull V view, int code, @NonNull String msg);

    public void onFinish(@NonNull V view) {

    }
}
