package com.example.wanted.android;

import android.os.Bundle;
import android.view.View;
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
        ToggleButton APEX = (ToggleButton)findViewById(R.id.tbtnAPEX);
        ToggleButton COD = (ToggleButton)findViewById(R.id.tbtnCOD);
        ToggleButton DORAQUE = (ToggleButton)findViewById(R.id.tbtnDORAQUE);
        ToggleButton FINAL = (ToggleButton)findViewById(R.id.tbtnFINAL);
        ToggleButton LOL = (ToggleButton)findViewById(R.id.tbtnLOL);
        ToggleButton POKEMON = (ToggleButton)findViewById(R.id.tbtnPOKEMON);
        ToggleButton SMASH = (ToggleButton)findViewById(R.id.tbtnSMASH);
        ToggleButton VAROLAMT = (ToggleButton)findViewById(R.id.tbtnVAROLANT);

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
