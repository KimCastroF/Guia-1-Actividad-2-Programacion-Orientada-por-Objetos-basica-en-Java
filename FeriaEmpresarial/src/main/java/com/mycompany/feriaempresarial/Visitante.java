/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.feriaempresarial;

/**
 *
 * @author Kimberly Castro French - Eduar Sachica - Lizeth Katherine Trochez
 */

public class Visitante {
    private String nombre;
    private int identificacion;
    private String correo;
    private Integer calificacion;
    private String comentario; 
    
//constructor
    public Visitante(String nombre, int identificacion, String correo) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correo = correo;
        this.calificacion = null;
        this.comentario = null;
    }
    
//getter para conseguir los datos
    public String getNombre() { return nombre; }
    public int getIdentificacion() { return identificacion; }
    public String getCorreo() { return correo; }
    public Integer getCalificacion() { return calificacion; }
    public String getComentario() { return comentario; }
    
//setter para modificar los datos de las instancias del constructor
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setIdentificacion(int identificacion) { this.identificacion = identificacion; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }
    public void setComentario(String comentario) { this.comentario = comentario; }   
}