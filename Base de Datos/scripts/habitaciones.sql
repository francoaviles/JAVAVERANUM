CREATE OR REPLACE PACKAGE habitaciones_tapi
IS
type habitaciones_tapi_rec
IS
  record
  (
    id_estado habitaciones.id_estado%type ,
    ubicacion habitaciones.ubicacion%type ,
    precio habitaciones.precio%type ,
    id_hotel habitaciones.id_hotel%type ,
    cant_personas habitaciones.cant_personas%type ,
    id habitaciones.id%type ,
    id_tipo habitaciones.id_tipo%type );
type habitaciones_tapi_tab
IS
  TABLE OF habitaciones_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id_estado     IN habitaciones.id_estado%type ,
      p_ubicacion     IN habitaciones.ubicacion%type ,
      p_precio        IN habitaciones.precio%type ,
      p_id_hotel      IN habitaciones.id_hotel%type ,
      p_cant_personas IN habitaciones.cant_personas%type ,
      p_id            IN habitaciones.id%type ,
      p_id_tipo       IN habitaciones.id_tipo%type );
  -- update
  PROCEDURE upd(
      p_id_estado     IN habitaciones.id_estado%type ,
      p_ubicacion     IN habitaciones.ubicacion%type ,
      p_precio        IN habitaciones.precio%type ,
      p_id_hotel      IN habitaciones.id_hotel%type ,
      p_cant_personas IN habitaciones.cant_personas%type ,
      p_id            IN habitaciones.id%type ,
      p_id_tipo       IN habitaciones.id_tipo%type );
  -- delete
  PROCEDURE del(
      p_id IN habitaciones.id%type );
END habitaciones_tapi;
/
CREATE OR REPLACE PACKAGE body habitaciones_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id_estado     IN habitaciones.id_estado%type ,
      p_ubicacion     IN habitaciones.ubicacion%type ,
      p_precio        IN habitaciones.precio%type ,
      p_id_hotel      IN habitaciones.id_hotel%type ,
      p_cant_personas IN habitaciones.cant_personas%type ,
      p_id            IN habitaciones.id%type ,
      p_id_tipo       IN habitaciones.id_tipo%type )
  IS
  BEGIN
    INSERT
    INTO habitaciones
      (
        id_estado ,
        ubicacion ,
        precio ,
        id_hotel ,
        cant_personas ,
        id ,
        id_tipo
      )
      VALUES
      (
        p_id_estado ,
        p_ubicacion ,
        p_precio ,
        p_id_hotel ,
        p_cant_personas ,
        p_id ,
        p_id_tipo
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id_estado     IN habitaciones.id_estado%type ,
      p_ubicacion     IN habitaciones.ubicacion%type ,
      p_precio        IN habitaciones.precio%type ,
      p_id_hotel      IN habitaciones.id_hotel%type ,
      p_cant_personas IN habitaciones.cant_personas%type ,
      p_id            IN habitaciones.id%type ,
      p_id_tipo       IN habitaciones.id_tipo%type
    )
  IS
  BEGIN
    UPDATE habitaciones
    SET id_estado   = p_id_estado ,
      ubicacion     = p_ubicacion ,
      precio        = p_precio ,
      id_hotel      = p_id_hotel ,
      cant_personas = p_cant_personas ,
      id_tipo       = p_id_tipo
    WHERE id        = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN habitaciones.id%type )
  IS
  BEGIN
    DELETE FROM habitaciones WHERE id = p_id;
  END;
END habitaciones_tapi;