CREATE OR REPLACE PACKAGE tipo_reportes_tapi
IS
type tipo_reportes_tapi_rec
IS
  record
  (
    descripcion tipo_reportes.descripcion%type ,
    id tipo_reportes.id%type ,
    nombre tipo_reportes.nombre%type );
type tipo_reportes_tapi_tab
IS
  TABLE OF tipo_reportes_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_descripcion IN tipo_reportes.descripcion%type ,
      p_id          IN tipo_reportes.id%type ,
      p_nombre      IN tipo_reportes.nombre%type );
  -- update
  PROCEDURE upd(
      p_descripcion IN tipo_reportes.descripcion%type ,
      p_id          IN tipo_reportes.id%type ,
      p_nombre      IN tipo_reportes.nombre%type );
  -- delete
  PROCEDURE del(
      p_id IN tipo_reportes.id%type );
END tipo_reportes_tapi;
/
CREATE OR REPLACE PACKAGE body tipo_reportes_tapi
IS
  -- insert
  PROCEDURE ins(
      p_descripcion IN tipo_reportes.descripcion%type ,
      p_id          IN tipo_reportes.id%type ,
      p_nombre      IN tipo_reportes.nombre%type )
  IS
  BEGIN
    INSERT
    INTO tipo_reportes
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
      p_descripcion IN tipo_reportes.descripcion%type ,
      p_id          IN tipo_reportes.id%type ,
      p_nombre      IN tipo_reportes.nombre%type
    )
  IS
  BEGIN
    UPDATE tipo_reportes
    SET descripcion = p_descripcion ,
      nombre        = p_nombre
    WHERE id        = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN tipo_reportes.id%type )
  IS
  BEGIN
    DELETE FROM tipo_reportes WHERE id = p_id;
  END;
END tipo_reportes_tapi;