package com.huaraz.luis.apphuarazTecnico.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huaraz.luis.apphuarazTecnico.Model.Demo;
import com.huaraz.luis.apphuarazTecnico.Model.Noticias;
import com.huaraz.luis.apphuarazTecnico.Model.Pedido;
import com.huaraz.luis.apphuarazTecnico.R;

import java.util.List;

/**
 * Created by java on 07/12/2016.
 */

public class PedidosAdapter extends ArrayAdapter<Pedido> {

    String name=null;

    public List<Pedido> list;

    public PedidosAdapter(Context context, List<Pedido> objects) {
        super(context, 0, objects);
        list = objects;
    }

    @Override
    public Pedido getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.lista_pedidos,
                    parent,
                    false);


        holder = new ViewHolder();
    //    holder.photo = (ImageView) convertView.findViewById(R.id.petPhoto);
        holder.Provincia = (TextView) convertView.findViewById(R.id.Provincia);
        holder.Distrito = (TextView) convertView.findViewById(R.id.Distrito);
    //    holder.fecha=(TextView) convertView.findViewById(R.id.fecha);

        convertView.setTag(holder);
        }else{
            holder= (ViewHolder)convertView.getTag();
        }

        // Lead actual.
        Pedido demo = getItem(position);
        //demo = noti.get();

        // Configuracion

        //String foto=noti.getPicture();
        /*
        if(foto!=null){
        // Receiving side
        byte[] data1 = Base64.decode(foto, Base64.DEFAULT);
        String text1 = null;
        try {
            Bitmap bitmap = BitmapFactory.decodeByteArray(data1, 0, data1.length);
            holder.photo.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        }
        */
        /*
        Picasso.with(getContext())
                .load("http://findmewebapp-eberttoribioupc.c9.io/system/pets/photos/000/000/0"+pet.getId()+"/thumb/"+pet.getPhotoFileName())
                .resize(120, 120)
                .into( holder.photo);*/

        holder.Provincia.setText(demo.getProvincia());
        holder.Distrito.setText(demo.getDistrito());
       // holder.info_pet.setText(noti.getCaracteristica());
       // holder.fecha.setText(noti.getFecha());

     /*
        holder.sal_disp.setText(cuenta.getSaldo());
        holder.fecha_aper.setText(cuenta.getFechaApertura());
        holder.fecha_ult.setText(cuenta.getFechaUltimoMovimiento());
        holder.est_cuenta.setText(cuenta.getEstado());*/


        return convertView;
    }

    static class ViewHolder {

        ImageView photo;
        TextView name_pet;
        TextView info_pet;
        TextView fecha;
        TextView Provincia;
        TextView Distrito;

    }
}
