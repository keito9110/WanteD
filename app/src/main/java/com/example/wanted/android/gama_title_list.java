package com.example.wanted.android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wanted.R;

public class gama_title_list extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_title_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button APEX = (Button)findViewById(R.id.btnAPEX);
        Button COD = (Button)findViewById(R.id.btnCOD);
        Button DORAQUE = (Button)findViewById(R.id.btnDORAQUE);
        Button FINAL = (Button)findViewById(R.id.btnFINAL);
        Button LOL = (Button)findViewById(R.id.btnLOL);
        Button POKEMON = (Button)findViewById(R.id.btnPOKEMON);
        Button SMASH = (Button)findViewById(R.id.btnSMASH);
        Button VAROLAMT = (Button)findViewById(R.id.btnVAROLANT);

         APEX.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });

        COD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        DORAQUE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        FINAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        LOL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        POKEMON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        SMASH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        VAROLAMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
