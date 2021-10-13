
INSERT INTO usuarios (username, password, enabled) VALUES ('rene','$2a$10$d3rZ6nZbwvJ1P5q3zVZkju1IZEjrHWi/Uv7r949pIKC4LMHEIAUvy',true); --12345
INSERT INTO usuarios (username, password, enabled) VALUES ('admin','$2a$10$qTme6hMTZUgHKA0Wytbs7./PT3QHNj.kX8X9Jzn2riRiCouxEFEoq',true);--admin

INSERT INTO roles (nombre, estado) VALUES ('ROLE_USER', true);
INSERT INTO roles (nombre, estado) VALUES ('ROLE_ADMIN', true);

INSERT INTO roles_usuarios (usuario_id, rol_id, estado) VALUES (1, 1, true);
INSERT INTO roles_usuarios (usuario_id, rol_id, estado) VALUES (2, 2, true);

INSERT INTO vacunas (nombre, estado) VALUES ('Sputnik', true);
INSERT INTO vacunas (nombre, estado) VALUES ('AstraZeneca', true);
INSERT INTO vacunas (nombre, estado) VALUES ('Pfizer', true);
INSERT INTO vacunas (nombre, estado) VALUES ('Jhonson&Jhonson', true);
INSERT INTO vacunas (nombre, estado) VALUES ('Sinovac', true);

INSERT INTO empleados (apellidos, cedula, celular, correo, direccion, estado, fecha_nacimiento, nombres, vacunado, usuario_id) VALUES ('Trávez Vinueza', '1717172637', '0995712364', 'rene.travez@hotmail.com', 'La Florida', true, '1987-05-10', 'René Marcelo', false, 1);