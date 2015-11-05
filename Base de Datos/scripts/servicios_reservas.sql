CREATE OR REPLACE PACKAGE servicios_reservas_tapi
IS
type servicios_reservas_tapi_rec
IS
  record
  (
    id_reserva servicios_reservas.id_reserva%type ,
    id_servicio servicios_reservas.id_servicio%type );
type servicios_reservas_tapi_tab
IS
  TABLE OF servicios_reservas_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id_reserva  IN servicios_reservas.id_reserva%type ,
      p_id_servicio IN servicios_reservas.id_servicio%type );
  -- update
  PROCEDURE upd(
      p_id_reserva  IN servicios_reservas.id_reserva%type ,
      p_id_servicio IN servicios_reservas.id_servicio%type );
  -- delete
  PROCEDURE del(
      p_id_servicio IN servicios_reservas.id_servicio%type ,
      p_id_reserva  IN servicios_reservas.id_reserva%type );
END servicios_reservas_tapi;
/
CREATE OR REPLACE PACKAGE body servicios_reservas_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id_reserva  IN servicios_reservas.id_reserva%type ,
      p_id_servicio IN servicios_reservas.id_servicio%type )
  IS
  BEGIN
    INSERT
    INTO servicios_reservas
      (
        id_reserva ,
        id_servicio
      )
      VALUES
      (
        p_id_reserva ,
        p_id_servicio
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id_reserva  IN servicios_reservas.id_reserva%type ,
      p_id_servicio IN servicios_reservas.id_servicio%type
    )
  IS
  BEGIN
    UPDATE servicios_reservas
    SET
    WHERE id_servicio = p_id_servicio
    AND id_reserva    = p_id_reserva;
  END;
-- del
  PROCEDURE del(
      p_id_servicio IN servicios_reservas.id_servicio%type ,
      p_id_reserva  IN servicios_reservas.id_reserva%type )
  IS
  BEGIN
    DELETE
    FROM servicios_reservas
    WHERE id_servicio = p_id_servicio
    AND id_reserva    = p_id_reserva;
  END;
END servicios_reservas_tapi;