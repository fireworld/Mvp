package cc.iceworld.mvp.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.widget.Toast;

import cc.iceworld.mvp.api.IBase;


/**
 * Created by cxx on 16/6/20.
 * xx.ch@outlook.com
 */
public abstract class BaseActivity<P extends IBase.Presenter> extends Activity implements IBase.View<P> {
    protected P mPresenter;

    @CallSuper
    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getPresenter();
        initView(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.onCreate();
        }
    }

    protected abstract void initView(@Nullable Bundle savedInstanceState);

    @CallSuper
    @Override
    protected void onStart() {
        super.onStart();
        if (mPresenter != null) {
            mPresenter.onStart();
        }
    }

    @CallSuper
    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @CallSuper
    @Override
    protected void onPause() {
        if (mPresenter != null) {
            mPresenter.onPause();
        }
        super.onPause();
    }

    @CallSuper
    @Override
    protected void onStop() {
        if (mPresenter != null) {
            mPresenter.onStop();
        }
        super.onStop();
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter = null;
        }
        super.onDestroy();
    }

    @Override
    public final boolean isActive() {
        return !isFinishing();
    }

    @Override
    public void toast(@NonNull CharSequence text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toast(@StringRes int resId) {
        Toast.makeText(getApplicationContext(), resId, Toast.LENGTH_SHORT).show();
    }
}
