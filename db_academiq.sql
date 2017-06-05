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
	presente boolean,
	fk_aluno int references aluno(id),
	fk_disciplina int references disciplina(id)
);


-- Inserindo algumas aulas em Junho
insert into academiq.presenca values(1, '2017-06-02', true, 1, 1);
insert into academiq.presenca values(2, '2017-06-02', true, 2, 1);
insert into academiq.presenca values(3, '2017-06-02', true, 3, 1);
insert into academiq.presenca values(4, '2017-06-02', true, 4, 1);
insert into academiq.presenca values(5, '2017-06-02', true, 5, 1);
insert into academiq.presenca values(6, '2017-06-07', true, 1, 1);
insert into academiq.presenca values(7, '2017-06-07', true, 2, 1);
insert into academiq.presenca values(8, '2017-06-07', true, 3, 1);
insert into academiq.presenca values(9, '2017-06-07', true, 4, 1);
insert into academiq.presenca values(10, '2017-06-07', true, 5, 1);
insert into academiq.presenca values(11, '2017-06-09', true, 1, 1);
insert into academiq.presenca values(12, '2017-06-09', true, 2, 1);
insert into academiq.presenca values(13, '2017-06-09', true, 3, 1);
insert into academiq.presenca values(14, '2017-06-09', true, 4, 1);
insert into academiq.presenca values(15, '2017-06-09', true, 5, 1);
insert into academiq.presenca values(16, '2017-06-14', false, 1, 1);
insert into academiq.presenca values(17, '2017-06-14', false, 2, 1);
insert into academiq.presenca values(18, '2017-06-14', false, 3, 1);
insert into academiq.presenca values(19, '2017-06-14', false, 4, 1);
insert into academiq.presenca values(20, '2017-06-14', false, 5, 1);
insert into academiq.presenca values(21, '2017-06-16', false, 1, 1);
insert into academiq.presenca values(22, '2017-06-16', false, 2, 1);
insert into academiq.presenca values(23, '2017-06-16', false, 3, 1);
insert into academiq.presenca values(24, '2017-06-16', false, 4, 1);
insert into academiq.presenca values(25, '2017-06-16', false, 5, 1);
insert into academiq.presenca values(26, '2017-06-07', false, 1, 1);
insert into academiq.presenca values(27, '2017-06-07', false, 2, 1);
insert into academiq.presenca values(28, '2017-06-07', false, 3, 1);
insert into academiq.presenca values(29, '2017-06-07', false, 4, 1);
insert into academiq.presenca values(30, '2017-06-07', false, 5, 1);
insert into academiq.presenca values(31, '2017-06-21', false, 1, 1);
insert into academiq.presenca values(32, '2017-06-21', false, 2, 1);
insert into academiq.presenca values(33, '2017-06-21', false, 3, 1);
insert into academiq.presenca values(34, '2017-06-21', false, 4, 1);
insert into academiq.presenca values(35, '2017-06-21', false, 5, 1);
insert into academiq.presenca values(36, '2017-06-06', false, 1, 2);
insert into academiq.presenca values(37, '2017-06-06', false, 2, 2);
insert into academiq.presenca values(38, '2017-06-06', false, 3, 2);
insert into academiq.presenca values(39, '2017-06-06', false, 4, 2);
insert into academiq.presenca values(40, '2017-06-06', false, 5, 2);
insert into academiq.presenca values(41, '2017-06-07', false, 1, 2);
insert into academiq.presenca values(42, '2017-06-07', false, 2, 2);
insert into academiq.presenca values(43, '2017-06-07', false, 3, 2);
insert into academiq.presenca values(44, '2017-06-07', false, 4, 2);
insert into academiq.presenca values(45, '2017-06-07', false, 5, 2);
insert into academiq.presenca values(46, '2017-06-13', false, 1, 2);
insert into academiq.presenca values(47, '2017-06-13', false, 2, 2);
insert into academiq.presenca values(48, '2017-06-13', false, 3, 2);
insert into academiq.presenca values(49, '2017-06-13', false, 4, 2);
insert into academiq.presenca values(50, '2017-06-13', false, 5, 2);
insert into academiq.presenca values(51, '2017-06-14', false, 1, 2);
insert into academiq.presenca values(52, '2017-06-14', false, 2, 2);
insert into academiq.presenca values(53, '2017-06-14', false, 3, 2);
insert into academiq.presenca values(54, '2017-06-14', false, 4, 2);
insert into academiq.presenca values(55, '2017-06-14', false, 5, 2);
insert into academiq.presenca values(56, '2017-06-20', false, 1, 2);
insert into academiq.presenca values(57, '2017-06-20', false, 2, 2);
insert into academiq.presenca values(58, '2017-06-20', false, 3, 2);
insert into academiq.presenca values(59, '2017-06-20', false, 4, 2);
insert into academiq.presenca values(60, '2017-06-20', false, 5, 2);
insert into academiq.presenca values(61, '2017-06-21', false, 1, 2);
insert into academiq.presenca values(62, '2017-06-21', false, 2, 2);
insert into academiq.presenca values(63, '2017-06-21', false, 3, 2);
insert into academiq.presenca values(64, '2017-06-21', false, 4, 2);
insert into academiq.presenca values(65, '2017-06-21', false, 5, 2);
insert into academiq.presenca values(66, '2017-06-05', false, 1, 3);
insert into academiq.presenca values(67, '2017-06-05', false, 2, 3);
insert into academiq.presenca values(68, '2017-06-05', false, 3, 3);
insert into academiq.presenca values(69, '2017-06-05', false, 4, 3);
insert into academiq.presenca values(70, '2017-06-05', false, 5, 3);
insert into academiq.presenca values(71, '2017-06-06', false, 1, 3);
insert into academiq.presenca values(72, '2017-06-06', false, 2, 3);
insert into academiq.presenca values(73, '2017-06-06', false, 3, 3);
insert into academiq.presenca values(74, '2017-06-06', false, 4, 3);
insert into academiq.presenca values(75, '2017-06-06', false, 5, 3);
insert into academiq.presenca values(76, '2017-06-12', false, 1, 3);
insert into academiq.presenca values(77, '2017-06-12', false, 2, 3);
insert into academiq.presenca values(78, '2017-06-12', false, 3, 3);
insert into academiq.presenca values(79, '2017-06-12', false, 4, 3);
insert into academiq.presenca values(80, '2017-06-12', false, 5, 3);
insert into academiq.presenca values(81, '2017-06-13', false, 1, 3);
insert into academiq.presenca values(82, '2017-06-13', false, 2, 3);
insert into academiq.presenca values(83, '2017-06-13', false, 3, 3);
insert into academiq.presenca values(84, '2017-06-13', false, 4, 3);
insert into academiq.presenca values(85, '2017-06-13', false, 5, 3);
insert into academiq.presenca values(86, '2017-06-19', false, 1, 3);
insert into academiq.presenca values(87, '2017-06-19', false, 2, 3);
insert into academiq.presenca values(88, '2017-06-19', false, 3, 3);
insert into academiq.presenca values(89, '2017-06-19', false, 4, 3);
insert into academiq.presenca values(90, '2017-06-19', false, 5, 3);
insert into academiq.presenca values(91, '2017-06-20', false, 1, 3);
insert into academiq.presenca values(92, '2017-06-20', false, 2, 3);
insert into academiq.presenca values(93, '2017-06-20', false, 3, 3);
insert into academiq.presenca values(94, '2017-06-20', false, 4, 3);
insert into academiq.presenca values(95, '2017-06-20', false, 5, 3);
insert into academiq.presenca values(96, '2017-06-06', false, 1, 4);
insert into academiq.presenca values(97, '2017-06-06', false, 2, 4);
insert into academiq.presenca values(98, '2017-06-06', false, 3, 4);
insert into academiq.presenca values(99, '2017-06-06', false, 4, 4);
insert into academiq.presenca values(100, '2017-06-06', false, 5, 4);
insert into academiq.presenca values(101, '2017-06-13', false, 1, 4);
insert into academiq.presenca values(102, '2017-06-13', false, 2, 4);
insert into academiq.presenca values(103, '2017-06-13', false, 3, 4);
insert into academiq.presenca values(104, '2017-06-13', false, 4, 4);
insert into academiq.presenca values(105, '2017-06-13', false, 5, 4);
insert into academiq.presenca values(106, '2017-06-20', false, 1, 4);
insert into academiq.presenca values(107, '2017-06-20', false, 2, 4);
insert into academiq.presenca values(108, '2017-06-20', false, 3, 4);
insert into academiq.presenca values(109, '2017-06-20', false, 4, 4);
insert into academiq.presenca values(110, '2017-06-20', false, 5, 4);