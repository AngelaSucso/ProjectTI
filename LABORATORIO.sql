CREATE TABLE `CURSO`(
	`idCurso` INT PRIMARY KEY AUTO_INCREMENT,
	`Curso_asign` VARCHAR(80) NOT NULL
);

INSERT INTO `CURSO` (`Curso_asign`) VALUES ('FUNDAMENTOS DE COMPUTACIÓN');

INSERT INTO `CURSO` (`Curso_asign`) VALUES ('CIENCIAS DE LA COMPUTACION II');
INSERT INTO `CURSO` (`Curso_asign`) VALUES ('DESARROLLO BASADO EN PLATAFORMAS');
INSERT INTO `CURSO` (`Curso_asign`) VALUES ('ARQUITECTURA DE COMPUTADORES');

INSERT INTO `CURSO` (`Curso_asign`) VALUES ('BASE DE DATOS II');

INSERT INTO `CURSO` (`Curso_asign`) VALUES ('REDES Y COMUNICACIONES');

INSERT INTO `CURSO` (`Curso_asign`) VALUES ('METODOS FORMALES');

CREATE TABLE `HORARIO`(
	`idHorario` INT PRIMARY KEY AUTO_INCREMENT,
	`Hora_inicio` VARCHAR(45) NOT NULL,
	`Hora_fin` VARCHAR(45) NOT NULL,
	`Fecha` VARCHAR(45) NOT NULL
);

INSERT INTO `HORARIO`(`Hora_inicio`, `Hora_fin`, `Fecha`) VALUES ('15:50','17:30','LUNES');
INSERT INTO `HORARIO`(`Hora_inicio`, `Hora_fin`, `Fecha`) VALUES ('15:50','17:30','MIERCOLES');
INSERT INTO `HORARIO`(`Hora_inicio`, `Hora_fin`, `Fecha`) VALUES ('12:20','14:00','LUNES');
INSERT INTO `HORARIO`(`Hora_inicio`, `Hora_fin`, `Fecha`) VALUES ('8:50','10:30','VIERNES');
INSERT INTO `HORARIO`(`Hora_inicio`, `Hora_fin`, `Fecha`) VALUES ('14:00','15:40','LUNES');
INSERT INTO `HORARIO`(`Hora_inicio`, `Hora_fin`, `Fecha`) VALUES ('15:50','15:40','MIERCOLES');

INSERT INTO `HORARIO`(`Hora_inicio`, `Hora_fin`, `Fecha`) VALUES ('14:00','15:40','VIERNES');
INSERT INTO `HORARIO`(`Hora_inicio`, `Hora_fin`, `Fecha`) VALUES ('16:40','18:30','JUEVES');

INSERT INTO `HORARIO`(`Hora_inicio`, `Hora_fin`, `Fecha`) VALUES ('17:40','19:20','LUNES');
INSERT INTO `HORARIO`(`Hora_inicio`, `Hora_fin`, `Fecha`) VALUES ('10:40','12:20','JUEVES');
INSERT INTO `HORARIO`(`Hora_inicio`, `Hora_fin`, `Fecha`) VALUES ('10:40','12:20','VIERNES');

CREATE TABLE `GRADO`(
	`idGrado` INT PRIMARY KEY AUTO_INCREMENT,
	`Grado_asign` VARCHAR(10) NOT NULL
);

INSERT INTO `GRADO`(`Grado_asign`) VALUES ('1°');
INSERT INTO `GRADO`(`Grado_asign`) VALUES ('2°');
INSERT INTO `GRADO`(`Grado_asign`) VALUES ('3°');
INSERT INTO `GRADO`(`Grado_asign`) VALUES ('4°');
INSERT INTO `GRADO`(`Grado_asign`) VALUES ('5°');

CREATE TABLE `GRUPO`(
	`idGrupo` INT PRIMARY KEY AUTO_INCREMENT,
	`Grupo_asign` VARCHAR(1) NOT NULL
);

INSERT INTO `GRUPO`(`Grupo_asign`) VALUES ('A');
INSERT INTO `GRUPO`(`Grupo_asign`) VALUES ('B');
INSERT INTO `GRUPO`(`Grupo_asign`) VALUES ('C');
INSERT INTO `GRUPO`(`Grupo_asign`) VALUES ('D');

CREATE TABLE `PROFESOR`(
	`idProfesor` INT PRIMARY KEY AUTO_INCREMENT,
	`Nombres` VARCHAR(60) NOT NULL,
	`Apellidos` VARCHAR(60) NOT NULL
);

INSERT INTO `PROFESOR`(`Nombres`, `Apellidos`) VALUES ('Eliana', 'Adriazola Herrera');
INSERT INTO `PROFESOR`(`Nombres`, `Apellidos`) VALUES ('Álvaro Henry', 'Mamani Aliaga');
INSERT INTO `PROFESOR`(`Nombres`, `Apellidos`) VALUES ('Pedro Alex', 'Rodriguez Gonzales');
INSERT INTO `PROFESOR`(`Nombres`, `Apellidos`) VALUES ('Edgar', 'Sarmiento Calisaya');


CREATE TABLE `ASIGNATURA`(
	`idAsignatura` INT PRIMARY KEY AUTO_INCREMENT,
	`idCurso` INT NOT NULL,
	`idHorario` INT NOT NULL,
	`idGrado` INT NOT NULL,
	`idGrupo` INT NOT NULL,
	`idProfesor` INT NOT NULL,
	`Capacidad` INT NOT NULL,
	FOREIGN KEY (`idCurso`) REFERENCES `CURSO` (`idCurso`),
	FOREIGN KEY (`idHorario`) REFERENCES `HORARIO` (`idHorario`),
	FOREIGN KEY (`idGrado`) REFERENCES `GRADO` (`idGrado`),
	FOREIGN KEY (`idGrupo`) REFERENCES `GRUPO` (`idGrupo`),
	FOREIGN KEY (`idProfesor`) REFERENCES `PROFESOR` (`idProfesor`)
);

INSERT INTO `ASIGNATURA`(`idCurso`, `idHorario`, `idGrado`, `idGrupo`, `idProfesor`, `Capacidad`) VALUES (1,1,1,1,1,25);
INSERT INTO `ASIGNATURA`(`idCurso`, `idHorario`, `idGrado`, `idGrupo`, `idProfesor`, `Capacidad`) VALUES (1,2,1,1,1,25);
INSERT INTO `ASIGNATURA`(`idCurso`, `idHorario`, `idGrado`, `idGrupo`, `idProfesor`, `Capacidad`) VALUES (1,3,1,2,1,25);
INSERT INTO `ASIGNATURA`(`idCurso`, `idHorario`, `idGrado`, `idGrupo`, `idProfesor`, `Capacidad`) VALUES (1,4,1,2,1,25);
INSERT INTO `ASIGNATURA`(`idCurso`, `idHorario`, `idGrado`, `idGrupo`, `idProfesor`, `Capacidad`) VALUES (1,5,1,3,1,25);
INSERT INTO `ASIGNATURA`(`idCurso`, `idHorario`, `idGrado`, `idGrupo`, `idProfesor`, `Capacidad`) VALUES (1,6,1,3,1,25);

INSERT INTO `ASIGNATURA`(`idCurso`, `idHorario`, `idGrado`, `idGrupo`, `idProfesor`, `Capacidad`) VALUES (4,7,2,1,3,25);
INSERT INTO `ASIGNATURA`(`idCurso`, `idHorario`, `idGrado`, `idGrupo`, `idProfesor`, `Capacidad`) VALUES (4,8,2,2,3,25);

INSERT INTO `ASIGNATURA`(`idCurso`, `idHorario`, `idGrado`, `idGrupo`, `idProfesor`, `Capacidad`) VALUES (2,9,2,1,2,25);
INSERT INTO `ASIGNATURA`(`idCurso`, `idHorario`, `idGrado`, `idGrupo`, `idProfesor`, `Capacidad`) VALUES (2,10,2,2,2,25);

CREATE TABLE `ALUMNO`(
	`idAlumno` INT PRIMARY KEY AUTO_INCREMENT,
	`C.U.I.` INT(10) NOT NULL,
	`Nombres_Alumno` VARCHAR(45) NOT NULL,
	`Apellidos_Almuno` VARCHAR(45) NOT NULL,
	`Correo` VARCHAR(80) NOT NULL,
	`idAsignatura` INT,
	FOREIGN KEY (`idAsignatura`) REFERENCES `ASIGNATURA` (`idAsignatura`)
);

INSERT INTO `ALUMNO` (`C.U.I.`, `Nombres_Alumno`, `Apellidos_Almuno`, `Correo`, `idAsignatura`) VALUES (20202238, 'Alejandro', 'Herrera','abil@unsa.edu.pe',1);
