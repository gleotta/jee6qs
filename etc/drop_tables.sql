
    alter table ADUANA 
        drop constraint FK72D0DFE26416A780

    alter table BARRIO 
        drop constraint FK745A54254EB6468A

    alter table CIUDAD 
        drop constraint FK768110588A651A62

    alter table DOMICILIO 
        drop constraint FKDA4E694513305174

    alter table OPERADOR 
        drop constraint FK10CFDC94B2565211

    alter table OPERADOR_JURIDICO 
        drop constraint FKECBCFABEA01FC49B

    alter table OPERADOR_JURIDICO 
        drop constraint FKECBCFABE4B7F909

    alter table OPERADOR_NATURAL 
        drop constraint FK772C535E978B38D4

    alter table OPERADOR_NATURAL 
        drop constraint FK772C535E4B7F909

    alter table OPERADOR_POR_ADUANA 
        drop constraint FK77F36BF94755E59E

    alter table OPERADOR_POR_ADUANA 
        drop constraint FK77F36BF9E6E1D882

    drop table if exists ADUANA cascade

    drop table if exists BARRIO cascade

    drop table if exists CIUDAD cascade

    drop table if exists DEPARTAMENTO cascade

    drop table if exists DOMICILIO cascade

    drop table if exists OPERADOR cascade

    drop table if exists OPERADOR_JURIDICO cascade

    drop table if exists OPERADOR_NATURAL cascade

    drop table if exists OPERADOR_POR_ADUANA cascade

    drop sequence hibernate_sequence