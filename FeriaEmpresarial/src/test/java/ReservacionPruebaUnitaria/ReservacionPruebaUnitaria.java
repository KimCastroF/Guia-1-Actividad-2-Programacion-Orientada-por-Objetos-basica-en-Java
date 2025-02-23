/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReservacionPruebaUnitaria;

/**
 *
 * @author Kimberly Castro French - Eduar Sachica - Lizeth Katherine Trochez
 */

import com.mycompany.feriaempresarial.Reservacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReservacionPruebaUnitaria {
    private Reservacion reservacion;

    @BeforeEach
    void setUp() {
        reservacion = new Reservacion(); 
    }

    @Test
    void testRegistrarEmpresa() {
        boolean resultado = reservacion.registrarEmpresa("Adidas", "Deportivo", "adidas@gmail.com", 2);
        assertTrue(resultado, "La empresa debería registrarse correctamente en un stand disponible.");
    }

    @Test
    void testRegistrarEmpresaEnStandOcupado() {
        reservacion.registrarEmpresa("Adidas", "Deportivo", "adidas@gmail.com", 2);
        boolean resultado = reservacion.registrarEmpresa("Nike", "Zapatos", "nike@gmail.com", 2);
        assertFalse(resultado, "No se debería permitir registrar otra empresa en un stand ya ocupado.");
    }

    @Test
    void testRegistrarVisitanteEnStandOcupado() {
        reservacion.registrarEmpresa("Adidas", "Deportivo", "adidas@gmail.com", 2);
        boolean resultado = reservacion.registrarVisitante(2, "Carlos Florez", 12345, "carlos@gmail.com");
        assertTrue(resultado, "El visitante debería poder registrarse en un stand ocupado.");
    }

    @Test
    void testRegistrarVisitanteEnStandVacio() {
        boolean resultado = reservacion.registrarVisitante(3, "María Díaz", 67890, "maria@gmail.com");
        assertFalse(resultado, "No se debería permitir registrar un visitante en un stand sin empresa.");
    }

    @Test
    void testAsignarCalificacionYComentario() {
        reservacion.registrarEmpresa("Adidas", "Deportivo", "adidas@gmail.com", 2);
        reservacion.registrarVisitante(2, "Carlos Florez", 12345, "carlos@gmail.com");

        boolean calificado = reservacion.calificarStand(12345, 5, "¡uJu!");
        assertTrue(calificado, "El visitante debería poder calificar el stand.");
    }

    @Test
    void testPromedioCalificaciones() {
        reservacion.registrarEmpresa("Adidas", "Deportivo", "adidas@gmail.com", 2);
        reservacion.registrarVisitante(2, "Carlos Florez", 12345, "carlos@gmail.com");
        reservacion.calificarStand(12345, 5, "Excelente!");

        reservacion.registrarVisitante(2, "María Díaz", 67890, "maria@gmail.com");
        reservacion.calificarStand(67890, 3, "Regular");

        double promedio = reservacion.calcularPromedioCalificaciones();
        assertEquals(4.0, promedio, 0.1, "El promedio de calificaciones debería ser correcto.");
    }
}
