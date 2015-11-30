BEGIN
   FOR cur_rec IN (SELECT object_name, object_type
                     FROM user_objects
                    WHERE object_type IN
                             ('TABLE',
                              'VIEW',
                              'PACKAGE',
                              'PROCEDURE',
                              'FUNCTION',
                              'SEQUENCE',
                              'INDEX',
                              'PRIMARY'
                             ))
   LOOP
      BEGIN
         IF cur_rec.object_type = 'TABLE'
         THEN
            EXECUTE IMMEDIATE    'DROP '
                              || cur_rec.object_type
                              || ' "'
                              || cur_rec.object_name
                              || '" CASCADE CONSTRAINTS';
         ELSE
            EXECUTE IMMEDIATE    'DROP '
                              || cur_rec.object_type
                              || ' "'
                              || cur_rec.object_name
                              || '"';
         END IF;
      EXCEPTION
         WHEN OTHERS
         THEN
            DBMS_OUTPUT.put_line (   'FAILED: DROP '
                                  || cur_rec.object_type
                                  || ' "'
                                  || cur_rec.object_name
                                  || '"'
                                 );
      END;
   END LOOP;
END;
/
/*
Creado: 16/08/2015
Modificado: 12/10/2015
Model: Oracle 11g Release 1
Database: Oracle 11g Release 1
*/

-- TABLAS
-- -----------------------------------------------
-- Comunas
CREATE TABLE "comunas" (
  "id_comuna" Number NOT NULL,
  "comuna_nombre" varchar(64) NOT NULL,
  "id_provincia" Number NOT NULL
);
/
-- Key
ALTER TABLE "comunas" ADD CONSTRAINT "comunaPrimary" PRIMARY KEY ("id_comuna");
/
-- -----------------------------------------------
-- Provincias
CREATE TABLE "provincias" (
  "id_provincia" Number NOT NULL,
  "provincia_nombre" varchar(64) NOT NULL,
  "id_region" Number NOT NULL
);
/
-- Key
ALTER TABLE "provincias" ADD CONSTRAINT "provinciasPrimary" PRIMARY KEY ("id_provincia");
/
-- -----------------------------------------------
-- Regiones
CREATE TABLE "regiones" (
  "id_region" Number NOT NULL,
  "region_nombre" varchar(64) NOT NULL,
  "region_ordinal" varchar(4) NOT NULL
);
/
-- Key
ALTER TABLE "regiones" ADD CONSTRAINT "regionesPrimary" PRIMARY KEY ("id_region");
/
-- -----------------------------------------------
-- Cadenas
CREATE TABLE "cadenas" (
  "id_cadena" NUMBER NOT NULL,
  "nombre" Varchar2(60) NOT NULL
);
/
-- Keys
ALTER TABLE "cadenas" ADD CONSTRAINT "cadenasPrimary" PRIMARY KEY ("id_cadena");
/
-- -----------------------------------------------
-- hoteles
CREATE TABLE "hoteles" (
  "id_hotel" NUMBER NOT NULL,
  "id_cadena" Number NOT NULL,
  "id_region" Number NOT NULL,
  "id_provincia" Number NOT NULL,
  "id_comuna" Number NOT NULL,
  "nombre" Varchar2(100) NOT NULL,
  "direccion" Varchar2(100) NOT NULL
);
/
-- Keys
ALTER TABLE "hoteles" ADD CONSTRAINT "hotelesPrimary" PRIMARY KEY ("id_hotel");
/

-- -----------------------------------------------
-- servicios
CREATE TABLE "servicios" (
  "id_servicio" NUMBER NOT NULL,
  "nombre" Varchar2(60) NOT NULL,
  "precio" Number NOT NULL
);
/
-- Keys
ALTER TABLE "servicios" ADD CONSTRAINT "serviciosPrimary" PRIMARY KEY ("id_servicio");
/
-- -----------------------------------------------
-- hoteles_servicios
CREATE TABLE "hoteles_servicios" (
  "id_hotel" NUMBER NOT NULL,
  "id_servicio" Number NOT NULL
);
/
-- Keys
ALTER TABLE "hoteles_servicios" ADD CONSTRAINT "hoteles_serviciosPrimary" PRIMARY KEY ("id_hotel", "id_servicio");
/
-- -----------------------------------------------
-- tipo_caracteristica
CREATE TABLE "tipo_caracteristicas" (
  "id_tipo_caract" NUMBER NOT NULL,
  "nombre" Varchar2(100) NOT NULL,
  "descripcion" Varchar2(255) NOT NULL
);
/
-- Keys
ALTER TABLE "tipo_caracteristicas" ADD CONSTRAINT "tipo_caracteristicaPrimary" PRIMARY KEY ("id_tipo_caract");
/
-- -----------------------------------------------

-- caracteristicas
CREATE TABLE "caracteristicas" (
  "id_caracteristica" NUMBER NOT NULL,
  "id_tipo_caract" Number NOT NULL,
  "cantidad" Number NOT NULL,
  "tipo" Varchar2(15) NOT NULL
);
/
-- Keys
ALTER TABLE "caracteristicas" ADD CONSTRAINT "caracteristicasPrimary" PRIMARY KEY ("id_caracteristica");
/
-- -----------------------------------------------
-- hoteles_caracteristicas
CREATE TABLE "hoteles_caracteristicas" (
  "id_hotel" NUMBER NOT NULL,
  "id_caracteristica" Number NOT NULL
);
/
-- Keys
ALTER TABLE "hoteles_caracteristicas" 
  ADD CONSTRAINT "hoteles_caractPrimary" 
  PRIMARY KEY ("id_hotel", "id_caracteristica");
/

-- -----------------------------------------------
-- habitaciones_caracteristicas
CREATE TABLE "habitaciones_caracteristicas" (
  "id_habitacion" NUMBER NOT NULL,
  "id_caracteristica" Number NOT NULL
);
/
-- Keys
ALTER TABLE "habitaciones_caracteristicas" 
  ADD CONSTRAINT "habitaciones_caractPrimary" 
  PRIMARY KEY ("id_habitacion", "id_caracteristica");
/

-- -----------------------------------------------


-- habitaciones
CREATE TABLE "habitaciones" (
  "id_habitacion" NUMBER NOT NULL,
  "id_hotel" Number NOT NULL,
  "id_habitacion_tipo" Number NOT NULL,
  "id_habitacion_estado" Number NOT NULL,
  "ubicacion" Varchar2(10) NOT NULL,
  "cant_personas" Number NOT NULL,
  "precio" Number NOT NULL
);
/
-- Keys
ALTER TABLE "habitaciones" ADD CONSTRAINT "habitacionesPrimary" PRIMARY KEY ("id_habitacion");
/
-- -----------------------------------------------
-- historial_precios
CREATE TABLE "historial_precios" (
  "id_historial_precio" NUMBER NOT NULL,
  "id_habitacion" Number NOT NULL,
  "precio" Number NOT NULL,
  "fecha" Date
);
/
-- Keys
ALTER TABLE "historial_precios" ADD CONSTRAINT "historial_preciosPrimary" PRIMARY KEY ("id_historial_precio");
/
-- -----------------------------------------------

-- habitacion_tipos
CREATE TABLE "habitacion_tipos" (
  "id_habitacion_tipo" NUMBER NOT NULL,
  "nombre" Varchar2(100) NOT NULL
);
/
-- Keys
ALTER TABLE "habitacion_tipos" ADD CONSTRAINT "habitacion_tiposPrimary" PRIMARY KEY ("id_habitacion_tipo");
/
-- -----------------------------------------------

-- habitacion_estados
CREATE TABLE "habitacion_estados" (
  "id_habitacion_estado" NUMBER NOT NULL,
  "estado" Varchar2(100) NOT NULL
);
/
-- Keys
ALTER TABLE "habitacion_estados" ADD CONSTRAINT "habitacion_estadosPrimary" PRIMARY KEY ("id_habitacion_estado");
/
-- -----------------------------------------------
-- habitacion_inspecciones
CREATE TABLE "habitacion_inspecciones" (
  "id_habitacion_inspeccion" NUMBER NOT NULL,
  "id_habitacion" Number NOT NULL,
  "fecha_inicio" Date,
  "comentario" Varchar2(255) NOT NULL,
  "nombre_inspector" Varchar2(30) NOT NULL
);
/
-- Keys
ALTER TABLE "habitacion_inspecciones" ADD CONSTRAINT "habitacion_inspeccionesPrimary" PRIMARY KEY ("id_habitacion_inspeccion");
/
-- -----------------------------------------------

-- empresas
CREATE TABLE "empresas" (
  "id_empresa" NUMBER NOT NULL,
  "nombre" Varchar2(100) NOT NULL
);
/
-- Keys
ALTER TABLE "empresas" ADD CONSTRAINT "empresasPrimary" PRIMARY KEY ("id_empresa");
/
-- -----------------------------------------------
-- convenios
CREATE TABLE "convenios" (
  "id_convenio" NUMBER NOT NULL,
  "id_empresa" Number NOT NULL,
  "fecha_inicio" Date,
  "fecha_fin" Date,
  "estado" Varchar2(10) NOT NULL
);
/
-- Keys
ALTER TABLE "convenios" ADD CONSTRAINT "conveniosPrimary" PRIMARY KEY ("id_convenio");
/
-- -----------------------------------------------
-- hoteles_convenios
CREATE TABLE "hoteles_convenios" (
  "id_hotel" NUMBER NOT NULL,
  "id_convenio" Number NOT NULL
);
/
-- Keys
ALTER TABLE "hoteles_convenios" ADD CONSTRAINT "hoteles_conveniosPrimary" PRIMARY KEY ("id_hotel", "id_convenio");
/
-- -----------------------------------------------
-- pasajeros
CREATE TABLE "pasajeros" (
  "id_pasajero" NUMBER NOT NULL,
  "rut" Varchar2(15) NOT NULL,
  "nombre" Varchar2(20) NOT NULL,
  "contrasena" Varchar2(255) NOT NULL,
  "apellido_pa" Varchar2(20) NOT NULL,
  "apellido_ma" Varchar2(20) NOT NULL,
  "telefono" Varchar2(15) NOT NULL,
  "email" Varchar2(50) NOT NULL,
  "id_region" Number,
  "id_provincia" Number,
  "id_comuna" Number,
  "direccion" Varchar2(100) NOT NULL,
  "fecha_nac" Date,
  "id_rol" Number NOT NULL
);
/
-- Keys
ALTER TABLE "pasajeros" ADD CONSTRAINT "pasajerosPrimary" PRIMARY KEY ("id_pasajero");
/
-- -----------------------------------------------
-- roles
CREATE TABLE "roles" (
  "id_rol" NUMBER NOT NULL,
  "nombre" Varchar2(100) NOT NULL,
  "descripcion" Varchar2(255) NOT NULL
);
/
-- Keys
ALTER TABLE "roles" ADD CONSTRAINT "rolesPrimary" PRIMARY KEY ("id_rol");
/
-- -----------------------------------------------

-- reserva_reportes
CREATE TABLE "reserva_reportes" (
  "id_reserva_reporte" NUMBER NOT NULL,
  "id_reserva" Number NOT NULL,
  "fecha_reporte" Date,
  "comentario" Varchar2(255) NOT NULL,
  "tipo" Varchar2(100) NOT NULL,
  "valor" Number NOT NULL
);
/
-- Keys
ALTER TABLE "reserva_reportes" ADD CONSTRAINT "reserva_reportesPrimary" PRIMARY KEY ("id_reserva_reporte");
/
-- -----------------------------------------------

-- reservas
CREATE TABLE "reservas" (
  "id_reserva" NUMBER NOT NULL,
  "id_pasajero" Number NOT NULL,
  "id_reserva_estado" Number NOT NULL,
  "fecha_ingreso" Date NOT NULL,
  "fecha_salida" Date NOT NULL,
  "precio_total" Number NOT NULL
);
/
-- Keys
ALTER TABLE "reservas" ADD CONSTRAINT "reservasPrimary" PRIMARY KEY ("id_reserva");
/
-- -----------------------------------------------
-- estado_reservas
CREATE TABLE "estado_reservas" (
  "id_reserva_estado" NUMBER NOT NULL,
  "nombre" Varchar2(20) NOT NULL
);
/
-- Keys
ALTER TABLE "estado_reservas" ADD CONSTRAINT "estado_reservasPrimary" PRIMARY KEY ("id_reserva_estado");
/
-- -----------------------------------------------

-- habitaciones_reservas
CREATE TABLE "habitaciones_reservas" (
  "id_habitacion" NUMBER NOT NULL,
  "id_reserva" Number NOT NULL
);
/
-- Keys
ALTER TABLE "habitaciones_reservas" 
  ADD CONSTRAINT "habitaciones_reservasPrimary" 
  PRIMARY KEY ("id_habitacion", "id_reserva");
/
-- -----------------------------------------------
-- servicios_reservas
CREATE TABLE "servicios_reservas" (
  "id_servicio" NUMBER NOT NULL,
  "id_reserva" Number NOT NULL
);
/
-- Keys
ALTER TABLE "servicios_reservas" 
  ADD CONSTRAINT "servicios_reservasPrimary" 
  PRIMARY KEY ("id_servicio", "id_reserva");
/
-- -----------------------------------------------
-- tipo_menu
CREATE TABLE "tipo_menu" (
  "id_tipo_menu" NUMBER NOT NULL,
  "nombre" Varchar2(60) NOT NULL
);
/
-- Keys
ALTER TABLE "tipo_menu" ADD CONSTRAINT "tipo_menuPrimary" PRIMARY KEY ("id_tipo_menu");
/
-- -----------------------------------------------
-- hote_tipo_menu
CREATE TABLE "hotel_tipo_menu" (
  "id_hotel" NUMBER NOT NULL,
  "id_menu" Number NOT NULL
);
/
-- Keys
ALTER TABLE "hotel_tipo_menu" 
  ADD CONSTRAINT "hotel_tipo_menuPrimary"
  PRIMARY KEY ("id_hotel", "id_menu");
/

-- -----------------------------------------------
-- menu
CREATE TABLE "menu" (
  "id_menu" NUMBER NOT NULL,
  "id_tipo_menu" Number NOT NULL,
  "nombre" Varchar2(100) NOT NULL,
  "precio" Number NOT NULL
);
/
-- Keys
ALTER TABLE "menu" ADD CONSTRAINT "menuPrimary" PRIMARY KEY ("id_menu");
/
-- -----------------------------------------------
-- insumos
CREATE TABLE "insumos" (
  "id_insumo" NUMBER NOT NULL,
  "nombre" Varchar2(100) NOT NULL,
  "descripcion" Varchar2(255) NOT NULL
);
/
-- Keys
ALTER TABLE "insumos" ADD CONSTRAINT "insumosPrimary" PRIMARY KEY ("id_insumo");
/
-- -----------------------------------------------
-- medidas
CREATE TABLE "medidas" (
  "id_medida" NUMBER NOT NULL,
  "medida" Varchar2(100) NOT NULL
);
/
-- Keys
ALTER TABLE "medidas" ADD CONSTRAINT "medidasPrimary" PRIMARY KEY ("id_medida");
/
-- -----------------------------------------------

-- menu_insumos
CREATE TABLE "menu_insumos" (
  "id_menu_insumo" NUMBER NOT NULL,
  "id_insumo" Number NOT NULL,
  "id_menu" Number NOT NULL,
  "id_medida" Number NOT NULL,
  "cantidad" Number NOT NULL
);
/
-- Keys
ALTER TABLE "menu_insumos" ADD CONSTRAINT "menu_insumosPrimary" PRIMARY KEY ("id_menu_insumo");
/
-- -----------------------------------------------
-- hotel_insumos
CREATE TABLE "hotel_insumos" (
  "id_insumo_hotel" NUMBER NOT NULL,
  "id_insumo" Number NOT NULL,
  "id_hotel" Number NOT NULL,
  "id_medida" Number NOT NULL,
  "stock" Number NOT NULL
);
/
-- Keys
ALTER TABLE "hotel_insumos" ADD CONSTRAINT "hotel_insumosPrimary" PRIMARY KEY ("id_insumo_hotel");
/
-- -----------------------------------------------
-- tipo_reportes
CREATE TABLE "tipo_reportes" (
  "id_tipo_reporte" NUMBER NOT NULL,
  "nombre" Varchar2(100) NOT NULL,
  "descripcion" Varchar2(255) NOT NULL
);
/
-- Keys
ALTER TABLE "tipo_reportes" ADD CONSTRAINT "tipo_reportesPrimary" PRIMARY KEY ("id_tipo_reporte");
/
-- -----------------------------------------------
-- reportes
CREATE TABLE "reportes" (
  "id_reporte" NUMBER NOT NULL,
  "id_tipo_reporte" Number NOT NULL,
  "fecha_creacion" Date NOT NULL,
  "archivo" Varchar2(255) NOT NULL,
  "comentario" Varchar2(255) NOT NULL
);
/
-- Keys
ALTER TABLE "reportes" ADD CONSTRAINT "reportesPrimary" PRIMARY KEY ("id_reporte");
/
-- -----------------------------------------------
-- --------------------------------------------------------------------------------------
-- FOREIGN KEYS
-- --------------------------------------------------------------------------------------



ALTER TABLE "hoteles" 
  ADD CONSTRAINT "hoteles_cadenas_FK" 
  FOREIGN KEY ("id_cadena") 
    REFERENCES "cadenas" ("id_cadena");
/
-- --------
ALTER TABLE "hoteles_servicios" 
  ADD CONSTRAINT "servicios_hoteles_FK" 
  FOREIGN KEY ("id_servicio") 
    REFERENCES "servicios" ("id_servicio");
/
-- --------
ALTER TABLE "hoteles_servicios" 
  ADD CONSTRAINT "hoteles_servicios_FK" 
  FOREIGN KEY ("id_hotel") 
    REFERENCES "hoteles" ("id_hotel");
/
-- --------
ALTER TABLE "caracteristicas" 
  ADD CONSTRAINT "caracteristicas_tipo_FK" 
  FOREIGN KEY ("id_tipo_caract") 
    REFERENCES "tipo_caracteristicas" ("id_tipo_caract");
/
-- --------
ALTER TABLE "hoteles_caracteristicas" 
  ADD CONSTRAINT "hoteles_caracteristicas_FK" 
  FOREIGN KEY ("id_caracteristica") 
    REFERENCES "caracteristicas" ("id_caracteristica");
/
-- --------
ALTER TABLE "hoteles_caracteristicas" 
  ADD CONSTRAINT "hoteles_caracteristicas_FK2" 
  FOREIGN KEY ("id_hotel") 
    REFERENCES "hoteles" ("id_hotel");
/
-- --------
ALTER TABLE "habitaciones_caracteristicas" 
  ADD CONSTRAINT "habitaciones_caract_FK" 
  FOREIGN KEY ("id_habitacion") 
    REFERENCES "habitaciones" ("id_habitacion");
/
-- --------
ALTER TABLE "habitaciones_caracteristicas" 
  ADD CONSTRAINT "habitaciones_caract_FK2" 
  FOREIGN KEY ("id_caracteristica") 
    REFERENCES "caracteristicas" ("id_caracteristica");
/
-- --------
ALTER TABLE "habitaciones" 
  ADD CONSTRAINT "habitaciones_hoteles_FK" 
  FOREIGN KEY ("id_hotel") 
    REFERENCES "hoteles" ("id_hotel");
/
-- --------
ALTER TABLE "habitaciones" 
  ADD CONSTRAINT "habit_hab_tipos_FK" 
  FOREIGN KEY ("id_habitacion_tipo") 
    REFERENCES "habitacion_tipos" ("id_habitacion_tipo");
/
-- --------
ALTER TABLE "habitaciones" 
  ADD CONSTRAINT "habit_hab_estados_FK" 
  FOREIGN KEY ("id_habitacion_estado") 
    REFERENCES "habitacion_estados" ("id_habitacion_estado");
/
-- --------
ALTER TABLE "historial_precios" 
  ADD CONSTRAINT "hist_precios_hab_FK" 
  FOREIGN KEY ("id_habitacion") 
    REFERENCES "habitaciones" ("id_habitacion");
/
-- --------
ALTER TABLE "habitacion_inspecciones" 
  ADD CONSTRAINT "habitacion_inspecciones_FK" 
  FOREIGN KEY ("id_habitacion") 
    REFERENCES "habitaciones" ("id_habitacion");
/
-- --------
ALTER TABLE "convenios" 
  ADD CONSTRAINT "convenios_empresas_FK" 
  FOREIGN KEY ("id_empresa") 
    REFERENCES "empresas" ("id_empresa");
/
-- --------
ALTER TABLE "pasajeros" 
  ADD CONSTRAINT "pasajeros_roles_FK" 
  FOREIGN KEY ("id_rol") 
    REFERENCES "roles" ("id_rol");
/
-- --------
ALTER TABLE "hoteles_convenios" 
  ADD CONSTRAINT "hoteles_convenios_hoteles_FK" 
  FOREIGN KEY ("id_hotel") 
    REFERENCES "hoteles" ("id_hotel");
/
-- --------
ALTER TABLE "hoteles_convenios" 
  ADD CONSTRAINT "hoteles_convenios_convenios_FK" 
  FOREIGN KEY ("id_convenio") 
    REFERENCES "convenios" ("id_convenio");
/
-- --------
ALTER TABLE "reservas" 
  ADD CONSTRAINT "reservas_pasajeros_FK" 
  FOREIGN KEY ("id_pasajero") 
    REFERENCES "pasajeros" ("id_pasajero");
/
-- --------
ALTER TABLE "reservas" 
  ADD CONSTRAINT "reservas_estado_FK" 
  FOREIGN KEY ("id_reserva_estado") 
    REFERENCES "estado_reservas" ("id_reserva_estado");
/
-- --------
ALTER TABLE "reserva_reportes" 
  ADD CONSTRAINT "reserva_reportes_FK" 
  FOREIGN KEY ("id_reserva") 
    REFERENCES "reservas" ("id_reserva");
/
-- --------
ALTER TABLE "habitaciones_reservas" 
  ADD CONSTRAINT "habitaciones_reservas_FK" 
  FOREIGN KEY ("id_habitacion") 
    REFERENCES "habitaciones" ("id_habitacion");
/
-- --------
ALTER TABLE "habitaciones_reservas" 
  ADD CONSTRAINT "habitaciones_reservas_FK2" 
  FOREIGN KEY ("id_reserva") 
    REFERENCES "reservas" ("id_reserva");
/
-- --------
ALTER TABLE "servicios_reservas" 
  ADD CONSTRAINT "servs_resas_se_FK" 
  FOREIGN KEY ("id_servicio") 
    REFERENCES "servicios" ("id_servicio");
/
-- --------
ALTER TABLE "servicios_reservas" 
  ADD CONSTRAINT "servs_resas_re_FK" 
  FOREIGN KEY ("id_reserva") 
    REFERENCES "reservas" ("id_reserva");
/
-- --------
ALTER TABLE "hotel_tipo_menu" 
  ADD CONSTRAINT "hotel_tipo_menu_hoteles_FK" 
  FOREIGN KEY ("id_hotel") 
    REFERENCES "hoteles" ("id_hotel");
/
-- --------
ALTER TABLE "hotel_tipo_menu" 
  ADD CONSTRAINT "hotel_tipo_menu_tipo_menu_FK" 
  FOREIGN KEY ("id_menu") 
    REFERENCES "menu" ("id_menu");
/
-- --------
ALTER TABLE "menu" 
  ADD CONSTRAINT "menu_tipo_menu_FK" 
  FOREIGN KEY ("id_tipo_menu") 
    REFERENCES "tipo_menu" ("id_tipo_menu");
/
-- --------
ALTER TABLE "menu_insumos" 
  ADD CONSTRAINT "menu_insumos_menu_FK" 
  FOREIGN KEY ("id_menu") 
    REFERENCES "menu" ("id_menu");
/
-- --------
ALTER TABLE "menu_insumos" 
  ADD CONSTRAINT "menu_insumos_medidas_FK" 
  FOREIGN KEY ("id_medida") 
    REFERENCES "medidas" ("id_medida");
/
-- --------
ALTER TABLE "menu_insumos" 
  ADD CONSTRAINT "menu_insumos_insumos_FK" 
  FOREIGN KEY ("id_insumo") 
    REFERENCES "insumos" ("id_insumo");
/
-- --------
ALTER TABLE "hotel_insumos" 
  ADD CONSTRAINT "hotel_insumos_insumos_FK" 
  FOREIGN KEY ("id_insumo") 
    REFERENCES "insumos" ("id_insumo");
/
-- --------
ALTER TABLE "hotel_insumos" 
  ADD CONSTRAINT "hotel_insumos_hoteles_FK" 
  FOREIGN KEY ("id_hotel") 
    REFERENCES "hoteles" ("id_hotel");
/
-- --------
ALTER TABLE "hotel_insumos" 
  ADD CONSTRAINT "hotel_insumos_medidas_FK" 
  FOREIGN KEY ("id_medida") 
    REFERENCES "medidas" ("id_medida");
/
-- --------
ALTER TABLE "reportes" 
  ADD CONSTRAINT "reportes_tipo_reportes_FK" 
  FOREIGN KEY ("id_tipo_reporte") 
    REFERENCES "tipo_reportes" ("id_tipo_reporte");
/
-- --------
ALTER TABLE "comunas" 
  ADD CONSTRAINT "comunas_provincias_FK" 
  FOREIGN KEY ("id_provincia") 
    REFERENCES "provincias" ("id_provincia");
/
-- --------
ALTER TABLE "provincias" 
  ADD CONSTRAINT "provincias_region_FK" 
  FOREIGN KEY ("id_region") 
    REFERENCES "regiones" ("id_region");
/
-- --------
ALTER TABLE "hoteles" 
  ADD CONSTRAINT "hoteles_region_FK" 
  FOREIGN KEY ("id_region") 
    REFERENCES "regiones" ("id_region");
/
-- --------
ALTER TABLE "hoteles" 
  ADD CONSTRAINT "hoteles_provincia_FK" 
  FOREIGN KEY ("id_provincia") 
    REFERENCES "provincias" ("id_provincia");
/
-- --------
ALTER TABLE "hoteles" 
  ADD CONSTRAINT "hoteles_comuna_FK" 
  FOREIGN KEY ("id_comuna") 
    REFERENCES "comunas" ("id_comuna");
/
-- --------
ALTER TABLE "pasajeros" 
  ADD CONSTRAINT "pasajeros_region_FK" 
  FOREIGN KEY ("id_region") 
    REFERENCES "regiones" ("id_region");
/
-- --------
ALTER TABLE "pasajeros" 
  ADD CONSTRAINT "pasajeros_provincia_FK" 
  FOREIGN KEY ("id_provincia") 
    REFERENCES "provincias" ("id_provincia");
/
-- --------
ALTER TABLE "pasajeros" 
  ADD CONSTRAINT "pasajeros_comuna_FK" 
  FOREIGN KEY ("id_comuna") 
    REFERENCES "comunas" ("id_comuna");
/
-- --------
/* REGIONES */
INSERT INTO "regiones" ("id_region","region_nombre","region_ordinal") VALUES (1,'Arica y Parinacota','XV');
INSERT INTO "regiones" ("id_region","region_nombre","region_ordinal") VALUES (2,'Tarapacá','I');
INSERT INTO "regiones" ("id_region","region_nombre","region_ordinal") VALUES (3,'Antofagasta','II');
INSERT INTO "regiones" ("id_region","region_nombre","region_ordinal") VALUES (4,'Atacama','III');
INSERT INTO "regiones" ("id_region","region_nombre","region_ordinal") VALUES (5,'Coquimbo','IV');
INSERT INTO "regiones" ("id_region","region_nombre","region_ordinal") VALUES (6,'Valparaiso','V');
INSERT INTO "regiones" ("id_region","region_nombre","region_ordinal") VALUES (7,'Metropolitana de Santiago','RM');
INSERT INTO "regiones" ("id_region","region_nombre","region_ordinal") VALUES (8,'Libertador General Bernardo OHiggins','VI');
INSERT INTO "regiones" ("id_region","region_nombre","region_ordinal") VALUES (9,'Maule','VII');
INSERT INTO "regiones" ("id_region","region_nombre","region_ordinal") VALUES (10,'Biobío','VIII');
INSERT INTO "regiones" ("id_region","region_nombre","region_ordinal") VALUES (11,'La Araucanía','IX');
INSERT INTO "regiones" ("id_region","region_nombre","region_ordinal") VALUES (12,'Los Ríos','XIV');
INSERT INTO "regiones" ("id_region","region_nombre","region_ordinal") VALUES (13,'Los Lagos','X');
INSERT INTO "regiones" ("id_region","region_nombre","region_ordinal") VALUES (14,'Aisén del General Carlos Ibáñez del Campo','XI');
INSERT INTO "regiones" ("id_region","region_nombre","region_ordinal") VALUES (15,'Magallanes y de la Antártica Chilena','XII');


/* PROVINCIAS */
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(1,'Arica',1);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(2,'Parinacota',1);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(3,'Iquique',2);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(4,'El Tamarugal',2);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(5,'Antofagasta',3);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(6,'El Loa',3);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(7,'Tocopilla',3);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(8,'Chañaral',4);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(9,'Copiapó',4);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(10,'Huasco',4);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(11,'Choapa',5);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(12,'Elqui',5);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(13,'Limarí',5);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(14,'Isla de Pascua',6);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(15,'Los Andes',6);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(16,'Petorca',6);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(17,'Quillota',6);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(18,'San Antonio',6);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(19,'San Felipe de Aconcagua',6);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(20,'Valparaiso',6);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(21,'Chacabuco',7);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(22,'Cordillera',7);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(23,'Maipo',7);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(24,'Melipilla',7);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(25,'Santiago',7);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(26,'Talagante',7);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(27,'Cachapoal',8);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(28,'Cardenal Caro',8);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(29,'Colchagua',8);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(30,'Cauquenes',9);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(31,'Curicó',9);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(32,'Linares',9);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(33,'Talca',9);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(34,'Arauco',10);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(35,'Bio Bío',10);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(36,'Concepción',10);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(37,'Ñuble',10);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(38,'Cautín',11);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(39,'Malleco',11);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(40,'Valdivia',12);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(41,'Ranco',12);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(42,'Chiloé',13);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(43,'Llanquihue',13);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(44,'Osorno',13);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(45,'Palena',13);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(46,'Aisén',14);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(47,'Capitán Prat',14);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(48,'Coihaique',14);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(49,'General Carrera',14);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(50,'Antártica Chilena',15);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(51,'Magallanes',15);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(52,'Tierra del Fuego',15);
INSERT INTO "provincias" ("id_provincia","provincia_nombre","id_region") VALUES	(53,'Última Esperanza',15);

/* COMUNAS */
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (1,'Arica',1);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (2,'Camarones',1);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (3,'General Lagos',2);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (4,'Putre',2);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (5,'Alto Hospicio',3);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (6,'Iquique',3);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (7,'Camiña',4);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (8,'Colchane',4);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (9,'Huara',4);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (10,'Pica',4);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (11,'Pozo Almonte',4);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (12,'Antofagasta',5);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (13,'Mejillones',5);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (14,'Sierra Gorda',5);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (15,'Taltal',5);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (16,'Calama',6);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (17,'Ollague',6);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (18,'San Pedro de Atacama',6);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (19,'María Elena',7);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (20,'Tocopilla',7);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (21,'Chañaral',8);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (22,'Diego de Almagro',8);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (23,'Caldera',9);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (24,'Copiapó',9);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (25,'Tierra Amarilla',9);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (26,'Alto del Carmen',10);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (27,'Freirina',10);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (28,'Huasco',10);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (29,'Vallenar',10);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (30,'Canela',11);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (31,'Illapel',11);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (32,'Los Vilos',11);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (33,'Salamanca',11);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (34,'Andacollo',12);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (35,'Coquimbo',12);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (36,'La Higuera',12);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (37,'La Serena',12);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (38,'Paihuaco',12);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (39,'Vicuña',12);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (40,'Combarbalá',13);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (41,'Monte Patria',13);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (42,'Ovalle',13);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (43,'Punitaqui',13);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (44,'Río Hurtado',13);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (45,'Isla de Pascua',14);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (46,'Calle Larga',15);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (47,'Los Andes',15);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (48,'Rinconada',15);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (49,'San Esteban',15);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (50,'La Ligua',16);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (51,'Papudo',16);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (52,'Petorca',16);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (53,'Zapallar',16);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (54,'Hijuelas',17);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (55,'La Calera',17);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (56,'La Cruz',17);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (57,'Limache',17);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (58,'Nogales',17);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (59,'Olmué',17);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (60,'Quillota',17);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (61,'Algarrobo',18);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (62,'Cartagena',18);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (63,'El Quisco',18);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (64,'El Tabo',18);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (65,'San Antonio',18);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (66,'Santo Domingo',18);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (67,'Catemu',19);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (68,'Llaillay',19);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (69,'Panquehue',19);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (70,'Putaendo',19);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (71,'San Felipe',19);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (72,'Santa María',19);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (73,'Casablanca',20);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (74,'Concón',20);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (75,'Juan Fernández',20);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (76,'Puchuncaví',20);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (77,'Quilpué',20);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (78,'Quintero',20);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (79,'Valparaíso',20);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (80,'Villa Alemana',20);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (81,'Viña del Mar',20);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (82,'Colina',21);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (83,'Lampa',21);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (84,'Tiltil',21);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (85,'Pirque',22);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (86,'Puente Alto',22);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (87,'San José de Maipo',22);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (88,'Buin',23);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (89,'Calera de Tango',23);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (90,'Paine',23);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (91,'San Bernardo',23);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (92,'Alhué',24);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (93,'Curacaví',24);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (94,'María Pinto',24);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (95,'Melipilla',24);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (96,'San Pedro',24);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (97,'Cerrillos',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (98,'Cerro Navia',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (99,'Conchalí',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (100,'El Bosque',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (101,'Estación Central',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (102,'Huechuraba',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (103,'Independencia',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (104,'La Cisterna',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (105,'La Granja',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (106,'La Florida',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (107,'La Pintana',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (108,'La Reina',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (109,'Las Condes',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (110,'Lo Barnechea',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (111,'Lo Espejo',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (112,'Lo Prado',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (113,'Macul',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (114,'Maipú',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (115,'Ñuñoa',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (116,'Pedro Aguirre Cerda',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (117,'Peñalolén',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (118,'Providencia',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (119,'Pudahuel',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (120,'Quilicura',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (121,'Quinta Normal',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (122,'Recoleta',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (123,'Renca',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (124,'San Miguel',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (125,'San Joaquín',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (126,'San Ramón',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (127,'Santiago',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (128,'Vitacura',25);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (129,'El Monte',26);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (130,'Isla de Maipo',26);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (131,'Padre Hurtado',26);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (132,'Peñaflor',26);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (133,'Talagante',26);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (134,'Codegua',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (135,'Coínco',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (136,'Coltauco',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (137,'Doñihue',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (138,'Graneros',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (139,'Las Cabras',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (140,'Machalí',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (141,'Malloa',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (142,'Mostazal',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (143,'Olivar',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (144,'Peumo',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (145,'Pichidegua',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (146,'Quinta de Tilcoco',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (147,'Rancagua',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (148,'Rengo',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (149,'Requínoa',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (150,'San Vicente de Tagua Tagua',27);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (151,'La Estrella',28);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (152,'Litueche',28);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (153,'Marchihue',28);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (154,'Navidad',28);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (155,'Peredones',28);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (156,'Pichilemu',28);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (157,'Chépica',29);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (158,'Chimbarongo',29);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (159,'Lolol',29);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (160,'Nancagua',29);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (161,'Palmilla',29);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (162,'Peralillo',29);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (163,'Placilla',29);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (164,'Pumanque',29);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (165,'San Fernando',29);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (166,'Santa Cruz',29);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (167,'Cauquenes',30);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (168,'Chanco',30);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (169,'Pelluhue',30);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (170,'Curicó',31);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (171,'Hualañé',31);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (172,'Licantén',31);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (173,'Molina',31);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (174,'Rauco',31);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (175,'Romeral',31);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (176,'Sagrada Familia',31);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (177,'Teno',31);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (178,'Vichuquén',31);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (179,'Colbún',32);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (180,'Linares',32);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (181,'Longaví',32);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (182,'Parral',32);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (183,'Retiro',32);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (184,'San Javier',32);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (185,'Villa Alegre',32);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (186,'Yerbas Buenas',32);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (187,'Constitución',33);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (188,'Curepto',33);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (189,'Empedrado',33);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (190,'Maule',33);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (191,'Pelarco',33);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (192,'Pencahue',33);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (193,'Río Claro',33);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (194,'San Clemente',33);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (195,'San Rafael',33);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (196,'Talca',33);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (197,'Arauco',34);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (198,'Cañete',34);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (199,'Contulmo',34);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (200,'Curanilahue',34);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (201,'Lebu',34);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (202,'Los Álamos',34);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (203,'Tirúa',34);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (204,'Alto Biobío',35);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (205,'Antuco',35);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (206,'Cabrero',35);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (207,'Laja',35);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (208,'Los Ángeles',35);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (209,'Mulchén',35);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (210,'Nacimiento',35);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (211,'Negrete',35);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (212,'Quilaco',35);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (213,'Quilleco',35);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (214,'San Rosendo',35);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (215,'Santa Bárbara',35);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (216,'Tucapel',35);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (217,'Yumbel',35);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (218,'Chiguayante',36);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (219,'Concepción',36);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (220,'Coronel',36);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (221,'Florida',36);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (222,'Hualpén',36);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (223,'Hualqui',36);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (224,'Lota',36);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (225,'Penco',36);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (226,'San Pedro de La Paz',36);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (227,'Santa Juana',36);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (228,'Talcahuano',36);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (229,'Tomé',36);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (230,'Bulnes',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (231,'Chillán',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (232,'Chillán Viejo',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (233,'Cobquecura',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (234,'Coelemu',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (235,'Coihueco',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (236,'El Carmen',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (237,'Ninhue',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (238,'Ñiquen',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (239,'Pemuco',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (240,'Pinto',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (241,'Portezuelo',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (242,'Quillón',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (243,'Quirihue',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (244,'Ránquil',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (245,'San Carlos',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (246,'San Fabián',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (247,'San Ignacio',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (248,'San Nicolás',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (249,'Treguaco',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (250,'Yungay',37);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (251,'Carahue',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (252,'Cholchol',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (253,'Cunco',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (254,'Curarrehue',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (255,'Freire',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (256,'Galvarino',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (257,'Gorbea',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (258,'Lautaro',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (259,'Loncoche',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (260,'Melipeuco',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (261,'Nueva Imperial',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (262,'Padre Las Casas',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (263,'Perquenco',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (264,'Pitrufquén',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (265,'Pucón',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (266,'Saavedra',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (267,'Temuco',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (268,'Teodoro Schmidt',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (269,'Toltén',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (270,'Vilcún',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (271,'Villarrica',38);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (272,'Angol',39);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (273,'Collipulli',39);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (274,'Curacautín',39);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (275,'Ercilla',39);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (276,'Lonquimay',39);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (277,'Los Sauces',39);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (278,'Lumaco',39);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (279,'Purén',39);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (280,'Renaico',39);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (281,'Traiguén',39);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (282,'Victoria',39);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (283,'Corral',40);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (284,'Lanco',40);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (285,'Los Lagos',40);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (286,'Máfil',40);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (287,'Mariquina',40);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (288,'Paillaco',40);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (289,'Panguipulli',40);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (290,'Valdivia',40);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (291,'Futrono',41);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (292,'La Unión',41);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (293,'Lago Ranco',41);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (294,'Río Bueno',41);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (295,'Ancud',42);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (296,'Castro',42);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (297,'Chonchi',42);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (298,'Curaco de Vélez',42);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (299,'Dalcahue',42);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (300,'Puqueldón',42);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (301,'Queilén',42);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (302,'Quemchi',42);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (303,'Quellón',42);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (304,'Quinchao',42);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (305,'Calbuco',43);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (306,'Cochamó',43);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (307,'Fresia',43);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (308,'Frutillar',43);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (309,'Llanquihue',43);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (310,'Los Muermos',43);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (311,'Maullín',43);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (312,'Puerto Montt',43);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (313,'Puerto Varas',43);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (314,'Osorno',44);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (315,'Puero Octay',44);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (316,'Purranque',44);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (317,'Puyehue',44);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (318,'Río Negro',44);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (319,'San Juan de la Costa',44);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (320,'San Pablo',44);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (321,'Chaitén',45);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (322,'Futaleufú',45);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (323,'Hualaihué',45);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (324,'Palena',45);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (325,'Aisén',46);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (326,'Cisnes',46);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (327,'Guaitecas',46);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (328,'Cochrane',47);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (329,'Ohiggins',47);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (330,'Tortel',47);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (331,'Coihaique',48);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (332,'Lago Verde',48);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (333,'Chile Chico',49);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (334,'Río Ibáñez',49);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (335,'Antártica',50);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (336,'Cabo de Hornos',50);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (337,'Laguna Blanca',51);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (338,'Punta Arenas',51);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (339,'Río Verde',51);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (340,'San Gregorio',51);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (341,'Porvenir',52);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (342,'Primavera',52);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (343,'Timaukel',52);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (344,'Natales',53);
INSERT INTO "comunas" ("id_comuna","comuna_nombre","id_provincia") VALUES (345,'Torres del Paine',53);

INSERT INTO "estado_reservas" ("id_reserva_estado", "nombre") VALUES (1, 'Reservada');
INSERT INTO "estado_reservas" ("id_reserva_estado", "nombre") VALUES (2, 'Pagada');
INSERT INTO "estado_reservas" ("id_reserva_estado", "nombre") VALUES (3, 'Cancelada');

INSERT INTO "roles" ("id_rol", "nombre", "descripcion") VALUES (1, 'Admin', 'Super administrador');
INSERT INTO "roles" ("id_rol", "nombre", "descripcion") VALUES (2, 'Recepcionista', 'Puede realizar reservas y modificarlas.');
INSERT INTO "roles" ("id_rol", "nombre", "descripcion") VALUES (3, 'Cliente', 'Pasajero del hotel');
INSERT INTO "roles" ("id_rol", "nombre", "descripcion") VALUES (4, 'Inspector', 'Inspecciones sanitarias y de habitacion');

Insert into "servicios" ("id_servicio","nombre","precio") values ('1','Gimnasio','75000');
Insert into "servicios" ("id_servicio","nombre","precio") values ('2','Piscina','35000');
Insert into "servicios" ("id_servicio","nombre","precio") values ('3','Spa','20000');
Insert into "servicios" ("id_servicio","nombre","precio") values ('4','Cancha de Tenis','60000');

Insert into "tipo_caracteristicas" ("id_tipo_caract","nombre","descripcion") values ('5','Individual','para una persona');
Insert into "tipo_caracteristicas" ("id_tipo_caract","nombre","descripcion") values ('6','Grupal','4 o más');
Insert into "tipo_caracteristicas" ("id_tipo_caract","nombre","descripcion") values ('7','Duos','2 personas');
Insert into "tipo_caracteristicas" ("id_tipo_caract","nombre","descripcion") values ('8','Parejas','2 personas');

Insert into "tipo_menu" ("id_tipo_menu","nombre") values ('1','Desayuno');
Insert into "tipo_menu" ("id_tipo_menu","nombre") values ('2','Almuerzo');
Insert into "tipo_menu" ("id_tipo_menu","nombre") values ('3','Once');
Insert into "tipo_menu" ("id_tipo_menu","nombre") values ('4','Cena');

Insert into "tipo_reportes" ("id_tipo_reporte","nombre","descripcion") values ('1','Sanitario Hotel','sanidad del hotel');
Insert into "tipo_reportes" ("id_tipo_reporte","nombre","descripcion") values ('2','Sanitario piezas','Sanidad de las piezas');
Insert into "tipo_reportes" ("id_tipo_reporte","nombre","descripcion") values ('3','Sanitario baño','sanidad de los baños');
Insert into "tipo_reportes" ("id_tipo_reporte","nombre","descripcion") values ('4','Daños','daños por los clientes');



Insert into "pasajeros" ("id_pasajero","rut","nombre","contrasena","apellido_pa","apellido_ma","telefono","email","id_region","id_provincia","id_comuna","direccion","fecha_nac","id_rol") values ('1','182745782','Zacarias','asd','Medina','Garcia','12345678','z.medina@duoc.cl',null,null,null,'miKasa',to_date('02/11/92','DD/MM/RR'),'1');
Insert into "pasajeros" ("id_pasajero","rut","nombre","contrasena","apellido_pa","apellido_ma","telefono","email","id_region","id_provincia","id_comuna","direccion","fecha_nac","id_rol") values ('2','17254388K','Carlos','asd','de la Guarda','Gonzalez','1231231','carlos@asd.com',null,null,null,'sucasa 123',to_date('01/01/88','DD/MM/RR'),'1');
Insert into "pasajeros" ("id_pasajero","rut","nombre","contrasena","apellido_pa","apellido_ma","telefono","email","id_region","id_provincia","id_comuna","direccion","fecha_nac","id_rol") values ('3','123455679','Daniel','d.media','Medina','Osorio','1231235','d.medina@asd.cl',null,null,null,'asd 123',to_date('01/01/90','DD/MM/RR'),'1');
Insert into "pasajeros" ("id_pasajero","rut","nombre","contrasena","apellido_pa","apellido_ma","telefono","email","id_region","id_provincia","id_comuna","direccion","fecha_nac","id_rol") values ('4','123455578','Carlos','c.vasquez','Vasquez','Munoz','1321234','c.vasquez@asd.cl',null,null,null,'asd 123',to_date('01/01/90','DD/MM/RR'),'1');
Insert into "pasajeros" ("id_pasajero","rut","nombre","contrasena","apellido_pa","apellido_ma","telefono","email","id_region","id_provincia","id_comuna","direccion","fecha_nac","id_rol") values ('5','109998881','Victor','v.vasquez','Vasquez','Munoz','1123123','v.vasquez@asd.cl',null,null,null,'asdasd 123',to_date('01/01/80','DD/MM/RR'),'3');

Insert into "cadenas" ("id_cadena","nombre") values ('1','Veranum');

Insert into "hoteles" ("id_hotel","id_cadena","id_region","id_provincia","id_comuna","nombre","direccion") values ('1','1','7','25','118','VHSantiago','Santa María 1742');
Insert into "hoteles" ("id_hotel","id_cadena","id_region","id_provincia","id_comuna","nombre","direccion") values ('2','1','6','20','81','VHViña del Mar','Armada de Chile 15');
Insert into "hoteles" ("id_hotel","id_cadena","id_region","id_provincia","id_comuna","nombre","direccion") values ('3','1','5','12','35','VHCoquimbo','Avda. Penuelas Norte 56');
Insert into "hoteles" ("id_hotel","id_cadena","id_region","id_provincia","id_comuna","nombre","direccion") values ('4','1','11','38','265','VHPucon','Clemente Holzapfel 190');
Insert into "hoteles" ("id_hotel","id_cadena","id_region","id_provincia","id_comuna","nombre","direccion") values ('5','1','1','1','1','VHArica','Ingeniero Raul Pey Casado 3105');
Insert into "hoteles" ("id_hotel","id_cadena","id_region","id_provincia","id_comuna","nombre","direccion") values ('6','1','15','51','338','VHPunta Arenas','Avenida Cristobal Colon 716');


Insert into "insumos" ("id_insumo","nombre","descripcion") values ('1','Arroz','carbohidrato');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('2','spaghetti','carbohidrato');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('3','Sal','asd');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('4','Azucar','Endulzante');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('5','Stevia','asds');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('6','Cuchara','asd');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('7','Cuchillo','cortar');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('8','Tenedor','asdsd');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('9','Chuchara Té','para el té :v');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('10','Vaso vidrio','rrr');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('11','vaso plastico','vlfkdngvfj');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('12','Copa de vino','un manjar');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('13','Espumante','para usar la copa xdg');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('14','tomate','asd');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('15','espinaca','gg');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('16','acelga','ggg');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('17','cebolla','gg');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('18','cebollin','ggg');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('19','zanahoria','gwerw');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('20','Aceite','ggs');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('21','ajo','f');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('22','pimenton','gbfd');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('23','brocoli','gfd');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('24','lomo liso','gfd');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('25','lomo vetado','gfd');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('26','huachalomo','sdfdfw');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('27','reineta','gsdfj');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('28','jurel','sdffg');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('29','lechuga','legfdsg');
Insert into "insumos" ("id_insumo","nombre","descripcion") values ('30','congrio','sdf');

Insert into "medidas" ("id_medida","medida") values ('1','Kilogramos');
Insert into "medidas" ("id_medida","medida") values ('2','Gramos');
Insert into "medidas" ("id_medida","medida") values ('3','Litros');
Insert into "medidas" ("id_medida","medida") values ('4','Centimetors Cubicos');
Insert into "medidas" ("id_medida","medida") values ('5','Miligramos');



Insert into "menu" ("id_menu","id_tipo_menu","nombre", "precio") values ('1','1','Desayuno Sano', 6990);
Insert into "menu" ("id_menu","id_tipo_menu","nombre", "precio") values ('2','2','Almuerzo Uno', 8990);
Insert into "menu" ("id_menu","id_tipo_menu","nombre", "precio") values ('3','3','Once Uno', 4590);
Insert into "menu" ("id_menu","id_tipo_menu","nombre", "precio") values ('4','4','Cena uno', 3990);


Insert into "caracteristicas" ("id_caracteristica","id_tipo_caract","cantidad","tipo") values ('4','8','100','Cama matrimonio');
Insert into "caracteristicas" ("id_caracteristica","id_tipo_caract","cantidad","tipo") values ('5','5','100','Silla');
Insert into "caracteristicas" ("id_caracteristica","id_tipo_caract","cantidad","tipo") values ('3','5','100','Cama Individual');
Insert into "caracteristicas" ("id_caracteristica","id_tipo_caract","cantidad","tipo") values ('6','6','100','Mesa');
Insert into "caracteristicas" ("id_caracteristica","id_tipo_caract","cantidad","tipo") values ('7','5','50','Escritorios');


Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('1','4');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('1','5');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('1','7');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('2','4');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('2','5');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('2','3');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('2','6');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('2','7');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('3','4');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('3','5');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('3','3');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('3','6');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('3','7');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('4','4');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('4','5');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('4','3');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('4','6');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('4','7');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('5','4');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('5','5');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('5','3');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('5','6');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('5','7');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('6','4');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('6','5');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('6','3');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('6','6');
Insert into "hoteles_caracteristicas" ("id_hotel","id_caracteristica") values ('6','7');


Insert into "habitacion_estados" ("id_habitacion_estado","estado") values ('1','Disponible');
Insert into "habitacion_estados" ("id_habitacion_estado","estado") values ('2','Reservada');
Insert into "habitacion_estados" ("id_habitacion_estado","estado") values ('3','Ocupada');

Insert into "habitacion_tipos" ("id_habitacion_tipo","nombre") values ('1','VIP');
Insert into "habitacion_tipos" ("id_habitacion_tipo","nombre") values ('2','Business');
Insert into "habitacion_tipos" ("id_habitacion_tipo","nombre") values ('3','Basica');


Insert into "habitaciones" ("id_habitacion","id_hotel","id_habitacion_tipo","id_habitacion_estado","ubicacion","cant_personas","precio") values ('1','1','1','1','10','2','200000');
Insert into "habitaciones" ("id_habitacion","id_hotel","id_habitacion_tipo","id_habitacion_estado","ubicacion","cant_personas","precio") values ('2','1','2','1','6','2','150000');
Insert into "habitaciones" ("id_habitacion","id_hotel","id_habitacion_tipo","id_habitacion_estado","ubicacion","cant_personas","precio") values ('3','1','2','1','1','5','60000');
Insert into "habitaciones" ("id_habitacion","id_hotel","id_habitacion_tipo","id_habitacion_estado","ubicacion","cant_personas","precio") values ('4','1','2','1','1','3','45000');
Insert into "habitaciones" ("id_habitacion","id_hotel","id_habitacion_tipo","id_habitacion_estado","ubicacion","cant_personas","precio") values ('5','2','1','1','10','2','220000');
Insert into "habitaciones" ("id_habitacion","id_hotel","id_habitacion_tipo","id_habitacion_estado","ubicacion","cant_personas","precio") values ('6','2','2','1','6','2','155000');
Insert into "habitaciones" ("id_habitacion","id_hotel","id_habitacion_tipo","id_habitacion_estado","ubicacion","cant_personas","precio") values ('7','2','3','1','1','5','55000');
Insert into "habitaciones" ("id_habitacion","id_hotel","id_habitacion_tipo","id_habitacion_estado","ubicacion","cant_personas","precio") values ('8','3','1','1','10','2','200000');



Insert into "habitaciones_caracteristicas" ("id_habitacion","id_caracteristica") values ('1','4');
Insert into "habitaciones_caracteristicas" ("id_habitacion","id_caracteristica") values ('1','7');
Insert into "habitaciones_caracteristicas" ("id_habitacion","id_caracteristica") values ('1','6');
Insert into "habitaciones_caracteristicas" ("id_habitacion","id_caracteristica") values ('2','3');
Insert into "habitaciones_caracteristicas" ("id_habitacion","id_caracteristica") values ('2','6');
Insert into "habitaciones_caracteristicas" ("id_habitacion","id_caracteristica") values ('3','3');



Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('1','1');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('1','2');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('1','3');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('1','4');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('2','1');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('2','2');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('2','3');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('2','4');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('3','1');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('3','2');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('3','3');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('3','4');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('4','1');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('4','2');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('4','3');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('4','4');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('5','1');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('5','2');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('5','3');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('5','4');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('6','1');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('6','2');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('6','3');
Insert into "hoteles_servicios" ("id_hotel","id_servicio") values ('6','4');


Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('1','1');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('1','2');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('1','3');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('1','4');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('2','1');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('2','2');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('2','3');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('2','4');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('3','1');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('3','2');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('3','3');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('3','4');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('4','1');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('4','2');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('4','3');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('4','4');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('5','1');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('5','2');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('5','3');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('5','4');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('6','1');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('6','2');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('6','3');
Insert into "hotel_tipo_menu" ("id_hotel","id_menu") values ('6','4');

/
CREATE  SEQUENCE roles_seq START WITH 5 INCREMENT BY 1;
/
create or replace trigger trg_roles
    before insert on "roles"
    for each row
  begin
    select roles_seq.nextval
      into :NEW."id_rol"
      from dual;
  end;
/
CREATE  SEQUENCE cadenas_seq START WITH 2 INCREMENT BY 1;
/
create or replace trigger trg_cadenas
    before insert on "cadenas"
    for each row
  begin
    select cadenas_seq.nextval
      into :NEW."id_cadena"
      from dual;
  end;
/
CREATE  SEQUENCE caracteristicas_seq START WITH 8 INCREMENT BY 1;
/
create or replace trigger trg_caracteristicas
    before insert on "caracteristicas"
    for each row
  begin
    select caracteristicas_seq.nextval
      into :NEW."id_caracteristica"
      from dual;
  end;
/
CREATE  SEQUENCE comunas_seq START WITH 346 INCREMENT BY 1;
/
create or replace trigger trg_comunas
    before insert on "comunas"
    for each row
  begin
    select comunas_seq.nextval
      into :NEW."id_comuna"
      from dual;
  end;
/
CREATE  SEQUENCE convenios_seq;
/
create or replace trigger trg_convenios
    before insert on "convenios"
    for each row
  begin
    select convenios_seq.nextval
      into :NEW."id_convenio"
      from dual;
  end;
/
CREATE  SEQUENCE empresas_seq;
/
create or replace trigger trg_empresas
    before insert on "empresas"
    for each row
  begin
    select empresas_seq.nextval
      into :NEW."id_empresa"
      from dual;
  end;
/
CREATE  SEQUENCE estado_reservas_seq  START WITH 4 INCREMENT BY 1; 
/
create or replace trigger trg_estado_reservas
    before insert on "estado_reservas"
    for each row
  begin
    select estado_reservas_seq.nextval
      into :NEW."id_reserva_estado"
      from dual;
  end;
  /
  CREATE  SEQUENCE habitacion_estados_seq START WITH 4 INCREMENT BY 1;
  /
  create or replace trigger trg_habitacion_estados
      before insert on "habitacion_estados"
      for each row
    begin
      select habitacion_estados_seq.nextval
        into :NEW."id_habitacion_estado"
        from dual;
    end;
    /
    CREATE  SEQUENCE habitacion_inspecciones_seq;
    /
    create or replace trigger trg_habitacion_inspecciones
        before insert on "habitacion_inspecciones"
        for each row
      begin
        select habitacion_inspecciones_seq.nextval
          into :NEW."id_habitacion_inspeccion"
          from dual;
      end;
/
CREATE  SEQUENCE habitacion_tipos_seq START WITH 4 INCREMENT BY 1;
/
create or replace trigger trg_habitacion_tipos
    before insert on "habitacion_tipos"
    for each row
  begin
    select habitacion_tipos_seq.nextval
      into :NEW."id_habitacion_tipo"
      from dual;
  end;
/
CREATE  SEQUENCE habitaciones_seq START WITH 9 INCREMENT BY 1;
/
create or replace trigger trg_habitaciones
    before insert on "habitaciones"
    for each row
  begin
    select habitaciones_seq.nextval
      into :NEW."id_habitacion"
      from dual;
  end;
/
CREATE  SEQUENCE historial_precios_seq;
/
create or replace trigger trg_historial_precios
    before insert on "historial_precios"
    for each row
  begin
    select historial_precios_seq.nextval
      into :NEW."id_historial_precio"
      from dual;
  end;
/
CREATE  SEQUENCE hoteles_seq START WITH 7 INCREMENT BY 1;
/
create or replace trigger trg_hoteles
    before insert on "hoteles"
    for each row
  begin
    select hoteles_seq.nextval
      into :NEW."id_hotel"
      from dual;
  end;
/
CREATE  SEQUENCE insumos_seq START WITH 31 INCREMENT BY 1;
/
create or replace trigger trg_insumos
    before insert on "insumos"
    for each row
  begin
    select insumos_seq.nextval
      into :NEW."id_insumo"
      from dual;
  end;
/
CREATE  SEQUENCE medidas_seq START WITH 7 INCREMENT BY 1;
/
create or replace trigger trg_medidas
    before insert on "medidas"
    for each row
  begin
    select medidas_seq.nextval
      into :NEW."id_medida"
      from dual;
  end;
/
CREATE  SEQUENCE menu_seq START WITH 5 INCREMENT BY 1;
/
create or replace trigger trg_menu
    before insert on "menu"
    for each row
  begin
    select menu_seq.nextval
      into :NEW."id_menu"
      from dual;
  end;
/
CREATE  SEQUENCE pasajeros_seq START WITH 6 INCREMENT BY 1;
/
create or replace trigger trg_pasajeros
    before insert on "pasajeros"
    for each row
  begin
    select pasajeros_seq.nextval
      into :NEW."id_pasajero"
      from dual;
  end;
/
CREATE  SEQUENCE provincias_seq START WITH 54 INCREMENT BY 1;
/
create or replace trigger trg_provincias
    before insert on "provincias"
    for each row
  begin
    select provincias_seq.nextval
      into :NEW."id_provincia"
      from dual;
  end;
/
CREATE  SEQUENCE regiones_seq START WITH 16 INCREMENT BY 1;
/
create or replace trigger trg_regiones
    before insert on "regiones"
    for each row
  begin
    select regiones_seq.nextval
      into :NEW."id_region"
      from dual;
  end;
/
CREATE  SEQUENCE reportes_seq;
/
create or replace trigger trg_reportes
    before insert on "reportes"
    for each row
  begin
    select reportes_seq.nextval
      into :NEW."id_reporte"
      from dual;
  end;
/
CREATE  SEQUENCE reservas_seq;
/
create or replace trigger trg_reservas
    before insert on "reservas"
    for each row
  begin
    select reservas_seq.nextval
      into :NEW."id_reserva"
      from dual;
  end;
/
CREATE  SEQUENCE servicios_seq START WITH 5 INCREMENT BY 1;
/
create or replace trigger trg_servicios
    before insert on "servicios"
    for each row
  begin
    select servicios_seq.nextval
      into :NEW."id_servicio"
      from dual;
  end;
/
CREATE  SEQUENCE tipo_caracteristicas_seq START WITH 9 INCREMENT BY 1;
/
create or replace trigger trg_tipo_caracteristicas
    before insert on "tipo_caracteristicas"
    for each row
  begin
    select tipo_caracteristicas_seq.nextval
      into :NEW."id_tipo_caract"
      from dual;
  end;
/
CREATE  SEQUENCE tipo_menu_seq START WITH 5 INCREMENT BY 1;
/
create or replace trigger trg_tipo_menu
    before insert on "tipo_menu"
    for each row
  begin
    select tipo_menu_seq.nextval
      into :NEW."id_tipo_menu"
      from dual;
  end;
/
CREATE  SEQUENCE tipo_reportes_seq START WITH 5 INCREMENT BY 1;
/
create or replace trigger trg_tipo_reportes
    before insert on "tipo_reportes"
    for each row
  begin
    select tipo_reportes_seq.nextval
      into :NEW."id_tipo_reporte"
      from dual;
  end;
/
CREATE  SEQUENCE hotel_insumos_seq;
/
create or replace trigger trg_hotel_insumos
    before insert on "hotel_insumos"
    for each row
  begin
    select hotel_insumos_seq.nextval
      into :NEW."id_insumo_hotel"
      from dual;
  end;
/

CREATE  SEQUENCE menu_insumos_seq;
/
create or replace trigger trg_menu_insumos
    before insert on "menu_insumos"
    for each row
  begin
    select menu_insumos_seq.nextval
      into :NEW."id_menu_insumo"
      from dual;
  end;
/



