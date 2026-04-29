create database projeto_integrador;

create table local(
local_id serial primary key,
nome varchar (100) not null,
latitude numeric (9,6) not null,
longitude numeric (9,6) not null,
tipo_solo varchar (50) not null
);

create table tipo_sensor(
tipo_sensor_id serial primary key,
tipo varchar (50) not null
);

create table sensor(
sensor_id serial primary key,
local_id int,
tipo_sensor_id int
);

create table leitura(
leitura_id serial primary key,
sensor_id int,
dado numeric (5,2) not null,
ultima_atualizacao timestamp not null,
risco_dado varchar (30) not null,
classificacao_dado varchar (30) not null
);

create table recomendacao(
recomendacao_id serial primary key,
leitura_id int,
texto_recomendacao text not null
);

alter table sensor add constraint fk_local foreign key (local_id) references local (local_id);
alter table sensor add constraint fk_tipo_sensor foreign key (tipo_sensor_id) references
tipo_sensor (tipo_sensor_id);
alter table leitura add constraint fk_sensor foreign key (sensor_id) references sensor
(sensor_id);
alter table recomendacao add constraint fk_leitura foreign key (leitura_id) references leitura
(leitura_id);

SELECT s.sensor_id, l.nome AS local, t.tipo AS tipo_sensor FROM sensor s INNER JOIN
local l ON s.local_id = l.local_id INNER JOIN tipo_sensor t ON s.tipo_sensor_id =
t.tipo_sensor_id;

SELECT le.dado AS leitura, t.tipo AS tipo_sensor, l.nome AS local FROM leitura le INNER
JOIN sensor s ON le.sensor_id = s.sensor_id INNER JOIN tipo_sensor t ON
s.tipo_sensor_id = t.tipo_sensor_id INNER JOIN local l ON s.local_id = l.local_id;

SELECT
le.dado,
le.risco_dado,
l.nome AS local
FROM leitura le
INNER JOIN sensor s ON le.sensor_id = s.sensor_id
INNER JOIN local l ON s.local_id = l.local_id
WHERE le.risco_dado = 'alto';