CREATE OR REPLACE PACKAGE menu_tapi
IS
type menu_tapi_rec
IS
  record
  (
    id_tipo_menu menu.id_tipo_menu%type ,
    id menu.id%type ,
    nombre menu.nombre%type );
type menu_tapi_tab
IS
  TABLE OF menu_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id_tipo_menu IN menu.id_tipo_menu%type ,
      p_id           IN menu.id%type ,
      p_nombre       IN menu.nombre%type );
  -- update
  PROCEDURE upd(
      p_id_tipo_menu IN menu.id_tipo_menu%type ,
      p_id           IN menu.id%type ,
      p_nombre       IN menu.nombre%type );
  -- delete
  PROCEDURE del(
      p_id IN menu.id%type );
END menu_tapi;
/
CREATE OR REPLACE PACKAGE body menu_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id_tipo_menu IN menu.id_tipo_menu%type ,
      p_id           IN menu.id%type ,
      p_nombre       IN menu.nombre%type )
  IS
  BEGIN
    INSERT
    INTO menu
      (
        id_tipo_menu ,
        id ,
        nombre
      )
      VALUES
      (
        p_id_tipo_menu ,
        p_id ,
        p_nombre
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id_tipo_menu IN menu.id_tipo_menu%type ,
      p_id           IN menu.id%type ,
      p_nombre       IN menu.nombre%type
    )
  IS
  BEGIN
    UPDATE menu
    SET id_tipo_menu = p_id_tipo_menu ,
      nombre         = p_nombre
    WHERE id         = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN menu.id%type )
  IS
  BEGIN
    DELETE FROM menu WHERE id = p_id;
  END;
END menu_tapi;