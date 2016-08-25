package cc.iceworld.mvp.toolbox;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cxx on 16-6-23.
 * xx.ch@outlook.com
 */
public class FakeLayoutInflater {
    private final LayoutInflater mInflater;

    private FakeLayoutInflater(@NonNull Context context) {
        mInflater = LayoutInflater.from(context);
    }

    private FakeLayoutInflater(@NonNull LayoutInflater inflater) {
        mInflater = inflater;
    }

    public static FakeLayoutInflater from(@NonNull Context context) {
        return new FakeLayoutInflater(context);
    }

    public static FakeLayoutInflater from(@NonNull LayoutInflater inflater) {
        return new FakeLayoutInflater(inflater);
    }

    public View inflate(@LayoutRes int layoutResId, ViewGroup container) {
        return mInflater.inflate(layoutResId, container, false);
    }
}
