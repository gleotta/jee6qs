package bo.gob.aduanda.apps.service;

import java.util.List;

import javax.ejb.Local;

import bo.gob.aduanda.apps.exceptions.BusinessException;
import bo.gob.aduanda.apps.model.Operador;
import bo.gob.aduanda.apps.model.OperadorNatural;


@Local
public interface OperadoresService {
	
	public void altaOperadorNatural(OperadorNatural op) throws BusinessException;
	
	public List<Operador> obtenerOperadores();
	
	public Operador obtenerOperador(String identificador);

}
