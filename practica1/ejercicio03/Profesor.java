package practica1.ejercicio03;

public class Profesor extends Persona{
	private String catedra;
	private String facultad;
	
	public Profesor() {
		
	}
	
	public String getCatedra() {
		return catedra;
	}
	
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	
	public String getFacultad() {
		return facultad;
	}
	
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	@Override
	public String tusDatos() {
		String aux = super.tusDatos();
		
		aux += "Catedra: " + this.getCatedra() + "\n" +
			  "Facultad: " + this.getFacultad() + "\n";
		
		return aux;
	}
}
