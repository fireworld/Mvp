package cc.iceworld.mvp.presenter;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import cc.iceworld.mvp.api.IBase;


/**
 * Created by cxx on 16/6/20.
 * xx.ch@outlook.com
 */
public class BasePresenter<V extends IBase.View> implements IBase.Presenter {
    /**
     * 在 View 销毁时会连同销毁 Presenter，此时 mView 会被置空，因此在网络请求回调中 mView 可能为空。
     */
    protected V mView;

    public BasePresenter(@NonNull V view) {
        mView = view;
    }

    @CallSuper
    @Override
    public void onCreate() {

    }

    @CallSuper
    @Override
    public void onStart() {

    }

    @CallSuper
    @Override
    public void onResume() {

    }

    @CallSuper
    @Override
    public void onPause() {

    }

    @CallSuper
    @Override
    public void onStop() {

    }

    @CallSuper
    @Override
    public void onDestroy() {
        mView = null;
    }

    protected final boolean viewEnable() {
        return mView != null && mView.isActive();
    }
}
