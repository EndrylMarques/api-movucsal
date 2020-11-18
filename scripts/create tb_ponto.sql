-- DROP TABLE IF EXISTS tb_ponto CASCADE;
CREATE TABLE tb_ponto(
    id serial,
	codigo varchar(6)  not null,
	descricao varchar(255) not null,
	predio char(2) not null,
	acessivel boolean not null,
	latitude numeric not null,
	longitude numeric not null,
	altura smallint not null,
	CONSTRAINT pk_ponto PRIMARY KEY (id),
	CONSTRAINT cd_ponto UNIQUE (codigo)
);