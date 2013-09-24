package bo.gob.aduanda.apps.model;

import java.util.Date;

public class OperadorNatural extends Operador {

	private String ci;
	
	private String nombre;
	
	private String apellido;
	
	private Date fechaNacimiento;
	
	private OperadorJuridico empleador;
	
	
	@Override
	public String getIdentificador() {
		
		return ci;
	}


	public String getCi() {
		return ci;
	}


	public void setCi(String ci) {
		this.ci = ci;
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


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public OperadorJuridico getEmpleador() {
		return empleador;
	}


	public void setEmpleador(OperadorJuridico empleador) {
		this.empleador = empleador;
	}

}
