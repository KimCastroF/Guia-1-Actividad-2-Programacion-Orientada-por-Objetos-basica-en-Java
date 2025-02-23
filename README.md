# Guia-1-Actividad-2-Programacion-Orientada-por-Objetos-basica-en-Java
 Solución Guía 1 - Actividad 2. Programación Orientada por Objetos básica en Java - Desarrollo de Software - Universidad EAN

# Sistema de Gestión de Feria Empresarial

## Descripción
Este proyecto es la solución de la Actividad No. 2 de la Guía 1 para la asignatura de Desarrollo de Software de la Universidad EAN, carrera de Ingeniería de Sistemas. El sistema permite gestionar reservas de stands para empresas y registro de visitantes en una feria empresarial.

## Funcionalidades

### 1. Reservación de Stands (Opción 1)
- Muestra stands habilitados y disponibles
- Solicita datos de la empresa:
  - Nombre de la empresa
  - Sector
  - Correo electrónico
  - Código del stand deseado
- Verifica disponibilidad del stand seleccionado

### 2. Registro de Visitantes (Opción 2)
- Requiere registro previo de empresa en el stand
- Solicita datos del visitante:
  - Número de stand a visitar
  - Nombre
  - Identificación
  - Correo electrónico
- Valida que el stand esté ocupado por una empresa

### 3. Edición de Datos de Empresa (Opción 3)
- Permite modificar información de empresas registradas
- Verifica existencia de empresa en el stand
- Actualiza todos los datos de la empresa

### 4. Edición de Datos de Visitante (Opción 4)
- Modifica información de visitantes registrados
- Requiere identificación válida del visitante

### 5. Visualización de Stands (Opción 5)
- Muestra todos los stands:
  - Disponibles
  - Ocupados
- Incluye detalles de pabellón, número y tamaño

### 6. Sistema de Comentarios (Opción 6)
- Permite a visitantes registrados dejar comentarios
- Incluye:
  - Calificación (1-5)
  - Comentario (máximo 20 caracteres)
- Requiere identificación válida

### 7. Reporte de Empresas (Opción 7)
Muestra información detallada de empresas registradas:
- Código
- Ubicación en pabellón
- Número de stand
- Tamaño
- Nombre de empresa
- Sector
- Correo electrónico

### 8. Reporte de Visitantes (Opción 8)
Lista completa de visitantes con:
- Nombre
- Identificación
- Correo electrónico
- Código de stand
- Pabellón
- Número de stand

### 9. Promedio de Calificaciones (Opción 9)
- Muestra el promedio de calificaciones de visitantes

### 0. Salir (Opción 0)
- Finaliza la ejecución del programa

## Requisitos Importantes
1. Para registrar una empresa, el stand debe estar disponible
2. Para registrar un visitante, el stand debe estar ocupado por una empresa
3. La modificación de datos requiere registro previo
4. Los comentarios requieren registro tanto de empresa como de visitante
5. Los reportes mostrarán mensaje si no hay registros
6. El promedio de calificaciones requiere al menos una calificación registrada

## Ejecución del Proyecto
1. Abrir el proyecto en NetBeans
2. Ejecutar el proyecto usando el ícono "Run Project" o presionando F6
3. Seleccionar la opción deseada del menú (1-9, 0 para salir)
