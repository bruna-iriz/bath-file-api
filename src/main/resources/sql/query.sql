CREATE DATABASE db_batch;
CREATE DATABASE app;
USE app;

CREATE table conversation (
	id int auto_increment,
	data VARCHAR(20),
	status VARCHAR(30),
	mensagem VARCHAR(200),
	primary key(id)
);