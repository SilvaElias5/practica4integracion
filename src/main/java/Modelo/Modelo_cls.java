package Modelo;

public class Modelo_cls {
	private int id;
	private String Nombre_pila;
	private String Apellido_paterno;
	private String Apellido_materno;
	private String Servicio;
	private int Fecha_nacimiento;
	private String Plan;
	private String Estatus;
	
	public Modelo_cls(int id, String nombre_pila, String apellido_paterno, String apellido_materno, String servicio,
			int fecha_nacimiento, String plan, String estatus) {
		super();
		this.id = id;
		Nombre_pila = nombre_pila;
		Apellido_paterno = apellido_paterno;
		Apellido_materno = apellido_materno;
		Servicio = servicio;
		Fecha_nacimiento = fecha_nacimiento;
		Plan = plan;
		Estatus = estatus;
	}
public Modelo_cls() {
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre_pila() {
	return Nombre_pila;
}
public void setNombre_pila(String nombre_pila) {
	Nombre_pila = nombre_pila;
} 


public String getApellido_paterno() {
	return Apellido_paterno;
}


public void setApellido_paterno(String apellido_paterno) {
	Apellido_paterno = apellido_paterno;
}
public String getApellido_materno() {
	return Apellido_materno;
}
public void setApellido_materno(String apellido_materno) {
	Apellido_materno = apellido_materno;
}
public String getServicio() {
	return Servicio;
}
public void setServicio(String servicio) {
	Servicio = servicio;
}
public int getFecha_nacimiento() {
	return Fecha_nacimiento;
}
public void setFecha_nacimiento(int fecha_nacimiento) {
	Fecha_nacimiento = fecha_nacimiento;
}
public String getPlan() {
	return Plan;
}
public void setPlan(String plan) {
	Plan = plan;
}
public String getEstatus() {
	return Estatus;
}
public void setEstatus(String estatus) {
	Estatus = estatus;
}
  
}
