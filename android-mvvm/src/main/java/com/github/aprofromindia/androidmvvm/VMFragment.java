package com.github.aprofromindia.androidmvvm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.aprofromindia.androidmvvm.interfaces.ViewModelProvider;

public abstract class VMFragment<T> extends Fragment implements ViewModelProvider<T> {
    protected T viewModel;
    protected boolean saveOnConfigChange = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (saveOnConfigChange) {
            viewModel = FragmentUtils.onCreate(getChildFragmentManager(), this);
        } else {
            viewModel = provideViewModel();
        }
    }
}
