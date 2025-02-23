/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.feriaempresarial;

/**
 *
 * @author Kimberly Castro French - Eduar Sachica - Lizeth Katherine Trochez
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stand {
    private final int numero;
    private final String ubicacion;
    private final String tamano;
    private Empresa empresa; 
    private List<Visitante> visitantes;
    
    private static final String[] TAMANOS = {"Pequeño", "Mediano", "Grande"};
    private static final Random RANDOM = new Random();
    
    public Stand(int numero, String ubicacion) {
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.tamano = TAMANOS[RANDOM.nextInt(TAMANOS.length)];
        this.empresa = null; // Inicialmente libre
        this.visitantes = new ArrayList<>();
    }

    // Getters
    public int getNumero() { return numero; }
    public String getUbicacion() { return ubicacion; }
    public String getTamano() { return tamano; }
    public Empresa getEmpresa() { return empresa; }
    public String getEstado() { return (empresa == null) ? "Disponible" : "Ocupado"; }
    public List<Visitante> getVisitantes() { return visitantes; }

    // Asignar empresa al stand
    public void asignarEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    // Generar lista de stands
    public static List<Stand> generarStands() {
        List<Stand> stands = new ArrayList<>();
        int codigo = 1;
        
        for (char pabellon = 'A'; pabellon <= 'J'; pabellon++) {
            for (int i = 1; i <= 5; i++) {
                String ubicacion = "Pabellón: " + pabellon + " Stand: " + i;
                stands.add(new Stand(codigo, ubicacion));
                codigo++;
            }
        }
        return stands;
    }
     // Agregar visitante al stand
    public void agregarVisitante(Visitante visitante) {
        visitantes.add(visitante);
    }
}