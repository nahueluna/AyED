package practica1.ejercicio03;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private String email;
	
	public Persona() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String tusDatos() {
		String aux = "Nombre: " + this.getNombre() + "\n" +
					 "Apellido: " + this.getApellido() + "\n" +
					 "Email: " + this.getEmail() + "\n";
		
		return aux;
	}
}
