package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] opcoes = {1, 2, 9};
		
		RedesController operacoes = new RedesController();
		
		int selecionado = (int) JOptionPane.showInputDialog(null, "Escolha um item: \n1- Chamada de config do IP\n2 - Calculo do tempo médio do PING\n9- Encerrar programa", "Exercício 01", JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
		
		switch(selecionado) {
		
		case 1: operacoes.ip(operacoes.os());
			break;
			
		case 2: operacoes.ping(operacoes.os());
			break;
			
		case 9:
			JOptionPane.showMessageDialog(null, "Programa finalizado");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida");
		}
			
		
	}

}
