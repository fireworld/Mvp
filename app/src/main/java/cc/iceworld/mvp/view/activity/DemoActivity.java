package cc.iceworld.mvp.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import cc.iceworld.mvp.R;
import cc.iceworld.mvp.api.IDemo;
import cc.iceworld.mvp.bean.User;
import cc.iceworld.mvp.presenter.DemoPresenter;

public class DemoActivity extends BaseActivity<IDemo.Presenter> implements IDemo.View {
    private TableLayout mRootTl;
    private TextView mLoginResultTv;
    private EditText mUsernameEt;
    private EditText mPasswordEt;
    private Button mSubmitBtn;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.view_demo);
        mRootTl = (TableLayout) findViewById(R.id.tl_root);
        mLoginResultTv = (TextView) findViewById(R.id.tv_login_result);
        mUsernameEt = (EditText) findViewById(R.id.et_username);
        mPasswordEt = (EditText) findViewById(R.id.et_password);
        mSubmitBtn = (Button) findViewById(R.id.btn_submit);
        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.toLogin();
            }
        });
    }

    @Override
    public String getUsername() {
        return mUsernameEt.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPasswordEt.getText().toString();
    }

    @Override
    public void setSubmitEnabled(boolean enabled) {
        mSubmitBtn.setEnabled(enabled);
    }

    @Override
    public void setUsernameError(@NonNull String tip) {
        mUsernameEt.setError(tip);
    }

    @Override
    public void setPasswordError(@NonNull String tip) {
        mPasswordEt.setError(tip);
    }

    @Override
    public void onLoginSuccess(@NonNull User user) {
        setResult(Color.parseColor("#ffff00"), user.getUsername() + " login success!");
    }

    @Override
    public void onLoginFailure(String msg) {
        setResult(Color.parseColor("#0000ff"), msg);
    }

    private void setResult(int color, String tip) {
        mRootTl.setBackgroundColor(color);
        mLoginResultTv.setText(tip);
    }

    @NonNull
    @Override
    public IDemo.Presenter getPresenter() {
        return new DemoPresenter(this);
    }
}
