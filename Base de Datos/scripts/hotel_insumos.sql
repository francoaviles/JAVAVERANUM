CREATE OR REPLACE PACKAGE hotel_insumos_tapi
IS
type hotel_insumos_tapi_rec
IS
  record
  (
    id_hotel hotel_insumos.id_hotel%type ,
    id_insumo hotel_insumos.id_insumo%type ,
    id hotel_insumos.id%type ,
    id_medida hotel_insumos.id_medida%type ,
    stock hotel_insumos.stock%type );
type hotel_insumos_tapi_tab
IS
  TABLE OF hotel_insumos_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id_hotel  IN hotel_insumos.id_hotel%type ,
      p_id_insumo IN hotel_insumos.id_insumo%type ,
      p_id        IN hotel_insumos.id%type ,
      p_id_medida IN hotel_insumos.id_medida%type ,
      p_stock     IN hotel_insumos.stock%type );
  -- update
  PROCEDURE upd(
      p_id_hotel  IN hotel_insumos.id_hotel%type ,
      p_id_insumo IN hotel_insumos.id_insumo%type ,
      p_id        IN hotel_insumos.id%type ,
      p_id_medida IN hotel_insumos.id_medida%type ,
      p_stock     IN hotel_insumos.stock%type );
  -- delete
  PROCEDURE del(
      p_id IN hotel_insumos.id%type );
END hotel_insumos_tapi;
/
CREATE OR REPLACE PACKAGE body hotel_insumos_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id_hotel  IN hotel_insumos.id_hotel%type ,
      p_id_insumo IN hotel_insumos.id_insumo%type ,
      p_id        IN hotel_insumos.id%type ,
      p_id_medida IN hotel_insumos.id_medida%type ,
      p_stock     IN hotel_insumos.stock%type )
  IS
  BEGIN
    INSERT
    INTO hotel_insumos
      (
        id_hotel ,
        id_insumo ,
        id ,
        id_medida ,
        stock
      )
      VALUES
      (
        p_id_hotel ,
        p_id_insumo ,
        p_id ,
        p_id_medida ,
        p_stock
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id_hotel  IN hotel_insumos.id_hotel%type ,
      p_id_insumo IN hotel_insumos.id_insumo%type ,
      p_id        IN hotel_insumos.id%type ,
      p_id_medida IN hotel_insumos.id_medida%type ,
      p_stock     IN hotel_insumos.stock%type
    )
  IS
  BEGIN
    UPDATE hotel_insumos
    SET id_hotel = p_id_hotel ,
      id_insumo  = p_id_insumo ,
      id_medida  = p_id_medida ,
      stock      = p_stock
    WHERE id     = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN hotel_insumos.id%type )
  IS
  BEGIN
    DELETE FROM hotel_insumos WHERE id = p_id;
  END;
END hotel_insumos_tapi;