package com.delaroystudios.alarmreminder;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registerPage extends AppCompatActivity {
    EditText t1,t2,t3;
    SharedPreferences sp;
    String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        t1=findViewById(R.id.email);
        t2=findViewById(R.id.pass1);
        t3=findViewById(R.id.pass2);

        sp = getSharedPreferences("login",MODE_PRIVATE);
        if(sp!=null){
            email=sp.getString("mail","");
            password=sp.getString("pass","");

        }

    }

    public void signup(View view) {
        password = t2.getText().toString();
        email = t1.getText().toString();
        if(password.equals(t3.getText().toString())){
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("mail",email);
            editor.putString("pass",password);
            editor.commit();
            Toast.makeText(this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(registerPage.this,loginPage.class);
            startActivity(i);
        }

    }
}