package practica3.ejercicio04;

public class AreaEmpresa {
	private String identificacion;
	private int retardo;
	
	public AreaEmpresa() {
		
	}
	
	public AreaEmpresa(int retardo) {
		this.identificacion = null;
		this.retardo = retardo;
	}
	
	public AreaEmpresa(String identificacion, int retardo) {
		this.identificacion = identificacion;
		this.retardo = retardo;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public int getRetardo() {
		return retardo;
	}

	public void setRetardo(int retardo) {
		this.retardo = retardo;
	}
	
	
}
