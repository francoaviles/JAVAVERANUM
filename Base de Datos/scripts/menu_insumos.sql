CREATE OR REPLACE PACKAGE menu_insumos_tapi
IS
type menu_insumos_tapi_rec
IS
  record
  (
    id_menu menu_insumos.id_menu%type ,
    id_insumo menu_insumos.id_insumo%type ,
    id menu_insumos.id%type ,
    id_medida menu_insumos.id_medida%type ,
    cantidad menu_insumos.cantidad%type );
type menu_insumos_tapi_tab
IS
  TABLE OF menu_insumos_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id_menu   IN menu_insumos.id_menu%type ,
      p_id_insumo IN menu_insumos.id_insumo%type ,
      p_id        IN menu_insumos.id%type ,
      p_id_medida IN menu_insumos.id_medida%type ,
      p_cantidad  IN menu_insumos.cantidad%type );
  -- update
  PROCEDURE upd(
      p_id_menu   IN menu_insumos.id_menu%type ,
      p_id_insumo IN menu_insumos.id_insumo%type ,
      p_id        IN menu_insumos.id%type ,
      p_id_medida IN menu_insumos.id_medida%type ,
      p_cantidad  IN menu_insumos.cantidad%type );
  -- delete
  PROCEDURE del(
      p_id IN menu_insumos.id%type );
END menu_insumos_tapi;
/
CREATE OR REPLACE PACKAGE body menu_insumos_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id_menu   IN menu_insumos.id_menu%type ,
      p_id_insumo IN menu_insumos.id_insumo%type ,
      p_id        IN menu_insumos.id%type ,
      p_id_medida IN menu_insumos.id_medida%type ,
      p_cantidad  IN menu_insumos.cantidad%type )
  IS
  BEGIN
    INSERT
    INTO menu_insumos
      (
        id_menu ,
        id_insumo ,
        id ,
        id_medida ,
        cantidad
      )
      VALUES
      (
        p_id_menu ,
        p_id_insumo ,
        p_id ,
        p_id_medida ,
        p_cantidad
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id_menu   IN menu_insumos.id_menu%type ,
      p_id_insumo IN menu_insumos.id_insumo%type ,
      p_id        IN menu_insumos.id%type ,
      p_id_medida IN menu_insumos.id_medida%type ,
      p_cantidad  IN menu_insumos.cantidad%type
    )
  IS
  BEGIN
    UPDATE menu_insumos
    SET id_menu = p_id_menu ,
      id_insumo = p_id_insumo ,
      id_medida = p_id_medida ,
      cantidad  = p_cantidad
    WHERE id    = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN menu_insumos.id%type )
  IS
  BEGIN
    DELETE FROM menu_insumos WHERE id = p_id;
  END;
END menu_insumos_tapi;