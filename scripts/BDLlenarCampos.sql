
USE db_foodstore;

INSERT INTO rol(`rolname`) VALUES ("administrador"),("cliente");

INSERT INTO permiso(`description`) VALUES ("Registrar producto"),("Administrar cliente"),("Buscar producto"),("Comprar producto"),("Generar venta");

INSERT INTO permiso_rol(`id_permiso`,`id_rol`,`created_at`) VALUES (1,1, CURDATE()), (2,1,CURDATE()), (3,1,CURDATE()), (4,2,CURDATE()), (5,2,CURDATE());

INSERT INTO usuario(`username`,`password`,`created_at`) VALUES ("jairo1","123",CURDATE()),("admin","123",CURDATE());

INSERT INTO rol_usuario(`id_rol`,`id_usuario`,`created_at`) VALUES (1,2, CURDATE()), (2,1, CURDATE());

SELECT * FROM permiso_rol;
SELECT * FROM permiso;
SELECT * FROM usuario;
SELECT * FROM rol;
SELECT * FROM rol_usuario;