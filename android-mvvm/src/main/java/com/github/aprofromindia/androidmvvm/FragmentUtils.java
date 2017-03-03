package com.github.aprofromindia.androidmvvm;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.github.aprofromindia.androidmvvm.interfaces.ViewModelProvider;

public final class FragmentUtils {

    @NonNull
    static <T> T onCreate(@NonNull FragmentManager fragmentManager,
                          @NonNull ViewModelProvider<T> provider) {
        //noinspection unchecked
        StateFragment<T> stateFragment = (StateFragment<T>) fragmentManager
                .findFragmentByTag(StateFragment.TAG);

        if (stateFragment == null) {
            stateFragment = StateFragment.newInstance(provider.provideViewModel());

            fragmentManager
                    .beginTransaction()
                    .add(stateFragment, StateFragment.TAG)
                    .commit();
        }
        //noinspection ConstantConditions
        return stateFragment.getViewModel();
    }

    @NonNull
    public static <T extends Fragment> T addFragment(@NonNull FragmentManager fragmentManager,
                                                     @NonNull FragmentProvider<T> provider,
                                                     @NonNull String tag) {
        return addFragment(fragmentManager, provider, tag, false);
    }

    @NonNull
    public static <T extends Fragment> T addFragment(@NonNull FragmentManager fragmentManager,
                                                     @NonNull FragmentProvider<T> provider,
                                                     @IdRes int id) {
        return addFragment(fragmentManager, provider, id, false);
    }

    @NonNull
    public static <T extends Fragment> T addFragment(@NonNull FragmentManager fragmentManager,
                                                     @NonNull FragmentProvider<T> provider,
                                                     @IdRes int id,
                                                     boolean addToBackStack) {
        T fragment = (T) fragmentManager.findFragmentById(id);
        if (fragment == null) {
            fragment = provider.provideFragment();

            FragmentTransaction transaction = fragmentManager
                    .beginTransaction()
                    .add(id, fragment);
            if (addToBackStack) {
                transaction.addToBackStack(null);
            }
            transaction.commit();
        }
        return fragment;
    }


    @NonNull
    public static <T extends Fragment> T addFragment(@NonNull FragmentManager fragmentManager,
                                                     @NonNull FragmentProvider<T> provider,
                                                     @NonNull String tag,
                                                     boolean addToBackStack) {
        T fragment = (T) fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            fragment = provider.provideFragment();

            FragmentTransaction transaction = fragmentManager
                    .beginTransaction()
                    .add(fragment, tag);
            if (addToBackStack) {
                transaction.addToBackStack(null);
            }
            transaction.commit();
        }
        return fragment;
    }

    public interface FragmentProvider<T extends Fragment> {
        T provideFragment();
    }
}
