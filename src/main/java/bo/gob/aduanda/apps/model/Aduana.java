package bo.gob.aduanda.apps.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ADUANA")
public class Aduana {
	
	@Id
	@GeneratedValue
	private Long id;
	

	@NotNull
	@Column(unique=true)
	private String codigo;
	
	@OneToOne
	@NotNull
	private Domicilio domicilio;
	
	@NotNull
	private String descripcion;
	
	@OneToMany(mappedBy="aduana")
	private Set<OperadorPorAduana> operadores;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<OperadorPorAduana> getOperadores() {
		return operadores;
	}

	public void setOperadores(Set<OperadorPorAduana> operadores) {
		this.operadores = operadores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aduana other = (Aduana) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
