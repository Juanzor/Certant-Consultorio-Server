
create database consultoriodb;

use consultoriodb;


CREATE TABLE especialidad (  
				especialidad_id int AUTO_INCREMENT PRIMARY KEY, 
				nombre varchar(50)
				 );

CREATE TABLE consultorio (  
				consultorio_id int AUTO_INCREMENT PRIMARY KEY, 
				nombre varchar(50)
				 );

CREATE TABLE profesional (  
				profesional_id int AUTO_INCREMENT PRIMARY KEY, 
				nombre varchar(50),
                apellido varchar(50),
				dni int UNIQUE,
				especialidad_id int,
                foreign key (especialidad_id) references especialidad(especialidad_id)
				 );
                 
CREATE TABLE paciente (  
				paciente_id int AUTO_INCREMENT PRIMARY KEY, 
				nombre varchar(50),
				apellido varchar(50),
				dni int UNIQUE);
                
                 
CREATE TABLE turno (  
				turno_id int AUTO_INCREMENT PRIMARY KEY, 
				fecha DATE,
				hora TIME,
				profesional_id int,
				paciente_id int,
                consultorio_id int,
                estado boolean default true,
                foreign key (profesional_id) references profesional(profesional_id),
                foreign key (paciente_id) references paciente(paciente_id),
                foreign key (consultorio_id) references consultorio(consultorio_id)
				 );
         
         -- Inserts especialidades
INSERT INTO especialidad (nombre) VALUES
('Clínica Médica'),
('Dermatología'),
('Pediatría'),
('Cardiología');

-- Inserts consultorios
INSERT INTO consultorio (nombre) VALUES
('Consultorio 1'),
('Consultorio 2'),
('Consultorio 3');

-- Inserts profesionales
INSERT INTO profesional (nombre, apellido, dni, especialidad_id) VALUES
('Elena', 'Verdugo', 12345678, 1),  
('Diego', 'Echeverría', 23456789, 1), 
('Juan', 'Zaragoza', 34567890, 1), 
('Ana', 'Quintanilla', 45678901, 1),  

('Luis', 'Aravena', 56789012, 2),  
('Carla', 'Morales', 67890123, 2),  
('Santiago', 'Salazar', 78901234, 2),  
('Nadia', 'Bermúdez', 89012345, 2),  

('Pedro', 'Alarcón', 90123456, 3),  
('María', 'Ceballos', 12345679, 3), 
('Lucía', 'Hernández', 23456780, 3),  
('Javier', 'Montes', 34567891, 3),  

('José', 'Figueroa', 45678902, 4), 
('Laura', 'Villalobos', 56789013, 4), 
('Andrés', 'Sotelo', 67890124, 4),  
('Patricia', 'Carbajal', 78901235, 4);  


-- Inserts pacientes
INSERT INTO paciente (nombre, apellido, dni) VALUES
('Ricardo', 'Salazar', 12345678),
('Laura', 'Mendoza', 23456789),
('Andrés', 'Cruz', 34567890),
('Sofía', 'Pinto', 45678901);

-- Inserts turnos
INSERT INTO turno (fecha, hora, profesional_id, paciente_id, consultorio_id, estado) VALUES
('2024-10-13', '09:00:00', 1, 1, 1, true),
('2024-10-13', '10:00:00', 2, 2, 1, true),
('2024-10-14', '11:00:00', 3, 3, 2, true),
('2024-10-14', '12:00:00', 4, 4, 2, true),
('2024-10-15', '14:00:00', 5, 1, 3, true),
('2024-10-15', '15:00:00', 6, 2, 3, true),
('2024-10-16', '16:00:00', 7, 3, 1, true),
('2024-10-16', '17:00:00', 8, 4, 1, true);
        


-- Probando select con todas las tablas
SELECT t.turno_id, t.fecha, t.hora, e.nombre AS especialidad,
       p.nombre AS profesional_nombre, 
       pac.nombre AS paciente_nombre, pac.apellido AS paciente_apellido, 
       c.nombre AS consultorio_nombre
FROM turno t
JOIN profesional p ON t.profesional_id = p.profesional_id
JOIN especialidad e ON e.especialidad_id = p.especialidad_id
JOIN paciente pac ON t.paciente_id = pac.paciente_id
JOIN consultorio c ON t.consultorio_id = c.consultorio_id;



                 
                              
	