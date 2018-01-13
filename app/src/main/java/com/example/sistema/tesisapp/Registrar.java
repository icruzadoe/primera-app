package com.example.sistema.tesisapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Sistema on 8/01/2018.
 */

public class Registrar extends AppCompatActivity implements View.OnClickListener{
    Button btn_Aceptar, btn_cancelar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_login);
        init();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case(R.id.btn_reg_aceptar):
                break;
            case(R.id.btn_reg_cancelar):
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
        }
    }

    public void init(){
        btn_Aceptar = findViewById(R.id.btn_reg_aceptar);
        btn_cancelar = findViewById(R.id.btn_reg_cancelar);

        btn_Aceptar.setOnClickListener(this);
        btn_cancelar.setOnClickListener(this);
    }
}
