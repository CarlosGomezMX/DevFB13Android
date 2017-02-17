package com.ken.quizapp.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ken.quizapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnswerFragment extends Fragment {
private String score;

    public AnswerFragment() {
        score = "";
    }

    @SuppressLint("ValidFragment")
    public AnswerFragment(String title) {
        this.score = title;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =inflater.inflate(R.layout.fragment_answer, container, false);

        TextView tvScore = (TextView) view.findViewById(R.id.score);


        tvScore.setText(score);
        return view;
    }

}
