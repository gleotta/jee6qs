-- You can use this file to load seed data into the database using SQL statements
insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212') 

--
-- TOC entry 1998 (class 0 OID 16673)
-- Dependencies: 171
-- Data for Name: departamento; Type: TABLE DATA; Schema: public; Owner: prueba
--

INSERT INTO departamento VALUES (1, 'La Paz');


--
-- TOC entry 1997 (class 0 OID 16668)
-- Dependencies: 170
-- Data for Name: ciudad; Type: TABLE DATA; Schema: public; Owner: prueba
--

INSERT INTO ciudad VALUES (2, 'La Paz', 1);
INSERT INTO ciudad VALUES (6, 'El Alto', 1);


--
-- TOC entry 1996 (class 0 OID 16663)
-- Dependencies: 169
-- Data for Name: barrio; Type: TABLE DATA; Schema: public; Owner: prueba
--

INSERT INTO barrio VALUES (3, 'Central', 2);
INSERT INTO barrio VALUES (4, 'Sopocachi', 2);
INSERT INTO barrio VALUES (5, 'Achumani', 2);
INSERT INTO barrio VALUES (7, '16 de Julio', 6);
INSERT INTO barrio VALUES (8, 'Villa Adela', 6);


--
-- TOC entry 1999 (class 0 OID 16678)
-- Dependencies: 172
-- Data for Name: domicilio; Type: TABLE DATA; Schema: public; Owner: prueba
--

INSERT INTO domicilio VALUES (9, 'Calle Abdon Saavedra', NULL, 'Los Laureles', '1925', 'Of. Nº 1', 'P.B.', '2413325', 4);
INSERT INTO domicilio VALUES (10, 'AV. MARISCAL SANTA CRUZ', NULL, 'LITORAL', 'S/N', 'LOCAL 10', 'P.B.', '2358234', 3);
INSERT INTO domicilio VALUES (11, 'CALLE 12', NULL, NULL, '21', NULL, NULL, '2912527', 5);
INSERT INTO domicilio VALUES (12, 'AV/ALEXANDER ESQ.C/23 BLOQUE SAUCES', NULL, 'COND. GIRASOLES', 'S/N', '108B', '3', '2710844', 8);
INSERT INTO domicilio VALUES (13, 'CALLE 1', NULL, NULL, '10', NULL, NULL, '2410937', 7);
INSERT INTO domicilio VALUES (19, 'Av. 20 de Octubre entre Juan Jose Perez y Aspiazu', NULL, NULL, '2038', NULL, NULL, '2128008', 7);
INSERT INTO domicilio VALUES (20, 'Av. Arce', NULL, 'TORRE DE LAS AMERICAS', '2433', '216', 'MZ 2', '2120300', 5);


--
-- TOC entry 1995 (class 0 OID 16655)
-- Dependencies: 168
-- Data for Name: aduana; Type: TABLE DATA; Schema: public; Owner: prueba
--

INSERT INTO aduana VALUES (21, '200', 'Oficina Central', 19);
INSERT INTO aduana VALUES (22, '201', 'Interior La Paz', 20);


--
-- TOC entry 2000 (class 0 OID 16686)
-- Dependencies: 173
-- Data for Name: operador; Type: TABLE DATA; Schema: public; Owner: prueba
--

INSERT INTO operador VALUES (14, 9);
INSERT INTO operador VALUES (15, 9);
INSERT INTO operador VALUES (16, 11);
INSERT INTO operador VALUES (17, 12);
INSERT INTO operador VALUES (18, 13);


--
-- TOC entry 2001 (class 0 OID 16691)
-- Dependencies: 174
-- Data for Name: operador_juridico; Type: TABLE DATA; Schema: public; Owner: prueba
--

INSERT INTO operador_juridico VALUES (NULL, '1998-11-01 00:00:00', '1020304050', 'AGC SRL', 14, NULL);
INSERT INTO operador_juridico VALUES (NULL, '2000-06-15 00:00:00', '1000889024', 'IMPORTACIONES MARISCAL ANDRES DE SANTA CRUZ S.R.L', 15, NULL);


--
-- TOC entry 2002 (class 0 OID 16699)
-- Dependencies: 175
-- Data for Name: operador_natural; Type: TABLE DATA; Schema: public; Owner: prueba
--

INSERT INTO operador_natural VALUES ('CUENCA REYES ORTIZ', '197539', '1965-01-15 00:00:00', 'FERNANDO', 18, NULL);
INSERT INTO operador_natural VALUES ('MERCADO RODAS', '1971674', '1970-11-01 00:00:00', 'ROXANA SONIA', 16, 14);
INSERT INTO operador_natural VALUES ('BAUER REINECKE', '1971969', '1960-11-01 00:00:00', 'ANA MARIA', 17, 14);


--
-- TOC entry 2003 (class 0 OID 16707)
-- Dependencies: 176
-- Data for Name: operador_por_aduana; Type: TABLE DATA; Schema: public; Owner: prueba
--

INSERT INTO operador_por_aduana VALUES (23, NULL, '2013-09-25 16:53:51.379', 21, 14);
INSERT INTO operador_por_aduana VALUES (24, NULL, '2013-09-25 16:53:51.379', 21, 15);
INSERT INTO operador_por_aduana VALUES (25, NULL, '2013-09-25 16:53:51.38', 22, 16);


-- Completed on 2013-09-25 17:57:51

--
-- PostgreSQL database dump complete