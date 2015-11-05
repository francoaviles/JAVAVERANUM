CREATE OR REPLACE PACKAGE habitaciones_reservas_tapi
IS
type habitaciones_reservas_tapi_rec
IS
  record
  (
    id_reserva habitaciones_reservas.id_reserva%type ,
    id_habitacion habitaciones_reservas.id_habitacion%type );
type habitaciones_reservas_tapi_tab
IS
  TABLE OF habitaciones_reservas_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id_reserva    IN habitaciones_reservas.id_reserva%type ,
      p_id_habitacion IN habitaciones_reservas.id_habitacion%type );
  -- update
  PROCEDURE upd(
      p_id_reserva    IN habitaciones_reservas.id_reserva%type ,
      p_id_habitacion IN habitaciones_reservas.id_habitacion%type );
  -- delete
  PROCEDURE del(
      p_id_habitacion IN habitaciones_reservas.id_habitacion%type ,
      p_id_reserva    IN habitaciones_reservas.id_reserva%type );
END habitaciones_reservas_tapi;
/
CREATE OR REPLACE PACKAGE body habitaciones_reservas_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id_reserva    IN habitaciones_reservas.id_reserva%type ,
      p_id_habitacion IN habitaciones_reservas.id_habitacion%type )
  IS
  BEGIN
    INSERT
    INTO habitaciones_reservas
      (
        id_reserva ,
        id_habitacion
      )
      VALUES
      (
        p_id_reserva ,
        p_id_habitacion
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id_reserva    IN habitaciones_reservas.id_reserva%type ,
      p_id_habitacion IN habitaciones_reservas.id_habitacion%type
    )
  IS
  BEGIN
    UPDATE habitaciones_reservas
    SET
    WHERE id_habitacion = p_id_habitacion
    AND id_reserva      = p_id_reserva;
  END;
-- del
  PROCEDURE del(
      p_id_habitacion IN habitaciones_reservas.id_habitacion%type ,
      p_id_reserva    IN habitaciones_reservas.id_reserva%type )
  IS
  BEGIN
    DELETE
    FROM habitaciones_reservas
    WHERE id_habitacion = p_id_habitacion
    AND id_reserva      = p_id_reserva;
  END;
END habitaciones_reservas_tapi;