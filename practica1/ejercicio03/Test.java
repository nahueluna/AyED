package practica1.ejercicio03;

public class Test {

	public static void main(String[] args) {
		Estudiante[] estudiantes = new Estudiante[2];
		Profesor[] profesores = new Profesor[3];
		
		Estudiante e1, e2;
		e1 = new Estudiante();
		e2 = new Estudiante();
		
		e1.setNombre("Nahuel");
		e1.setApellido("Luna");
		e1.setEmail("nahuelu@hotmail.com");
		e1.setComision(5);
		e1.setDireccion("Avenida Corrientes");
		
		e2.setNombre("Juan");
		e2.setApellido("Perez");
		e2.setEmail("juanperez@gmail.com");
		e2.setComision(8);
		e2.setDireccion("9 de Julio");
		
		estudiantes[0] = e1;
		estudiantes[1] = e2;
		
		Profesor p1, p2, p3;
		p1 = new Profesor();
		p2 = new Profesor();
		p3 = new Profesor();
		
		p1.setNombre("Pedro");
		p1.setApellido("Martinez");
		p1.setEmail("pedromartinez@hotmail.com");
		p1.setCatedra("FOD");
		p1.setFacultad("Informatica");
		
		p2.setNombre("Lionel");
		p2.setApellido("Messi");
		p2.setEmail("leomessi@hotmail.com");
		p2.setCatedra("Fulbo");
		p2.setFacultad("Humanidades");
		
		p3.setNombre("Cristiano");
		p3.setApellido("Ronaldo");
		p3.setEmail("ronaldo7@hotmail.com");
		p3.setCatedra("Electronica Digital");
		p3.setFacultad("Ingenieria");
		
		profesores[0] = p1;
		profesores[1] = p2;
		profesores[2] = p3;
		
		for(Estudiante var: estudiantes)
			System.out.println(var.tusDatos());
		
		System.out.println();
		
		for(Profesor var: profesores)
			System.out.println(var.tusDatos());
			
	}

}
