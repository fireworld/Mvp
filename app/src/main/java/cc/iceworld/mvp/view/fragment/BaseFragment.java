package cc.iceworld.mvp.view.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cc.iceworld.mvp.api.IBase;
import cc.iceworld.mvp.toolbox.FakeLayoutInflater;


/**
 * Created by cxx on 16/6/20.
 * xx.ch@outlook.com
 */
public abstract class BaseFragment<P extends IBase.Presenter> extends Fragment implements IBase.View<P> {
    private boolean mOnCreateOfPresenterNeedCall = true;
    protected P mPresenter;
    protected View mRootView;
    private boolean mIsActive = false;

    @Override
    public final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getPresenter();
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (mRootView == null) {
            mRootView = initView(FakeLayoutInflater.from(inflater), container, savedInstanceState);
            mOnCreateOfPresenterNeedCall = true;
        }
        return mRootView;
    }

    protected abstract View initView(@NonNull FakeLayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    @CallSuper
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mIsActive = true;
        if (mOnCreateOfPresenterNeedCall && mPresenter != null) {
            mPresenter.onCreate();
            mOnCreateOfPresenterNeedCall = false;
        }
    }

    @CallSuper
    @Override
    public void onStart() {
        super.onStart();
        if (mPresenter != null) {
            mPresenter.onStart();
        }
    }

    @CallSuper
    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @CallSuper
    @Override
    public void onPause() {
        if (mPresenter != null) {
            mPresenter.onPause();
        }
        super.onPause();
    }

    @CallSuper
    @Override
    public void onStop() {
        if (mPresenter != null) {
            mPresenter.onStop();
        }
        super.onStop();
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @CallSuper
    @Override
    public void onDestroy() {
        mIsActive = false;
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter = null;
        }
        mRootView = null;
        super.onDestroy();
    }

    @Override
    public boolean isActive() {
        return mIsActive;
    }

    @Override
    public void toast(@NonNull CharSequence text) {
        Activity a = getActivity();
        if (a != null) {
            Toast.makeText(a.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void toast(@StringRes int resId) {
        Activity a = getActivity();
        if (a != null) {
            Toast.makeText(a.getApplicationContext(), resId, Toast.LENGTH_SHORT).show();
        }
    }
}
