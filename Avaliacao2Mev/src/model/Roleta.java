package model;

import java.util.ArrayList;
import java.util.Random;

public class Roleta {
	int tamRoleta;
	Populacao populacao;

	ArrayList<Double> posicoes = new ArrayList<Double>();
	
	public Roleta(Populacao p) {
		populacao = p;
		criaRoleta();
	}
	
	public void criaRoleta() {
		int qt=0;
		for (Individuo ind : populacao.individuos) {
			double posInd = ind.getProbabilidade();
			if(qt == 0) { //Se for o primeiro da lista
				posicoes.add(posInd); //Adiciona
			} else { //senao
				posicoes.add(posicoes.get(qt-1) + posInd); //Soma a probabilidade do individuo atual com o anterior
			}
			qt++;
		}
	}
	

	
	public Individuo sorteia() {
		
		Random nroAleatorio = new Random();
		String nroAnterior = posicoes.get(posicoes.size()-1)+"";
		
		nroAnterior  = nroAnterior.substring(0, nroAnterior.indexOf("."));
	
		
		if(populacao.somaFitnessPopulacao() <= 0) {
			System.err.println("\n\nErro: A soma dos fitness da população deu negativa! Fechando programa.");
			System.exit(-1);
		}
		
		//int nrSorteado = nroAleatorio.nextInt(fitnessSomado);
		
		System.out.println("\n\nA soma dos fitness deu: "+populacao.somaFitnessPopulacao());
		
		int nrSorteado = nroAleatorio.nextInt(Integer.parseInt(nroAnterior));
		
		//System.out.println("\n\nA soma dos fitness deu: "+populacao.somaFitnessPopulacao());
		//System.out.println("\nNro sorteado: "+nrSorteado);
		
		int qt = 0;
		while(posicoes.get(qt) < nrSorteado) {
			//System.out.println("\nO nro "+posicoes.get(qt)+" é menor que o nro "+nrSorteado);
			if(qt < posicoes.size()-1) {
				//System.out.println("O QT era: "+qt);
				qt++;
				//System.out.println("O QT agora é: "+qt+"\n");
			}
		}
		
		return populacao.individuos.get(qt > 0 ? qt-1 : qt);
	}
	
	
	
}
