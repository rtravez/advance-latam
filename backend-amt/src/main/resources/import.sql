
INSERT INTO usuarios (username, password, enabled) VALUES ('rene','$2a$10$d3rZ6nZbwvJ1P5q3zVZkju1IZEjrHWi/Uv7r949pIKC4LMHEIAUvy',true); --12345
INSERT INTO usuarios (username, password, enabled) VALUES ('admin','$2a$10$qTme6hMTZUgHKA0Wytbs7./PT3QHNj.kX8X9Jzn2riRiCouxEFEoq',true);--admin

INSERT INTO roles (nombre, estado) VALUES ('ROLE_USER', true);
INSERT INTO roles (nombre, estado) VALUES ('ROLE_ADMIN', true);

INSERT INTO roles_usuarios (usuario_id, rol_id, estado) VALUES (1, 1, true);
INSERT INTO roles_usuarios (usuario_id, rol_id, estado) VALUES (2, 2, true);
INSERT INTO restricciones (restriccion_id, descripcion, estado, fecha_creacion, modificable, valor_cadena, valor_decimal, valor_entero) VALUES ('PRM_LUN', 'LUNES', true, '2021-10-14', true, '0,1,2,3', null, 1);
INSERT INTO restricciones (restriccion_id, descripcion, estado, fecha_creacion, modificable, valor_cadena, valor_decimal, valor_entero) VALUES ('PRM_MAR', 'MARTES', true, '2021-10-14', true, '2,3,4,5', null, 2);
INSERT INTO restricciones (restriccion_id, descripcion, estado, fecha_creacion, modificable, valor_cadena, valor_decimal, valor_entero) VALUES ('PRM_MIE', 'MIERCOLES', true, '2021-10-14', true, '4,5,6,7', null, 3);
INSERT INTO restricciones (restriccion_id, descripcion, estado, fecha_creacion, modificable, valor_cadena, valor_decimal, valor_entero) VALUES ('PRM_JUE', 'JUEVES', true, '2021-10-14', true, '6,7,8,9', null, 4);
INSERT INTO restricciones (restriccion_id, descripcion, estado, fecha_creacion, modificable, valor_cadena, valor_decimal, valor_entero) VALUES ('PRM_VIE', 'VIERNES', true, '2021-10-14', true, '0,1,8,9', null, 5);
INSERT INTO restricciones (restriccion_id, descripcion, estado, fecha_creacion, modificable, valor_cadena, valor_decimal, valor_entero) VALUES ('PRM_SAB', 'SABADO', true, '2021-10-14', true, '', null, 6);
INSERT INTO restricciones (restriccion_id, descripcion, estado, fecha_creacion, modificable, valor_cadena, valor_decimal, valor_entero) VALUES ('PRM_DOM', 'DOMINGO', true, '2021-10-14', true, '', null, 7);
