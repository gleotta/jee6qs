    create table ADUANA (
        id int8 not null,
        codigo varchar(255) not null,
        descripcion varchar(255) not null,
        domicilio_id int8 not null,
        primary key (id)
    )

    create table BARRIO (
        id int8 not null,
        nombre varchar(255) not null,
        ciudad int8 not null,
        primary key (id)
    )

    create table CIUDAD (
        id int8 not null,
        nombre varchar(255) not null,
        departamento int8 not null,
        primary key (id)
    )

    create table DEPARTAMENTO (
        id int8 not null,
        nombre varchar(255) not null,
        primary key (id)
    )

    create table DOMICILIO (
        id int8 not null,
        calle varchar(255) not null,
        celular varchar(255),
        edificio varchar(255),
        numero varchar(255),
        oficina varchar(255),
        piso varchar(255),
        telefono varchar(255),
        barrio_id int8 not null,
        primary key (id)
    )

    create table OPERADOR (
        id int8 not null,
        domicilioLegal_id int8 not null,
        primary key (id)
    )

    create table OPERADOR_JURIDICO (
        cantidadEmpleados int4,
        fechaConstitucion timestamp,
        nit varchar(255) not null,
        razonSocial varchar(255) not null,
        id int8 not null,
        domicilioFisico_id int8,
        primary key (id)
    )

    create table OPERADOR_NATURAL (
        apellido varchar(255) not null,
        ci varchar(255) not null,
        fechaNacimiento timestamp not null,
        nombre varchar(255) not null,
        id int8 not null,
        empleador_id int8,
        primary key (id)
    )

    create table OPERADOR_POR_ADUANA (
        id int8 not null,
        cantTramites int4,
        fechaAceptacion timestamp not null,
        aduana int8 not null,
        operador int8 not null,
        primary key (id)
    )

    alter table ADUANA 
        add constraint uc_ADUANA_1 unique (codigo)

    alter table ADUANA 
        add constraint FK72D0DFE26416A780 
        foreign key (domicilio_id) 
        references DOMICILIO

    alter table BARRIO 
        add constraint UK_BARRIO_1 unique (nombre, ciudad)

    alter table BARRIO 
        add constraint FK745A54254EB6468A 
        foreign key (ciudad) 
        references CIUDAD

    alter table CIUDAD 
        add constraint UK_CIUDAD_1 unique (nombre, departamento)

    alter table CIUDAD 
        add constraint FK768110588A651A62 
        foreign key (departamento) 
        references DEPARTAMENTO

    alter table DEPARTAMENTO 
        add constraint uc_DEPARTAMENTO_1 unique (nombre)

    alter table DOMICILIO 
        add constraint FKDA4E694513305174 
        foreign key (barrio_id) 
        references BARRIO

    alter table OPERADOR 
        add constraint FK10CFDC94B2565211 
        foreign key (domicilioLegal_id) 
        references DOMICILIO

    alter table OPERADOR_JURIDICO 
        add constraint uc_OPERADOR_JURIDICO_1 unique (nit)

    alter table OPERADOR_JURIDICO 
        add constraint FKECBCFABEA01FC49B 
        foreign key (domicilioFisico_id) 
        references DOMICILIO

    alter table OPERADOR_JURIDICO 
        add constraint FKECBCFABE4B7F909 
        foreign key (id) 
        references OPERADOR

    alter table OPERADOR_NATURAL 
        add constraint uc_OPERADOR_NATURAL_1 unique (ci)

    alter table OPERADOR_NATURAL 
        add constraint FK772C535E978B38D4 
        foreign key (empleador_id) 
        references OPERADOR_JURIDICO

    alter table OPERADOR_NATURAL 
        add constraint FK772C535E4B7F909 
        foreign key (id) 
        references OPERADOR

    alter table OPERADOR_POR_ADUANA 
        add constraint UK_OPERADOR_POR_ADUANA_1 unique (operador, aduana)

    alter table OPERADOR_POR_ADUANA 
        add constraint FK77F36BF94755E59E 
        foreign key (aduana) 
        references ADUANA

    alter table OPERADOR_POR_ADUANA 
        add constraint FK77F36BF9E6E1D882 
        foreign key (operador) 
        references OPERADOR

    create sequence hibernate_sequence