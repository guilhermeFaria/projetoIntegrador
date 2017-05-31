drop schema if exists academiq;
CREATE SCHEMA academiq DEFAULT CHARACTER SET utf8;

CREATE TABLE academiq.autorizacao(
	id int unsigned auto_increment PRIMARY KEY ,
    autorizacao varchar(50) unique
);

insert into academiq.autorizacao(autorizacao) values ('ROLE_ADMIN');
insert into academiq.autorizacao(autorizacao) values ('ROLE_PROF');
insert into academiq.autorizacao(autorizacao) values ('ROLE_ALUNO');

CREATE TABLE academiq.usuario
(
	id int AUTO_INCREMENT primary key,
	nome varchar(70) NOT NULL,
	login varchar(50) NOT NULL unique,
	senha varchar(256) NOT NULL,
	status boolean
);

insert into academiq.usuario values (1, 'Admin', 'admin', SHA2('admin', 256), true);
insert into academiq.usuario values (2, 'Denis', 'denis@academiq.com', SHA2('teste', 256), true);
insert into academiq.usuario values (3, 'Joao', 'joao@academiq.com', SHA2('teste', 256), true);
insert into academiq.usuario values (4, 'Igor', 'igor@academiq.com', SHA2('teste', 256), true);
insert into academiq.usuario values (5, 'Cleiton', 'cleiton@academiq.com', SHA2('teste', 256), true);
insert into academiq.usuario values (6, 'Gustavo', 'gustavo@academiq.com', SHA2('teste', 256), true);
insert into academiq.usuario values (7, 'Claudio', 'claudio@academiq.com', SHA2('teste', 256), true);
insert into academiq.usuario values (8, 'Mineda', 'mineda@academiq.com', SHA2('teste', 256), true);
insert into academiq.usuario values (9, 'Walter', 'walter@academiq.com', SHA2('teste', 256), true);


CREATE TABLE academiq.usuario_autorizacao(
    fk_usuario int references academiq.usuario(id),
    fk_autorizacao int references academiq.autoricacao(id),
    primary key(fk_usuario,fk_autorizacao)
);

insert into academiq.usuario_autorizacao values (1, 1);
insert into academiq.usuario_autorizacao values (2, 3); -- Denis
insert into academiq.usuario_autorizacao values (3, 3); -- Joao
insert into academiq.usuario_autorizacao values (4, 3); -- Igor
insert into academiq.usuario_autorizacao values (5, 3); -- Cleiton
insert into academiq.usuario_autorizacao values (6, 3); -- Gustavo
insert into academiq.usuario_autorizacao values (7, 2); -- Claudio
insert into academiq.usuario_autorizacao values (8, 2); -- Mineda
insert into academiq.usuario_autorizacao values (9, 2); -- Walter


CREATE TABLE academiq.professor
(
	id int AUTO_INCREMENT primary key,
	fk_usuario integer NOT NULL references usuario(id)
);

insert into academiq.professor values(1, 7); -- Cláudio
insert into academiq.professor values(2, 8); -- Mineda
insert into academiq.professor values(3, 9); -- Walter

CREATE TABLE academiq.aluno
(
	id int AUTO_INCREMENT primary key,
	ra varchar(25),
	fk_usuario int references usuario(id)
);

insert into academiq.aluno values(1, '20140201', 2); -- Denis
insert into academiq.aluno values(2, '20140202', 3); -- João
insert into academiq.aluno values(3, '20140203', 4); -- Igor
insert into academiq.aluno values(4, '20140204', 5); -- Cleiton
insert into academiq.aluno values(5, '20140205', 6); -- Gustavo


CREATE TABLE academiq.curso
(
	id int AUTO_INCREMENT primary key,
	nome varchar(50),
	sigla varchar(10)
);

insert into academiq.curso value(1, 'Analise e Desenvolvimento de Sistemas', 'ADS');
insert into academiq.curso value(2, 'Banco de Dados', 'BD');
insert into academiq.curso value(3, 'Logistica', 'LOG');

CREATE TABLE academiq.disciplina
(
	id int AUTO_INCREMENT primary key,
	nome varchar(50),
	fk_curso int  NOT NULL references curso(id),
	fk_professor int references professor(id)
);

insert into academiq.disciplina values(1, 'Gestão de Projetos', 1, 1); -- Cláudio
insert into academiq.disciplina values(2, 'Gestão e Gorvernança de TI', 1, 1); -- Cláudio
insert into academiq.disciplina values(3, 'Tópicos especiais em informática', 1, 2); -- Mineda
insert into academiq.disciplina values(4, 'Empreendedorismo', 1, 3); -- Walter

CREATE TABLE academiq.presenca
(
	id int AUTO_INCREMENT primary key,
	data date,
	fk_aluno int references aluno(id),
	fk_disciplina int references disciplina(id)
);
