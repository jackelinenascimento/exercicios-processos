package view;

import javax.swing.JOptionPane;

import controller.Metodos;

public class Main {

	public static void main(String[] args) {
		
		Metodos metodos = new Metodos();
		
		Object[] opcoes = {1, 2, 3, 9};
		
		int selecionado = (int) JOptionPane.showInputDialog(null, "Escolha um item: \n \n1- Ver processos ativos \n2 - Encerrar processo ativo por NOME\n3 - Encerrar processo ativo por PIB \n9- Encerrar programa \n ", "Exercício 02", JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
		
		switch(selecionado) {
		
			case 1: metodos.listarMetodos(metodos.so());
					break;
			
			case 2: metodos.metodoKillNome(metodos.so());
					break;
			
			case 3: metodos.metodoKillPid(metodos.so());
					break;
			
			case 9:	JOptionPane.showMessageDialog(null, "Programa finalizado");
					break;
		
			default: JOptionPane.showMessageDialog(null, "Opção inválida");

		}
	}
}
