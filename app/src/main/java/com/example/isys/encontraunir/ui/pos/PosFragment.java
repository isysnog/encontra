package com.example.isys.encontraunir.ui.pos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.isys.encontraunir.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PosFragment extends Fragment {


    public PosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pos, container, false);
    }

}
