-- DROP TABLE IF EXISTS tb_caminho CASCADE;
CREATE TABLE tb_caminho(
    id serial,
	distancia numeric not null,
	pontoOrigemId integer not null,
	pontoDestinoId integer not null,
	CONSTRAINT pk_caminho PRIMARY KEY (id),
	CONSTRAINT fk_caminho_ponto_origem 
		FOREIGN KEY (pontoOrigemId) REFERENCES tb_ponto (id),
	CONSTRAINT fk_caminho_ponto_destino 
		FOREIGN KEY (pontoDestinoId) REFERENCES tb_ponto (id)
);