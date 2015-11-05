CREATE OR REPLACE PACKAGE cadenas_tapi
IS
type cadenas_tapi_rec
IS
  record
  (
    id cadenas.id%type ,
    nombre cadenas.nombre%type );
type cadenas_tapi_tab
IS
  TABLE OF cadenas_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id     IN cadenas.id%type ,
      p_nombre IN cadenas.nombre%type );
  -- update
  PROCEDURE upd(
      p_id     IN cadenas.id%type ,
      p_nombre IN cadenas.nombre%type );
  -- delete
  PROCEDURE del(
      p_id IN cadenas.id%type );
END cadenas_tapi;
/
CREATE OR REPLACE PACKAGE body cadenas_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id     IN cadenas.id%type ,
      p_nombre IN cadenas.nombre%type )
  IS
  BEGIN
    INSERT INTO cadenas
      ( id ,nombre
      ) VALUES
      ( p_id ,p_nombre
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id     IN cadenas.id%type ,
      p_nombre IN cadenas.nombre%type
    )
  IS
  BEGIN
    UPDATE cadenas SET nombre = p_nombre WHERE id = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN cadenas.id%type )
  IS
  BEGIN
    DELETE FROM cadenas WHERE id = p_id;
  END;
END cadenas_tapi;