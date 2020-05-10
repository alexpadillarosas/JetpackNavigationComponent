package com.blueradix.android.jetpacknavigationcomponent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.blueradix.android.jetpacknavigationcomponent.databinding.FragmentMainBinding;

import java.util.Optional;
import java.util.stream.Stream;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    //for profile binding
    private FragmentMainBinding binding;

    public MainFragment() {
        // Required empty public constructor
    }
    /**
     * Use onCreate for any non-graphical initialisations
     */

    /**
     * <p>It is recommended to <strong>only</strong> inflate the layout in this method and move
     * logic that operates on the returned View to {@link #onViewCreated(View, Bundle)}.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
        //return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.viewTransactionButton.setOnClickListener(v -> buttonClicked(v));
        binding.sendMoneyButton.setOnClickListener(v -> buttonClicked(v));
        binding.viewBalanceButton.setOnClickListener(v -> buttonClicked(v));

    }

    private void buttonClicked(View v) {
        NavController navController = Navigation.findNavController(v);
        if( v.getId() == binding.viewTransactionButton.getId()) {
            navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment);
            return;
        }
        if( v.getId() == binding.sendMoneyButton.getId()) {
            navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment);
            return;
        }
        if( v.getId() == binding.viewBalanceButton.getId()) {
            navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment);
            return;
        }

    }
}
