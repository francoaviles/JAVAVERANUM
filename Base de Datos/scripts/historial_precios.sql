CREATE OR REPLACE PACKAGE historial_precios_tapi
IS
type historial_precios_tapi_rec
IS
  record
  (
    fecha historial_precios.fecha%type ,
    precio historial_precios.precio%type ,
    id historial_precios.id%type ,
    id_habitacion historial_precios.id_habitacion%type );
type historial_precios_tapi_tab
IS
  TABLE OF historial_precios_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_fecha         IN historial_precios.fecha%type DEFAULT NULL ,
      p_precio        IN historial_precios.precio%type ,
      p_id            IN historial_precios.id%type ,
      p_id_habitacion IN historial_precios.id_habitacion%type );
  -- update
  PROCEDURE upd(
      p_fecha         IN historial_precios.fecha%type DEFAULT NULL ,
      p_precio        IN historial_precios.precio%type ,
      p_id            IN historial_precios.id%type ,
      p_id_habitacion IN historial_precios.id_habitacion%type );
  -- delete
  PROCEDURE del(
      p_id IN historial_precios.id%type );
END historial_precios_tapi;
/
CREATE OR REPLACE PACKAGE body historial_precios_tapi
IS
  -- insert
  PROCEDURE ins(
      p_fecha         IN historial_precios.fecha%type DEFAULT NULL ,
      p_precio        IN historial_precios.precio%type ,
      p_id            IN historial_precios.id%type ,
      p_id_habitacion IN historial_precios.id_habitacion%type )
  IS
  BEGIN
    INSERT
    INTO historial_precios
      (
        fecha ,
        precio ,
        id ,
        id_habitacion
      )
      VALUES
      (
        p_fecha ,
        p_precio ,
        p_id ,
        p_id_habitacion
      );
  END;
-- update
  PROCEDURE upd
    (
      p_fecha         IN historial_precios.fecha%type DEFAULT NULL ,
      p_precio        IN historial_precios.precio%type ,
      p_id            IN historial_precios.id%type ,
      p_id_habitacion IN historial_precios.id_habitacion%type
    )
  IS
  BEGIN
    UPDATE historial_precios
    SET fecha       = p_fecha ,
      precio        = p_precio ,
      id_habitacion = p_id_habitacion
    WHERE id        = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN historial_precios.id%type )
  IS
  BEGIN
    DELETE FROM historial_precios WHERE id = p_id;
  END;
END historial_precios_tapi;