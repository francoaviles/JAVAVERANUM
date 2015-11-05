CREATE OR REPLACE PACKAGE servicios_tapi
IS
type servicios_tapi_rec
IS
  record
  (
    precio servicios.precio%type ,
    id servicios.id%type ,
    nombre servicios.nombre%type );
type servicios_tapi_tab
IS
  TABLE OF servicios_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_precio IN servicios.precio%type ,
      p_id     IN servicios.id%type ,
      p_nombre IN servicios.nombre%type );
  -- update
  PROCEDURE upd(
      p_precio IN servicios.precio%type ,
      p_id     IN servicios.id%type ,
      p_nombre IN servicios.nombre%type );
  -- delete
  PROCEDURE del(
      p_id IN servicios.id%type );
END servicios_tapi;
/
CREATE OR REPLACE PACKAGE body servicios_tapi
IS
  -- insert
  PROCEDURE ins(
      p_precio IN servicios.precio%type ,
      p_id     IN servicios.id%type ,
      p_nombre IN servicios.nombre%type )
  IS
  BEGIN
    INSERT
    INTO servicios
      (
        precio ,
        id ,
        nombre
      )
      VALUES
      (
        p_precio ,
        p_id ,
        p_nombre
      );
  END;
-- update
  PROCEDURE upd
    (
      p_precio IN servicios.precio%type ,
      p_id     IN servicios.id%type ,
      p_nombre IN servicios.nombre%type
    )
  IS
  BEGIN
    UPDATE servicios SET precio = p_precio ,nombre = p_nombre WHERE id = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN servicios.id%type )
  IS
  BEGIN
    DELETE FROM servicios WHERE id = p_id;
  END;
END servicios_tapi;