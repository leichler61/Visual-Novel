package edu.vassar.cmpu203.batonpass.view;

import android.view.View;
import androidx.fragment.app.Fragment;

public interface IMainView {

    View getRootView();

    void displayFragment(Fragment frag, boolean addToStack, String name);
}
