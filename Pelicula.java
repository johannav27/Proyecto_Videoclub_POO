package videoclub;

import java.time.LocalDate;

public class Pelicula {
	private String titulo;
    private String genero;
    private String Alquilada="Nadie";
	private LocalDate fecha_alquiler=null;
    private int dias_permitidos;

    public Pelicula(String titulo, String genero, int dias_permitidos) {
        this.titulo = titulo;
        this.genero = genero;
        this.Alquilada = "Nadie";
        this.dias_permitidos = dias_permitidos;
        this.fecha_alquiler =null;
        

    }
    public String toString() {
    	String cadena = "Titulo: "+this.getTitulo()+"\n Género:"+this.getGenero();
    	if (this.getAlquilada()=="Nadie") {
    		cadena= cadena + "\nDisponible";}
    	else {cadena = cadena + "\nAlquilada a: "+this.getAlquilada();}
		return cadena;}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public LocalDate getFecha_alquiler() {
		return fecha_alquiler;
	}

	public void setFecha_alquiler(LocalDate fecha_alquiler) {
		this.fecha_alquiler = fecha_alquiler;
	}

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAlquilada() {
        return Alquilada;
    }

    public void setAlquilada(String Alquilada) {
        this.Alquilada = Alquilada;
    }

    public int getDias_permitidos() {
        return dias_permitidos;
    }

    public void setDias_permitidos(int dias_permitidos) {
        this.dias_permitidos = dias_permitidos;
    }

    
}



