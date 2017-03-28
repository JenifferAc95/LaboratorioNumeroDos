package co.edu.udea.compumovil.gr07_20171.laboratorionumerodos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickLogin(View view) {
        if (view.getId() == R.id.buttoLogin) {
            EditText username = (EditText) findViewById(R.id.etUsernameL);
            String usernamestr = username.getText().toString();

            Intent i = new Intent(Login.this, Display.class);
            i.putExtra("Username", usernamestr);
            startActivity(i);
        }
    }

    public void onClickSignUp(View view) {

        if (view.getId() == R.id.buttonsignup) {
            Intent i = new Intent(Login.this, SignUp.class);
            startActivity(i);
        }

    }
}