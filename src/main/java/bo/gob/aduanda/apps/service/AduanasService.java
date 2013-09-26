package bo.gob.aduanda.apps.service;

import java.util.List;

import javax.ejb.Local;

import bo.gob.aduanda.apps.exceptions.BusinessException;
import bo.gob.aduanda.apps.model.Aduana;
import bo.gob.aduanda.apps.model.Operador;

@Local
public interface AduanasService {
	
	public void editarAduana(Aduana aduana) throws BusinessException;
	
	public void asignarOperadores(Aduana a, List<Operador> operadores);
	
	public List<Operador> listarOperadores(Aduana a);
	
	public void eliminarOperador(Aduana A, Operador o);
	
}
