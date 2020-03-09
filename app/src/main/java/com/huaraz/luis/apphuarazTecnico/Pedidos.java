package com.huaraz.luis.apphuarazTecnico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.os.AsyncTask;
import com.huaraz.luis.apphuarazTecnico.Adaptador.DemoAdapter;
import com.huaraz.luis.apphuarazTecnico.Adaptador.NoticiaAdapter;
import com.huaraz.luis.apphuarazTecnico.Adaptador.PedidosAdapter;
import com.huaraz.luis.apphuarazTecnico.Model.Demo;
import com.huaraz.luis.apphuarazTecnico.Model.Noticias;
import com.huaraz.luis.apphuarazTecnico.Model.Pedido;
import com.huaraz.luis.apphuarazTecnico.Model.Pet;
import com.huaraz.luis.apphuarazTecnico.Servicio.APIService;
import com.huaraz.luis.apphuarazTecnico.Servicio.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pedidos extends Fragment {
    private APIService mAPIService;
    PedidosAdapter pet;
    private FloatingActionButton fabAddPet;
    ListView lv;

    ArrayList<Pedido> fotografia= new ArrayList<>();

    public Pedidos() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_pedidos, container, false);

        lv = (ListView) root.findViewById(R.id.lista_demos);

        mAPIService = ApiUtils.getAPIService();  ///Crear variable global para realizar una conexion unica
        loadProfile();
       /*
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                System.out.println("hola");
                Intent in  = new Intent(getActivity(),Fotografia.class);
                startActivity(in);

            }
        });*/






      //   fabAddPet = (FloatingActionButton)root.findViewById(R.id.AddPet);



        //codigoSocio = WebServiceValidarUsuario.codigoSocio;

        // lv = (ListView) root.findViewById(R.id.lista_lost_pet);
        // AsyncCallWS task = new AsyncCallWS();
        //task.execute();
        //Evento de pruebas




        return  root;

    }

    public  void  loadProfile(){


        //final

        // final List<Pet> itemsPet = new ArrayList<>();


        mAPIService.getPedido().enqueue(new Callback<List<Pedido>>() {
            @Override
            public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {


                if(response.isSuccessful()) {
                    for(int i=0;i<response.body().size();i++){
                        fotografia.add(response.body().get(i));
                        // itemsPet.add(response.body().get(i).getPet());
                        System.out.println("Llegada de valor"+fotografia.get(i).toString());
                        // System.out.println("array ++"+itemsLostPets.get(i).getInfo()+"Name"+itemsPet.get(i).getName());


                    }

                }else {
                    int statusCode  = response.code();
                    System.out.println("2"+statusCode);
                    // handle request errors depending on status code
                }
                if (getActivity()!=null){

                    pet = new PedidosAdapter (getActivity(),fotografia);
                    //  lv.setLa;
                    lv.deferNotifyDataSetChanged();
                    lv.setAdapter(pet);

                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                            Intent in  = new Intent(getContext().getApplicationContext(),Fotografia.class);
                            Pedido de =  pet.getItem(i);

                            in.putExtra("id_pedido",de.getId_pedido());
                            /*
                            in.putExtra("foto01",de.getFoto_01());
                            in.putExtra("foto02",de.getFoto_02());
                            in.putExtra("foto03",de.getFoto_02());
                            */

                            startActivity(in);



                        }
                    });


                    System.out.println("3");
                }////codigo importante





            }

            @Override
            public void onFailure(Call<List<Pedido>> call, Throwable t) {

            }
        });


        /*

        System.out.println("Demo Demo");
        mAPIService.getFoto().enqueue(new Callback<List<Demo>>() {
            @Override
            public void onResponse(Call<List<Demo>> call, Response<List<Demo>> response) {


                if(response.isSuccessful()) {
                    for(int i=0;i<response.body().size();i++){
                        fotografia.add(response.body().get(i));
                        // itemsPet.add(response.body().get(i).getPet());
                        System.out.println("Luis"+fotografia.get(i).getId_distrito().toString());
                        // System.out.println("array ++"+itemsLostPets.get(i).getInfo()+"Name"+itemsPet.get(i).getName());


                    }

                }else {
                    int statusCode  = response.code();
                    System.out.println("2"+statusCode);
                    // handle request errors depending on status code
                }
                if (getActivity()!=null){

                    pet = new PedidosAdapter (getActivity(),fotografia);
                  //  lv.setLa;
                    lv.deferNotifyDataSetChanged();
                    lv.setAdapter(pet);

                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                            Demo de =  pet.getItem(i);
                            Intent in  = new Intent(getActivity(),Fotografia.class);

                            in.putExtra("foto01",de.getId_foto1());
                            in.putExtra("foto02",de.getId_foto2());
                            in.putExtra("foto03",de.getId_foto3());

                            startActivity(in);



                        }
                    });


                    System.out.println("3");
                }////codigo importante



            }

            @Override
            public void onFailure(Call<List<Demo>> call, Throwable t) {
                t.printStackTrace();
            }
        });


  */

    }


    public  void pets(){
        int user=loginPet.id_user;
        String usuario= String.valueOf(user);
        //idi de usuario mientras realizo el login fijo 49

        final List<Pet> itemsPets = new ArrayList<>();
        mAPIService.getMyPets(usuario).enqueue(new Callback<List<Pet>>() {
            @Override
            public void onResponse(Call<List<Pet>> call, Response<List<Pet>> response) {

                if(response.isSuccessful()) {
                    System.out.println("Ingresa el valor"+response.body());
                    for(int i=0;i<response.body().size();i++){
                        itemsPets.add(response.body().get(i));

                    }

                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
                if (getActivity()!=null){

                 /*
                pet = new PetAdapter(getActivity(),itemsPets);
                lv.setAdapter(pet);
                */
                }
            }

            @Override
            public void onFailure(Call<List<Pet>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


}
