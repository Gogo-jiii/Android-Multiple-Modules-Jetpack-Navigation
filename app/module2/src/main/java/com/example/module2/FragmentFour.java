package com.example.module2;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.commonmodule.ToolbarManager;


public class FragmentFour extends Fragment {

    private View rootView;
    private NavController navController;
    private ToolbarManager toolbarManager;
    private Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_four, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.fragmentContainerView);

        toolbarManager = ToolbarManager.getInstance();
        toolbar = rootView.findViewById(R.id.toolbar4);

        setupToolbar();

        return rootView;
    }

    private void setupToolbar() {
        toolbarManager.setupToolbar(getActivity(), navController, null, toolbar,
                true);
    }
}