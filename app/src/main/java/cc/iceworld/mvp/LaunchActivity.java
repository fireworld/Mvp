package cc.iceworld.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import cc.iceworld.mvp.demo.DemoActivity;
import cc.iceworld.mvp.demo.DemoDialogFragment;
import cc.iceworld.mvp.demo.DemoFragment;


/**
 * Created by cxx on 16-6-24.
 * xx.ch@outlook.com
 */
public class LaunchActivity extends Activity implements View.OnClickListener {
    private LinearLayout mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        mRootView = (LinearLayout) findViewById(R.id.ll_root);

        findViewById(R.id.btn_to_demo_activity).setOnClickListener(this);
        findViewById(R.id.btn_to_demo_fragment).setOnClickListener(this);
        findViewById(R.id.btn_show_demo_dialog_fragment).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_to_demo_activity:
                startActivity(new Intent(this, DemoActivity.class));
                break;
            case R.id.btn_to_demo_fragment:
                mRootView.removeAllViews();
                getFragmentManager().beginTransaction().replace(R.id.ll_root, new DemoFragment()).commit();
                break;
            case R.id.btn_show_demo_dialog_fragment:
                new DemoDialogFragment().show(getFragmentManager(), "DemoDialogFragment");
                break;
            default:
                break;
        }
    }
}
