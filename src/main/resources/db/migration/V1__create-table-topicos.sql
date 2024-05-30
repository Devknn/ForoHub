create table topicos(

    id bigint not null auto_increment,
    titulo varchar(250) not null unique,
    mensaje varchar(250) not null unique,
    nombre varchar(60) not null,
    correo_electronico varchar(80) not null unique,
    contrasena varchar(10) not null,
    perfil varchar(100) not null,
    nombre_curso varchar(100),
    categoria varchar(50),

    primary key(id)

);