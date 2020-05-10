package com.blueradix.android.jetpacknavigationcomponent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphNavigator;
import androidx.navigation.NavHost;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueradix.android.jetpacknavigationcomponent.databinding.FragmentLoginBinding;

import static com.blueradix.android.jetpacknavigationcomponent.LoginFragmentDirections.actionLoginFragmentToMainFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.loginButton.setOnClickListener( v -> buttonClicked(v));
    }

    private void buttonClicked(View v) {
        NavController navController = Navigation.findNavController(v);
        if(v.getId() == binding.loginButton.getId()){
            navController.navigate(R.id.action_loginFragment_to_mainFragment);
        }
    }
}
