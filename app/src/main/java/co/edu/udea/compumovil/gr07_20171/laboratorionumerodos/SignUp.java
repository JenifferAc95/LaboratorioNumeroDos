package co.edu.udea.compumovil.gr07_20171.laboratorionumerodos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    DataBaseHelper helper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        DataBaseHelper db = new DataBaseHelper(this);
    }

    public void onClickSign(View view){
        if(view.getId() == R.id.buttonsign){

            EditText username = (EditText) findViewById(R.id.etusername);
            EditText password = (EditText) findViewById(R.id.etpassword);
            EditText name = (EditText) findViewById(R.id.etname);
            EditText email = (EditText) findViewById(R.id.etemail);
            EditText age = (EditText) findViewById(R.id.etage);

            String usernamestr = username.getText().toString();
            String namestr = name.getText().toString();
            String passwordstr = password.getText().toString();
            String emailstr = email.getText().toString();
            String agestr = age.getText().toString();

            /*User user = new User();
            user.setUserName(usernamestr);
            user.setName(namestr);
            user.setPassword(passwordstr);
            user.setEmail(emailstr);
            user.setAge(agestr);*/

            Context context = getApplicationContext();
            helper = new DataBaseHelper(context);
            helper = helper.open();

            helper.insertUser(usernamestr, namestr, passwordstr, emailstr, agestr);


            Toast signUp = Toast.makeText(SignUp.this, "User registered", Toast.LENGTH_SHORT);
            signUp.show();
        }
    }
}
