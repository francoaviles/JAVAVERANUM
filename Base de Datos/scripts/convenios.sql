CREATE OR REPLACE PACKAGE convenios_tapi
IS
type convenios_tapi_rec
IS
  record
  (
    estado convenios.estado%type ,
    fecha_inicio convenios.fecha_inicio%type ,
    fecha_fin convenios.fecha_fin%type ,
    id_empresa convenios.id_empresa%type ,
    id convenios.id%type );
type convenios_tapi_tab
IS
  TABLE OF convenios_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_estado       IN convenios.estado%type ,
      p_fecha_inicio IN convenios.fecha_inicio%type DEFAULT NULL ,
      p_fecha_fin    IN convenios.fecha_fin%type DEFAULT NULL ,
      p_id_empresa   IN convenios.id_empresa%type ,
      p_id           IN convenios.id%type );
  -- update
  PROCEDURE upd(
      p_estado       IN convenios.estado%type ,
      p_fecha_inicio IN convenios.fecha_inicio%type DEFAULT NULL ,
      p_fecha_fin    IN convenios.fecha_fin%type DEFAULT NULL ,
      p_id_empresa   IN convenios.id_empresa%type ,
      p_id           IN convenios.id%type );
  -- delete
  PROCEDURE del(
      p_id IN convenios.id%type );
END convenios_tapi;
/
CREATE OR REPLACE PACKAGE body convenios_tapi
IS
  -- insert
  PROCEDURE ins(
      p_estado       IN convenios.estado%type ,
      p_fecha_inicio IN convenios.fecha_inicio%type DEFAULT NULL ,
      p_fecha_fin    IN convenios.fecha_fin%type DEFAULT NULL ,
      p_id_empresa   IN convenios.id_empresa%type ,
      p_id           IN convenios.id%type )
  IS
  BEGIN
    INSERT
    INTO convenios
      (
        estado ,
        fecha_inicio ,
        fecha_fin ,
        id_empresa ,
        id
      )
      VALUES
      (
        p_estado ,
        p_fecha_inicio ,
        p_fecha_fin ,
        p_id_empresa ,
        p_id
      );
  END;
-- update
  PROCEDURE upd
    (
      p_estado       IN convenios.estado%type ,
      p_fecha_inicio IN convenios.fecha_inicio%type DEFAULT NULL ,
      p_fecha_fin    IN convenios.fecha_fin%type DEFAULT NULL ,
      p_id_empresa   IN convenios.id_empresa%type ,
      p_id           IN convenios.id%type
    )
  IS
  BEGIN
    UPDATE convenios
    SET estado     = p_estado ,
      fecha_inicio = p_fecha_inicio ,
      fecha_fin    = p_fecha_fin ,
      id_empresa   = p_id_empresa
    WHERE id       = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN convenios.id%type )
  IS
  BEGIN
    DELETE FROM convenios WHERE id = p_id;
  END;
END convenios_tapi;