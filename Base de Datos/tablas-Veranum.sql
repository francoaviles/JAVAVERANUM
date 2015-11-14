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
	"rut" Varchar2(12) NOT NULL,
	"nombre" Varchar2(15) NOT NULL,
	"contrasena" Varchar2(255) NOT NULL,
	"apellido_pa" Varchar2(20) NOT NULL,
	"apellido_ma" Varchar2(20) NOT NULL,
	"telefono" Varchar2(15) NOT NULL,
	"email" Varchar2(20) NOT NULL,
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
	"id_tipo_menu" Number NOT NULL
);
/
-- Keys
ALTER TABLE "hotel_tipo_menu" 
	ADD CONSTRAINT "hote_tipo_menuPrimary"
	PRIMARY KEY ("id_hotel", "id_tipo_menu");
/

-- -----------------------------------------------
-- menu
CREATE TABLE "menu" (
	"id_menu" NUMBER NOT NULL,
	"id_tipo_menu" Number NOT NULL,
	"nombre" Varchar2(100) NOT NULL
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
