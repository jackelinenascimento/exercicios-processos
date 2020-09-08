package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] opcoes = {01, 02};
		
		RedesController operacoes = new RedesController();
		
		int selecionado = (int) JOptionPane.showInputDialog(null, "Escolha um item: \n1- Chamada de config do IP\n2 - Calculo do tempo médio do PING: ", "Exercício 01", JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
		
		switch(selecionado) {
		case 1:
			JOptionPane.showMessageDialog(null, operacoes.ip(operacoes.os()));
			break;
		case 2:
			JOptionPane.showMessageDialog(null, operacoes.ping(operacoes.os()));
			break;
		case 0:
			break;
		}
	}

}
