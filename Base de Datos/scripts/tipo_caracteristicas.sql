CREATE OR REPLACE PACKAGE tipo_caracteristicas_tapi
IS
type tipo_caracteristicas_tapi_rec
IS
  record
  (
    descripcion tipo_caracteristicas.descripcion%type ,
    id tipo_caracteristicas.id%type ,
    nombre tipo_caracteristicas.nombre%type );
type tipo_caracteristicas_tapi_tab
IS
  TABLE OF tipo_caracteristicas_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_descripcion IN tipo_caracteristicas.descripcion%type ,
      p_id          IN tipo_caracteristicas.id%type ,
      p_nombre      IN tipo_caracteristicas.nombre%type );
  -- update
  PROCEDURE upd(
      p_descripcion IN tipo_caracteristicas.descripcion%type ,
      p_id          IN tipo_caracteristicas.id%type ,
      p_nombre      IN tipo_caracteristicas.nombre%type );
  -- delete
  PROCEDURE del(
      p_id IN tipo_caracteristicas.id%type );
END tipo_caracteristicas_tapi;
/
CREATE OR REPLACE PACKAGE body tipo_caracteristicas_tapi
IS
  -- insert
  PROCEDURE ins(
      p_descripcion IN tipo_caracteristicas.descripcion%type ,
      p_id          IN tipo_caracteristicas.id%type ,
      p_nombre      IN tipo_caracteristicas.nombre%type )
  IS
  BEGIN
    INSERT
    INTO tipo_caracteristicas
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
      p_descripcion IN tipo_caracteristicas.descripcion%type ,
      p_id          IN tipo_caracteristicas.id%type ,
      p_nombre      IN tipo_caracteristicas.nombre%type
    )
  IS
  BEGIN
    UPDATE tipo_caracteristicas
    SET descripcion = p_descripcion ,
      nombre        = p_nombre
    WHERE id        = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN tipo_caracteristicas.id%type )
  IS
  BEGIN
    DELETE FROM tipo_caracteristicas WHERE id = p_id;
  END;
END tipo_caracteristicas_tapi;