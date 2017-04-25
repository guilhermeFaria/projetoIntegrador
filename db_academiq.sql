drop schema if exists academiq;
CREATE SCHEMA academiq DEFAULT CHARACTER SET utf8;

CREATE TABLE academiq.usuario
(
	id int AUTO_INCREMENT primary key,
	nome varchar(70) NOT NULL,
	login varchar(50) NOT NULL,
	senha varchar(50) NOT NULL,
	status boolean
);

CREATE TABLE academiq.instituicao
(
	id int AUTO_INCREMENT primary key,
	nome varchar(70) NOT NULL,
	cnpj varchar(18) NOT NULL
);

CREATE TABLE academiq.curso
(
	id int AUTO_INCREMENT primary key,
	nome varchar(50),
	sigla varchar(10),
	fk_instituicao int references instituicao(id)
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
	fk_usuario integer NOT NULL references usuario(id),
	fk_instituicao integer NOT NULL references instituicao(id)
);

CREATE TABLE academiq.inscrito
(
	id int AUTO_INCREMENT primary key,
	data date,
	fk_professor int references professor(id),
	fk_disciplina int references disciplina(id)
);

CREATE TABLE academiq.aluno
(
	id int AUTO_INCREMENT primary key,
	ra varchar(25),
	fk_usuario int references usuario(id),
	fk_matricula int references matricula(id)
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
