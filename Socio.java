package videoclub;

public class Socio {
	private String nombre;
	private String ID;
	private String celular;
	private String domicilio; 
	//private date(libreria de fecha) fecha_de_nacimiento; esta clase es opcional podria ser para dar un regalo al socio si es su cumple 
	    
	//constructor
	
	
	    
	

	public Socio(String ID,String nombre, String celular, String domicilio) {
	    this.nombre = nombre;
	    this.ID= ID;
	    this.celular = celular;
	    this.domicilio = domicilio;
	    }
	public String toString() {
		return "DNI: "+this.getID()+"\nNombre: "+this.getNombre()+"\nTelefono: "+this.getCelular()+""
				+ "\nDireccion: "+this.getDomicilio();}

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getNombre() {
		return nombre;
	}

	public String getID() {
		return ID;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setID(String iD) {
		ID = iD;
	}

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
     
     
}




