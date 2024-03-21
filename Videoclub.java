package videoclub;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.time.temporal.*;
import java.time.LocalDate;

public class Videoclub {
static ArrayList<Socio> Socios = new ArrayList<Socio>();
static ArrayList<Pelicula> Peliculas = new ArrayList<Pelicula>();

public boolean contiene_socio(String ID) {
	for(Socio i : Videoclub.Socios) {
		if (i.getID().equals(ID)){
			return true;
		}
	}
	return false;}
public boolean contiene_pelicula(String titulo) {
	for(Pelicula i : Videoclub.Peliculas) {
		if (i.getTitulo().equals(titulo)){
			return true;
		}
	}
	return false;}
public void alta_socio(Socio socio) {
	Videoclub.Socios.add(socio);
}
public void baja_socio(String ID) {
	for(Socio i : Videoclub.Socios) {
		if (i.getID().equals(ID)){
			Videoclub.Socios.remove(i);
		}}}
public void alta_pelicula(Pelicula pelicula, int ejemplares) {
	for (int i=1; i<= ejemplares;i++) {
		Pelicula nuevo_ejemplar= new Pelicula(pelicula.getTitulo(),pelicula.getGenero(), pelicula.getDias_permitidos());
		Videoclub.Peliculas.add(nuevo_ejemplar);
	}}
public int baja_pelicula(String titulo, int ejemplares) {
	int bajas_efectivas = 0;
	int i=0;
	while ((i<Peliculas.size())&&(bajas_efectivas<ejemplares)) {
		if ((Peliculas.get(i).getTitulo().equals(titulo))&&(Peliculas.get(i).getAlquilada().equals("Nadie"))) {
			Peliculas.remove(i);
			bajas_efectivas += 1;
		}
		else { i+=1;}
	}
	return bajas_efectivas;
	}
public long devolver_pelicula(String titulo, String ID) {
	for (Pelicula i: Peliculas) {
		if((i.getTitulo().equals(titulo))&&(i.getAlquilada().equals(ID))) {
			i.setAlquilada("Nadie");
			long dias_retraso = ChronoUnit.DAYS.between(i.getFecha_alquiler(), LocalDate.now());
			return dias_retraso;
		}
	}
	return -1;

}
public boolean alquilar_pelicula(String titulo, String ID) {
	for(Pelicula i: Peliculas) {
		if ((i.getTitulo().equals(titulo))&&(i.getAlquilada().equals("Nadie"))) {
			i.setAlquilada(ID);
			i.setFecha_alquiler(LocalDate.now());
			return true;
		}
	}
	return false;
}
public void listado_por_genero(String genero) {
	ArrayList <String> disponibles = new ArrayList<String>();
	ArrayList <String> alquiladas = new ArrayList<String>();
	for (Pelicula i: Peliculas) {
		if (i.getGenero().equals(genero)) {
			if ((i.getAlquilada().equals("Nadie"))&&(!(disponibles.contains(i.getTitulo())))) {
				disponibles.add(i.getTitulo());
			}
		}
		else if (!(i.getAlquilada().equals("Nadie"))&&!(alquiladas.contains(i.getTitulo()))) {
			alquiladas.add(i.getTitulo());
		}
	}
	for (String titulo: disponibles) {JOptionPane.showMessageDialog(null, titulo+" DISPONIBLE");}
	for (String titulo: alquiladas) {
		if (!(disponibles.contains(titulo))){
		JOptionPane.showMessageDialog(null, titulo+" NO DISPONIBLE");}}
	
}


}
