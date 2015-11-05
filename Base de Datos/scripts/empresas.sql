CREATE OR REPLACE PACKAGE empresas_tapi
IS
type empresas_tapi_rec
IS
  record
  (
    id empresas.id%type ,
    nombre empresas.nombre%type );
type empresas_tapi_tab
IS
  TABLE OF empresas_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id     IN empresas.id%type ,
      p_nombre IN empresas.nombre%type );
  -- update
  PROCEDURE upd(
      p_id     IN empresas.id%type ,
      p_nombre IN empresas.nombre%type );
  -- delete
  PROCEDURE del(
      p_id IN empresas.id%type );
END empresas_tapi;
/
CREATE OR REPLACE PACKAGE body empresas_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id     IN empresas.id%type ,
      p_nombre IN empresas.nombre%type )
  IS
  BEGIN
    INSERT INTO empresas
      ( id ,nombre
      ) VALUES
      ( p_id ,p_nombre
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id     IN empresas.id%type ,
      p_nombre IN empresas.nombre%type
    )
  IS
  BEGIN
    UPDATE empresas SET nombre = p_nombre WHERE id = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN empresas.id%type )
  IS
  BEGIN
    DELETE FROM empresas WHERE id = p_id;
  END;
END empresas_tapi;