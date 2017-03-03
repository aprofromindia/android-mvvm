package com.github.aprofromindia.androidmvvm.interfaces;

import android.support.annotation.NonNull;

public interface ViewModelProvider<T> {

    @NonNull
    T provideViewModel();
}
