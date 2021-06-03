package com.appsnipp.loginsamples;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RegisterActivity extends AppCompatActivity {
    public static final String URL = "https://dickyelectre.000webhostapp.com/";
    private ProgressDialog progress;

    @BindView(R.id.txtnisn)
    EditText getTxtnisn;
    @BindView(R.id.txtkip)
    EditText getTxtkip;
    @BindView(R.id.txtnama)
    EditText getTxtnama;
    @BindView(R.id.txtas)
    EditText getTxtas;
    @BindView(R.id.txtusername)
    EditText getTxtusername;
    @BindView(R.id.txtpassword)
    EditText getTxtpassword;



    @OnClick(R.id.btndaftar) void daftar() {
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

       String kode_alternatif = getTxtnisn.getText().toString();
        String id_KIP = getTxtkip.getText().toString();
        String nama_alternatif = getTxtnama.getText().toString();
        String asal_sekolah = getTxtas.getText().toString();
        String username = getTxtusername.getText().toString();
        String password = getTxtpassword.getText().toString();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.daftar(kode_alternatif,id_KIP,nama_alternatif,asal_sekolah,username,password);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                progress.dismiss();
                if (value.equals("1")) {
                    Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(RegisterActivity.this, "Sukses Mendaftar!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        TextView login = (TextView) findViewById(R.id.txtlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}

