CREATE OR REPLACE PACKAGE hoteles_convenios_tapi
IS
type hoteles_convenios_tapi_rec
IS
  record
  (
    id_hotel hoteles_convenios.id_hotel%type ,
    id_convenio hoteles_convenios.id_convenio%type );
type hoteles_convenios_tapi_tab
IS
  TABLE OF hoteles_convenios_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id_hotel    IN hoteles_convenios.id_hotel%type ,
      p_id_convenio IN hoteles_convenios.id_convenio%type );
  -- update
  PROCEDURE upd(
      p_id_hotel    IN hoteles_convenios.id_hotel%type ,
      p_id_convenio IN hoteles_convenios.id_convenio%type );
  -- delete
  PROCEDURE del(
      p_id_hotel    IN hoteles_convenios.id_hotel%type ,
      p_id_convenio IN hoteles_convenios.id_convenio%type );
END hoteles_convenios_tapi;
/
CREATE OR REPLACE PACKAGE body hoteles_convenios_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id_hotel    IN hoteles_convenios.id_hotel%type ,
      p_id_convenio IN hoteles_convenios.id_convenio%type )
  IS
  BEGIN
    INSERT
    INTO hoteles_convenios
      (
        id_hotel ,
        id_convenio
      )
      VALUES
      (
        p_id_hotel ,
        p_id_convenio
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id_hotel    IN hoteles_convenios.id_hotel%type ,
      p_id_convenio IN hoteles_convenios.id_convenio%type
    )
  IS
  BEGIN
    UPDATE hoteles_convenios
    SET
    WHERE id_hotel  = p_id_hotel
    AND id_convenio = p_id_convenio;
  END;
-- del
  PROCEDURE del(
      p_id_hotel    IN hoteles_convenios.id_hotel%type ,
      p_id_convenio IN hoteles_convenios.id_convenio%type )
  IS
  BEGIN
    DELETE
    FROM hoteles_convenios
    WHERE id_hotel  = p_id_hotel
    AND id_convenio = p_id_convenio;
  END;
END hoteles_convenios_tapi;