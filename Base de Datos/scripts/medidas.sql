CREATE OR REPLACE PACKAGE medidas_tapi
IS
type medidas_tapi_rec
IS
  record
  (
    medida medidas.medida%type ,
    id medidas.id%type );
type medidas_tapi_tab
IS
  TABLE OF medidas_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_medida IN medidas.medida%type ,
      p_id     IN medidas.id%type );
  -- update
  PROCEDURE upd(
      p_medida IN medidas.medida%type ,
      p_id     IN medidas.id%type );
  -- delete
  PROCEDURE del(
      p_id IN medidas.id%type );
END medidas_tapi;
/
CREATE OR REPLACE PACKAGE body medidas_tapi
IS
  -- insert
  PROCEDURE ins(
      p_medida IN medidas.medida%type ,
      p_id     IN medidas.id%type )
  IS
  BEGIN
    INSERT INTO medidas
      ( medida ,id
      ) VALUES
      ( p_medida ,p_id
      );
  END;
-- update
  PROCEDURE upd
    (
      p_medida IN medidas.medida%type ,
      p_id     IN medidas.id%type
    )
  IS
  BEGIN
    UPDATE medidas SET medida = p_medida WHERE id = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN medidas.id%type )
  IS
  BEGIN
    DELETE FROM medidas WHERE id = p_id;
  END;
END medidas_tapi;