package cc.iceworld.mvp.api;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

/**
 * Created by cxx on 16/6/20.
 * xx.ch@outlook.com
 */
public interface IBase {

    interface Presenter {

        /**
         * 应在此方法中对 Presenter 进行初始化，如需立即请求的网络数据等应在此进行。
         * 此方法在 View 的视图初始化后调用。
         */
        void onCreate();

        void onStart();

        void onResume();

        void onPause();

        void onStop();

        /**
         * 应在此方法中释放相关资源，解除对 View 的引用。
         */
        void onDestroy();
    }

    interface View<P extends Presenter> {

        /**
         * 返回一个 Presenter, 不允许私自调用，基础类将自动调用。
         *
         * @return IBase.Presenter 或其子类，对应不同的 View 应有不同的 Presenter，应加以限制。
         */
        @NonNull
        P getPresenter();

        /**
         * 如果当前 View 可以设置数据（即没有被销毁）就返回 true，否则返回 false。
         * 如 Activity.isFinishing() 返回 true 时表明即将被销毁，此时 isActive() 应返回 false.
         */
        boolean isActive();

        void toast(@NonNull CharSequence text);

        void toast(@StringRes int resId);
    }
}
