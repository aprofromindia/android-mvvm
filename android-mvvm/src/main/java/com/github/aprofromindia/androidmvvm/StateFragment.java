package com.github.aprofromindia.androidmvvm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public final class StateFragment<T> extends Fragment {
    public static final String TAG = StateFragment.class.getName();

    private T viewModel;
    private Class<T> clazz;

    public StateFragment() {
    }

    static <T> StateFragment<T> newInstance(T viewModel) {
        StateFragment<T> fragment = new StateFragment<>();
        fragment.viewModel = viewModel;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @NonNull
    public String getGenTag() {
        return clazz.getSimpleName() + ":" +
                getClass().getSimpleName();
    }

    @Nullable
    public T getViewModel() {
        return viewModel;
    }
}
