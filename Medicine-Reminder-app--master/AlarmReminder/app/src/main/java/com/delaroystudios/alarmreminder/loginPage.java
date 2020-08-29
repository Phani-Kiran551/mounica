package com.delaroystudios.alarmreminder;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class loginPage extends AppCompatActivity {
    SharedPreferences sp;
    String email,password;
    EditText t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        t1=findViewById(R.id.gmail);
        t2=findViewById(R.id.password);
        sp = getSharedPreferences("login",MODE_PRIVATE);
        if(sp!=null){
            email=sp.getString("mail","");
            password=sp.getString("pass","");

        }
    }
    public void openActivitymain(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void login(View view) {

        if(email.equals(t1.getText().toString()) && password.equals(t2.getText().toString())){
            Intent i = new Intent(loginPage.this,MainActivity.class);
            startActivity(i);

        }
        else{
            Toast.makeText(this, "no", Toast.LENGTH_SHORT).show();
        }

    }

    public void newuser(View view) {
        Intent i1 = new Intent(loginPage.this,registerPage.class);
        startActivity(i1);
    }
}