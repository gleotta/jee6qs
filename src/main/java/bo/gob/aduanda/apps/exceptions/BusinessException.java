package bo.gob.aduanda.apps.exceptions;

import javax.ejb.ApplicationException;


@ApplicationException(rollback=true)
public class BusinessException extends Exception {
	
	public BusinessException(String message){
		super(message);
	}

}
