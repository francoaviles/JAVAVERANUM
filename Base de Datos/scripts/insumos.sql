CREATE OR REPLACE PACKAGE insumos_tapi
IS
type insumos_tapi_rec
IS
  record
  (
    descripcion insumos.descripcion%type ,
    id insumos.id%type ,
    nombre insumos.nombre%type );
type insumos_tapi_tab
IS
  TABLE OF insumos_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_descripcion IN insumos.descripcion%type ,
      p_id          IN insumos.id%type ,
      p_nombre      IN insumos.nombre%type );
  -- update
  PROCEDURE upd(
      p_descripcion IN insumos.descripcion%type ,
      p_id          IN insumos.id%type ,
      p_nombre      IN insumos.nombre%type );
  -- delete
  PROCEDURE del(
      p_id IN insumos.id%type );
END insumos_tapi;
/
CREATE OR REPLACE PACKAGE body insumos_tapi
IS
  -- insert
  PROCEDURE ins(
      p_descripcion IN insumos.descripcion%type ,
      p_id          IN insumos.id%type ,
      p_nombre      IN insumos.nombre%type )
  IS
  BEGIN
    INSERT
    INTO insumos
      (
        descripcion ,
        id ,
        nombre
      )
      VALUES
      (
        p_descripcion ,
        p_id ,
        p_nombre
      );
  END;
-- update
  PROCEDURE upd
    (
      p_descripcion IN insumos.descripcion%type ,
      p_id          IN insumos.id%type ,
      p_nombre      IN insumos.nombre%type
    )
  IS
  BEGIN
    UPDATE insumos
    SET descripcion = p_descripcion ,
      nombre        = p_nombre
    WHERE id        = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN insumos.id%type )
  IS
  BEGIN
    DELETE FROM insumos WHERE id = p_id;
  END;
END insumos_tapi;