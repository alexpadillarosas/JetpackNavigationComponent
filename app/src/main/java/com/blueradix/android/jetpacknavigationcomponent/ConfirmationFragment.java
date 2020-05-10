package com.blueradix.android.jetpacknavigationcomponent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueradix.android.jetpacknavigationcomponent.databinding.FragmentConfirmationBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmationFragment extends Fragment {

    FragmentConfirmationBinding binding;
    String recipient;
    Money money;

    public ConfirmationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConfirmationFragmentArgs args = ConfirmationFragmentArgs.fromBundle(getArguments());
        recipient = args.getRecipient();
        money = args.getAmount();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentConfirmationBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String confirmationMessage = "You have sent $" + money.getAmount().toString() + " to " + recipient;
        binding.confirmationMessageTextView.setText(confirmationMessage);

        //both ways work!
//        binding.goBackHomeButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_confirmationFragment_to_mainFragment));
        binding.goBackHomeButton.setOnClickListener(Navigation.createNavigateOnClickListener(ConfirmationFragmentDirections.actionConfirmationFragmentToMainFragment()));
    }
}
