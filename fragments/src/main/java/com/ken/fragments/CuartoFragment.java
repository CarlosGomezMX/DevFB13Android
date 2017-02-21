package com.ken.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CuartoFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private String text;
    private OnFragment4InteractionListener mlistener;
    private TextView tvText;
    private TextView tvContador;

    public static CuartoFragment newInstance(String text)
    {
        //creo una instancia de CuartoFragment
        CuartoFragment fragment = new CuartoFragment();
        //creo el bundle que guardara los datos que guardare en mi fragmento
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, text);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);

        if(context instanceof  MainActivity)
        {
           mlistener = (OnFragment4InteractionListener) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(getArguments() != null)
        {   //obtenemos los bundle de mi fragmento
            Bundle bundle = getArguments();
            //obtenemos el texto que tenia guardado
            text = bundle.getString(ARG_PARAM1);

        }
    }


    public CuartoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cuarto, container, false);
       tvText = (TextView) view.findViewById(R.id.tv_fragment4);
        tvText.setText(text);
        tvContador = (TextView) view.findViewById(R.id.contadorCuarto);
        //Referencia
        View rootLayout = view.findViewById(R.id.fragment4_root_layout);
        rootLayout.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        mlistener.onFragment4Interaction("Hola!!");
    }

    public void setDatoInicial(String texto)
    {
        tvText.setText(texto);
    }

    public String getContador() {
        return (String) tvContador.getText();
    }

    public void setContador(int contador) {
        tvContador.setText(contador+"");
    }

    public interface OnFragment4InteractionListener {

        void onFragment4Interaction(String data);


    }

}
