/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.feriaempresarial;

/**
 *
 * @author Kimberly Castro French - Eduar Sachica - Lizeth Katherine Trochez
 */

import java.util.Scanner;

public class FeriaEmpresarial {
    public static void main(String[] args) {
        Reservacion reservacion = new Reservacion();
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            boolean continuar = true;

            while (continuar) {
                System.out.println(" ");
                System.out.println("1 Hacer reservación de empresa");
                System.out.println("2.Hacer reservación de visitante");
                System.out.println("3.Editar datos de empresa");
                System.out.println("4.Editar datos de visitante");
                System.out.println("5.Mostrar stands");
                System.out.println("6.Dejar comentarios");
                System.out.println("7.Mostrar reportes de empresas");
                System.out.println("8.Mostrar reportes de visitantes");
                System.out.println("9.Mostrar promedio de calificaciones");
                System.out.println("0. Salir");                
                System.out.print("Elige una opción: ");

                if (scanner.hasNextInt()) { 
                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1 -> {
                            scanner.nextLine();
                            // Mostrar todos los stands disponibles
                            System.out.println("Stands disponibles en todos los pabellones:");
                            reservacion.mostrarStands(null, null, null, "Disponible");
                            System.out.print("Ingrese el nombre de la empresa: ");
                            String nombre = scanner.nextLine();
                            System.out.print("Ingrese el sector: ");                            
                            String sector = scanner.nextLine(); 

                            System.out.print("Ingrese el correo: ");
                            String correo = scanner.nextLine();
                            System.out.print("Ingrese el número de stand");
                            Integer numStand = scanner.nextInt();
                            scanner.nextLine(); // Consumir la línea extra

                            boolean registrado = reservacion.registrarEmpresa(nombre, sector, correo, numStand == -1 ? null : numStand);
                            if (registrado) {
                                System.out.println("Empresa registrada con éxito.");
                            } else {
                                System.out.println("stand ocupado o no encontrado en la lista");
                            }

                        }
                        case 2 -> {
                            System.out.print("Ingrese el número de stand donde desea registrarse: ");
                            int numeroStand = scanner.nextInt();
                            scanner.nextLine(); 

                            System.out.print("Ingrese su nombre: ");
                            String nombre = scanner.nextLine();

                            System.out.print("Ingrese su identificación: ");
                            int identificacion = scanner.nextInt();
                            scanner.nextLine(); 

                            System.out.print("Ingrese su correo electrónico: ");
                            String correo = scanner.nextLine();

                            boolean registrado = reservacion.registrarVisitante(numeroStand, nombre, identificacion, correo);
                            if (registrado) {
                                System.out.println("Visitante registrado exitosamente.");
                            }
                        }

                        case 3 -> {
                            System.out.print("Ingrese el número de stand donde está la empresa: ");
                            int numeroStand = scanner.nextInt();
                            scanner.nextLine(); 

                            System.out.print("Nuevo nombre de la empresa (presione Enter para no cambiar): ");
                            String nuevoNombre = scanner.nextLine();

                            System.out.print("Nuevo sector de la empresa (presione Enter para no cambiar): ");
                            String nuevoSector = scanner.nextLine();

                            System.out.print("Nuevo correo de la empresa (presione Enter para no cambiar): ");
                            String nuevoCorreo = scanner.nextLine();

                            boolean actualizado = reservacion.actualizarEmpresa(numeroStand, 
                                                     nuevoNombre.isEmpty() ? null : nuevoNombre, 
                                                     nuevoSector.isEmpty() ? null : nuevoSector, 
                                                     nuevoCorreo.isEmpty() ? null : nuevoCorreo);

                            if (actualizado) {
                                System.out.println("Datos de la empresa actualizados correctamente.");
                            } else {
                                System.out.println("No se encontró una empresa en ese stand o el número de stand es incorrecto.");
                            }
                        }

                        case 4 -> {
                            System.out.print("Ingrese su identificación: ");
                            int identificacion = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Nuevo nombre (presione Enter para no cambiar): ");
                            String nuevoNombre = scanner.nextLine();

                            System.out.print("Nueva identificación (presione Enter para no cambiar): ");
                            String identificacionInput = scanner.nextLine();
                            Integer nuevaIdentificacion = identificacionInput.isEmpty() ? null : Integer.parseInt(identificacionInput);

                            System.out.print("Nuevo correo (presione Enter para no cambiar): ");
                            String nuevoCorreo = scanner.nextLine();

                            boolean actualizado = reservacion.actualizarVisitante(identificacion, 
                                                        nuevoNombre.isEmpty() ? null : nuevoNombre, 
                                                        nuevaIdentificacion, 
                                                        nuevoCorreo.isEmpty() ? null : nuevoCorreo);

                            if (actualizado) {
                                System.out.println("Datos del visitante actualizados correctamente.");
                            } else {
                                System.out.println("No se encontró un visitante con esa identificación.");
                            }
                        }

                        case 5 -> {reservacion.mostrarStands(null, null, null, null);}
                        case 6 -> {
                            System.out.print("Ingrese su identificación: ");
                            int identificacion = scanner.nextInt();
                            scanner.nextLine(); 

                            System.out.print("Ingrese su calificación (1-5): ");
                            int calificacion = scanner.nextInt();
                            scanner.nextLine(); 

                            System.out.print("Ingrese su comentario (máx. 20 caracteres): ");
                            String comentario = scanner.nextLine();

                            if (comentario.length() > 20) {
                                System.out.println("El comentario es demasiado largo. Inténtelo de nuevo.");
                                break;
                            }

                            boolean registrado = reservacion.calificarStand(identificacion, calificacion, comentario);
                            if (registrado) {
                                System.out.println("Calificación registrada correctamente.");
                            }
                        }

                        case 7 -> {
                                System.out.println("\nLista de todas las empresas registradas y sus stands:");
                                reservacion.mostrarEmpresasRegistradas();
                            }
                        case 8 -> {
                            System.out.println("\n📋 Lista de visitantes registrados en cada stand:");
                            reservacion.mostrarVisitantes();
                        }

                        case 9 -> {
                            double promedio = reservacion.calcularPromedioCalificaciones();
                            System.out.println("\n⭐ Promedio de calificaciones de visitantes: " + (promedio == 0 ? "No hay calificaciones aún" : promedio));
                        }

                        case 0 -> {
                            System.out.println("Saliendo...");
                            continuar = false;
                        }
                        default -> System.out.println("Opción no válida. Intenta de nuevo.");
                    }
                } else {
                    System.out.println("Entrada no válida. Ingresa un número.");
                    scanner.next();
                }
            }
        }
    }
}