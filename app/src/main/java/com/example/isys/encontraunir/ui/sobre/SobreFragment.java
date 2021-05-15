package com.example.isys.encontraunir.ui.sobre;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.isys.encontraunir.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class SobreFragment extends Fragment {


    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String descricao = "O encontraUNIR tem como objetivo auxiliar na localização dos espaços do"+
                " campus da Universidade Federal de Rôndonia - UNIR.\n" +
                "\n Aqui você pode navegar por todo campus de maneira fácil e rápida,"+
                " localizando prédios, departamentos, espaços públicos, entre outros."+
                " Chegue ao seu destino de forma rápida e sem se perder!";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        return new AboutPage (getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato")
                .addEmail("ascom@unir.br","Enviar e-mail")
                .addWebsite("www.unir.br","Acessar site da Instituição")

                .addGroup("Redes sociais")
                .addFacebook("unir", "Facebook")
                .addInstagram("unir.rondonia","Instagram")
                .addYoutube("UCAHopwb3eg9b4T7LRZxeQ5g","YouTube")
                .addItem(versao)

                .create();

        //return inflater.inflate(R.layout.fragment_sobre, container, false);
    }

}
