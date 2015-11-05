CREATE OR REPLACE PACKAGE habitacion_estados_tapi
IS
type habitacion_estados_tapi_rec
IS
  record
  (
    estado habitacion_estados.estado%type ,
    id habitacion_estados.id%type );
type habitacion_estados_tapi_tab
IS
  TABLE OF habitacion_estados_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_estado IN habitacion_estados.estado%type ,
      p_id     IN habitacion_estados.id%type );
  -- update
  PROCEDURE upd(
      p_estado IN habitacion_estados.estado%type ,
      p_id     IN habitacion_estados.id%type );
  -- delete
  PROCEDURE del(
      p_id IN habitacion_estados.id%type );
END habitacion_estados_tapi;
/
CREATE OR REPLACE PACKAGE body habitacion_estados_tapi
IS
  -- insert
  PROCEDURE ins(
      p_estado IN habitacion_estados.estado%type ,
      p_id     IN habitacion_estados.id%type )
  IS
  BEGIN
    INSERT INTO habitacion_estados
      ( estado ,id
      ) VALUES
      ( p_estado ,p_id
      );
  END;
-- update
  PROCEDURE upd
    (
      p_estado IN habitacion_estados.estado%type ,
      p_id     IN habitacion_estados.id%type
    )
  IS
  BEGIN
    UPDATE habitacion_estados SET estado = p_estado WHERE id = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN habitacion_estados.id%type )
  IS
  BEGIN
    DELETE FROM habitacion_estados WHERE id = p_id;
  END;
END habitacion_estados_tapi;