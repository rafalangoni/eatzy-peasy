insert into kitchen (name, id) values ('Thai', 1);
insert into kitchen (name, id) values ('Japanese', 2);
insert into kitchen (id, name) values (3, 'Argentina');
insert into kitchen (id, name) values (4, 'Brasileira');

insert into restaurant (id, name, delivery_fee, kitchen_id, registration_date, update_date) values (1, 'Feijoadao do Ze', 4.99, 1, utc_timestamp, utc_timestamp);
insert into restaurant (id, name, delivery_fee, kitchen_id, registration_date, update_date) values (2, 'Sushi do Joao', 5.99,2, utc_timestamp, utc_timestamp);
insert into restaurant (id, name, delivery_fee, kitchen_id, registration_date, update_date) values (3, 'Yakisoba do Mane', 6.99,3 ,utc_timestamp, utc_timestamp);
insert into restaurant (id, name, delivery_fee, kitchen_id, registration_date, update_date) values (4, 'Java Steakhouse', 12, 3, utc_timestamp, utc_timestamp);
insert into restaurant (id, name, delivery_fee, kitchen_id, registration_date, update_date) values (5, 'Lanchonete do Tio Sam', 11, 4, utc_timestamp, utc_timestamp);
insert into restaurant (id, name, delivery_fee, kitchen_id, registration_date, update_date) values (6, 'Bar da Maria', 6, 4, utc_timestamp, utc_timestamp);

insert into permission (id, name, description) values (1, 'EDIT_KITCHEN', 'Can remove or edit kitchens');
insert into permission (id, name, description) values (2, 'SEARCH_KITCHEN', 'Can search kitchens');

insert into state (id, name) values (1, 'MG');
insert into state (id, name) values (2, 'DF');

insert into city (id, name, state_id) values (1, 'Monte Carmelo', 1);
insert into city (id, name, state_id) values (2, 'Uberlândia', 1);

insert into payment_type (id, description) values (1, 'Credit card');
insert into payment_type (id, description) values (2, 'Gift card');
insert into payment_type (id, description) values (3, 'Pix');

insert into restaurant_payment_type (payment_type_id, restaurant_id) values (1,1), (1,2), (2,1), (2,2);

insert into restaurant_payment_type (restaurant_id, payment_type_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3), (4, 1), (4, 2), (5, 1), (5, 2), (6, 3);

insert into product (name, description, price, is_active, restaurant_id) values ('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, 1, 1);
insert into product (name, description, price, is_active, restaurant_id) values ('Camarão tailandês', '16 camarões grandes ao molho picante', 110, 1, 1);

insert into product (name, description, price, is_active, restaurant_id) values ('Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, 1, 2);

insert into product (name, description, price, is_active, restaurant_id) values ('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, 1, 3);
insert into product (name, description, price, is_active, restaurant_id) values ('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, 1, 3);

insert into product (name, description, price, is_active, restaurant_id) values ('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, 1, 4);
insert into product (name, description, price, is_active, restaurant_id) values ('T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, 1, 4);

insert into product (name, description, price, is_active, restaurant_id) values ('Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, 1, 5);

insert into product (name, description, price, is_active, restaurant_id) values ('Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, 1, 6);







