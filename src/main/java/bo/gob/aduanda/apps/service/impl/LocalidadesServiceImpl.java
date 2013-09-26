package bo.gob.aduanda.apps.service.impl;

import java.util.List;

import javax.ejb.Stateless;

import bo.gob.aduanda.apps.model.Barrio;
import bo.gob.aduanda.apps.model.Ciudad;
import bo.gob.aduanda.apps.model.Departamento;
import bo.gob.aduanda.apps.service.LocalidadesService;

//TODO agregar implementacion
@Stateless
public class LocalidadesServiceImpl implements LocalidadesService {

	@Override
	public List<Barrio> obtenerBarrios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Barrio> obtenerBarrios(Ciudad c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ciudad> obtenerCiudades() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ciudad> obtenerCiudades(Departamento d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departamento> obtenerDepartamentos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento obtenerDepartamento(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Barrio obtenerBarrio(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ciudad obtenerCiudad(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento obtenerDepartamento(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
