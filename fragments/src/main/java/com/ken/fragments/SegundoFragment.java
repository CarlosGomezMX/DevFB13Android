package com.ken.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SegundoFragment extends Fragment implements View.OnClickListener {

    private TextView tvContador;
    private OnFragment2InteractionListener mlistener;

    public SegundoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_segundo, container, false);
        tvContador = (TextView) view.findViewById(R.id.contadorSegundo);
        //Referencia
        View rootLayout = view.findViewById(R.id.fragment2_root_layout);
        rootLayout.setOnClickListener(this);

        return view;

    }



    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);

        if(context instanceof  MainActivity)
        {
            mlistener = (SegundoFragment.OnFragment2InteractionListener) context;
        }
    }


    @Override
    public void onClick(View v) {
        mlistener.onFragment2Interaction();
    }



    public interface OnFragment2InteractionListener {

        void onFragment2Interaction();


    }

    public String getContador() {
        return (String) tvContador.getText();
    }

    public void setContador(int contador) {
        tvContador.setText(contador+"");
    }


}
