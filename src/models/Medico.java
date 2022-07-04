package models;

public class Medico extends Pessoa {

	private String especializacao;
	private String crm;
	public static String medico = "";
	public static String especialidade  = "";
	public static String numerocrm  = "";
	public static String numerocpf  = "";	
	public static String enderecoEmail = "";
	
	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

}
