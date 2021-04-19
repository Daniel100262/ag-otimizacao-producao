package main;

import java.util.ArrayList;

import model.Individuo;
import model.Populacao;
import model.Roleta;


/*=================  Definições  ================
 * 
 * Gene: cada gene é uma característica de um cromossomo
 * Ex: Lucro 
 * 
 * Cromossomo: Cada cromossomo é um tipo de calçado
 * Ex: Sandalia
 * 
 * Individuo: Cada individuo é um conjunto de cromossomos (uma das muitas possíveis soluções p/ o problema)
 * Ex: 10 Botas, 15 Sandalias,8 sapatos femininos e 12 sapatos masculinos
 * 
 * População: Cada população é um conjunto de individuos
 * Ex: Ind01, Ind02 e Ind03 fazem parte da geração (e populacao) pai
 *     Ind03, Ind04 e Ind05 fazem parte da geração (e população) filho01
 * 
 * 
 * */



public class Principal {
	
	
	
	
	public static void main(String[] args) {
		
		ArrayList<Individuo> listaInds = new ArrayList<Individuo>();
		
		//listaInds = geraIndividuosPopulacao(5);
		
		Populacao pop = new Populacao();
		
		listaInds = pop.geraIndividuosPopulacao(5);
		
		mostraIndividuosGerados(listaInds);
		
		Roleta roleta = new Roleta(pop);
		
		Individuo indSorteado = roleta.sorteia();
		
		System.out.println("Ind Sorteado: "+indSorteado);
		
	}
	

	
	
	public static void mostraIndividuosGerados(ArrayList<Individuo> listaInds) {
		for (Individuo ind : listaInds) {
			ind.calculaFitness(listaInds);
			System.out.println(ind);
		}
	}
	
	
}
