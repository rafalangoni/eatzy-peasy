insert into kitchen (name, id) values ('Thai', 1);
insert into kitchen (name, id) values ('Japanese', 2);
insert into kitchen (name, id) values ('Chinese', 3);
insert into kitchen (name, id) values ('Brazilian', 4);

insert into restaurant (id, name, kitchen_id) values (1, 'Feijoadao do Ze', 4);
insert into restaurant (id, name, kitchen_id) values (2, 'Sushi do Joao', 2);
insert into restaurant (id, name, kitchen_id) values (3, 'Yakisoba do Mane', 3);

insert into payment_type (id, description) values (1, 'Credit card');
insert into payment_type (id, description) values (2, 'Gift card');

insert into permission (id, name, description) values (1, 'EDIT_KITCHEN', 'Can remove or edit kitchens');
insert into permission (id, name, description) values (2, 'SEARCH_KITCHEN', 'Can search kitchens');

insert into state (id, name) values (1, 'MG');

insert into city (id, name, state_id) values (1, 'Monte Carmelo', 1);
insert into city (id, name, state_id) values (2, 'Uberlândia', 1);





