CREATE OR REPLACE PACKAGE pasajeros_tapi
IS
type pasajeros_tapi_rec
IS
  record
  (
    rut pasajeros.rut%type ,
    fecha_nac pasajeros.fecha_nac%type ,
    apellido_pa pasajeros.apellido_pa%type ,
    direccion pasajeros.direccion%type ,
    id pasajeros.id%type ,
    telefono pasajeros.telefono%type ,
    nombre pasajeros.nombre%type ,
    email pasajeros.email%type ,
    apellido_ma pasajeros.apellido_ma%type );
type pasajeros_tapi_tab
IS
  TABLE OF pasajeros_tapi_rec;
  -- insert
  PROCEDURE ins(
      p_rut         IN pasajeros.rut%type ,
      p_fecha_nac   IN pasajeros.fecha_nac%type DEFAULT NULL ,
      p_apellido_pa IN pasajeros.apellido_pa%type ,
      p_direccion   IN pasajeros.direccion%type ,
      p_id          IN pasajeros.id%type ,
      p_telefono    IN pasajeros.telefono%type ,
      p_nombre      IN pasajeros.nombre%type ,
      p_email       IN pasajeros.email%type ,
      p_apellido_ma IN pasajeros.apellido_ma%type );
  -- update
  PROCEDURE upd(
      p_rut         IN pasajeros.rut%type ,
      p_fecha_nac   IN pasajeros.fecha_nac%type DEFAULT NULL ,
      p_apellido_pa IN pasajeros.apellido_pa%type ,
      p_direccion   IN pasajeros.direccion%type ,
      p_id          IN pasajeros.id%type ,
      p_telefono    IN pasajeros.telefono%type ,
      p_nombre      IN pasajeros.nombre%type ,
      p_email       IN pasajeros.email%type ,
      p_apellido_ma IN pasajeros.apellido_ma%type );
  -- delete
  PROCEDURE del(
      p_id IN pasajeros.id%type );
END pasajeros_tapi;
/
CREATE OR REPLACE PACKAGE body pasajeros_tapi
IS
  -- insert
  PROCEDURE ins(
      p_rut         IN pasajeros.rut%type ,
      p_fecha_nac   IN pasajeros.fecha_nac%type DEFAULT NULL ,
      p_apellido_pa IN pasajeros.apellido_pa%type ,
      p_direccion   IN pasajeros.direccion%type ,
      p_id          IN pasajeros.id%type ,
      p_telefono    IN pasajeros.telefono%type ,
      p_nombre      IN pasajeros.nombre%type ,
      p_email       IN pasajeros.email%type ,
      p_apellido_ma IN pasajeros.apellido_ma%type )
  IS
  BEGIN
    INSERT
    INTO pasajeros
      (
        rut ,
        fecha_nac ,
        apellido_pa ,
        direccion ,
        id ,
        telefono ,
        nombre ,
        email ,
        apellido_ma
      )
      VALUES
      (
        p_rut ,
        p_fecha_nac ,
        p_apellido_pa ,
        p_direccion ,
        p_id ,
        p_telefono ,
        p_nombre ,
        p_email ,
        p_apellido_ma
      );
  END;
-- update
  PROCEDURE upd
    (
      p_rut         IN pasajeros.rut%type ,
      p_fecha_nac   IN pasajeros.fecha_nac%type DEFAULT NULL ,
      p_apellido_pa IN pasajeros.apellido_pa%type ,
      p_direccion   IN pasajeros.direccion%type ,
      p_id          IN pasajeros.id%type ,
      p_telefono    IN pasajeros.telefono%type ,
      p_nombre      IN pasajeros.nombre%type ,
      p_email       IN pasajeros.email%type ,
      p_apellido_ma IN pasajeros.apellido_ma%type
    )
  IS
  BEGIN
    UPDATE pasajeros
    SET rut       = p_rut ,
      fecha_nac   = p_fecha_nac ,
      apellido_pa = p_apellido_pa ,
      direccion   = p_direccion ,
      telefono    = p_telefono ,
      nombre      = p_nombre ,
      email       = p_email ,
      apellido_ma = p_apellido_ma
    WHERE id      = p_id;
  END;
-- del
  PROCEDURE del(
      p_id IN pasajeros.id%type )
  IS
  BEGIN
    DELETE FROM pasajeros WHERE id = p_id;
  END;
END pasajeros_tapi;