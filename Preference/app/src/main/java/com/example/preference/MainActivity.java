package com.example.preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edtuserName;
    EditText edtpassword;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        edtuserName.setText(sharedPreferences.getString("taikhoan", ""));
        edtpassword.setText(sharedPreferences.getString("matkhau", ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtuserName.getText().toString().trim();
                String password = edtpassword.getText().toString().trim();
                if (userName.equals("tiendat") && password.equals("1234")) {
                    Toast.makeText(MainActivity.this, "Login Success!!", Toast.LENGTH_SHORT).show();
                    if (cbRemember.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan", userName);
                        editor.putString("matkhau", password);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    } else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Login Fail!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void Anhxa() {
        btnLogin = (Button) findViewById(R.id.btn_Login);
        edtuserName = (EditText) findViewById(R.id.editTextTextPersonName);
        edtpassword = (EditText) findViewById(R.id.editTextTextPersonName2);
        cbRemember = (CheckBox) findViewById(R.id.checkBox);
    }
}