CREATE OR REPLACE PACKAGE caracteristicas_tapi
IS
type caracteristicas_tapi_rec
IS
  record
  (
    tipo caracteristicas.tipo%type ,
    id caracteristicas.id%type ,
    id_tipo caracteristicas.id_tipo%type ,
    cantidad caracteristicas.cantidad%type );
type caracteristicas_tapi_tab
IS
  TABLE OF caracteristicas_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_tipo     IN caracteristicas.tipo%type ,
      p_id       IN caracteristicas.id%type ,
      p_id_tipo  IN caracteristicas.id_tipo%type ,
      p_cantidad IN caracteristicas.cantidad%type );
  -- update
  PROCEDURE upd(
      p_tipo     IN caracteristicas.tipo%type ,
      p_id       IN caracteristicas.id%type ,
      p_id_tipo  IN caracteristicas.id_tipo%type ,
      p_cantidad IN caracteristicas.cantidad%type );
  -- delete
  PROCEDURE del(
      p_id IN caracteristicas.id%type );
END caracteristicas_tapi;
/
CREATE OR REPLACE PACKAGE body caracteristicas_tapi
IS
  -- insert
  PROCEDURE ins(
      p_tipo     IN caracteristicas.tipo%type ,
      p_id       IN caracteristicas.id%type ,
      p_id_tipo  IN caracteristicas.id_tipo%type ,
      p_cantidad IN caracteristicas.cantidad%type )
  IS
  BEGIN
    INSERT
    INTO caracteristicas
      (
        tipo ,
        id ,
        id_tipo ,
        cantidad
      )
      VALUES
      (
        p_tipo ,
        p_id ,
        p_id_tipo ,
        p_cantidad
      );
  END;
-- update
  PROCEDURE upd
    (
      p_tipo     IN caracteristicas.tipo%type ,
      p_id       IN caracteristicas.id%type ,
      p_id_tipo  IN caracteristicas.id_tipo%type ,
      p_cantidad IN caracteristicas.cantidad%type
    )
  IS
  BEGIN
    UPDATE caracteristicas
    SET tipo   = p_tipo ,
      id_tipo  = p_id_tipo ,
      cantidad = p_cantidad
    WHERE id   = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN caracteristicas.id%type )
  IS
  BEGIN
    DELETE FROM caracteristicas WHERE id = p_id;
  END;
END caracteristicas_tapi;