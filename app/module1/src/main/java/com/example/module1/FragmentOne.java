package com.example.module1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.commonmodule.ToolbarManager;

public class FragmentOne extends Fragment {

    private View rootView;
    private NavController navController;
    private Button btnGotoSecondFragment, btnGoToThirdFragment;
    private ToolbarManager toolbarManager;
    private Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_one, container, false);
        toolbar = rootView.findViewById(R.id.toolbar);
        btnGotoSecondFragment = rootView.findViewById(R.id.btnGotoSecondFragment);
        btnGoToThirdFragment = rootView.findViewById(R.id.btnGoToThirdFragment);

        navController = Navigation.findNavController(getActivity(), R.id.fragmentContainerView);
        toolbarManager = ToolbarManager.getInstance();

        setupToolbar();

        btnGotoSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                navController.navigate(R.id.action_fragmentOne_to_fragmentTwo);
            }
        });

        btnGoToThirdFragment.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                navController.navigate(R.id.action_fragmentOne_to_fragmentThree);
            }
        });

        return rootView;
    }

    private void setupToolbar() {
        toolbarManager.setupToolbar(getActivity(), navController, null, toolbar,
                false);
    }

}