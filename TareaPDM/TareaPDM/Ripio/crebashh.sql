if exists(select 1 from sys.sysforeignkey where role='FK_ACTIVIDA_R3_ALUMNOPR') then
    alter table ACTIVIDAD
       delete foreign key FK_ACTIVIDA_R3_ALUMNOPR
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ACTIVIDA_R4_TIPO_ACT') then
    alter table ACTIVIDAD
       delete foreign key FK_ACTIVIDA_R4_TIPO_ACT
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ALUMNOPR_R1_ALUMNO') then
    alter table ALUMNOPROYECTO
       delete foreign key FK_ALUMNOPR_R1_ALUMNO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ALUMNOPR_R2_PROYECTO') then
    alter table ALUMNOPROYECTO
       delete foreign key FK_ALUMNOPR_R2_PROYECTO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PROYECTO_R6_ENCARGAD') then
    alter table PROYECTO
       delete foreign key FK_PROYECTO_R6_ENCARGAD
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PROYECTO_R7_ENTIDAD_') then
    alter table PROYECTO
       delete foreign key FK_PROYECTO_R7_ENTIDAD_
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PROYECTO_R8_TIPO_PRO') then
    alter table PROYECTO
       delete foreign key FK_PROYECTO_R8_TIPO_PRO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PROYECTO_R9_TUTOR') then
    alter table PROYECTO
       delete foreign key FK_PROYECTO_R9_TUTOR
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_TIPO_ACT_R5_MODALIDA') then
    alter table TIPO_ACTIVIDAD
       delete foreign key FK_TIPO_ACT_R5_MODALIDA
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_TUTOR_R10_ESPECIAL') then
    alter table TUTOR
       delete foreign key FK_TUTOR_R10_ESPECIAL
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ACTIVIDAD')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'OBSERVACION_LF')
   where q.index_owner = 'USER')
then
   drop index ACTIVIDAD.OBSERVACION_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ACTIVIDAD')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'NUMHORAS_LF')
   where q.index_owner = 'USER')
then
   drop index ACTIVIDAD.NUMHORAS_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ACTIVIDAD')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'IDACTIVIDAD_LF')
   where q.index_owner = 'USER')
then
   drop index ACTIVIDAD.IDACTIVIDAD_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ACTIVIDAD')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'FECHA_LF')
   where q.index_owner = 'USER')
then
   drop index ACTIVIDAD.FECHA_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ACTIVIDAD')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'ACTIVIDAD_LF')
   where q.index_owner = 'USER')
then
   drop index ACTIVIDAD.ACTIVIDAD_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ACTIVIDAD')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CODITIPOACTIVIDAD_LF')
   where q.index_owner = 'USER')
then
   drop index ACTIVIDAD.CODITIPOACTIVIDAD_LF
end if;

if exists(
   select 1 from sys.systable 
   where table_name='ACTIVIDAD'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table ACTIVIDAD
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ALUMNO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'DIRECCION_LF')
   where q.index_owner = 'USER')
then
   drop index ALUMNO.DIRECCION_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ALUMNO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CORREO2_LF')
   where q.index_owner = 'USER')
then
   drop index ALUMNO.CORREO2_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ALUMNO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CORREO1_LF')
   where q.index_owner = 'USER')
then
   drop index ALUMNO.CORREO1_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ALUMNO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'TELEFONO2_LF')
   where q.index_owner = 'USER')
then
   drop index ALUMNO.TELEFONO2_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ALUMNO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'TELEFONO1_LF')
   where q.index_owner = 'USER')
then
   drop index ALUMNO.TELEFONO1_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ALUMNO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'MATERIASGANADAS_LF')
   where q.index_owner = 'USER')
then
   drop index ALUMNO.MATERIASGANADAS_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ALUMNO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'SEXO_LF')
   where q.index_owner = 'USER')
then
   drop index ALUMNO.SEXO_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ALUMNO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CARRERA_LF')
   where q.index_owner = 'USER')
then
   drop index ALUMNO.CARRERA_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ALUMNO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'APELLIDO_LF')
   where q.index_owner = 'USER')
then
   drop index ALUMNO.APELLIDO_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ALUMNO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'NOMBRE_LF')
   where q.index_owner = 'USER')
then
   drop index ALUMNO.NOMBRE_LF
end if;

if exists(
   select 1 from sys.systable 
   where table_name='ALUMNO'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table ALUMNO
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ALUMNOPROYECTO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'IDACTIVIDAD_LF')
   where q.index_owner = 'USER')
then
   drop index ALUMNOPROYECTO.IDACTIVIDAD_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ALUMNOPROYECTO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CODIGOPROYECTO_LF')
   where q.index_owner = 'USER')
then
   drop index ALUMNOPROYECTO.CODIGOPROYECTO_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ALUMNOPROYECTO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CARNET_LF')
   where q.index_owner = 'USER')
then
   drop index ALUMNOPROYECTO.CARNET_LF
end if;

if exists(
   select 1 from sys.systable 
   where table_name='ALUMNOPROYECTO'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table ALUMNOPROYECTO
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ENCARGADO_SERV_SOCIAL')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CORREO_LF')
   where q.index_owner = 'USER')
then
   drop index ENCARGADO_SERV_SOCIAL.CORREO_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ENCARGADO_SERV_SOCIAL')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'SEXO_LF')
   where q.index_owner = 'USER')
then
   drop index ENCARGADO_SERV_SOCIAL.SEXO_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ENCARGADO_SERV_SOCIAL')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'APELLIDOENCARGADO_LF')
   where q.index_owner = 'USER')
then
   drop index ENCARGADO_SERV_SOCIAL.APELLIDOENCARGADO_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ENCARGADO_SERV_SOCIAL')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'NOMBREENCARGADO_LF')
   where q.index_owner = 'USER')
then
   drop index ENCARGADO_SERV_SOCIAL.NOMBREENCARGADO_LF
end if;

if exists(
   select 1 from sys.systable 
   where table_name='ENCARGADO_SERV_SOCIAL'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table ENCARGADO_SERV_SOCIAL
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ENTIDAD_SOLICITANTE')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'DIRECCION_LF')
   where q.index_owner = 'USER')
then
   drop index ENTIDAD_SOLICITANTE.DIRECCION_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ENTIDAD_SOLICITANTE')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'TELEFONO_LF')
   where q.index_owner = 'USER')
then
   drop index ENTIDAD_SOLICITANTE.TELEFONO_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ENTIDAD_SOLICITANTE')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'RUBRO_LF')
   where q.index_owner = 'USER')
then
   drop index ENTIDAD_SOLICITANTE.RUBRO_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ENTIDAD_SOLICITANTE')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'NOMBREORGANIZACION_LF')
   where q.index_owner = 'USER')
then
   drop index ENTIDAD_SOLICITANTE.NOMBREORGANIZACION_LF
end if;

if exists(
   select 1 from sys.systable 
   where table_name='ENTIDAD_SOLICITANTE'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table ENTIDAD_SOLICITANTE
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ESPECIALIDAD')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CANTIDAD_ESTUDIANTES_LF')
   where q.index_owner = 'USER')
then
   drop index ESPECIALIDAD.CANTIDAD_ESTUDIANTES_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'ESPECIALIDAD')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'NOMBREESPECIALIDAD_LF')
   where q.index_owner = 'USER')
then
   drop index ESPECIALIDAD.NOMBREESPECIALIDAD_LF
end if;

if exists(
   select 1 from sys.systable 
   where table_name='ESPECIALIDAD'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table ESPECIALIDAD
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'MODALIDAD')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'SISTEMA_MODALIDAD_LF')
   where q.index_owner = 'USER')
then
   drop index MODALIDAD.SISTEMA_MODALIDAD_LF
end if;

if exists(
   select 1 from sys.systable 
   where table_name='MODALIDAD'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table MODALIDAD
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'PROYECTO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CANTIDADALUMNNECESARIOS_LF')
   where q.index_owner = 'USER')
then
   drop index PROYECTO.CANTIDADALUMNNECESARIOS_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'PROYECTO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'NOMBREPROYECTO_LF')
   where q.index_owner = 'USER')
then
   drop index PROYECTO.NOMBREPROYECTO_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'PROYECTO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CODIGOTUTOR_LF')
   where q.index_owner = 'USER')
then
   drop index PROYECTO.CODIGOTUTOR_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'PROYECTO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CODIGOTIPOPROYECTO_LF')
   where q.index_owner = 'USER')
then
   drop index PROYECTO.CODIGOTIPOPROYECTO_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'PROYECTO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CODIGOENTIDAD_LF')
   where q.index_owner = 'USER')
then
   drop index PROYECTO.CODIGOENTIDAD_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'PROYECTO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CODIGOENCARGADO_LF')
   where q.index_owner = 'USER')
then
   drop index PROYECTO.CODIGOENCARGADO_LF
end if;

if exists(
   select 1 from sys.systable 
   where table_name='PROYECTO'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table PROYECTO
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'TIPO_ACTIVIDAD')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'TIPOACTIVIDAD_LF')
   where q.index_owner = 'USER')
then
   drop index TIPO_ACTIVIDAD.TIPOACTIVIDAD_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'TIPO_ACTIVIDAD')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'COSTOPORHORA_LF')
   where q.index_owner = 'USER')
then
   drop index TIPO_ACTIVIDAD.COSTOPORHORA_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'TIPO_ACTIVIDAD')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CODIGOMODALIDAD_LF')
   where q.index_owner = 'USER')
then
   drop index TIPO_ACTIVIDAD.CODIGOMODALIDAD_LF
end if;

if exists(
   select 1 from sys.systable 
   where table_name='TIPO_ACTIVIDAD'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table TIPO_ACTIVIDAD
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'TIPO_PROYECTO')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'TIPOPROYECTO_LF')
   where q.index_owner = 'USER')
then
   drop index TIPO_PROYECTO.TIPOPROYECTO_LF
end if;

if exists(
   select 1 from sys.systable 
   where table_name='TIPO_PROYECTO'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table TIPO_PROYECTO
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'TUTOR')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'SEXO_LF')
   where q.index_owner = 'USER')
then
   drop index TUTOR.SEXO_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'TUTOR')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CARGO_LF')
   where q.index_owner = 'USER')
then
   drop index TUTOR.CARGO_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'TUTOR')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'APELLIDOTUTOR_LF')
   where q.index_owner = 'USER')
then
   drop index TUTOR.APELLIDOTUTOR_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'TUTOR')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'NOMBRETUTOR_LF')
   where q.index_owner = 'USER')
then
   drop index TUTOR.NOMBRETUTOR_LF
end if;

if exists (select 1 from sys.sysiqidx q
   join sys.systab t on (t.table_id = q.table_id and t.table_name = 'TUTOR')
   join sys.sysidx i on (i.table_id = q.table_id and i.index_id = q.index_id and i.index_name = 'CODIGOESPECIALIDAD_LF')
   where q.index_owner = 'USER')
then
   drop index TUTOR.CODIGOESPECIALIDAD_LF
end if;

if exists(
   select 1 from sys.systable 
   where table_name='TUTOR'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table TUTOR
end if;

create table ACTIVIDAD (
   CODACTIVIDAD         varchar(8)                     not null,
   CODITIPOACTIVIDAD    varchar(8)                     not null,
   ACTIVIDAD            varchar(100)                   not null,
   FECHA                date                           not null,
   IDACTIVIDAD          varchar(8)                     not null,
   NUMHORAS             integer                        null,
   OBSERVACION          varchar(150)                   null,
   constraint PK_ACTIVIDAD primary key (CODACTIVIDAD)
);

create LF index CODITIPOACTIVIDAD_LF on ACTIVIDAD (
CODITIPOACTIVIDAD
);

create LF index ACTIVIDAD_LF on ACTIVIDAD (
ACTIVIDAD
);

create LF index FECHA_LF on ACTIVIDAD (
FECHA
);

create LF index IDACTIVIDAD_LF on ACTIVIDAD (
IDACTIVIDAD
);

create LF index NUMHORAS_LF on ACTIVIDAD (
NUMHORAS
);

create LF index OBSERVACION_LF on ACTIVIDAD (
OBSERVACION
);

create table ALUMNO (
   CARNET               varchar(100)                   not null,
   NOMBRE               varchar(50)                    null,
   APELLIDO             varchar(50)                    null,
   CARRERA              varchar(80)                    null,
   SEXO                 varchar(1)                     null,
   MATERIASGANADAS      numeric(2)                     null,
   TELEFONO1            varchar(9)                     null,
   TELEFONO2            varchar(9)                     null,
   CORREO1              varchar(50)                    null,
   CORREO2              varchar(50)                    null,
   DIRECCION            varchar(100)                   null,
   constraint PK_ALUMNO primary key (CARNET)
);

create LF index NOMBRE_LF on ALUMNO (
NOMBRE
);

create LF index APELLIDO_LF on ALUMNO (
APELLIDO
);

create LF index CARRERA_LF on ALUMNO (
CARRERA
);

create LF index SEXO_LF on ALUMNO (
SEXO
);

create LF index MATERIASGANADAS_LF on ALUMNO (
MATERIASGANADAS
);

create LF index TELEFONO1_LF on ALUMNO (
TELEFONO1
);

create LF index TELEFONO2_LF on ALUMNO (
TELEFONO2
);

create LF index CORREO1_LF on ALUMNO (
CORREO1
);

create LF index CORREO2_LF on ALUMNO (
CORREO2
);

create LF index DIRECCION_LF on ALUMNO (
DIRECCION
);

create table ALUMNOPROYECTO (
   CARNET               varchar(100)                   not null,
   CODIGOPROYECTO       varchar(10)                    not null,
   IDACTIVIDAD          varchar(8)                     not null,
   constraint PK_ALUMNOPROYECTO primary key (CARNET, CODIGOPROYECTO, IDACTIVIDAD)
);

create LF index CARNET_LF on ALUMNOPROYECTO (
CARNET
);

create LF index CODIGOPROYECTO_LF on ALUMNOPROYECTO (
CODIGOPROYECTO
);

create LF index IDACTIVIDAD_LF on ALUMNOPROYECTO (
IDACTIVIDAD
);

create table ENCARGADO_SERV_SOCIAL (
   CODIGOENCARGADO      varchar(7)                     not null,
   NOMBREENCARGADO      varchar(30)                    null,
   APELLIDOENCARGADO    varchar(30)                    null,
   SEXO                 varchar(1)                     null,
   CORREO               varchar(50)                    null,
   constraint PK_ENCARGADO_SERV_SOCIAL primary key (CODIGOENCARGADO)
);

create LF index NOMBREENCARGADO_LF on ENCARGADO_SERV_SOCIAL (
NOMBREENCARGADO
);

create LF index APELLIDOENCARGADO_LF on ENCARGADO_SERV_SOCIAL (
APELLIDOENCARGADO
);

create LF index SEXO_LF on ENCARGADO_SERV_SOCIAL (
SEXO
);

create LF index CORREO_LF on ENCARGADO_SERV_SOCIAL (
CORREO
);

create table ENTIDAD_SOLICITANTE (
   CODIGOENTIDAD        varchar(10)                    not null,
   NOMBREORGANIZACION   varchar(100)                   null,
   RUBRO                varchar(50)                    null,
   TELEFONO             numeric(8)                     null,
   DIRECCION            varchar(200)                   null,
   constraint PK_ENTIDAD_SOLICITANTE primary key (CODIGOENTIDAD)
);

create LF index NOMBREORGANIZACION_LF on ENTIDAD_SOLICITANTE (
NOMBREORGANIZACION
);

create LF index RUBRO_LF on ENTIDAD_SOLICITANTE (
RUBRO
);

create LF index TELEFONO_LF on ENTIDAD_SOLICITANTE (
TELEFONO
);

create LF index DIRECCION_LF on ENTIDAD_SOLICITANTE (
DIRECCION
);

create table ESPECIALIDAD (
   CODIGOESPECIALIDAD   varchar(10)                    not null,
   NOMBREESPECIALIDAD   varchar(100)                   null,
   CANTIDAD_ESTUDIANTES integer                        null,
   constraint PK_ESPECIALIDAD primary key (CODIGOESPECIALIDAD)
);

create LF index NOMBREESPECIALIDAD_LF on ESPECIALIDAD (
NOMBREESPECIALIDAD
);

create LF index CANTIDAD_ESTUDIANTES_LF on ESPECIALIDAD (
CANTIDAD_ESTUDIANTES
);

create table MODALIDAD (
   CODIGOMODALIDAD      varchar(10)                    not null,
   SISTEMA_MODALIDAD    varchar(50)                    null,
   constraint PK_MODALIDAD primary key (CODIGOMODALIDAD)
);

create LF index SISTEMA_MODALIDAD_LF on MODALIDAD (
SISTEMA_MODALIDAD
);

create table PROYECTO (
   CODIGOPROYECTO       varchar(10)                    not null,
   CODIGOENCARGADO      varchar(7)                     not null,
   CODIGOENTIDAD        varchar(10)                    not null,
   CODIGOTIPOPROYECTO   varchar(10)                    not null,
   CODIGOTUTOR          varchar(7)                     not null,
   NOMBREPROYECTO       varchar(100)                   null,
   CANTIDADALUMNNECESARIOS numeric(4)                     null,
   constraint PK_PROYECTO primary key (CODIGOPROYECTO)
);

create LF index CODIGOENCARGADO_LF on PROYECTO (
CODIGOENCARGADO
);

create LF index CODIGOENTIDAD_LF on PROYECTO (
CODIGOENTIDAD
);

create LF index CODIGOTIPOPROYECTO_LF on PROYECTO (
CODIGOTIPOPROYECTO
);

create LF index CODIGOTUTOR_LF on PROYECTO (
CODIGOTUTOR
);

create LF index NOMBREPROYECTO_LF on PROYECTO (
NOMBREPROYECTO
);

create LF index CANTIDADALUMNNECESARIOS_LF on PROYECTO (
CANTIDADALUMNNECESARIOS
);

create table TIPO_ACTIVIDAD (
   CODIGO_TIPO_ACTIVIDAD varchar(10)                    not null,
   CODIGOMODALIDAD      varchar(10)                    not null,
   COSTOPORHORA         float(4)                       null,
   TIPOACTIVIDAD        varchar(50)                    null,
   constraint PK_TIPO_ACTIVIDAD primary key (CODIGO_TIPO_ACTIVIDAD)
);

create LF index CODIGOMODALIDAD_LF on TIPO_ACTIVIDAD (
CODIGOMODALIDAD
);

create LF index COSTOPORHORA_LF on TIPO_ACTIVIDAD (
COSTOPORHORA
);

create LF index TIPOACTIVIDAD_LF on TIPO_ACTIVIDAD (
TIPOACTIVIDAD
);

create table TIPO_PROYECTO (
   CODIGOTIPOPROYECTO   varchar(10)                    not null,
   TIPOPROYECTO         varchar(50)                    null,
   constraint PK_TIPO_PROYECTO primary key (CODIGOTIPOPROYECTO)
);

create LF index TIPOPROYECTO_LF on TIPO_PROYECTO (
TIPOPROYECTO
);

create table TUTOR (
   CODIGOTUTOR          varchar(7)                     not null,
   CODIGOESPECIALIDAD   varchar(7)                     not null,
   NOMBRETUTOR          varchar(30)                    null,
   APELLIDOTUTOR        varchar(30)                    null,
   CARGO                varchar(50)                    null,
   SEXO                 varchar(1)                     null,
   constraint PK_TUTOR primary key (CODIGOTUTOR)
);

create LF index CODIGOESPECIALIDAD_LF on TUTOR (
CODIGOESPECIALIDAD
);

create LF index NOMBRETUTOR_LF on TUTOR (
NOMBRETUTOR
);

create LF index APELLIDOTUTOR_LF on TUTOR (
APELLIDOTUTOR
);

create LF index CARGO_LF on TUTOR (
CARGO
);

create LF index SEXO_LF on TUTOR (
SEXO
);

alter table ACTIVIDAD
   add foreign key FK_ACTIVIDA_R3_ALUMNOPR (ACTIVIDAD, FECHA, IDACTIVIDAD)
      references ALUMNOPROYECTO (CARNET, CODIGOPROYECTO, IDACTIVIDAD)
      on delete restrict on update restrict;

alter table ACTIVIDAD
   add foreign key FK_ACTIVIDA_R4_TIPO_ACT (CODITIPOACTIVIDAD)
      references TIPO_ACTIVIDAD (CODIGO_TIPO_ACTIVIDAD)
      on delete restrict on update restrict;

alter table ALUMNOPROYECTO
   add foreign key FK_ALUMNOPR_R1_ALUMNO (CARNET)
      references ALUMNO (CARNET)
      on delete restrict on update restrict;

alter table ALUMNOPROYECTO
   add foreign key FK_ALUMNOPR_R2_PROYECTO (CODIGOPROYECTO)
      references PROYECTO (CODIGOPROYECTO)
      on delete restrict on update restrict;

alter table PROYECTO
   add foreign key FK_PROYECTO_R6_ENCARGAD (CODIGOENCARGADO)
      references ENCARGADO_SERV_SOCIAL (CODIGOENCARGADO)
      on delete restrict on update restrict;

alter table PROYECTO
   add foreign key FK_PROYECTO_R7_ENTIDAD_ (CODIGOENTIDAD)
      references ENTIDAD_SOLICITANTE (CODIGOENTIDAD)
      on delete restrict on update restrict;

alter table PROYECTO
   add foreign key FK_PROYECTO_R8_TIPO_PRO (CODIGOTIPOPROYECTO)
      references TIPO_PROYECTO (CODIGOTIPOPROYECTO)
      on delete restrict on update restrict;

alter table PROYECTO
   add foreign key FK_PROYECTO_R9_TUTOR (CODIGOTUTOR)
      references TUTOR (CODIGOTUTOR)
      on delete restrict on update restrict;

alter table TIPO_ACTIVIDAD
   add foreign key FK_TIPO_ACT_R5_MODALIDA (CODIGOMODALIDAD)
      references MODALIDAD (CODIGOMODALIDAD)
      on delete restrict on update restrict;

alter table TUTOR
   add foreign key FK_TUTOR_R10_ESPECIAL (CODIGOESPECIALIDAD)
      references ESPECIALIDAD (CODIGOESPECIALIDAD)
      on delete restrict on update restrict;

