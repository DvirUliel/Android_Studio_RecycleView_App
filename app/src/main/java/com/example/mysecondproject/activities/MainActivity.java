package com.example.mysecondproject.activities;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysecondproject.R;
import com.example.mysecondproject.classes.CustomeAdapter;
import com.example.mysecondproject.classes.DataArrays;
import com.example.mysecondproject.classes.DataModel;
import com.example.mysecondproject.models.Student;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }
    public void login(View view){
        String email = ((EditText)findViewById(R.id.emailEditTextFrag1)).getText().toString();
        String password = ((EditText)findViewById(R.id.passwordEditTextFrag1)).getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "login ok", Toast.LENGTH_LONG).show();
                            Navigation.findNavController(view).navigate(R.id.action_fragment1_to_fragment3);

                        } else {
                            Toast.makeText(MainActivity.this, "login fail", Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }

    public void register(){
        String email = ((EditText)findViewById(R.id.emailEditTextFrag2)).getText().toString();
        String password = ((EditText)findViewById(R.id.passwordEditTextFrag2)).getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Register OK", Toast.LENGTH_LONG).show();
                    } else {
                        // Log the error message to understand the failure
                        String errorMessage = task.getException().getMessage();
                        Log.e("REGISTER_ERROR", "Error: " + errorMessage);
                        Toast.makeText(MainActivity.this, "Register Fail: " + errorMessage, Toast.LENGTH_LONG).show();
                    }
                }

            });
    }

    public void addData(){
        String phone = ((EditText)findViewById(R.id.phoneEditTextFrag2)).getText().toString();
        String email = ((EditText)findViewById(R.id.emailEditTextFrag2)).getText().toString();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message").child(phone);

        Student s = new Student(phone,email);

        myRef.setValue(s);
    }

    public void getStudent(String phone){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message").child(phone);
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Student value = dataSnapshot.getValue(Student.class);
                Toast.makeText(MainActivity.this, value.getEmail(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }
}