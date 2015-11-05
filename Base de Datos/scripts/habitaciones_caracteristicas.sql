CREATE OR REPLACE PACKAGE habitaciones_caracteristicas_tapi
IS
type habitaciones_caracteristicas_tapi_rec
IS
  record
  (
    id_caracteristica habitaciones_caracteristicas.id_caracteristica%type ,
    id_habitacion habitaciones_caracteristicas.id_habitacion%type );
type habitaciones_caracteristicas_tapi_tab
IS
  TABLE OF habitaciones_caracteristicas_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id_caracteristica IN habitaciones_caracteristicas.id_caracteristica%type ,
      p_id_habitacion     IN habitaciones_caracteristicas.id_habitacion%type );
  -- update
  PROCEDURE upd(
      p_id_caracteristica IN habitaciones_caracteristicas.id_caracteristica%type ,
      p_id_habitacion     IN habitaciones_caracteristicas.id_habitacion%type );
  -- delete
  PROCEDURE del(
      p_id_habitacion     IN habitaciones_caracteristicas.id_habitacion%type ,
      p_id_caracteristica IN habitaciones_caracteristicas.id_caracteristica%type );
END habitaciones_caracteristicas_tapi;
/
CREATE OR REPLACE PACKAGE body habitaciones_caracteristicas_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id_caracteristica IN habitaciones_caracteristicas.id_caracteristica%type ,
      p_id_habitacion     IN habitaciones_caracteristicas.id_habitacion%type )
  IS
  BEGIN
    INSERT
    INTO habitaciones_caracteristicas
      (
        id_caracteristica ,
        id_habitacion
      )
      VALUES
      (
        p_id_caracteristica ,
        p_id_habitacion
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id_caracteristica IN habitaciones_caracteristicas.id_caracteristica%type ,
      p_id_habitacion     IN habitaciones_caracteristicas.id_habitacion%type
    )
  IS
  BEGIN
    UPDATE habitaciones_caracteristicas
    SET
    WHERE id_habitacion   = p_id_habitacion
    AND id_caracteristica = p_id_caracteristica;
  END;
-- del
  PROCEDURE del(
      p_id_habitacion     IN habitaciones_caracteristicas.id_habitacion%type ,
      p_id_caracteristica IN habitaciones_caracteristicas.id_caracteristica%type )
  IS
  BEGIN
    DELETE
    FROM habitaciones_caracteristicas
    WHERE id_habitacion   = p_id_habitacion
    AND id_caracteristica = p_id_caracteristica;
  END;
END habitaciones_caracteristicas_tapi;