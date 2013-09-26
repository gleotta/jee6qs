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
package bo.gob.aduanda.apps.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import bo.gob.aduanda.apps.model.Operador;
import bo.gob.aduanda.apps.model.OperadorJuridico;
import bo.gob.aduanda.apps.model.OperadorNatural;
import bo.gob.aduanda.apps.service.OperadoresService;

@RunWith(Arquillian.class)
public class OperadoresServiceTest {
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage("bo.gob.aduanda.apps.model")
                .addPackage("bo.gob.aduanda.apps.exceptions")
                .addPackage("bo.gob.aduanda.apps.integration")
                .addPackage("bo.gob.aduanda.apps.integration.impl")
                .addPackage("bo.gob.aduanda.apps.service")
                .addPackage("bo.gob.aduanda.apps.service.impl")
                .addPackage("bo.gob.aduanda.apps.util")
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsResource("import.sql", "import.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                
                // Deploy our test datasource
                .addAsWebInfResource("test-ds.xml");
    }

    @Inject
    private OperadoresService operadoresService;

    @Inject
    Logger log;

    @Test
    public void testObtenerOperadores() throws Exception {
    	List<Operador> operadores = operadoresService.obtenerOperadores();
    	assertNotNull(operadores);
    	assertTrue("La cantidad de operadores no es 5", operadores.size()==5);
    	for (Operador operador : operadores) {
			System.out.println("Operador: "+operador);
		}
    	
    }
    
    @Test
    public void testObtenerOperador() throws Exception {
    	String identificador = "1000889024";
    	Operador operador = operadoresService.obtenerOperador(identificador);
    	assertNotNull("Deberia traer el operador "+identificador, operador);
    }
    
    @Test
    public void testObtenerOperadoresNaturales() throws Exception {
    	List<OperadorNatural> operadoresNatu = operadoresService.obtenerOperadoresNaturales();
    	assertNotNull(operadoresNatu);
    	assertTrue("La cantidad de operadores no es 3", operadoresNatu.size()==3);
    	for (Operador operador : operadoresNatu) {
			System.out.println("Operadores Naturales******: "+operador);
		}
    	
    }
    
    
    @Test
    public void testObtenerOperadoresJuridicos() throws Exception {
    	List<OperadorJuridico> operadoresNatu = operadoresService.obtenerOperadoresJuridicos();
    	assertNotNull(operadoresNatu);
    	assertTrue("La cantidad de operadores no es 2", operadoresNatu.size()==2);
    	for (Operador operador : operadoresNatu) {
			System.out.println("Operadores Juridico******: "+operador);
		}
    	
    }
    
    @Test
    public void testEditarOperadorNatural() throws Exception {
    	String identificador = "197539";
    	OperadorNatural operador = (OperadorNatural)operadoresService.obtenerOperador(identificador);
    	operador.setNombre("PRUEBAJUNIT");
    	operadoresService.editarOperadorNatural(operador);
    	
    	OperadorNatural opdb = (OperadorNatural )operadoresService.obtenerOperador(operador.getIdentificador());
    	assertEquals("No se actualizó el dato crrectamente", operador.getNombre(), opdb.getNombre());
    	//assertNotNull("Deberia traer el operador "+identificador, operador);
       	
    }
    
    @Test
    public void testEditarOperadorJuridicol() throws Exception {
    	String identificador = "1020304050";
    	OperadorJuridico operador = (OperadorJuridico) operadoresService.obtenerOperador(identificador);
    	operador.setRazonSocial("NUEVA RAZON");
    	operadoresService.editarOperadorJuridico(operador);
    	
    	OperadorJuridico opdb = (OperadorJuridico )operadoresService.obtenerOperador(operador.getIdentificador());
    	assertEquals("No se actualizó el dato crrectamente", operador.getRazonSocial(), operador.getRazonSocial());
    	//assertNotNull("Deberia traer el operador "+identificador, operador);
       	
    }
    
    @Test
    public void testBorrarOperador() throws Exception {
    	String identificador = "197539";
    	operadoresService.borrarOperador(identificador);
    	
    	OperadorNatural opdb = (OperadorNatural )operadoresService.obtenerOperador(identificador);
    	assertNull("No se eliminó el registro", opdb);

    	
    }

}
