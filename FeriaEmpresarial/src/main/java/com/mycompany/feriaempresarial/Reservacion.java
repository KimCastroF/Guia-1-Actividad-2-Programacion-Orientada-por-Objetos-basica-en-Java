/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.feriaempresarial;

import java.util.List;

/**
 *
 * @author Kimberly Castro French - Eduar Sachica - Lizeth Katherine Trochez
 */

public class Reservacion {
    private final List<Stand> stands;

    public Reservacion() {
        this.stands = Stand.generarStands();
    }

    // Mostrar stands con filtros
    public void mostrarStands(Integer codigo, Character pabellon, Integer numero, String estado) {
        for (Stand stand : stands) {
            boolean coincideCodigo = (codigo == null || stand.getNumero() == codigo);
            boolean coincidePabellon = (pabellon == null || stand.getUbicacion().contains("Pabellón: " + pabellon));
            boolean coincideNumero = (numero == null || stand.getNumero() == numero);
            boolean coincideEstado = (estado == null || stand.getEstado().equalsIgnoreCase(estado));

            if (coincideCodigo && coincidePabellon && coincideNumero && coincideEstado) {
                System.out.println("Código: " + stand.getNumero() + " | " + stand.getUbicacion() +
                        " | Tamaño: " + stand.getTamano() + " | Estado: " + stand.getEstado());
            }
        }
    }

    // Registrar empresa en un stand
    public boolean registrarEmpresa(String nombre, String sector, String correo, int numeroStand) {
        for (Stand stand : stands) {
            if (stand.getNumero() == numeroStand && stand.getEmpresa() == null) {
                stand.asignarEmpresa(new Empresa(nombre, sector, correo));
                return true;
            }
        }
        return false; // No se encontró un stand libre con ese número
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        Reservacion reservacion = new Reservacion();

        // Mostrar stands disponibles en el pabellón B
        System.out.println("Stands disponibles en el pabellón B:");
        reservacion.mostrarStands(null, 'B', null, "Disponible");

        // Registrar una empresa en un stand
        boolean registrado = reservacion.registrarEmpresa("TechCorp", "Tecnología", "contacto@techcorp.com", 2);
        if (registrado) {
            System.out.println("Empresa registrada con éxito.");
        } else {
            System.out.println("Stand ocupado o fuera de la lista");
        }

        // Mostrar stands actualizados
        System.out.println("\nStands después del registro:");
        reservacion.mostrarStands(null, null, null, null);
    }
        public boolean actualizarEmpresa(int numeroStand, String nuevoNombre, String nuevoSector, String nuevoCorreo) {
        for (Stand stand : stands) {
            if (stand.getNumero() == numeroStand && stand.getEmpresa() != null) {
                Empresa empresa = stand.getEmpresa();
                if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
                    empresa.setNombre(nuevoNombre);
                }
                if (nuevoSector != null && !nuevoSector.isEmpty()) {
                    empresa.setSector(nuevoSector);
                }
                if (nuevoCorreo != null && !nuevoCorreo.isEmpty()) {
                    empresa.setCorreo(nuevoCorreo);
                }
                return true; // Datos actualizados con éxito
            }
        }
        return false; // No se encontró la empresa en ese stand
    }
        public void mostrarEmpresasRegistradas() {
        boolean hayEmpresas = false;

        System.out.println("\n=== Empresas Registradas ===");
        for (Stand stand : stands) {
            if (stand.getEmpresa() != null) {
                Empresa empresa = stand.getEmpresa();
                System.out.println("Stand N°: " + stand.getNumero() +
                                   " | Ubicación: " + stand.getUbicacion() +
                                   " | Tamaño: " + stand.getTamano() +
                                   " | Empresa: " + empresa.getNombre() +
                                   " | Sector: " + empresa.getSector() +
                                   " | Correo: " + empresa.getCorreo());
                hayEmpresas = true;
            }
        }

        if (!hayEmpresas) {
            System.out.println("No hay empresas registradas en ningún stand.");
        }
    }
    public boolean registrarVisitante(int numeroStand, String nombre, int identificacion, String correo) {
        for (Stand stand : stands) {
            if (stand.getNumero() == numeroStand) {
                if (stand.getEmpresa() != null) {
                    Visitante visitante = new Visitante(nombre, identificacion, correo);
                    stand.agregarVisitante(visitante);
                    return true;
                } else {
                    System.out.println("No hay evento agendado a ese numero de stand");
                    return false;
                }
            }
        }
        System.out.println("Número de stand no válido.");
        return false;
    }
    
    public boolean actualizarVisitante(int identificacion, String nuevoNombre, Integer nuevaIdentificacion, String nuevoCorreo) {
        for (Stand stand : stands) {
            for (Visitante visitante : stand.getVisitantes()) {
                if (visitante.getIdentificacion() == identificacion) {
                    if (nuevoNombre != null) visitante.setNombre(nuevoNombre);
                    if (nuevaIdentificacion != null) visitante.setIdentificacion(nuevaIdentificacion);
                    if (nuevoCorreo != null) visitante.setCorreo(nuevoCorreo);
                    return true;
                }
            }
        }
        return false; // No se encontró el visitante con esa identificación
    }
    public boolean calificarStand(int identificacion, int calificacion, String comentario) {
        if (calificacion < 1 || calificacion > 5) {
            System.out.println("La calificación debe estar entre 1 y 5.");
            return false;
        }
        if (comentario.length() > 20) {
            System.out.println("El comentario no puede tener más de 20 caracteres.");
            return false;
        }

        for (Stand stand : stands) {
            for (Visitante visitante : stand.getVisitantes()) {
                if (visitante.getIdentificacion() == identificacion) {
                    visitante.setCalificacion(calificacion);
                    visitante.setComentario(comentario);
                    return true;
                }
            }
        }
        System.out.println("No se encontró un visitante con esa identificación.");
        return false;
    }
    public void mostrarVisitantes() {
        boolean hayVisitantes = false;

        for (Stand stand : stands) {
            if (!stand.getVisitantes().isEmpty()) {
                System.out.println("\n📌 Stand " + stand.getNumero() + " (" + stand.getUbicacion() + ")");
                for (Visitante visitante : stand.getVisitantes()) {
                    System.out.println("👤 " + visitante.getNombre() +
                            " | ID: " + visitante.getIdentificacion() +
                            " | Correo: " + visitante.getCorreo());
                }
                hayVisitantes = true;
            }
        }

        if (!hayVisitantes) {
            System.out.println("No hay visitantes registrados aún.");
        }
    }
    public double calcularPromedioCalificaciones() {
        int sumaTotal = 0;
        int cantidadTotal = 0;

        for (Stand stand : stands) {
            for (Visitante visitante : stand.getVisitantes()) {
                if (visitante.getCalificacion() > 0) {
                    sumaTotal += visitante.getCalificacion();
                    cantidadTotal++;
                }
            }
        }

        return cantidadTotal == 0 ? 0 : (double) sumaTotal / cantidadTotal;
    }


}