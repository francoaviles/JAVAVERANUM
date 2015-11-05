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
	FOREIGN KEY ("id_tipo_menu") 
		REFERENCES "tipo_menu" ("id_tipo_menu");
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