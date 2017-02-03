package com.ken.devfb13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Charizard charizard = new Charizard("chari", "fuego/volador");
        Pikachu pikachu = new Pikachu("pikachu", "electrico");

//        ataquePokemon(charizard);
        ataquePokemon(pikachu);

    }


    public void ataquePokemon(Pokemon pokemon) {

        if (pokemon instanceof Pikachu) {
            Pikachu pikachu = (Pikachu) pokemon;
            pikachu.impactrueno();
        } else if (pokemon instanceof Charizard) {
            Charizard charizard = (Charizard) pokemon;
            charizard.vuela();
        }
    }



}
