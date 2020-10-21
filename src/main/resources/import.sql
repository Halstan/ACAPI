insert into countries(name_country) value ('Italia');
insert into countries(name_country) value ('EE.UU');
insert into countries(name_country) value ('Inglaterra');
insert into countries(name_country) value ('Egipto');
insert into countries(name_country) value ('España');

insert into weapons(name_weapon) values ('Espada');
insert into weapons(name_weapon) values ('Tomahawk');
insert into weapons(name_weapon) values ('Lanza');
insert into weapons(name_weapon) values ('Arco');
insert into weapons(name_weapon) values ('Ballesta');
insert into weapons(name_weapon) values ('Hacha');
insert into weapons(name_weapon) values ('Escudo');
insert into weapons(name_weapon) values ('Hoja oculta');

insert into assassins(created_at, height, last_name, name, id_country) values (NOW(), 1.80, 'Auditore', 'Ezio', 1);
insert into assassins(created_at, height, last_name, name, id_country) values (NOW(), 1.80, 'Kenway', 'Connor', 2);
insert into assassins(created_at, height, last_name, name, id_country) values (NOW(), 1.80, 'Auditore', 'Maria', 1);
insert into assassins(created_at, height, last_name, name, id_country) values (NOW(), 1.80, 'Kenway', 'Edward', 3);
insert into assassins(created_at, height, last_name, name, id_country) values (NOW(), 1.80, 'Eve', 'Frye', 3);
insert into assassins(created_at, height, last_name, name, id_country) values (NOW(), 1.80, 'Jacob', 'Frye', 3);
insert into assassins(created_at, height, last_name, name, id_country) values (NOW(), 1.80, 'Auditore', 'Ezio', 1);
insert into assassins(created_at, height, last_name, name, id_country) values (NOW(), 1.80, 'Kenway', 'Connor', 2);
insert into assassins(created_at, height, last_name, name, id_country) values (NOW(), 1.80, 'Auditore', 'Ezio', 1);
insert into assassins(created_at, height, last_name, name, id_country) values (NOW(), 1.80, 'Kenway', 'Connor', 2);
insert into assassins(created_at, height, last_name, name, id_country) values (NOW(), 1.80, 'Auditore', 'Ezio', 1);
insert into assassins(created_at, height, last_name, name, id_country) values (NOW(), 1.80, 'Kenway', 'Connor', 2);
insert into assassins(created_at, height, last_name, name, id_country) values (NOW(), 1.80, 'De siwa', 'Bayek', 4);
insert into assassins(created_at, height, last_name, name, id_country) values (NOW(), 1.80, 'Ibn Lah', 'Altair', 2);

insert into assassin_weapon(id_weapon, id_assassin) values (1, 1);
insert into assassin_weapon(id_weapon, id_assassin) values (1, 2);
insert into assassin_weapon(id_weapon, id_assassin) values (2, 2);

insert into users(enabled, last_name, name, password, username, email) VALUES (1, 'Arauco', 'Enzo', '$2a$10$5ZIByF.huZseuJjqx9I2aOg8A/p3d2C1HdBFVmaVLqfNTdWEZXoOW', 'halstan', 'enzoarauco@gmail.com');
insert into users(enabled, last_name, name, password, username, email) VALUES (1, 'Arauco', 'Omar', '$2a$10$FpOf1bWb/SE/fR3E2OdW9OPVQXJaRg7Xm.TySEC7bmr84uK4r4onG', 'omar', 'omararauco@gmail.com');

insert into roles(authority) VALUES ('ROLE_USER');
insert into roles(authority) VALUES ('ROLE_ADMIN');

insert into user_rol (id_user, id_rol) values (1, 1);
insert into user_rol (id_user, id_rol) values (2, 2);
insert into user_rol (id_user, id_rol) values (2, 1);