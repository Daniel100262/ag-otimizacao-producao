package main;

import java.util.ArrayList;

import model.Individuo;
import model.Pais;
import model.Populacao;
import model.Roleta;

public class Main2 {

	public static void main(String[] args) {
		
		ArrayList<Individuo> listaInds = new ArrayList<Individuo>(); //array p/ armazenar inds(solucoes) gerados aleatoriamente
		
		Populacao pop = new Populacao(); //Conjunto de inds gerados
		int qtPorGeracao = 16; //Max de individuos gerados por geracao (pai, filho, neto). Sera o dobro do nro de pais
		
		listaInds = pop.geraIndividuosPopulacao(qtPorGeracao); //Gera aleatoriamente inds
		
		//Calcular fitness de todos os individuos
		for (Individuo ind : listaInds) {
			ind.calculaFitness(listaInds);
			//System.out.println("Ind impresso do mostraIndividuosGerados: "+ind);
		}
		
		pop.calculaProbabilidades(); //Calcula probabilidades p/ usar na roleta
		
		for (int i = 0; i < 10; i++) {
			Roleta roleta = new Roleta(pop); //Cria uma roleta com a populacao e suas probabilidades
			Pais pais = new Pais(); 
			pais.populaListaPais(qtPorGeracao/2, roleta); //Seleciona os pais usando a roleta (com metade da quantidade de inds).
			pop = pais.reproduz(4); // Cromossomo é composto por 4 genes
			for (Individuo filho : pop.individuos) {
				pop.calculaProbabilidades();
				filho.calculaFitness(listaInds);
			}
		}
		mostraIndividuosGerados(listaInds); //Na hora de mostrar ele calcula o fitness
		
	}
	
	public static void mostraIndividuosGerados(ArrayList<Individuo> listaInds) {
		for (Individuo ind : listaInds) {
			ind.calculaFitness(listaInds);
			System.out.println("Ind impresso do mostraIndividuosGerados: "+ind);
		}
	}

}
