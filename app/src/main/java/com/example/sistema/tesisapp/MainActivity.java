package com.example.sistema.tesisapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private EditText txt_Usuario, txt_Contrasena;
    private Button btn_Ingresar, btn_Registrar;
    private Cursor fila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("TEST:", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        txt_Usuario = (EditText) findViewById(R.id.txt_usuario);
        txt_Contrasena = (EditText) findViewById(R.id.txt_contrasena);
        btn_Ingresar = (Button) findViewById(R.id.btn_ingresar);
        btn_Registrar = (Button) findViewById(R.id.btn_registrar);

        btn_Ingresar.setOnClickListener(this);
        btn_Registrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.btn_ingresar):
                Intent i = new Intent(this, inicio.class);
                startActivity(i);
                break;
            case(R.id.btn_registrar):
                Intent i_registrar = new Intent(this, Registrar.class);
                startActivity(i_registrar);
                break;
        }
    }

    public void ingresar(View v){
        DBHelper admin = new DBHelper(this,"colegio",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String usuario = txt_Usuario.getText().toString();
        String contrasena = txt_Contrasena.getText().toString();

        fila = db.rawQuery("select usuario,contrasena from usuarios where usuario ='" + usuario + "' and contrasena='" + contrasena + "'", null);
        //mientras fila tiene algun valor
        while(fila.moveToFirst()==true){
            String usua = fila.getString(0);
            String contra = fila.getString(1);

            if(usuario.equals(usua) && contrasena.equals(contra)){
                Log.v("TEST:", "evaluo");
                Intent i = new Intent(this,inicio.class);
                startActivity(i);
                txt_Usuario.setText("");
                txt_Contrasena.setText(" ");
            }
            else{
                Toast.makeText(getApplicationContext(),"Usuario Incorrecto", Toast.LENGTH_LONG).show();
            }

        }
    }
}
