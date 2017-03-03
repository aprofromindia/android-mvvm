package com.github.aprofromindia.androidmvvm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.aprofromindia.androidmvvm.interfaces.ViewModelProvider;

public abstract class VMActivity<T> extends AppCompatActivity
        implements ViewModelProvider<T> {
    protected T viewModel;
    protected boolean saveOnConfigChange = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (saveOnConfigChange) {
            viewModel = FragmentUtils.onCreate(getSupportFragmentManager(), this);
        } else {
            viewModel = provideViewModel();
        }
    }
}
