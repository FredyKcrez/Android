/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     24/05/2015 07:10:46 p.m.                     */
/*==============================================================*/


alter table ACTIVIDAD
   drop constraint FK_ACTIVIDA_RELATIONS_ALUMNOPR;

alter table ACTIVIDAD
   drop constraint FK_ACTIVIDA_RELATIONS_TIPO_ACT;

alter table ALUMNOPROYECTO
   drop constraint FK_ALUMNOPR_RELATIONS_ALUMNO;

alter table ALUMNOPROYECTO
   drop constraint FK_ALUMNOPR_RELATIONS_PROYECTO;

alter table PROYECTO
   drop constraint FK_PROYECTO_RELATIONS_ENCARGAD;

alter table PROYECTO
   drop constraint FK_PROYECTO_RELATIONS_ENTIDAD_;

alter table PROYECTO
   drop constraint FK_PROYECTO_RELATIONS_TIPO_PRO;

alter table PROYECTO
   drop constraint FK_PROYECTO_RELATIONS_TUTOR;

alter table TIPO_ACTIVIDAD
   drop constraint FK_TIPO_ACT_RELATIONS_MODALIDA;

alter table TUTOR
   drop constraint FK_TUTOR_RELATIONS_ESPECIAL;

drop index RELATIONSHIP_4_FK;

drop index RELATIONSHIP_3_FK;

drop table ACTIVIDAD cascade constraints;

drop table ALUMNO cascade constraints;

drop index RELATIONSHIP_2_FK;

drop index RELATIONSHIP_1_FK;

drop table ALUMNOPROYECTO cascade constraints;

drop table ENCARGADO_SERV_SOCIAL cascade constraints;

drop table ENTIDAD_SOLICITANTE cascade constraints;

drop table ESPECIALIDAD cascade constraints;

drop table MODALIDAD cascade constraints;

drop index RELATIONSHIP_9_FK;

drop index RELATIONSHIP_8_FK;

drop index RELATIONSHIP_7_FK;

drop index RELATIONSHIP_6_FK;

drop table PROYECTO cascade constraints;

drop index RELATIONSHIP_5_FK;

drop table TIPO_ACTIVIDAD cascade constraints;

drop table TIPO_PROYECTO cascade constraints;

drop index RELATIONSHIP_10_FK;

drop table TUTOR cascade constraints;

/*==============================================================*/
/* Table: ACTIVIDAD                                             */
/*==============================================================*/
create table ACTIVIDAD 
(
   CODACTIVIDAD         VARCHAR2(8)          not null,
   CODITIPOACTIVIDAD    VARCHAR2(8)          not null,
   ACTIVIDAD            VARCHAR2(100)        not null,
   FECHA                DATE                 not null,
   IDACTIVIDAD          VARCHAR2(8)          not null,
   NUMHORAS             INTEGER,
   OBSERVACION          VARCHAR2(150),
   constraint PK_ACTIVIDAD primary key (CODACTIVIDAD)
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_3_FK on ACTIVIDAD (
   ACTIVIDAD ASC,
   FECHA ASC,
   IDACTIVIDAD ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_4_FK on ACTIVIDAD (
   CODITIPOACTIVIDAD ASC
);

/*==============================================================*/
/* Table: ALUMNO                                                */
/*==============================================================*/
create table ALUMNO 
(
   CARNET               VARCHAR2(100)        not null,
   NOMBRE               VARCHAR2(50),
   APELLIDO             VARCHAR2(50),
   CARRERA              VARCHAR2(80),
   SEXO                 VARCHAR2(1),
   MATERIASGANADAS      NUMBER(2),
   TELEFONO1            VARCHAR2(9),
   TELEFONO2            VARCHAR2(9),
   CORREO1              VARCHAR2(50),
   CORREO2              VARCHAR2(50),
   DIRECCION            VARCHAR2(100),
   constraint PK_ALUMNO primary key (CARNET)
);

/*==============================================================*/
/* Table: ALUMNOPROYECTO                                        */
/*==============================================================*/
create table ALUMNOPROYECTO 
(
   CARNET               VARCHAR2(100)        not null,
   CODIGOPROYECTO       VARCHAR2(10)         not null,
   IDACTIVIDAD          VARCHAR2(8)          not null,
   constraint PK_ALUMNOPROYECTO primary key (CARNET, CODIGOPROYECTO, IDACTIVIDAD)
);

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_1_FK on ALUMNOPROYECTO (
   CARNET ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_2_FK on ALUMNOPROYECTO (
   CODIGOPROYECTO ASC
);

/*==============================================================*/
/* Table: ENCARGADO_SERV_SOCIAL                                 */
/*==============================================================*/
create table ENCARGADO_SERV_SOCIAL 
(
   CODIGOENCARGADO      VARCHAR2(7)          not null,
   NOMBREENCARGADO      VARCHAR2(30),
   APELLIDOENCARGADO    VARCHAR2(30),
   SEXO                 VARCHAR2(1),
   CORREO               VARCHAR2(50),
   constraint PK_ENCARGADO_SERV_SOCIAL primary key (CODIGOENCARGADO)
);

/*==============================================================*/
/* Table: ENTIDAD_SOLICITANTE                                   */
/*==============================================================*/
create table ENTIDAD_SOLICITANTE 
(
   CODIGOENTIDAD        VARCHAR2(10)         not null,
   NOMBREORGANIZACION   VARCHAR2(100),
   RUBRO                VARCHAR2(50),
   TELEFONO             NUMBER(8),
   DIRECCION            VARCHAR2(200),
   constraint PK_ENTIDAD_SOLICITANTE primary key (CODIGOENTIDAD)
);

/*==============================================================*/
/* Table: ESPECIALIDAD                                          */
/*==============================================================*/
create table ESPECIALIDAD 
(
   CODIGOESPECIALIDAD   VARCHAR2(10)         not null,
   NOMBREESPECIALIDAD   VARCHAR2(100),
   CANTIDAD_ESTUDIANTES INTEGER,
   constraint PK_ESPECIALIDAD primary key (CODIGOESPECIALIDAD)
);

/*==============================================================*/
/* Table: MODALIDAD                                             */
/*==============================================================*/
create table MODALIDAD 
(
   CODIGO               VARCHAR2(8)          not null,
   NOMBRE               VARCHAR2(30),
   constraint PK_MODALIDAD primary key (CODIGO)
);

/*==============================================================*/
/* Table: PROYECTO                                              */
/*==============================================================*/
create table PROYECTO 
(
   CODIGOPROYECTO       VARCHAR2(10)         not null,
   CODIGOENCARGADO      VARCHAR2(7)          not null,
   CODIGOENTIDAD        VARCHAR2(10)         not null,
   CODIGOTIPOPROYECTO   VARCHAR2(10)         not null,
   CODIGOTUTOR          VARCHAR2(7)          not null,
   NOMBREPROYECTO       VARCHAR2(100),
   CANTIDADALUMNNECESARIOS NUMBER(4),
   constraint PK_PROYECTO primary key (CODIGOPROYECTO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_6_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_6_FK on PROYECTO (
   CODIGOENCARGADO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_7_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_7_FK on PROYECTO (
   CODIGOENTIDAD ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_8_FK on PROYECTO (
   CODIGOTIPOPROYECTO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_9_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_9_FK on PROYECTO (
   CODIGOTUTOR ASC
);

/*==============================================================*/
/* Table: TIPO_ACTIVIDAD                                        */
/*==============================================================*/
create table TIPO_ACTIVIDAD 
(
   CODIGO_TIPO_ACTIVIDAD VARCHAR2(10)         not null,
   CODIGO               VARCHAR2(8)          not null,
   COSTOPORHORA         FLOAT(4),
   TIPOACTIVIDAD        VARCHAR2(50),
   constraint PK_TIPO_ACTIVIDAD primary key (CODIGO_TIPO_ACTIVIDAD)
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_5_FK on TIPO_ACTIVIDAD (
   CODIGO ASC
);

/*==============================================================*/
/* Table: TIPO_PROYECTO                                         */
/*==============================================================*/
create table TIPO_PROYECTO 
(
   CODIGOTIPOPROYECTO   VARCHAR2(10)         not null,
   TIPOPROYECTO         VARCHAR2(50),
   constraint PK_TIPO_PROYECTO primary key (CODIGOTIPOPROYECTO)
);

/*==============================================================*/
/* Table: TUTOR                                                 */
/*==============================================================*/
create table TUTOR 
(
   CODIGOTUTOR          VARCHAR2(7)          not null,
   CODIGOESPECIALIDAD   VARCHAR2(7)          not null,
   NOMBRETUTOR          VARCHAR2(30),
   APELLIDOTUTOR        VARCHAR2(30),
   CARGO                VARCHAR2(50),
   SEXO                 VARCHAR2(1),
   constraint PK_TUTOR primary key (CODIGOTUTOR)
);

/*==============================================================*/
/* Index: RELATIONSHIP_10_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_10_FK on TUTOR (
   CODIGOESPECIALIDAD ASC
);

alter table ACTIVIDAD
   add constraint FK_ACTIVIDA_RELATIONS_ALUMNOPR foreign key (ACTIVIDAD, FECHA, IDACTIVIDAD)
      references ALUMNOPROYECTO (CARNET, CODIGOPROYECTO, IDACTIVIDAD);

alter table ACTIVIDAD
   add constraint FK_ACTIVIDA_RELATIONS_TIPO_ACT foreign key (CODITIPOACTIVIDAD)
      references TIPO_ACTIVIDAD (CODIGO_TIPO_ACTIVIDAD);

alter table ALUMNOPROYECTO
   add constraint FK_ALUMNOPR_RELATIONS_ALUMNO foreign key (CARNET)
      references ALUMNO (CARNET);

alter table ALUMNOPROYECTO
   add constraint FK_ALUMNOPR_RELATIONS_PROYECTO foreign key (CODIGOPROYECTO)
      references PROYECTO (CODIGOPROYECTO);

alter table PROYECTO
   add constraint FK_PROYECTO_RELATIONS_ENCARGAD foreign key (CODIGOENCARGADO)
      references ENCARGADO_SERV_SOCIAL (CODIGOENCARGADO);

alter table PROYECTO
   add constraint FK_PROYECTO_RELATIONS_ENTIDAD_ foreign key (CODIGOENTIDAD)
      references ENTIDAD_SOLICITANTE (CODIGOENTIDAD);

alter table PROYECTO
   add constraint FK_PROYECTO_RELATIONS_TIPO_PRO foreign key (CODIGOTIPOPROYECTO)
      references TIPO_PROYECTO (CODIGOTIPOPROYECTO);

alter table PROYECTO
   add constraint FK_PROYECTO_RELATIONS_TUTOR foreign key (CODIGOTUTOR)
      references TUTOR (CODIGOTUTOR);

alter table TIPO_ACTIVIDAD
   add constraint FK_TIPO_ACT_RELATIONS_MODALIDA foreign key (CODIGO)
      references MODALIDAD (CODIGO);

alter table TUTOR
   add constraint FK_TUTOR_RELATIONS_ESPECIAL foreign key (CODIGOESPECIALIDAD)
      references ESPECIALIDAD (CODIGOESPECIALIDAD);

