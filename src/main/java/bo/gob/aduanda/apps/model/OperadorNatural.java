package bo.gob.aduanda.apps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="OPERADOR_NATURAL")
public class OperadorNatural extends Operador {

	


	@NotNull
	@Column(unique=true)
	private String ci;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String apellido;
	
	@NotNull
	private Date fechaNacimiento;
	
	@ManyToOne
	private OperadorJuridico empleador;
	
	
	public OperadorNatural() {
		
	}
	
	public OperadorNatural(String ci) {
		super();
		this.ci = ci;
	}


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

	@Override
	public String toString() {
		return "OperadorNatural [ci=" + ci + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", empleador=" + empleador + "]";
	}
	
	
}
