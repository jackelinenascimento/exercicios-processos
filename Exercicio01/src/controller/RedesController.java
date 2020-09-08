package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class RedesController {
	
	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void ip(String so) {
		
		int contAdaptador = 0, contIpv4 = 0, i = 0;
		String[] adaptador = new String[5];
		String[] ipv4 = new String[5];
		String process = "";
		
		if(so.contains("Linux")){
			process = "ifconfig";
		} else if (so.contains("Windows")) {
			process = "ipconfig";
		}
		
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) {
				if(linha.contains("Adaptador")) {
					adaptador[contAdaptador] = linha;
					contAdaptador++;
				}
				if(linha.contains("ipv4")) {
					ipv4[contIpv4] = linha;
					contIpv4++;
				}
				
				linha = buffer.readLine();
			}
			
			fluxo.close();
			leitor.close();
			buffer.close();
			
			for(i=0; i<contAdaptador; i++) {
				JOptionPane.showConfirmDialog(null, adaptador[i]);
				}
			
			for(i=0; i<contIpv4; i++) {
				JOptionPane.showConfirmDialog(null, ipv4[i]);
				}
				
			} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void ping(String so) {
		double media = 0;
		String process = "";
		int contador = 0;
		
		if(so.contains("Linux")){
			process = "ping www.google.com";
		} else if (so.contains("Windows")) {
			process = "ping www.google.com";
		}
		
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null & contador < 10) {
				
				if(linha.contains("time") || linha.contains("tempo")) {
					int index = linha.indexOf("ms");
					String ms = linha.substring(index-5, index);
					double x = Double.parseDouble(ms);
					media = media + x;
					contador++;				
				}
				
				linha = buffer.readLine();
			}
			
			fluxo.close();
			leitor.close();
			buffer.close();
			
			JOptionPane.showConfirmDialog(null, "Média: " + media/10);
				
			} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
