CREATE  SEQUENCE roles_seq;
/
create or replace trigger trg_roles
    before insert on "roles"
    for each row
  begin
    select roles_seq.nextval
      into :NEW."id_rol"
      from dual;
  end;
/
