package bo.gob.aduanda.apps.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="OPERADOR")
@Inheritance(strategy=InheritanceType.JOINED)
@JsonIgnoreProperties("aduanas")
public abstract class Operador implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@NotNull
	private Domicilio domicilioLegal;
	
	@OneToMany(mappedBy="operador")
	private Set<OperadorPorAduana> aduanas;
	
	
	public abstract String getIdentificador();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Domicilio getDomicilioLegal() {
		return domicilioLegal;
	}

	public void setDomicilioLegal(Domicilio domicilioLegal) {
		this.domicilioLegal = domicilioLegal;
	}

	public Set<OperadorPorAduana> getAduanas() {
		return aduanas;
	}

	public void setAduanas(Set<OperadorPorAduana> aduanas) {
		this.aduanas = aduanas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getIdentificador() == null) ? 0 : getIdentificador().hashCode());
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
		Operador other = (Operador) obj;
		if (getIdentificador() == null) {
			if (other.getIdentificador() != null)
				return false;
		} else if (!getIdentificador().equals(other.getIdentificador()))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		List<Operador> operadores = new ArrayList<Operador>();
		operadores.add(new OperadorNatural("CI1111"));
		operadores.add(new OperadorJuridico("NIT1111"));
		operadores.add(new OperadorNatural("CI2222"));
		operadores.add(new OperadorNatural("CI333"));
		operadores.add(new OperadorJuridico("NIT2222"));
		
		for (Operador operador : operadores) {
			System.out.println(operador.getIdentificador());
		}
		
		
	}

}
