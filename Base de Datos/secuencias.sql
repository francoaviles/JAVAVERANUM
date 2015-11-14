CREATE  SEQUENCE roles_seq;
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
CREATE  SEQUENCE cadenas_seq;
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
CREATE  SEQUENCE caracteristicas_seq;
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
/
CREATE  SEQUENCE estado_reservas_seq;
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
  CREATE  SEQUENCE habitacion_estados_seq;
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
CREATE  SEQUENCE habitacion_tipos_seq;
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
CREATE  SEQUENCE habitaciones_seq;
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
CREATE  SEQUENCE hoteles_seq;
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
CREATE  SEQUENCE insumos_seq;
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
CREATE  SEQUENCE medidas_seq;
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
CREATE  SEQUENCE menu_seq;
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
CREATE  SEQUENCE pasajeros_seq;
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
CREATE  SEQUENCE servicios_seq;
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
CREATE  SEQUENCE tipo_caracteristicas_seq;
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
CREATE  SEQUENCE tipo_menu_seq;
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
CREATE  SEQUENCE tipo_reportes_seq;
/
create or replace trigger trg_tipo_reportes
    before insert on "tipo_reportes"
    for each row
  begin
    select tipo_reportes_seq.nextval
      into :NEW."id_tipo_reporte"
      from dual;
  end;