package edu.vassar.cmpu203.batonpass.view;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import edu.vassar.cmpu203.batonpass.databinding.MainBinding;

public class MainView implements IMainView {

    FragmentManager fman;

    MainBinding binding;

    public MainView(FragmentActivity activity) {
        this.fman = activity.getSupportFragmentManager();
        this.binding = MainBinding.inflate(activity.getLayoutInflater());
    }

    public View getRootView() {
        return this.binding.getRoot();
    }

    // display other fragments
    public void displayFragment(Fragment frag, boolean addToStack, String name) {
        FragmentTransaction ft = fman.beginTransaction();
        ft.replace(this.binding.fragmentContainerView1.getId(), frag);
        if (addToStack)
            ft.addToBackStack(name);
        ft.commit();
    }
}
