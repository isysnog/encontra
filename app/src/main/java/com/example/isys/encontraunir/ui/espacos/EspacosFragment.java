package com.example.isys.encontraunir.ui.espacos;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.isys.encontraunir.MainActivity;
import com.example.isys.encontraunir.R;
import com.example.isys.encontraunir.ui.principal.PrincipalFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class EspacosFragment extends Fragment implements Button.OnClickListener {


    public EspacosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_espacos, container, false);
        Button bt1 = (Button) v.findViewById(R.id.bt_biblioteca);
        Button bt2 = (Button) v.findViewById(R.id.bt_dirca);
        Button bt3 = (Button) v.findViewById(R.id.bt_dce);
        Button bt4 = (Button) v.findViewById(R.id.bt_copia);
        Button bt5 = (Button) v.findViewById(R.id.bt_cantina);
        Button bt6 = (Button) v.findViewById(R.id.bt_estac);
        Button bt7 = (Button) v.findViewById(R.id.bt_paradas);
        Button bt8 = (Button) v.findViewById(R.id.bt_agua);
        Button bt9 = (Button) v.findViewById(R.id.bt_bho);
        Button bt10 = (Button) v.findViewById(R.id.bt_tatuzao);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        bt10.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {
        Bundle args = new Bundle();
        switch (v.getId()){
            case R.id.bt_biblioteca:
                PrincipalFragment principalFragment= new PrincipalFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                args.putDouble("latitude", -8.834438573424283);
                args.putDouble("longitude", -63.93909608023147);
                principalFragment.setArguments(args);
                fragmentTransaction.replace(R.id.mapView, principalFragment);
                fragmentTransaction.commit();
                break;
            case R.id.bt_dirca:
                Toast.makeText(getActivity(), "Selecionado", Toast.LENGTH_SHORT).show();
            case R.id.bt_dce:

            case R.id.bt_copia:

            case R.id.bt_cantina:

            case R.id.bt_estac:

            case R.id.bt_paradas:

            case R.id.bt_agua:

            case R.id.bt_bho:

            case R.id.bt_tatuzao:



        }

        //startActivity(new Intent(getActivity(), PrincipalFragment.class));

    }
}
