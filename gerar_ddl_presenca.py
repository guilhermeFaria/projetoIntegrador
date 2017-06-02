'''1 - 5 alunos
1, 'Gestão de Projetos' -- Cláudio
2, 'Gestão e Gorvernança'  -- Cláudio
3, 'Tópicos especiais em informática' -- Mineda
4, 'Empreendedorismo' -- Walter

-- id, ano-mes-dia, aluno, disciplina
insert into academiq.presenca values(1, '2017-05-17', 1, 1)'''

datas_gp = '2017-06-02,2017-06-07,2017-06-09,2017-06-14,2017-06-16,2017-06-07,2017-06-21'.split(',');
datas_ggti = '2017-06-06,2017-06-07,2017-06-13,2017-06-14,2017-06-20,2017-06-21'.split(',')
datas_empr = '2017-06-06,2017-06-13,2017-06-20'.split(',')
datas_tei = '2017-06-05,2017-06-06,2017-06-12,2017-06-13,2017-06-19,2017-06-20'.split(',')

id_presenca = 1

def generate_script(datas, disciplina):
	global id_presenca
	for dia in datas:
		for aluno in range(1,6):
			print('insert into academiq.presenca values(' + str(id_presenca) + ', \'' + dia + '\', ' + str(aluno) + ', ' + str(disciplina) + ');')
			id_presenca += 1


generate_script(datas_gp, 1)
generate_script(datas_ggti, 2)
generate_script(datas_tei, 3)
generate_script(datas_empr, 4)
