package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Metodos {
	
	public String so() {
		String so = System.getProperty("os.name");
		return so;
	}
	
	public void listarMetodos(String so) {
		
		String process = "";
		
		if(so.contains("Linux")){
			process = "top";
		} else if (so.contains("Windows")) {
			process = "TASKLIST";
		}
		
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
				}
			
			fluxo.close();
			leitor.close();
			buffer.close();
	
			} catch(Exception e) {
			e.printStackTrace();
			}
		}
	
	public void metodoKillNome(String so) {
		
		String nome = JOptionPane.showInputDialog("Informe o nome do processo que deseja finalizar?");
		
		String process = "";
		
		if(so.contains("Linux")){
			process = "kill " + nome;
		} else if (so.contains("Windows")) {
			process = "TASKKILL /IM " + nome;
		}
		
		try {
			callProcess(process);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void metodoKillPid(String so) {

		String pid = JOptionPane.showInputDialog("Informe o PID do processo deseja finalizar?");
		
		String process = "";
		
		if(so.contains("Linux")){
			process = "kill " + pid;
		} else if (so.contains("Windows")) {
			process = "TASKKILL /PID " + pid;
		}
		
		try {
			callProcess(process);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void callProcess(String process) {
		try {
			Runtime.getRuntime().exec(process);
		} catch (Exception e) {
			String msgErro = e.getMessage();
			System.err.println(msgErro);
			
			if(msgErro.contains("740")) {
				// cmd /c caminho_do_processo
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(process);
				
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				e.printStackTrace();
			}
		}
		
	}
}
