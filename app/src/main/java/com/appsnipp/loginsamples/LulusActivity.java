package com.appsnipp.loginsamples;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LulusActivity extends AppCompatActivity{
    TextView txtusername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lulus);
        txtusername = (TextView) findViewById(R.id.txtusername);
        Bundle extras = getIntent().getExtras();
        String username;

        if (extras != null) {
            username = extras.getString("username");
            txtusername.setText(username);
        }
    }
}
