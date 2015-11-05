CREATE OR REPLACE PACKAGE tipo_menu_tapi
IS
type tipo_menu_tapi_rec
IS
  record
  (
    id tipo_menu.id%type ,
    nombre tipo_menu.nombre%type );
type tipo_menu_tapi_tab
IS
  TABLE OF tipo_menu_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id     IN tipo_menu.id%type ,
      p_nombre IN tipo_menu.nombre%type );
  -- update
  PROCEDURE upd(
      p_id     IN tipo_menu.id%type ,
      p_nombre IN tipo_menu.nombre%type );
  -- delete
  PROCEDURE del(
      p_id IN tipo_menu.id%type );
END tipo_menu_tapi;
/
CREATE OR REPLACE PACKAGE body tipo_menu_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id     IN tipo_menu.id%type ,
      p_nombre IN tipo_menu.nombre%type )
  IS
  BEGIN
    INSERT INTO tipo_menu
      ( id ,nombre
      ) VALUES
      ( p_id ,p_nombre
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id     IN tipo_menu.id%type ,
      p_nombre IN tipo_menu.nombre%type
    )
  IS
  BEGIN
    UPDATE tipo_menu SET nombre = p_nombre WHERE id = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN tipo_menu.id%type )
  IS
  BEGIN
    DELETE FROM tipo_menu WHERE id = p_id;
  END;
END tipo_menu_tapi;