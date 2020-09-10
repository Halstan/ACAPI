insert into countries(name_country) value ('Italia');
insert into countries(name_country) value ('EE.UU');

insert into weapons(name_weapon) values ('Espada');
insert into weapons(name_weapon) values ('Tomahawk');

insert into assassins(created_at, height, last_name, name, id_country) values ('2020-09-17 13:32:19', 1.80, 'Auditore', 'Ezio', 1);
insert into assassins(created_at, height, last_name, name, id_country) values ('2020-09-17 13:32:19', 1.80, 'Kenway', 'Connor', 2);

insert into assassin_weapon(id_weapon, id_assassin) values (1, 1);
insert into assassin_weapon(id_weapon, id_assassin) values (1, 2);
insert into assassin_weapon(id_weapon, id_assassin) values (2, 2);