package bo.gob.aduanda.apps.service;

import java.util.List;

import javax.ejb.Local;

import bo.gob.aduanda.apps.exceptions.BusinessException;
import bo.gob.aduanda.apps.model.Operador;
import bo.gob.aduanda.apps.model.OperadorJuridico;
import bo.gob.aduanda.apps.model.OperadorNatural;


@Local
public interface OperadoresService {
	
	
	//Listados
	public List<Operador> obtenerOperadores();
	
	public List<Operador> obtenerOperadoresJuridicos();
	
	public List<Operador> obtenerOperadoresNaturales();
	
	public Operador obtenerOperador(String identificador);
	
	//altas
	public void altaOperadorNatural(OperadorNatural op) throws BusinessException;
	
	public void altaOperadorJuridico(OperadorJuridico op) throws BusinessException;
	
	//editar
	public void editarOperadorNatural(OperadorNatural op) throws BusinessException;
	
	public void editarOperadorJuridico(OperadorJuridico op) throws BusinessException;
	
	
	//baja
	public void borrarOperador(String identificadoro) throws BusinessException;
	
	
	

}
