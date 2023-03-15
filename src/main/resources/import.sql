insert into drone_state (state_name) values ('IDLE');

insert into drone_state (state_name) values ('LOADING');

insert into drone_state (state_name) values ('DELIVERING');

insert into drone_state (state_name) values ('DELIVERED');

insert into drone_state (state_name) values ('RETURNING');

insert into model (model_name,weight_limit) values ('Lightweight',200);

insert into model (model_name,weight_limit) values ('Middleweight',300);

insert into model (model_name,weight_limit) values ('Cruiserweight',400);

insert into model (model_name,weight_limit) values ('Heavyweight',500);


insert into medication (name,weight,code) values ('ibuprofen',25,'15AS45D15');

insert into medication (name,weight,code) values ('aspirin',50,'15AS45D16');

insert into medication (name,weight,code) values ('Amoxicilin',20,'19ME67Q91');

insert into medication (name,weight,code) values ('azithromycin',100,'19ME67F25');

insert into medication (name,weight,code) values ('cephalexin',75,'04TE58H42');

insert into medication (name,weight,code) values ('losartan',80,'04TE58F97');
