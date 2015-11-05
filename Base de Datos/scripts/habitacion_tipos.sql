CREATE OR REPLACE PACKAGE habitacion_tipos_tapi
IS
type habitacion_tipos_tapi_rec
IS
  record
  (
    id habitacion_tipos.id%type ,
    nombre habitacion_tipos.nombre%type );
type habitacion_tipos_tapi_tab
IS
  TABLE OF habitacion_tipos_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id     IN habitacion_tipos.id%type ,
      p_nombre IN habitacion_tipos.nombre%type );
  -- update
  PROCEDURE upd(
      p_id     IN habitacion_tipos.id%type ,
      p_nombre IN habitacion_tipos.nombre%type );
  -- delete
  PROCEDURE del(
      p_id IN habitacion_tipos.id%type );
END habitacion_tipos_tapi;
/
CREATE OR REPLACE PACKAGE body habitacion_tipos_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id     IN habitacion_tipos.id%type ,
      p_nombre IN habitacion_tipos.nombre%type )
  IS
  BEGIN
    INSERT INTO habitacion_tipos
      ( id ,nombre
      ) VALUES
      ( p_id ,p_nombre
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id     IN habitacion_tipos.id%type ,
      p_nombre IN habitacion_tipos.nombre%type
    )
  IS
  BEGIN
    UPDATE habitacion_tipos SET nombre = p_nombre WHERE id = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN habitacion_tipos.id%type )
  IS
  BEGIN
    DELETE FROM habitacion_tipos WHERE id = p_id;
  END;
END habitacion_tipos_tapi;