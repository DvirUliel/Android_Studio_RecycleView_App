package com.example.mysecondproject.fragments;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mysecondproject.R;
import com.example.mysecondproject.activities.MainActivity;

public class Register extends Fragment {

    private EditText emailEditText, passwordEditText, rePasswordEditText, phoneEditText;
    private Button registerButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register, container, false);

        // Initialize views
        emailEditText = view.findViewById(R.id.emailEditTextFrag2);
        passwordEditText = view.findViewById(R.id.passwordEditTextFrag2);
        rePasswordEditText = view.findViewById(R.id.rePasswordEditTextFrag2);
        phoneEditText = view.findViewById(R.id.phoneEditTextFrag2);
        registerButton = view.findViewById(R.id.registerButtonFrag2);

        // Handle registration button click
        registerButton.setOnClickListener(v -> {
            handleRegistration();
        });

        return view;
    }

    private void handleRegistration() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String rePassword = rePasswordEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(rePassword) || TextUtils.isEmpty(phone)) {
            Toast.makeText(getContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else if (!password.equals(rePassword)) {
            Toast.makeText(getContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Registration successful!", Toast.LENGTH_SHORT).show();
            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.register();
            mainActivity.addData();
            // Navigate back to Home (Fragment1)
            onRegistrationSuccess();
        }
    }

    private void onRegistrationSuccess() {
        // Use NavController to navigate back to the Home fragment (Fragment1)
        Navigation.findNavController(requireView()).popBackStack();
    }
}
