package com.blueradix.android.jetpacknavigationcomponent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueradix.android.jetpacknavigationcomponent.databinding.FragmentSpecifyAmountBinding;

import java.math.BigDecimal;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpecifyAmountFragment extends Fragment {

    FragmentSpecifyAmountBinding binding;
    String recipient;

    public SpecifyAmountFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SpecifyAmountFragmentArgs args = SpecifyAmountFragmentArgs.fromBundle(getArguments());
        recipient = args.getRecipient();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSpecifyAmountBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.sendButton.setOnClickListener(v -> buttonClicked(v));

        binding.cancelButton.setOnClickListener(v -> buttonClicked(v));
        String message = "Sending money to " + recipient;
        binding.recipientTextView.setText(message);
    }

    private void buttonClicked(View v) {
        NavController navigation = Navigation.findNavController(v);
        if(v.getId() == binding.sendButton.getId()){
            String amount = binding.inputAmount.getText().toString();
            if(!TextUtils.isEmpty(amount)){
                Money money = new Money();
                money.setAmount(new BigDecimal(amount));

                //call and pass the money
                SpecifyAmountFragmentDirections.ActionSpecifyAmountFragmentToConfirmationFragment action = SpecifyAmountFragmentDirections.actionSpecifyAmountFragmentToConfirmationFragment(money);

                //now pass the recipient
                action.setRecipient(recipient);
                navigation.navigate(action);
                return;
            }


        }
        if(v.getId() == binding.cancelButton.getId()){
            getActivity().onBackPressed();
            return;
        }

    }
}
