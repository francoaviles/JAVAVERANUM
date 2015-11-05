CREATE OR REPLACE PACKAGE hoteles_caracteristicas_tapi
IS
type hoteles_caracteristicas_tapi_rec
IS
  record
  (
    id_caracteristica hoteles_caracteristicas.id_caracteristica%type ,
    id_hotel hoteles_caracteristicas.id_hotel%type );
type hoteles_caracteristicas_tapi_tab
IS
  TABLE OF hoteles_caracteristicas_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id_caracteristica IN hoteles_caracteristicas.id_caracteristica%type ,
      p_id_hotel          IN hoteles_caracteristicas.id_hotel%type );
  -- update
  PROCEDURE upd(
      p_id_caracteristica IN hoteles_caracteristicas.id_caracteristica%type ,
      p_id_hotel          IN hoteles_caracteristicas.id_hotel%type );
  -- delete
  PROCEDURE del(
      p_id_hotel          IN hoteles_caracteristicas.id_hotel%type ,
      p_id_caracteristica IN hoteles_caracteristicas.id_caracteristica%type );
END hoteles_caracteristicas_tapi;
/
CREATE OR REPLACE PACKAGE body hoteles_caracteristicas_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id_caracteristica IN hoteles_caracteristicas.id_caracteristica%type ,
      p_id_hotel          IN hoteles_caracteristicas.id_hotel%type )
  IS
  BEGIN
    INSERT
    INTO hoteles_caracteristicas
      (
        id_caracteristica ,
        id_hotel
      )
      VALUES
      (
        p_id_caracteristica ,
        p_id_hotel
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id_caracteristica IN hoteles_caracteristicas.id_caracteristica%type ,
      p_id_hotel          IN hoteles_caracteristicas.id_hotel%type
    )
  IS
  BEGIN
    UPDATE hoteles_caracteristicas
    SET
    WHERE id_hotel        = p_id_hotel
    AND id_caracteristica = p_id_caracteristica;
  END;
-- del
  PROCEDURE del(
      p_id_hotel          IN hoteles_caracteristicas.id_hotel%type ,
      p_id_caracteristica IN hoteles_caracteristicas.id_caracteristica%type )
  IS
  BEGIN
    DELETE
    FROM hoteles_caracteristicas
    WHERE id_hotel        = p_id_hotel
    AND id_caracteristica = p_id_caracteristica;
  END;
END hoteles_caracteristicas_tapi;