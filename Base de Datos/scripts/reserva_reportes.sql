CREATE OR REPLACE PACKAGE reserva_reportes_tapi
IS
type reserva_reportes_tapi_rec
IS
  record
  (
    fecha_reporte reserva_reportes.fecha_reporte%type ,
    tipo reserva_reportes.tipo%type ,
    valor reserva_reportes.valor%type ,
    id_reserva reserva_reportes.id_reserva%type ,
    id reserva_reportes.id%type ,
    comentario reserva_reportes.comentario%type );
type reserva_reportes_tapi_tab
IS
  TABLE OF reserva_reportes_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_fecha_reporte IN reserva_reportes.fecha_reporte%type DEFAULT NULL ,
      p_tipo          IN reserva_reportes.tipo%type ,
      p_valor         IN reserva_reportes.valor%type ,
      p_id_reserva    IN reserva_reportes.id_reserva%type ,
      p_id            IN reserva_reportes.id%type ,
      p_comentario    IN reserva_reportes.comentario%type );
  -- update
  PROCEDURE upd(
      p_fecha_reporte IN reserva_reportes.fecha_reporte%type DEFAULT NULL ,
      p_tipo          IN reserva_reportes.tipo%type ,
      p_valor         IN reserva_reportes.valor%type ,
      p_id_reserva    IN reserva_reportes.id_reserva%type ,
      p_id            IN reserva_reportes.id%type ,
      p_comentario    IN reserva_reportes.comentario%type );
  -- delete
  PROCEDURE del(
      p_id IN reserva_reportes.id%type );
END reserva_reportes_tapi;
/
CREATE OR REPLACE PACKAGE body reserva_reportes_tapi
IS
  -- insert
  PROCEDURE ins(
      p_fecha_reporte IN reserva_reportes.fecha_reporte%type DEFAULT NULL ,
      p_tipo          IN reserva_reportes.tipo%type ,
      p_valor         IN reserva_reportes.valor%type ,
      p_id_reserva    IN reserva_reportes.id_reserva%type ,
      p_id            IN reserva_reportes.id%type ,
      p_comentario    IN reserva_reportes.comentario%type )
  IS
  BEGIN
    INSERT
    INTO reserva_reportes
      (
        fecha_reporte ,
        tipo ,
        valor ,
        id_reserva ,
        id ,
        comentario
      )
      VALUES
      (
        p_fecha_reporte ,
        p_tipo ,
        p_valor ,
        p_id_reserva ,
        p_id ,
        p_comentario
      );
  END;
-- update
  PROCEDURE upd
    (
      p_fecha_reporte IN reserva_reportes.fecha_reporte%type DEFAULT NULL ,
      p_tipo          IN reserva_reportes.tipo%type ,
      p_valor         IN reserva_reportes.valor%type ,
      p_id_reserva    IN reserva_reportes.id_reserva%type ,
      p_id            IN reserva_reportes.id%type ,
      p_comentario    IN reserva_reportes.comentario%type
    )
  IS
  BEGIN
    UPDATE reserva_reportes
    SET fecha_reporte = p_fecha_reporte ,
      tipo            = p_tipo ,
      valor           = p_valor ,
      id_reserva      = p_id_reserva ,
      comentario      = p_comentario
    WHERE id          = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN reserva_reportes.id%type )
  IS
  BEGIN
    DELETE FROM reserva_reportes WHERE id = p_id;
  END;
END reserva_reportes_tapi;