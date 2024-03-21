package videoclub;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Videoclub videoclub = new Videoclub();

        int opcion;
        Socio socio;
        String dni;
        Pelicula pelicula;
        int ejemplares;
        String titulo;
        int bajas;

        opcion = menu();

        while (opcion != 8) {

                if (opcion == 1) {

                JOptionPane.showMessageDialog(null, "Alta de socio");
                socio = nuevo_socio();
                if (videoclub.contiene_socio(socio.getID())) {
                    JOptionPane.showMessageDialog(null, "Ya existía un socio con este ID: " + socio.getID());
                } else {
                    videoclub.alta_socio(socio);
                }
            } else if (opcion == 2) {
                dni = JOptionPane.showInputDialog("Escribe el DNI del socio a dar de baja");

                if (videoclub.contiene_socio(dni)) {
                    videoclub.baja_socio(dni);
                    JOptionPane.showMessageDialog(null, "El socio con ID: " + dni + " ha sido dado de baja.");
                } else {
                    JOptionPane.showMessageDialog(null, "No existe ningún socio con este ID: " + dni);
                }
            } else if (opcion == 3) {
                JOptionPane.showMessageDialog(null, "Alta de película.");
                pelicula = nueva_pelicula();
                ejemplares = Integer.parseInt(JOptionPane.showInputDialog("Escriba la cantidad de ejemplares a dar de alta"));
                videoclub.alta_pelicula(pelicula, ejemplares);

            } else if (opcion == 4) {

                titulo = JOptionPane.showInputDialog("Baja de películas\nEscriba el título de la película a dar de baja");
                ejemplares = Integer.parseInt(JOptionPane.showInputDialog("Escriba la cantidad de ejemplares a dar de baja"));

                bajas = videoclub.baja_pelicula(titulo, ejemplares);

                if (bajas < ejemplares) {
                    JOptionPane.showMessageDialog(null, "Solo se pueden dar de baja " + ejemplares + " ejemplares.");
                } else {
                    JOptionPane.showMessageDialog(null, "Operación realizada");

                }

            } else if (opcion == 5) {
                titulo = JOptionPane.showInputDialog("Alquilar película \nEscriba el título de la película a alquilar");

                dni = JOptionPane.showInputDialog("Escribe el ID del socio");

                boolean hay_pelicula = videoclub.contiene_pelicula(titulo);
                boolean hay_socio = videoclub.contiene_socio(dni);

                if (hay_pelicula && hay_socio) {
                    if (videoclub.alquilar_pelicula(titulo, dni)) {
                        JOptionPane.showMessageDialog(null, "Operación realizada");
                    } else {
                        JOptionPane.showMessageDialog(null, "La película no está disponible");
                    }}
                    else {
                    if(!(hay_pelicula)){
                    JOptionPane.showMessageDialog(null, "No hay película titulada "+ titulo); 
                    }
                    if(!(hay_socio)){
                    JOptionPane.showMessageDialog(null, "No hay socio con ID " + dni); 
                    }
                    }
                } 
            else if (opcion == 6) {
                titulo = JOptionPane.showInputDialog("Devolver película \n Escriba el título de la película a devolver");
                dni = JOptionPane.showInputDialog("Escribe el ID del socio");
                boolean hay_pelicula = videoclub.contiene_pelicula(titulo);
                boolean hay_socio = videoclub.contiene_socio(dni);
                if (hay_pelicula && hay_socio) {
                   long resultado = videoclub.devolver_pelicula(titulo, dni);
                    if (resultado == 0) {
                        JOptionPane.showMessageDialog(null, "Operación realizada");
                    } else if (resultado > 0) {
                        JOptionPane.showMessageDialog(null, "Película entregada con un retraso de " + resultado + "dias");
                    } else {
                        JOptionPane.showMessageDialog(null, "La película " + titulo + "no está alquilada al socio " + dni);
                    }

                } else {
                    if (!(hay_pelicula)) {
                        JOptionPane.showMessageDialog(null, "No hay película titulada " + titulo);
                    }
                    if (!(hay_socio)) {
                        JOptionPane.showMessageDialog(null, "No hay socio con ID " + dni);
                    }
                }
            } else if (opcion == 7) {
                JOptionPane.showMessageDialog(null, "Listado por género");
                String genero = JOptionPane.showInputDialog("Género:");
                videoclub.listado_por_genero(genero);
            }

             opcion = menu();}
        
	}
	public static int menu() {
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("==========VIKBUSTER==========\n"
				+ "1) Dar de alta nuevo socio.\n2) Dar de baja un socio.\n3) Dar de alta nueva pelicula"
				+ "\n4) Dar de baja una pelicula.\n5) Alquilar pelicula.\n6) Devolver pelicula.\n"
				+ "7) Listado por género.\n8) Salir. \n Escoge opción:"));
		while (opcion<1 || opcion>8) {
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Escoge opción (entre 1 y 8): "));}
		return opcion;
	}
	public static Socio nuevo_socio() {
		String iD = JOptionPane.showInputDialog("Ingresa CURP (Será ID del club): ");
		String nombre = JOptionPane.showInputDialog("Ingresa nombre: ");
		String telefono = JOptionPane.showInputDialog("Ingresa número de celular: ");
		String domicilio = JOptionPane.showInputDialog("Ingresa domicilio: ");
		return new Socio(iD, nombre, telefono, domicilio);
	}
	public static Pelicula nueva_pelicula() {
		String titulo = JOptionPane.showInputDialog("Ingresa titulo: ");
		String genero = JOptionPane.showInputDialog("Ingresa género: ");
		int dias_permitidos = Integer.parseInt(JOptionPane.showInputDialog("Ingresa dias permitidos: "));
		return new Pelicula(titulo, genero, dias_permitidos);
		
	}

}
