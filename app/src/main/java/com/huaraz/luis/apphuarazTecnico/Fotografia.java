package com.huaraz.luis.apphuarazTecnico;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huaraz.luis.apphuarazTecnico.Model.Pedido;
import com.huaraz.luis.apphuarazTecnico.Servicio.APIService;
import com.huaraz.luis.apphuarazTecnico.Servicio.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fotografia extends AppCompatActivity {

    String foto01;
    String foto02;
    String foto03;
    private ImageView imgOwnerPhoto1;
    private ImageView imgOwnerPhoto2;
    private ImageView imgOwnerPhoto3;
    private APIService mAPIService;
    int id_pedido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotografia);


        //Valor de llegada dee la informacion
        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        id_pedido= (int) extras.get("id_pedido");
        System.out.println("Valor del id"+id_pedido);
     //   foto01= (String) extras.get("foto01");
     //   foto02= (String) extras.get("foto02");
     //   foto03 = (String) extras.get("foto03");


       // System.out.println("llegada de foto"+foto01+foto02+foto03);
        imgOwnerPhoto1 = (ImageView) findViewById(R.id.foto01);
        imgOwnerPhoto2 = (ImageView) findViewById(R.id.foto02);
        imgOwnerPhoto3 = (ImageView) findViewById(R.id.foto03);

        mAPIService = ApiUtils.getAPIService();
        Toast toast = new Toast(getApplicationContext());

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById((R.id.lytLayout)));

        TextView txtMsg = (TextView)layout.findViewById(R.id.txtMensaje);
        txtMsg.setText("¡Esperando Muestra de Cultivos!");

        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

        mAPIService.getMyPedidoD(id_pedido).enqueue(new Callback<Pedido>() {
            @Override
            public void onResponse(Call<Pedido> call, Response<Pedido> response) {

                if(response.isSuccessful()) {

                    foto01=response.body().getFoto_01();
                    foto02=response.body().getFoto_02();
                    foto03=response.body().getFoto_03();
                    System.out.println("Valor del fotos cargado"+foto01+foto02+foto03);

                    if(foto01!=null){
                        //Receiving side
                        byte[] data1 = Base64.decode(foto01, Base64.DEFAULT);
                        String text1 = null;
                        try {
                            Bitmap bitmap = BitmapFactory.decodeByteArray(data1, 0, data1.length);
                            Bitmap imagenFinal = Bitmap.createScaledBitmap(bitmap,500,500,false);
                            imgOwnerPhoto1.setImageBitmap(imagenFinal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    if(foto02!=null){
                        //Receiving side
                        byte[] data2 = Base64.decode(foto02, Base64.DEFAULT);
                        String text1 = null;
                        try {
                            Bitmap bitmap1 = BitmapFactory.decodeByteArray(data2, 0, data2.length);
                            Bitmap imagenFinal = Bitmap.createScaledBitmap(bitmap1,500,500,false);
                            imgOwnerPhoto2.setImageBitmap(imagenFinal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    if(foto03!=null){
                        //Receiving side
                        byte[] data3 = Base64.decode(foto03, Base64.DEFAULT);
                        String text1 = null;
                        try {
                            Bitmap bitmap3 = BitmapFactory.decodeByteArray(data3, 0, data3.length);
                            Bitmap imagenFinal = Bitmap.createScaledBitmap(bitmap3,500,500,false);
                            imgOwnerPhoto3.setImageBitmap(imagenFinal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }





                }

            }

            @Override
            public void onFailure(Call<Pedido> call, Throwable t) {

            }
        });

       /*
        if(foto01!=null){
            //Receiving side
            byte[] data1 = Base64.decode(foto01, Base64.DEFAULT);
            String text1 = null;
            try {
                Bitmap bitmap = BitmapFactory.decodeByteArray(data1, 0, data1.length);
                Bitmap imagenFinal = Bitmap.createScaledBitmap(bitmap,500,500,false);
                imgOwnerPhoto1.setImageBitmap(imagenFinal);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if(foto02!=null){
            //Receiving side
            byte[] data2 = Base64.decode(foto02, Base64.DEFAULT);
            String text1 = null;
            try {
                Bitmap bitmap1 = BitmapFactory.decodeByteArray(data2, 0, data2.length);
                Bitmap imagenFinal = Bitmap.createScaledBitmap(bitmap1,500,500,false);
                imgOwnerPhoto2.setImageBitmap(imagenFinal);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if(foto03!=null){
            //Receiving side
            byte[] data3 = Base64.decode(foto03, Base64.DEFAULT);
            String text1 = null;
            try {
                Bitmap bitmap3 = BitmapFactory.decodeByteArray(data3, 0, data3.length);
                Bitmap imagenFinal = Bitmap.createScaledBitmap(bitmap3,500,500,false);
                imgOwnerPhoto3.setImageBitmap(imagenFinal);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        */



    }
}
