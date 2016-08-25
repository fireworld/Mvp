package cc.iceworld.mvp.view.wrapper;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.widget.Toast;

import cc.iceworld.mvp.api.IBase;


/**
 * Created by cxx on 16-6-21.
 * xx.ch@outlook.com
 */
public abstract class BaseWrapper<P extends IBase.Presenter> implements IBase.View<P> {
    protected P mPresenter;
    protected Context mContext;
    private boolean mIsActive = false;

    {
        mPresenter = getPresenter();
    }

    public BaseWrapper(@NonNull Context context) {
        mContext = context;
    }

    @CallSuper
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mIsActive = true;
        if (mPresenter != null) {
            mPresenter.onCreate();
        }
    }

    @CallSuper
    public void onStart() {
        if (mPresenter != null) {
            mPresenter.onStart();
        }
    }

    @CallSuper
    public void onResume() {
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @CallSuper
    public void onPause() {
        if (mPresenter != null) {
            mPresenter.onPause();
        }
    }

    @CallSuper
    public void onStop() {
        if (mPresenter != null) {
            mPresenter.onStop();
        }
    }

    @CallSuper
    public void onDestroy() {
        mIsActive = false;
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter = null;
        }
        mContext = null;
    }

    @Override
    public final boolean isActive() {
        return mIsActive;
    }

    @Override
    public final void toast(@NonNull CharSequence text) {
        if (mContext != null) {
            Toast.makeText(mContext.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void toast(@StringRes int resId) {
        if (mContext != null) {
            Toast.makeText(mContext.getApplicationContext(), resId, Toast.LENGTH_SHORT).show();
        }
    }
}
