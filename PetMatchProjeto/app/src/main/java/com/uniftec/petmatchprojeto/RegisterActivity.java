package com.uniftec.petmatchprojeto;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        EditText nomeCompletoEdit = findViewById(R.id.editNomeCompleto);
        EditText emailEdit = findViewById(R.id.editEmailAddress);
        EditText passwordEdit = findViewById(R.id.editPassword);
        EditText confirmPasswordEdit = findViewById(R.id.editConfirmPassword);
        EditText cepEdit = findViewById(R.id.editCep);

        Button nextRegisterStep = findViewById(R.id.nextRegisterButton);
        nextRegisterStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textNomeCompleto = nomeCompletoEdit.getText().toString().trim();
                String textEmail = emailEdit.getText().toString().trim();
                String textPassword = passwordEdit.getText().toString().trim();
                String textConfirmPassword = confirmPasswordEdit.getText().toString().trim();
                String textCepEdit = cepEdit.getText().toString().trim();


                if (
                    !textNomeCompleto.isEmpty() &&
                    !textEmail.isEmpty() &&
                    !textPassword.isEmpty() &&
                    !textConfirmPassword.isEmpty() &&
                    !textCepEdit.isEmpty()
                ){
                    Intent intent = new Intent(RegisterActivity.this, TypeAnimalActivity.class);
                    startActivity(intent);
                }
                else{
                    new AlertDialog.Builder(RegisterActivity.this)
                            .setTitle("Preencha os campos corretamente!")
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .show();
                }

            }
        });

    }



}