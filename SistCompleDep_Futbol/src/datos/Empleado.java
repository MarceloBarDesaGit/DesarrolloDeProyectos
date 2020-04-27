package datos;

import java.util.Set;

public class Empleado extends Persona {
	private int idEmpleado;      // PK  10
	private long legajo;          //     100
	private float sueldoBase;    //     300000
	private Set<Rol> cgoRol;    // FK   1  Contadora / AdmSistemas / AdmCobranza / Canchero / BuffetChef / buffetVta1 / BuffetVta2
	
//-------------------------------------
//Constructores
	public Empleado() {}

	public Empleado(int legajo, float sueldoBase) {
		super();
		this.legajo = legajo;
		this.sueldoBase = sueldoBase;
	}
	
//-------------------------------------
//Getter y Setter
	public int getIdEmpleado() {
		return idEmpleado;
	}

	protected void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	//----------

	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	public float getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public Set<Rol> getCgoRol() {
		return cgoRol;
	}

	public void setCgoRol(Set<Rol> cgoRol) {
		this.cgoRol = cgoRol;
	}	
//-------------------------------------
//tostring	

	@Override
	public String toString() {
		return "Empleado: "  + super.toString() 
		+ "      \nID [ " + idEmpleado + " ]  - Legajo: " + legajo + ", Sueldo: " + sueldoBase;
	}
	
	
	
	
	
	
	
	
	
//----------------	
}//Fin Empleado


//import java.time.LocalDate;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;	
//--------------------------------------------
//	public float calcularSueldoMes(int mes) {
//		// El mes llega en formato 1 -12
//		List<Factura> facturasMes = this.facturas.stream().filter(s -> s.getFechaFactura().getMonthValue() == mes).collect(Collectors.toList()); // Filtro las facturas dejando solo las del mes
//		float sueldo = this.sueldoBase;
//		for (Factura f : facturasMes) {
//			for (LineaFactura lf: f.getLineasFactura()) {
//				sueldo += lf.getTotal() * 0.05; // la linea ya tiene su total = cantidad * precioUnitario
//			}
//		}
//		// FIXME en los filtros de solicitud deberia filtrar por estado = completado
//		List<Solicitud> solicitudesRealizadas = this.solicitudesRealizadas.stream().filter(s -> s.getFechaSolicitud().getMonthValue() == mes).collect(Collectors.toList());
//		List<Solicitud> solicitudesAprobadas = this.solicitudesAprobadas.stream().filter(s -> s.getFechaSolicitud().getMonthValue() == mes).collect(Collectors.toList());
//		for (Solicitud s : solicitudesRealizadas) for (LineaSolicitud ls : s.getLineasSolicitud()) sueldo += ls.getTotal() * 0.03;
//		for (Solicitud s : solicitudesAprobadas) for (LineaSolicitud ls : s.getLineasSolicitud()) sueldo += ls.getTotal() * 0.02;
//		return sueldo;
//	}
	

