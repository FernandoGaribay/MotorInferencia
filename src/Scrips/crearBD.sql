create database motorinferencia;
use motorinferencia;

create table quizzes (
	id int primary key auto_increment,
    nombre varchar(255)
);

create table preguntas (
	id int primary key auto_increment,
    enunciado varchar(255),
    idQuiz int,
    foreign key (idQuiz) references quizzes(id)
);

create table resultados (
	id int primary key auto_increment,
	nombre varchar(255)
);

create table opciones (
	id int primary key auto_increment,
	texto varchar(255),
	idPregunta int,
    idResultado int,
	puntos int,
	FOREIGN KEY (idPregunta) REFERENCES preguntas(id),
    FOREIGN KEY (idResultado) REFERENCES resultados(id)
);
