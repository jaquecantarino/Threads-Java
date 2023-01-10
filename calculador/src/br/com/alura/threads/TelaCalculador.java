package br.com.alura.threads;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCalculador {
	
	public static void main(String[] args) {
		
		JFrame janela = new JFrame("Multiplicação Demorada");

		JTextField primeiro = new JTextField(10);
		JTextField segundo = new JTextField(10);
		JButton botao = new JButton(" = ");
		JLabel resultado = new JLabel("           ?          ");
		
		//quando clica no botão será executado a classe Multiplicador
		botao.addActionListener(new AcaoBotao(primeiro, segundo, resultado));
		
		JPanel painel = new JPanel();
		painel.add(primeiro);
		painel.add(new JLabel("x"));
		painel.add(segundo);
		painel.add(botao);
		painel.add(resultado);
		
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);
		
		//exercicio: Crie uma classe que imprime no console uma String a partir de uma nova Thread! Chame a tarefa ImprimeString.
		String texto = "Mostrando a Nova Thread! Exercicio ImprimeString"; //criando o atribuito que será usado de parametro no objeto
		ImprimeString imprime = new ImprimeString(texto); //instanciando o objeto
		Thread exercicio = new Thread(imprime,"threadExercicio");//instanciando a thread
		exercicio.start();//iniciando a thread
	}
}
