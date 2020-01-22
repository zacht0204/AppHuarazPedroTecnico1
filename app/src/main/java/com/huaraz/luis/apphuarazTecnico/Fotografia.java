package com.huaraz.luis.apphuarazTecnico;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;

public class Fotografia extends AppCompatActivity {

    String foto01;
    String foto02;
    String foto03;
    private ImageView imgOwnerPhoto1;
    private ImageView imgOwnerPhoto2;
    private ImageView imgOwnerPhoto3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotografia);


        //Valor de llegada dee la informacion
        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        foto01= (String) extras.get("foto01");
        foto02= (String) extras.get("foto02");
        foto03 = (String) extras.get("foto03");

        imgOwnerPhoto1 = (ImageView) findViewById(R.id.foto01);
        imgOwnerPhoto2 = (ImageView) findViewById(R.id.foto02);
        imgOwnerPhoto3 = (ImageView) findViewById(R.id.foto03);


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
