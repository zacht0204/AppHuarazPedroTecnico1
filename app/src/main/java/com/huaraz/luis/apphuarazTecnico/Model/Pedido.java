
package com.huaraz.luis.apphuarazTecnico.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pedido {

    @SerializedName("id_pedido")
    @Expose
    private int id_pedido;

    @SerializedName("foto_01")
    @Expose
    private String foto_01;

    @SerializedName("foto_02")
    @Expose
    private String foto_02;

    @SerializedName("foto_03")
    @Expose
    private String foto_03;

    @SerializedName("provincia")
    @Expose
    private String provincia;

    @SerializedName("distrito")
    @Expose
    private String distrito;

    @SerializedName("id_usuario")
    @Expose
    private int id_usuario;

    @SerializedName("id_tecnico")
    @Expose
    private int id_tecnico;

    @SerializedName("fecha")
    @Expose
    private String fecha;

    @SerializedName("estado")
    @Expose
    private int estado;

    @SerializedName("altitud")
    @Expose
    private String altitud;

    @SerializedName("latitud")
    @Expose
    private String latitud;

    @SerializedName("temperatura")
    @Expose
    private String temperatura;

    @SerializedName("apellidos")
    @Expose
    private String apellidos;

    @SerializedName("nombres")
    @Expose
    private String nombres;

    @SerializedName("dni")
    @Expose
    private String dni;

    @SerializedName("telefono")
    @Expose
    private String telefono;


    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }




    public String getFoto_01() {
        return foto_01;
    }

    public void setFoto_01(String foto_01) {
        this.foto_01 = foto_01;
    }

    public String getFoto_02() {
        return foto_02;
    }

    public void setFoto_02(String foto_02) {
        this.foto_02 = foto_02;
    }

    public String getFoto_03() {
        return foto_03;
    }

    public void setFoto_03(String foto_03) {
        this.foto_03 = foto_03;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(int id_tecnico) {
        this.id_tecnico = id_tecnico;
    }



    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getAltitud() {
        return altitud;
    }

    public void setAltitud(String altitud) {
        this.altitud = altitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
}


