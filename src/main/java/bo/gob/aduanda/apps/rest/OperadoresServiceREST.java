/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package bo.gob.aduanda.apps.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bo.gob.aduanda.apps.exceptions.BusinessException;
import bo.gob.aduanda.apps.model.Member;
import bo.gob.aduanda.apps.model.Operador;
import bo.gob.aduanda.apps.model.OperadorJuridico;
import bo.gob.aduanda.apps.model.OperadorNatural;
import bo.gob.aduanda.apps.service.OperadoresService;

/**
 * JAX-RS Example
 * <p/>
 * This class produces a RESTful service to read/write the contents of the members table.
 */
@Path("/operador")
@RequestScoped
public class OperadoresServiceREST {

    @Inject
    private Logger log;

  

    @Inject
    private OperadoresService service;

      
    @GET
    @Path("/id/{identificador}")
    @Produces(MediaType.APPLICATION_JSON)
    public Operador obtenerOperador(@PathParam("identificador") String identificador) {
        Operador operador = service.obtenerOperador(identificador);
        if (operador == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return operador;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
  	public List<Operador> obtenerOperadores() 
  	{
    	 try {
 			return service.obtenerOperadores();
 		} catch (Exception e) {
 			throw new WebApplicationException(e,Response.Status.INTERNAL_SERVER_ERROR);
 		}
  	};
  	
  	@GET
    @Path("/juridico/list")
    @Produces(MediaType.APPLICATION_JSON)
  	public List<OperadorJuridico> obtenerOperadoresJuridicos() {
  		return null;
  	};
  	
  	
	@GET
    @Path("/natural/list")
    @Produces(MediaType.APPLICATION_JSON)
  	public List<OperadorNatural> obtenerOperadoresNaturales() {
  		
		return null;
  		
  	};
  	
  	
  	//altas
  	@POST
  	@Path("/natural/create")
  	@Consumes(MediaType.APPLICATION_JSON)
  	@Produces(MediaType.APPLICATION_JSON)
  	public void altaOperadorNatural(OperadorNatural op) {
  		
  		
  	};
  	
  	@POST
  	@Path("/juridico/create")
  	@Consumes(MediaType.APPLICATION_JSON)
  	@Produces(MediaType.APPLICATION_JSON)
  	public void altaOperadorJuridico(OperadorJuridico op) {
  		
  		
  	};
  	

  	@PUT
  	@Path("/natural/update")
  	@Consumes(MediaType.APPLICATION_JSON)
  	@Produces(MediaType.APPLICATION_JSON)
  	public void editarOperadorNatural(OperadorNatural op) {
  		
  	}
  	
  	
  	@PUT
  	@Path("/juridico/update")
  	@Consumes(MediaType.APPLICATION_JSON)
  	@Produces(MediaType.APPLICATION_JSON)
  	public void editarOperadorJuridico(OperadorJuridico op) {
  		
  	};
  	
  	
	@DELETE
  	@Path("/delete")
  	@Consumes(MediaType.APPLICATION_JSON)
  	@Produces(MediaType.APPLICATION_JSON)
  	public void borrarOperador(String identificador) {
  		
  	};
  	
}
