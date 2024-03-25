package practica1.ejercicio03;

public class Estudiante extends Persona {
	private int comision;
	private String direccion;
	
	public Estudiante() {
		
	}
	
	public int getComision() {
		return comision;
	}
	
	public void setComision(int comision) {
		this.comision = comision;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String tusDatos() {
		String aux = super.tusDatos();
		
		aux += "Comision: " + this.getComision() + "\n" +
			  "Direccion: " + this.getDireccion() + "\n";
		
		return aux;
	}
}
