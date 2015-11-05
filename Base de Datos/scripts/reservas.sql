CREATE OR REPLACE PACKAGE reservas_tapi
IS
type reservas_tapi_rec
IS
  record
  (
    id_estado reservas.id_estado%type ,
    id_pasajero reservas.id_pasajero%type ,
    fecha_salida reservas.fecha_salida%type ,
    precio_total reservas.precio_total%type ,
    id reservas.id%type ,
    fecha_ingreso reservas.fecha_ingreso%type );
type reservas_tapi_tab
IS
  TABLE OF reservas_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id_estado     IN reservas.id_estado%type ,
      p_id_pasajero   IN reservas.id_pasajero%type ,
      p_fecha_salida  IN reservas.fecha_salida%type ,
      p_precio_total  IN reservas.precio_total%type ,
      p_id            IN reservas.id%type ,
      p_fecha_ingreso IN reservas.fecha_ingreso%type );
  -- update
  PROCEDURE upd(
      p_id_estado     IN reservas.id_estado%type ,
      p_id_pasajero   IN reservas.id_pasajero%type ,
      p_fecha_salida  IN reservas.fecha_salida%type ,
      p_precio_total  IN reservas.precio_total%type ,
      p_id            IN reservas.id%type ,
      p_fecha_ingreso IN reservas.fecha_ingreso%type );
  -- delete
  PROCEDURE del(
      p_id IN reservas.id%type );
END reservas_tapi;
/
CREATE OR REPLACE PACKAGE body reservas_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id_estado     IN reservas.id_estado%type ,
      p_id_pasajero   IN reservas.id_pasajero%type ,
      p_fecha_salida  IN reservas.fecha_salida%type ,
      p_precio_total  IN reservas.precio_total%type ,
      p_id            IN reservas.id%type ,
      p_fecha_ingreso IN reservas.fecha_ingreso%type )
  IS
  BEGIN
    INSERT
    INTO reservas
      (
        id_estado ,
        id_pasajero ,
        fecha_salida ,
        precio_total ,
        id ,
        fecha_ingreso
      )
      VALUES
      (
        p_id_estado ,
        p_id_pasajero ,
        p_fecha_salida ,
        p_precio_total ,
        p_id ,
        p_fecha_ingreso
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id_estado     IN reservas.id_estado%type ,
      p_id_pasajero   IN reservas.id_pasajero%type ,
      p_fecha_salida  IN reservas.fecha_salida%type ,
      p_precio_total  IN reservas.precio_total%type ,
      p_id            IN reservas.id%type ,
      p_fecha_ingreso IN reservas.fecha_ingreso%type
    )
  IS
  BEGIN
    UPDATE reservas
    SET id_estado   = p_id_estado ,
      id_pasajero   = p_id_pasajero ,
      fecha_salida  = p_fecha_salida ,
      precio_total  = p_precio_total ,
      fecha_ingreso = p_fecha_ingreso
    WHERE id        = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN reservas.id%type )
  IS
  BEGIN
    DELETE FROM reservas WHERE id = p_id;
  END;
END reservas_tapi;