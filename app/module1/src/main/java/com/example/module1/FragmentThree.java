package com.example.module1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.commonmodule.ToolbarManager;

public class FragmentThree extends Fragment {

    private View rootView;
    private NavController navController;
    private ToolbarManager toolbarManager;
    private Toolbar toolbar;
    private Button btnGotoModule2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_three, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.fragmentContainerView);

        toolbarManager = ToolbarManager.getInstance();
        toolbar = rootView.findViewById(R.id.toolbar3);
        btnGotoModule2 = rootView.findViewById(R.id.btnGotoModule2);

        setupToolbar();

        btnGotoModule2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                navController.navigate(R.id.action_fragmentThree_to_module2_nav_graph);
            }
        });

        return rootView;
    }

    private void setupToolbar() {
        toolbarManager.setupToolbar(getActivity(), navController, null, toolbar,
                true);
    }
}