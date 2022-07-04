package banco;

import java.util.ArrayList;
import java.util.List;

import models.Enfermeiros;
import models.Medico;
import models.Paciente;

public class Armazenamento {
	
	public static List <Medico> medicos = new ArrayList<Medico>();
	
	public static List <Paciente> pacientes = new ArrayList<Paciente>();
	
	public static List <Enfermeiros> enfermeiros = new ArrayList<Enfermeiros>();
	
	public static boolean VerificarCPF(String cpf) {		
		for (Medico medico : Armazenamento.medicos) {
			if (medico.getCpf().equals(cpf)) {
				return true;
			}
		}
	return false;
	}
	
	public static boolean VerificarNovaSenha(String senha) {		
		for (Medico medico : Armazenamento.medicos) {
			if (medico.getSenha().equals(senha)) {
				return true;
			}
		}
	return false;
	}
}
