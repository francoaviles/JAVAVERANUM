CREATE OR REPLACE PACKAGE estado_reservas_tapi
IS
type estado_reservas_tapi_rec
IS
  record
  (
    id estado_reservas.id%type ,
    nombre estado_reservas.nombre%type );
type estado_reservas_tapi_tab
IS
  TABLE OF estado_reservas_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id     IN estado_reservas.id%type ,
      p_nombre IN estado_reservas.nombre%type );
  -- update
  PROCEDURE upd(
      p_id     IN estado_reservas.id%type ,
      p_nombre IN estado_reservas.nombre%type );
  -- delete
  PROCEDURE del(
      p_id IN estado_reservas.id%type );
END estado_reservas_tapi;
/
CREATE OR REPLACE PACKAGE body estado_reservas_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id     IN estado_reservas.id%type ,
      p_nombre IN estado_reservas.nombre%type )
  IS
  BEGIN
    INSERT INTO estado_reservas
      ( id ,nombre
      ) VALUES
      ( p_id ,p_nombre
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id     IN estado_reservas.id%type ,
      p_nombre IN estado_reservas.nombre%type
    )
  IS
  BEGIN
    UPDATE estado_reservas SET nombre = p_nombre WHERE id = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN estado_reservas.id%type )
  IS
  BEGIN
    DELETE FROM estado_reservas WHERE id = p_id;
  END;
END estado_reservas_tapi;