CREATE OR REPLACE PACKAGE reportes_tapi
IS
type reportes_tapi_rec
IS
  record
  (
    id_tipo_reporte reportes.id_tipo_reporte%type ,
    archivo reportes.archivo%type ,
    id reportes.id%type ,
    fecha_creacion reportes.fecha_creacion%type ,
    comentario reportes.comentario%type );
type reportes_tapi_tab
IS
  TABLE OF reportes_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_id_tipo_reporte IN reportes.id_tipo_reporte%type ,
      p_archivo         IN reportes.archivo%type ,
      p_id              IN reportes.id%type ,
      p_fecha_creacion  IN reportes.fecha_creacion%type ,
      p_comentario      IN reportes.comentario%type );
  -- update
  PROCEDURE upd(
      p_id_tipo_reporte IN reportes.id_tipo_reporte%type ,
      p_archivo         IN reportes.archivo%type ,
      p_id              IN reportes.id%type ,
      p_fecha_creacion  IN reportes.fecha_creacion%type ,
      p_comentario      IN reportes.comentario%type );
  -- delete
  PROCEDURE del(
      p_id IN reportes.id%type );
END reportes_tapi;
/
CREATE OR REPLACE PACKAGE body reportes_tapi
IS
  -- insert
  PROCEDURE ins(
      p_id_tipo_reporte IN reportes.id_tipo_reporte%type ,
      p_archivo         IN reportes.archivo%type ,
      p_id              IN reportes.id%type ,
      p_fecha_creacion  IN reportes.fecha_creacion%type ,
      p_comentario      IN reportes.comentario%type )
  IS
  BEGIN
    INSERT
    INTO reportes
      (
        id_tipo_reporte ,
        archivo ,
        id ,
        fecha_creacion ,
        comentario
      )
      VALUES
      (
        p_id_tipo_reporte ,
        p_archivo ,
        p_id ,
        p_fecha_creacion ,
        p_comentario
      );
  END;
-- update
  PROCEDURE upd
    (
      p_id_tipo_reporte IN reportes.id_tipo_reporte%type ,
      p_archivo         IN reportes.archivo%type ,
      p_id              IN reportes.id%type ,
      p_fecha_creacion  IN reportes.fecha_creacion%type ,
      p_comentario      IN reportes.comentario%type
    )
  IS
  BEGIN
    UPDATE reportes
    SET id_tipo_reporte = p_id_tipo_reporte ,
      archivo           = p_archivo ,
      fecha_creacion    = p_fecha_creacion ,
      comentario        = p_comentario
    WHERE id            = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN reportes.id%type )
  IS
  BEGIN
    DELETE FROM reportes WHERE id = p_id;
  END;
END reportes_tapi;