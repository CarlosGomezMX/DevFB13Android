package com.ken.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static android.R.attr.fragment;

public class MainActivity extends AppCompatActivity  implements  CuartoFragment.OnFragment4InteractionListener, SegundoFragment.OnFragment2InteractionListener{

    public CuartoFragment  fragment;
    public SegundoFragment fragment2;
   private static final String TAG_FRAGMENT_CUATRO="fragment4";
    private static final String TAG_FRAGMENT_SEGUNDO="fragment2";
    public int contadorSegundo=0;
    public int contadorCuarto=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Conseguimos la orientación del dispositivo
         * si es 1 esta en vertical
         * 2 horizontal
         */
        int orientacion = getResources().getConfiguration().orientation;
        if (orientacion == 1) {
            View fragmento1 = findViewById(R.id.fragmento1);
            fragmento1.setVisibility(View.GONE);
        }


        fragment = CuartoFragment.newInstance("texto inicial");
        //changeFragment(new TercerFragment());

        changeFragment(fragment, TAG_FRAGMENT_CUATRO);


    }


    @Override
    protected void onResume() {
        super.onResume();
        CuartoFragment fragment = (CuartoFragment) getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_CUATRO);

        if(fragment != null)
        {
          //  fragment.setDatoInicial("mandamos datos desde la actividad");
        }
    }

    /**
     * Agregamos dinamicamente  fragmnet pasado como parametro
     *
     * @param fragment
     */
    public void changeFragment(Fragment fragment, String tag) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout, fragment, tag)
                .commit();
    }


    @Override
    public void onFragment4Interaction(String data) {
        contadorCuarto++;
        SegundoFragment fragment = (SegundoFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento2);
        //fragment.setDatoInicial("mandamos datos desde la actividad");
        fragment.setContador(contadorCuarto);

    }

    @Override
    public void onFragment2Interaction() {
        contadorSegundo++;
        CuartoFragment fragment = (CuartoFragment) getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_CUATRO);
       //fragment.setDatoInicial("mandamos datos desde la actividad");
        fragment.setContador(contadorSegundo);

    }
}
