package bo.gob.aduanda.apps.model;

import java.util.Date;
import java.util.Set;

public class OperadorJuridico extends Operador{

	private String nit;
	
	private String razonSocial;
	
	private Domicilio domicilioFisico;
	
	private Date fechaConstitucion;
	
	private Integer cantidadEmpleados;
	
	private Set<OperadorNatural> operadores;
	
	@Override
	public String getIdentificador() {
		
		return nit;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Domicilio getDomicilioFisico() {
		return domicilioFisico;
	}

	public void setDomicilioFisico(Domicilio domicilioFisico) {
		this.domicilioFisico = domicilioFisico;
	}

	public Date getFechaConstitucion() {
		return fechaConstitucion;
	}

	public void setFechaConstitucion(Date fechaConstitucion) {
		this.fechaConstitucion = fechaConstitucion;
	}

	public Integer getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	public void setCantidadEmpleados(Integer cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}

	public Set<OperadorNatural> getOperadores() {
		return operadores;
	}

	public void setOperadores(Set<OperadorNatural> operadores) {
		this.operadores = operadores;
	}

}
