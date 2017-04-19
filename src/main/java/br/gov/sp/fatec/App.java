package br.gov.sp.fatec;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import br.gov.sp.fatec.service.AlunoService;
import br.gov.sp.fatec.service.AulaService;
import br.gov.sp.fatec.service.ChamadaService;
import br.gov.sp.fatec.service.ProfessorService;


public class App {
    public static void main( String[] args ) {
    	@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AlunoService aluno = (AlunoService) context.getBean("alunoService");
		try {
			aluno.cadastrarAlunos();
		
		} catch (Exception e) {
			System.out.println("Rollback realizado");
		}
		
		
		ProfessorService professorService = (ProfessorService) context.getBean("professorService");
		try {
			professorService.cadastrarProfessores();
			
		} catch (Exception e) {
			System.out.println("Rollback realizado");
		}
		
		
		AulaService aulaService = (AulaService) context.getBean("aulaService");
		try {
			aulaService.cadastrarAula();
			
		} catch (Exception e) {
			System.out.println("Rollback realizado");
		}
		
		
		ChamadaService chamadaService = (ChamadaService) context.getBean("chamadaService");
		try {
			chamadaService.fazerChamada();
			
		} catch (Exception e) {
			System.out.println("Rollback realizado");
		}
    }
}
