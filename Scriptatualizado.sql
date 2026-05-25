ALTER TABLE sensor DROP COLUMN tipo_sensor_id;
drop table tipo_sensor;
drop table  recomenacao;
ALTER TABLE sensor DROP CONSTRAINT fk_tipo_sensor;
ALTER TABLE sensor ADD COLUMN tipo_sensor varchar(30);