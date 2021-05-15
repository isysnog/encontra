package com.example.isys.encontraunir.ui.principal;


import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.isys.encontraunir.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrincipalFragment extends Fragment {

    MapView mMapView;
    GoogleMap googleMap;
    SearchView searchView;
    ListView listView;

    private String[] itens = {"1C - Laboratório de Informática", "1F - Copiadora",
            "1F - Lab. de Criação Ciência", "1H - Lab. de Máquinas Elétricas", "1H - Escritório Achados e Perdidos",
            "1H - NT - Núcle de Tecnologia", "1H - 202-Sala de Tradução e Intérprete",
            "1I - CEPEV- Centro de Práticas Esportivas", "1I - Sala dos Espelhos", "1I - Academia",
            "1K - NUCSA - Ciências Sociais Aplicadas", "1L - Herbário Virtual da Flora e dos Fungos",
            "1M - Lab. de Combustíveis", "1M - Lab. Didático I", "1M - Lab. de Psicologia Experimental",
            "1M - Lab. de Cartografia e Geoproc.", "1M - Lab. Dedático de Ensino, Pesq. e Extensão em Geog.",
            "1N - Lab. de Geografia e Planejamento Amb.", "1O - Lab. Pesquisa II", "1O - Lab. de Microbiologia",
            "1P - Lab. de Informática e Sala de Vídeo", "1P - Lab. Ensino de Química I",
            "1P - Lab. Ensino de Química II", "1Q - Lab. Nanomaterias e Nanobiomagnetismo",
            "1Q - Lab. de Física I a IV", "1P - Lab. de Física Computacional", "1S - Lab. de Banco de Germoplasma",
            "1S - Lab. de Prod. Naturais", "1S - Lab. de Solo", "1S - Lab. de Água",
            "1P - Lab. de Automação e Controle", "1S - Casa de Vegetação", "1T - Lab. de Gestão do Território",
            "1T - Laboratório de Geografia Física I e II", "2B - Auditório Paulo Freire", "2B - DCE",
            "2E - Biblioteca", "2E - DIRCA", "2G - EDUCIÊNCIA", "2H - Lab. de Genética Humana",
            "2I - Lab. de Infomática", "2I - 102-GAEPPE", "2J - Lab. Práticas Artísticas I e II",
            "2J - CEPESCO", "2K - Lab. de Genética Molecular", "2K - Lab. de Enfermagem",
            "2K - Lab. de Biologia Evolutiva e Conservação", "3A - 103-Lab. de Fisiologia Humana",
            "3A - 102-Lab. de Anatomopatologia", "3A - 101-Lab. de  Téc. Cirúrgicas", "3A - CEBIO",
            "3A - 204-Lab. de CHE e Patologia", "3A - 205-Lab. de Microb. Parasit. e Imuno.",
            "3A - Lab. de Farmacologia", "3B - Lab. de Anatomia", "3B - Lab. de Hab. Clínicas",
            "3C - Biotério"
    };

    public PrincipalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_principal, container, false);

        /*searchView = v.findViewById (R.id.localiza);
        listView = v.findViewById(R.id.lista);

        final ArrayAdapter<String>adaptador = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,itens);
        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adaptador.getFilter().filter(newText);
                return false;
            }
        });*/

        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // faz com q o mapa seja exibido imediatamente

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        double lati, longi;
        Bundle args = getArguments();
        if(args!=null){
            lati = args.getDouble("latitude");
            longi = args.getDouble("longitude");
            LatLng restaurante = new LatLng(lati,longi);
            googleMap.addMarker(
                    new MarkerOptions().position(restaurante).title("Biblioteca")
                            .snippet("Marcador enviado pela tela botao"));
        }
        else{

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

                // Colocar marcadores no do mapa
                //BLOCOS 1
                LatLng restaurante = new LatLng(-8.835553901362045, -63.939056823633436);
                googleMap.addMarker(
                        new MarkerOptions().position(restaurante).title("Centro de Convivência")
                                .snippet("Restaurante Universitário - em construção"));

                LatLng bloco1a = new LatLng(-8.835998680146314, -63.93871638483351);

                googleMap.addMarker(
                        new MarkerOptions().position(bloco1a).title("Bloco 1A")
                                .snippet("Salas do Curso de Ciência da Computação, Pedagogia e Ciências Contábeis"));

                LatLng bloco1b = new LatLng(-8.836313711365968, -63.938702170981465);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1b).title("Bloco 1B")
                                .snippet("Salas do Curso de Administração"));

                LatLng bloco1c = new LatLng(-8.836157363067159, -63.9390421323393);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1c).title("Bloco 1C")
                                .snippet("Salas e Laboratório do Curso de Ciência da Computação"));

                LatLng bloco1d = new LatLng(-8.836643924928453, -63.93891862222384);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1d).title("Bloco 1D")
                                .snippet("Salas Biblioteconomia"));

                LatLng bloco1e = new LatLng(-8.836668816435568, -63.93973023923353);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1e).title("Bloco 1E")
                                .snippet("Salas do Curso de Matemática"));

                LatLng bloco1f = new LatLng(-8.836474512252622, -63.939369328766055);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1f).title("Bloco 1F")
                                .snippet("Copiadora"));

                LatLng bloco1g = new LatLng(-8.836856822861352, -63.938929640040925);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1g).title("Bloco 1G")
                                .snippet(""));

                LatLng bloco1h = new LatLng(-8.837013053529244, -63.939081171347596);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1h).title("Bloco 1H")
                                .snippet(""));

                LatLng bloco1i = new LatLng(-8.837199728204238, -63.93905652159088);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1i).title("Bloco 1I")
                                .snippet("CEPV, Sala dos Espelhos e Academia"));

                LatLng bloco1k = new LatLng(-8.836721875462217, -63.938508250477874);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1k).title("Bloco 1K")
                                .snippet("NUCSA"));

                LatLng bloco1l = new LatLng(-8.837148830520572, -63.939360819602776);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1l).title("Bloco 1L")
                                .snippet("Herbário"));

                LatLng bloco1m = new LatLng(-8.837164238863515, -63.93960161108219);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1m).title("Bloco 1M")
                                .snippet("Laboratórios de Geografia e Biologia"));

                LatLng bloco1n = new LatLng(-8.837176153871589, -63.9400402464185);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1n).title("Bloco 1N")
                                .snippet("Laboratório do Curso de Geografia"));

                LatLng bloco1o = new LatLng(-8.836989140109555, -63.93935167248402);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1o).title("Bloco 1O")
                                .snippet("Laboratórios do Curso de Biologia"));

                LatLng bloco1p = new LatLng(-8.836983175978457, -63.939449011637244);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1p).title("Bloco 1P")
                                .snippet("Laboratórios do Curso de Química"));

                LatLng bloco1q = new LatLng(-8.837013340566127, -63.94011250187806);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1q).title("Bloco 1Q")
                                .snippet("Laboratórios do Curso de Física"));

                LatLng bloco1r = new LatLng(-8.836829887274085, -63.939661935946575);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1r).title("Bloco 1R")
                                .snippet("Casa de Vegetação"));

                LatLng bloco1s = new LatLng(-8.836847921371183, -63.93989919823136);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1s).title("Bloco 1S")
                                .snippet("Laboratórios de Biologia"));

                LatLng bloco1t = new LatLng(-8.83740283165317, -63.93969953999161);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1t).title("Bloco 1T")
                                .snippet("Salas e Laboratórios do Curso de Geografia"));

                LatLng bloco1u = new LatLng(-8.83740283165317, -63.93969953999161);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco1u).title("Bloco 1U")
                                .snippet("NCH"));


                //BLOCOS 2
                LatLng bloco2a = new LatLng(-8.835047763410563, -63.93865521550551);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2a).title("Bloco 2A")
                                .snippet("Teatro Universitário - em construção"));

                LatLng bloco2b = new LatLng(-8.834861103107642, -63.938658875099435);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2b).title("Bloco 2B")
                                .snippet("Auditório Paulo Freire"));

                LatLng bloco2b2 = new LatLng(-8.834874927295669, -63.93879704532477);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2b2).title("Bloco 2B")
                                .snippet("DCE"));

                LatLng bloco2c = new LatLng(-8.834460170192001, -63.93868975199559);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2c).title("Bloco 2C")
                                .snippet("Departamentos"));

                LatLng bloco2d = new LatLng(-8.834310479949307, -63.93848063717347);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2d).title("Bloco 2D"));

                LatLng bloco2e = new LatLng(-8.834058876394403, -63.93906970713514);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2e).title("Bloco 2E")
                                .snippet("DIRCA e DIRED"));

                LatLng bloco2e2 = new LatLng(-8.834438573424283, -63.93909608023147);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2e2).title("Bloco 2E")
                                .snippet("Biblioteca"));

                LatLng bloco2f = new LatLng(-8.834104636041417, -63.93869816326186);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2f).title("Bloco 2F")
                                .snippet("Pós-graduação - PGBIOEXP e PGDRA"));

                LatLng bloco2g = new LatLng(-8.8339607483991, -63.93850035888725);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2g).title("Bloco 2G")
                                .snippet("EDUCIÊNCIA"));

                LatLng bloco2h = new LatLng(-8.833947532696136, -63.938731025574924);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2h).title("Bloco 2H")
                                .snippet("Laboratório de Genética Humana"));

                LatLng bloco2i = new LatLng(-8.833093052492707, -63.938979039516965);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2i).title("Bloco 2I")
                                .snippet("Laboratório de Informática e GAEPPE"));

                LatLng bloco2j = new LatLng(-8.83298006294842, -63.938798018191754);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2j).title("Bloco 2J")
                                .snippet("Almoxarifado e Laboratórios de Práticas Artística"));

                LatLng bloco2k = new LatLng(-8.83283686144361, -63.93890970766099);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2k).title("Bloco 2K")
                                .snippet("Salas e Laboratórios do Curso de Enfermagem"));

                LatLng bloco2l = new LatLng(-8.833289875451054, -63.93882487350357);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2l).title("Bloco 2L")
                                .snippet("Laboratórios do Curso de Arqueologia"));

                LatLng bloco2m = new LatLng(-8.83470618186573, -63.93904667966373);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2m).title("Bloco 2M")
                                .snippet("Espaço Murupi"));

                LatLng bloco2n = new LatLng(-8.835134485989757, -63.93906771954042);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco2n).title("Bloco 2N")
                                .snippet("Espaço Urucum"));


                //BLOCOS 3
                LatLng bloco3a = new LatLng(-8.83227787957057, -63.93888537954527);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco3a).title("Bloco 3A")
                                .snippet("Salas e Laboratórios do Curso de Medicina"));

                LatLng bloco3b = new LatLng(-8.832306235491552, -63.938738821953216);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco3b).title("Bloco 3B")
                                .snippet("Laboratórios do Curso de Medicina"));

                LatLng bloco3c = new LatLng(-8.83208298677443, -63.938591689222726);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco3c).title("Bloco 3C")
                                .snippet("Biotério"));

                LatLng bloco3d = new LatLng(-8.832407035782207, -63.93908660257428);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco3d).title("Bloco 3D")
                                .snippet("Salas do Curso de Psicologia"));


                //BLOCO 4
                LatLng tatuzao = new LatLng(-8.83356586893297, -63.940308287770065);
                googleMap.addMarker(
                        new MarkerOptions().position(tatuzao).title("Tatuzão")
                                .snippet("Ginásio Poliesportivo"));

                LatLng bloco4a = new LatLng(-8.834796710193336, -63.93971912343873);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco4a).title("Bloco 4A")
                                .snippet("Pró-Reitorias"));

                LatLng bloco4b = new LatLng(-8.834099640430145, -63.94069218499845);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco4b).title("Bloco 4B")
                                .snippet("Láboratórios de Biologia"));

                LatLng bloco4c = new LatLng(-8.832919448380645, -63.94021624420087);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco4c).title("Bloco 4C")
                                .snippet("Salas do Curso de Educação Física"));

                LatLng bloco4d = new LatLng(-8.835415025642037, -63.940992966730676);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco4d).title("Bloco 4D")
                                .snippet("Salas e Laboratórios do curso de Engenharia Civil"));

                LatLng bloco4h = new LatLng(-8.834709651152707, -63.940674917561864);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco4h).title("Bloco 4H")
                                .snippet("Salas e Laboratórios do curso de Engenharia Elétrica"));


                //Bloco 5
                LatLng bloco5a = new LatLng(-8.83815077359086, -63.938311231635765);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco5a).title("Bloco 5A")
                                .snippet("CCGC"));

                LatLng bloco5b = new LatLng(-8.838084045875629, -63.938143003498986);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco5b).title("Bloco 5B")
                                .snippet(""));

                LatLng bloco5c = new LatLng(-8.838225598226618, -63.938137531215226);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco5c).title("Bloco 5C")
                                .snippet("Laboratórios do Curso de Música"));

                LatLng bloco5d = new LatLng(-8.838353491179673, -63.938317081924325);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco5d).title("Bloco 5D")
                                .snippet(""));

                LatLng bloco5e = new LatLng(-8.838516427013031, -63.93810731281478);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco5e).title("Bloco 5E")
                                .snippet(""));

                LatLng bloco5f = new LatLng(-8.838192694464382, -63.93847416591728);
                googleMap.addMarker(
                        new MarkerOptions().position(bloco5f).title("Bloco 5F")
                                .snippet("Galpão Património"));


                // Ampliar a localização dos marcadores - 2.0 até 21.0
                googleMap.moveCamera(
                        CameraUpdateFactory.newLatLngZoom(bloco2n,17));
            }
        });
        }
        return v;
    }
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_principal, container, false);

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}