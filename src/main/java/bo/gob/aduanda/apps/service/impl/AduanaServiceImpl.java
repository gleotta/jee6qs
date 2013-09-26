package bo.gob.aduanda.apps.service.impl;

import java.util.List;

import javax.ejb.Stateless;

import bo.gob.aduanda.apps.exceptions.BusinessException;
import bo.gob.aduanda.apps.model.Aduana;
import bo.gob.aduanda.apps.model.Operador;
import bo.gob.aduanda.apps.service.AduanasService;


//TODO agregar implementacion
@Stateless
public class AduanaServiceImpl implements AduanasService {

	@Override
	public void editarAduana(Aduana aduana) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void asignarOperadores(Aduana a, List<Operador> operadores) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Operador> listarOperadores(Aduana a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarOperador(Aduana A, Operador o) {
		// TODO Auto-generated method stub

	}

}
