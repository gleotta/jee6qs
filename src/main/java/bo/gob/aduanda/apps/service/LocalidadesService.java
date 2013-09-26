package bo.gob.aduanda.apps.service;

import java.util.List;

import javax.ejb.Local;

import bo.gob.aduanda.apps.model.Barrio;
import bo.gob.aduanda.apps.model.Ciudad;
import bo.gob.aduanda.apps.model.Departamento;

@Local
public interface LocalidadesService {
	
	public List<Barrio> obtenerBarrios();
	
	public List<Barrio> obtenerBarrios(Ciudad c);
	
	public List<Ciudad> obtenerCiudades();
	
	public List<Ciudad> obtenerCiudades(Departamento d);
	
	public List<Departamento> obtenerDepartamentos();
	
	public Departamento obtenerDepartamento(String nombre);
	
	public Barrio obtenerBarrio(Long id);
	
	public Ciudad obtenerCiudad(Long id);
	
	public Departamento obtenerDepartamento(Long id);
	

}
