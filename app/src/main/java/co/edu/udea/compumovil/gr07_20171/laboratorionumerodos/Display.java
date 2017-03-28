package co.edu.udea.compumovil.gr07_20171.laboratorionumerodos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String username = getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.showUsername);
        tv.setText(username);
    }
}
