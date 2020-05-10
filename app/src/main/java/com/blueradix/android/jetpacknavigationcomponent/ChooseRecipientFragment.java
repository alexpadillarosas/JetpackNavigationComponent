package com.blueradix.android.jetpacknavigationcomponent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueradix.android.jetpacknavigationcomponent.databinding.FragmentChooseRecipientBinding;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChooseRecipientFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseRecipientFragment extends Fragment {

    FragmentChooseRecipientBinding binding;

    public ChooseRecipientFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentChooseRecipientBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.cancelButton.setOnClickListener( v -> buttonClicked(v));
        binding.nextButton.setOnClickListener( v -> buttonClicked(v));
    }

    private void buttonClicked(View v) {

        NavController navigation = Navigation.findNavController(v);
        if(v.getId() == binding.nextButton.getId()) {
            String recipient = binding.inputRecipient.getText().toString();
            if(!TextUtils.isEmpty(recipient)){
                /* OLD STYLE WITHOUT SAFE ARGS
                final String RECIPIENT_KEY = "recipient";
                Bundle bundle = new Bundle();
                bundle.putString(RECIPIENT_KEY, binding.inputRecipient.getText().toString());
                navigation.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment, bundle );
                */

                //USING SAFE ARGS
                ChooseRecipientFragmentDirections.ActionChooseRecipientFragmentToSpecifyAmountFragment action = ChooseRecipientFragmentDirections.actionChooseRecipientFragmentToSpecifyAmountFragment();
                action.setRecipient(recipient);
                navigation.navigate(action);

                return;
            }
        }
        if(v.getId() == binding.cancelButton.getId()) {
            getActivity().onBackPressed();
            return;
        }
    }
}
