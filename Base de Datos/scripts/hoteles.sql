CREATE OR REPLACE PACKAGE hoteles_tapi
IS
type hoteles_tapi_rec
IS
  record
  (
    direccion hoteles.direccion%type ,
    id_cadena hoteles.id_cadena%type ,
    id hoteles.id%type ,
    nombre hoteles.nombre%type );
type hoteles_tapi_tab
IS
  TABLE OF hoteles_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_direccion IN hoteles.direccion%type ,
      p_id_cadena IN hoteles.id_cadena%type ,
      p_id        IN hoteles.id%type ,
      p_nombre    IN hoteles.nombre%type );
  -- update
  PROCEDURE upd(
      p_direccion IN hoteles.direccion%type ,
      p_id_cadena IN hoteles.id_cadena%type ,
      p_id        IN hoteles.id%type ,
      p_nombre    IN hoteles.nombre%type );
  -- delete
  PROCEDURE del(
      p_id IN hoteles.id%type );
END hoteles_tapi;
/
CREATE OR REPLACE PACKAGE body hoteles_tapi
IS
  -- insert
  PROCEDURE ins(
      p_direccion IN hoteles.direccion%type ,
      p_id_cadena IN hoteles.id_cadena%type ,
      p_id        IN hoteles.id%type ,
      p_nombre    IN hoteles.nombre%type )
  IS
  BEGIN
    INSERT
    INTO hoteles
      (
        direccion ,
        id_cadena ,
        id ,
        nombre
      )
      VALUES
      (
        p_direccion ,
        p_id_cadena ,
        p_id ,
        p_nombre
      );
  END;
-- update
  PROCEDURE upd
    (
      p_direccion IN hoteles.direccion%type ,
      p_id_cadena IN hoteles.id_cadena%type ,
      p_id        IN hoteles.id%type ,
      p_nombre    IN hoteles.nombre%type
    )
  IS
  BEGIN
    UPDATE hoteles
    SET direccion = p_direccion ,
      id_cadena   = p_id_cadena ,
      nombre      = p_nombre
    WHERE id      = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN hoteles.id%type )
  IS
  BEGIN
    DELETE FROM hoteles WHERE id = p_id;
  END;
END hoteles_tapi;