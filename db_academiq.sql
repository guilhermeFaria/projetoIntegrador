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

insert into academiq.usuario values (1,'Admin','admin',SHA2('admin',256),true);


CREATE TABLE academiq.usuario_autorizacao(
    fk_usuario int references academiq.usuario(id),
    fk_autorizacao int references academiq.autoricacao(id),
    primary key(fk_usuario,fk_autorizacao)
);

insert into academiq.usuario_autorizacao values (1,1);

-- CREATE TABLE academiq.instituicao
-- (
-- 	id int AUTO_INCREMENT primary key,
-- 	nome varchar(70) NOT NULL,
-- 	cnpj varchar(18) NOT NULL
-- );

CREATE TABLE academiq.curso
(
	id int AUTO_INCREMENT primary key,
	nome varchar(50),
	sigla varchar(10)
);

CREATE TABLE academiq.disciplina
(
	id int AUTO_INCREMENT primary key,
	nome varchar(50),
	fk_curso int  NOT NULL references curso(id)
);

CREATE TABLE academiq.professor
(
	id int AUTO_INCREMENT primary key,
	fk_usuario integer NOT NULL references usuario(id)
);

CREATE TABLE academiq.aluno
(
	id int AUTO_INCREMENT primary key,
	ra varchar(25),
	fk_usuario int references usuario(id)
);

CREATE TABLE academiq.aula
(
	id int AUTO_INCREMENT primary key,
	data date,
	fk_professor int references professor(id),
	fk_disciplina int references disciplina(id)
);

CREATE TABLE academiq.presenca
(
	id int AUTO_INCREMENT primary key,
	fk_aluno int references aluno(id),
	fk_aula int references aula(id)
);
