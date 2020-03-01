create database springdb;
use springdb;

insert into usuario (nombre, apellido, correo, usuario, contraseña) values ('admin', 'admin', 'admin@gmail.com', 'admin', 'ADMIN1234');
insert into springdb.role (descripcion, name) values ('role_admin', 'admin');
insert into springdb.role (descripcion, name) values ('role_supervisor', 'supervisor');
insert into springdb.role (descripcion, name) values ('role_usuario', 'usuario');
insert into usuario_roles (usuario_id, role_id) values ('1', '1');