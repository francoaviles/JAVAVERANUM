CREATE OR REPLACE PACKAGE hotel_tipo_menu_tapi
IS
type hotel_tipo_menu_tapi_rec
IS
  record
  (
    id_hotel hotel_tipo_menu.id_hotel%type ,
    id_tipo_menu hotel_tipo_menu.id_tipo_menu%type );
type hotel_tipo_menu_tapi_tab
IS
  TABLE OF hotel_tipo_menu_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id_hotel     IN hotel_tipo_menu.id_hotel%type ,
      p_id_tipo_menu IN hotel_tipo_menu.id_tipo_menu%type );
  -- update
  PROCEDURE upd(
      p_id_hotel     IN hotel_tipo_menu.id_hotel%type ,
      p_id_tipo_menu IN hotel_tipo_menu.id_tipo_menu%type );
  -- delete
  PROCEDURE del(
      p_id_hotel     IN hotel_tipo_menu.id_hotel%type ,
      p_id_tipo_menu IN hotel_tipo_menu.id_tipo_menu%type );
END hotel_tipo_menu_tapi;
/
CREATE OR REPLACE PACKAGE body hotel_tipo_menu_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id_hotel     IN hotel_tipo_menu.id_hotel%type ,
      p_id_tipo_menu IN hotel_tipo_menu.id_tipo_menu%type )
  IS
  BEGIN
    INSERT
    INTO hotel_tipo_menu
      (
        id_hotel ,
        id_tipo_menu
      )
      VALUES
      (
        p_id_hotel ,
        p_id_tipo_menu
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id_hotel     IN hotel_tipo_menu.id_hotel%type ,
      p_id_tipo_menu IN hotel_tipo_menu.id_tipo_menu%type
    )
  IS
  BEGIN
    UPDATE hotel_tipo_menu
    SET
    WHERE id_hotel   = p_id_hotel
    AND id_tipo_menu = p_id_tipo_menu;
  END;
-- del
  PROCEDURE del(
      p_id_hotel     IN hotel_tipo_menu.id_hotel%type ,
      p_id_tipo_menu IN hotel_tipo_menu.id_tipo_menu%type )
  IS
  BEGIN
    DELETE
    FROM hotel_tipo_menu
    WHERE id_hotel   = p_id_hotel
    AND id_tipo_menu = p_id_tipo_menu;
  END;
END hotel_tipo_menu_tapi;