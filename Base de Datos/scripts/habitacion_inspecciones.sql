CREATE OR REPLACE PACKAGE habitacion_inspecciones_tapi
IS
type habitacion_inspecciones_tapi_rec
IS
  record
  (
    fecha_inicio habitacion_inspecciones.fecha_inicio%type ,
    id habitacion_inspecciones.id%type ,
    id_habitacion habitacion_inspecciones.id_habitacion%type ,
    comentario habitacion_inspecciones.comentario%type );
type habitacion_inspecciones_tapi_tab
IS
  TABLE OF habitacion_inspecciones_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_fecha_inicio  IN habitacion_inspecciones.fecha_inicio%type DEFAULT NULL ,
      p_id            IN habitacion_inspecciones.id%type ,
      p_id_habitacion IN habitacion_inspecciones.id_habitacion%type ,
      p_comentario    IN habitacion_inspecciones.comentario%type );
  -- update
  PROCEDURE upd(
      p_fecha_inicio  IN habitacion_inspecciones.fecha_inicio%type DEFAULT NULL ,
      p_id            IN habitacion_inspecciones.id%type ,
      p_id_habitacion IN habitacion_inspecciones.id_habitacion%type ,
      p_comentario    IN habitacion_inspecciones.comentario%type );
  -- delete
  PROCEDURE del(
      p_id IN habitacion_inspecciones.id%type );
END habitacion_inspecciones_tapi;
/
CREATE OR REPLACE PACKAGE body habitacion_inspecciones_tapi
IS
  -- insert
  PROCEDURE ins(
      p_fecha_inicio  IN habitacion_inspecciones.fecha_inicio%type DEFAULT NULL ,
      p_id            IN habitacion_inspecciones.id%type ,
      p_id_habitacion IN habitacion_inspecciones.id_habitacion%type ,
      p_comentario    IN habitacion_inspecciones.comentario%type )
  IS
  BEGIN
    INSERT
    INTO habitacion_inspecciones
      (
        fecha_inicio ,
        id ,
        id_habitacion ,
        comentario
      )
      VALUES
      (
        p_fecha_inicio ,
        p_id ,
        p_id_habitacion ,
        p_comentario
      );
  END;
-- update
  PROCEDURE upd
    (
      p_fecha_inicio  IN habitacion_inspecciones.fecha_inicio%type DEFAULT NULL ,
      p_id            IN habitacion_inspecciones.id%type ,
      p_id_habitacion IN habitacion_inspecciones.id_habitacion%type ,
      p_comentario    IN habitacion_inspecciones.comentario%type
    )
  IS
  BEGIN
    UPDATE habitacion_inspecciones
    SET fecha_inicio = p_fecha_inicio ,
      id_habitacion  = p_id_habitacion ,
      comentario     = p_comentario
    WHERE id         = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN habitacion_inspecciones.id%type )
  IS
  BEGIN
    DELETE FROM habitacion_inspecciones WHERE id = p_id;
  END;
END habitacion_inspecciones_tapi;