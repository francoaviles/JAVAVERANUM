CREATE OR REPLACE PACKAGE hoteles_servicios_tapi
IS
type hoteles_servicios_tapi_rec
IS
  record
  (
    id_hotel hoteles_servicios.id_hotel%type ,
    id_servicio hoteles_servicios.id_servicio%type );
type hoteles_servicios_tapi_tab
IS
  TABLE OF hoteles_servicios_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id_hotel    IN hoteles_servicios.id_hotel%type ,
      p_id_servicio IN hoteles_servicios.id_servicio%type );
  -- update
  PROCEDURE upd(
      p_id_hotel    IN hoteles_servicios.id_hotel%type ,
      p_id_servicio IN hoteles_servicios.id_servicio%type );
  -- delete
  PROCEDURE del(
      p_id_hotel    IN hoteles_servicios.id_hotel%type ,
      p_id_servicio IN hoteles_servicios.id_servicio%type );
END hoteles_servicios_tapi;
/
CREATE OR REPLACE PACKAGE body hoteles_servicios_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id_hotel    IN hoteles_servicios.id_hotel%type ,
      p_id_servicio IN hoteles_servicios.id_servicio%type )
  IS
  BEGIN
    INSERT
    INTO hoteles_servicios
      (
        id_hotel ,
        id_servicio
      )
      VALUES
      (
        p_id_hotel ,
        p_id_servicio
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id_hotel    IN hoteles_servicios.id_hotel%type ,
      p_id_servicio IN hoteles_servicios.id_servicio%type
    )
  IS
  BEGIN
    UPDATE hoteles_servicios
    SET
    WHERE id_hotel  = p_id_hotel
    AND id_servicio = p_id_servicio;
  END;
-- del
  PROCEDURE del(
      p_id_hotel    IN hoteles_servicios.id_hotel%type ,
      p_id_servicio IN hoteles_servicios.id_servicio%type )
  IS
  BEGIN
    DELETE
    FROM hoteles_servicios
    WHERE id_hotel  = p_id_hotel
    AND id_servicio = p_id_servicio;
  END;
END hoteles_servicios_tapi;