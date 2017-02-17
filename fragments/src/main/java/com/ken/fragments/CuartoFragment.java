package com.ken.fragments;


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
public class CuartoFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private String text;

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
        TextView tvText = (TextView) view.findViewById(R.id.tv_fragment4);
        tvText.setText(text);
        return view;
    }

}
