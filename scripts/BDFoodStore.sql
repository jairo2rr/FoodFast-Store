drop database if exists db_foodstore;
create database db_foodstore;
use db_foodstore;

create table if not exists usuario(
	id_usuario INT AUTO_INCREMENT,
    username VARCHAR(25) NOT NULL,
    `password` VARCHAR(60) NOT NULL,
    created_at DATE,
    updated_at DATE,
    PRIMARY KEY(`id_usuario`)
);

create table if not exists rol(
	id_rol INT AUTO_INCREMENT,
    rolname VARCHAR(30) NOT NULL,
    PRIMARY KEY(`id_rol`)
);

create table if not exists rol_usuario(
	id_rolusuario INT AUTO_INCREMENT,
    id_rol INT,
    id_usuario INT,
    created_at DATE,
    updated_at DATE,
    PRIMARY KEY(`id_rolusuario`),
    FOREIGN KEY(`id_rol`) REFERENCES rol(`id_rol`),
    FOREIGN KEY(`id_usuario`) REFERENCES usuario(`id_usuario`)
);

create table if not exists permiso(
	id_permiso INT AUTO_INCREMENT,
    `description` TEXT,
    PRIMARY KEY(`id_permiso`)
);

create table if not exists permiso_rol(
	id_permisorol INT AUTO_INCREMENT,
    id_permiso INT,
    id_rol INT,
    created_at DATE,
    updated_at DATE,
    PRIMARY KEY(`id_permisorol`),
    FOREIGN KEY(`id_permiso`) REFERENCES permiso(`id_permiso`),
    FOREIGN KEY(`id_rol`) REFERENCES rol(`id_rol`)
);