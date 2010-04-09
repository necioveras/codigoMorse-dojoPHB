package codigoMorse;

import java.util.HashMap;
import java.util.Map;

public class Morse {
	
	private Map <String, String> tabela = new HashMap<String, String>();
	private String mensagem;
	
	private String charEspeciais = "çáéíóúãẽĩõũàèìòùâêîôûäëïöü";
	private String charCorretos  = "caeiouaeiouaeiouaeiouaeiou";
	private String charInvalidos = "!?@#$%*()/\\|<>+-";
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = substituiCaracteresEspeciais (mensagem).toUpperCase();
		this.mensagem = substituiCaracteresInvalidos (this.mensagem).toUpperCase();
	}
	

	private String substituiCaracteresEspeciais(String mensagem) {
		mensagem = mensagem.toLowerCase();
		StringBuffer message = new StringBuffer(mensagem);
		StringBuffer sb = new StringBuffer(charEspeciais);
		for (int i = 0; i < mensagem.length(); i++){
			char caracter = mensagem.charAt(i);			
			int pos = sb.indexOf(Character.toString(caracter));
			if ( pos != -1){
				message.replace(i, i+1, Character.toString(charCorretos.charAt(pos)));
			}				
		}
		return message.toString();
	}
	
	private String substituiCaracteresInvalidos(String mensagem) {
		mensagem = mensagem.toLowerCase();
		StringBuffer message = new StringBuffer(mensagem);
		StringBuffer sb = new StringBuffer(charInvalidos);
		for (int i = 0; i < mensagem.length(); i++){
			char caracter = mensagem.charAt(i);			
			int pos = sb.indexOf(Character.toString(caracter));
			if ( pos != -1){
				message.replace(i, i+1, " ");
			}				
		}
		return message.toString();
	}
	

	public Map <String, String> getTabela() {
		return tabela;
	}

	public Morse(){
		tabela.put("A", "*-");	tabela.put("B", "-***");	tabela.put("C", "-*-*");
		tabela.put("D", "-**");	tabela.put("E", "*");	tabela.put("F", "**-*");
		tabela.put("G", "--*");	tabela.put("H", "****");	tabela.put("I", "**");
		tabela.put("J", "*---");	tabela.put("K", "-*-");	tabela.put("L", "*-**");
		tabela.put("M", "--");	tabela.put("N", "-*");	tabela.put("O", "---");
		tabela.put("P", "*--*");	tabela.put("Q", "--*-");	tabela.put("R", "*-*");
		tabela.put("S", "***");	tabela.put("T", "-");	tabela.put("U", "**-");
		tabela.put("V", "***-");	tabela.put("W", "*--");	tabela.put("X", "-**-");
		tabela.put("Y", "-*--");	tabela.put("Z", "--**"); 
		tabela.put("1", "*----");	tabela.put("2", "**---");	tabela.put("3", "***--");
		tabela.put("4", "****-");	tabela.put("5", "*****");	tabela.put("6", "-****");
		tabela.put("7", "--***");	tabela.put("8", "---**");	tabela.put("9", "----*");
		tabela.put("0", "-----");tabela.put(".", "*-*-*-");	tabela.put(",", "--**--");
		tabela.put(" ", " ");
		
	}

	public String codifica() {
		String elementos = mensagem;
		StringBuffer sb = new StringBuffer();
		for (int i=0 ; i < elementos.length() - 1; i++){ 
			if(elementos.charAt(i) !=' ')
				sb.append(tabela.get(Character.toString(elementos.charAt(i)))).append(" ");
			else
				sb.append(tabela.get(Character.toString(elementos.charAt(i))));	
			
		}
		
		sb.append(tabela.get(Character.toString(elementos.charAt(elementos.length()-1))));
		return sb.toString();
	}
	
	

}
