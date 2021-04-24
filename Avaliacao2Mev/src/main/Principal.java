package main;

import java.util.ArrayList;

import model.Individuo;
import model.Pais;
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
		
		ArrayList<Individuo> listaInds = new ArrayList<Individuo>(); //array p/ armazenar inds(solucoes) gerados aleatoriamente
		
		//listaInds = geraIndividuosPopulacao(5);
		
		Populacao pop = new Populacao(); //Conjunto de inds gerados
		int qtPorGeracao = 16; //Max de individuos gerados por geracao (pai, filho, neto). Sera o dobro do nro de pais
		
		listaInds = pop.geraIndividuosPopulacao(qtPorGeracao); //Gera aleatoriamente inds
		
		mostraIndividuosGerados(listaInds); //Na hora de mostrar ele calcula o fitness
		
		pop.calculaProbabilidades(); //Calcula probabilidades p/ usar na roleta
		Roleta roleta = new Roleta(pop); //Cria uma roleta com a populacao e suas probabilidades
		Pais pais = new Pais(); 
		pais.populaListaPais(qtPorGeracao/2, roleta); //Seleciona os pais usando a roleta (com metade da quantidade de inds).
		
		int idPai=0; //Apenas para enumerar os pais gerados e facilitar a contagem.
		
		for (Individuo ind : pais.individuos) {
			idPai++;
			System.out.println("Pai ID: "+idPai+" gerado!\n"+ind);
		}
		
		System.out.println("************************ Daqui pra frente só filhos ************************");
		//pais.reproduz(4); // Cromossomo é composto por 4 genes
		
		Populacao nova = pais.reproduz(4); // Cromossomo é composto por 4 genes
		
		for (Individuo filho : nova.individuos) {
			System.out.println(filho);
		}
	}
	
	public static void mostraIndividuosGerados(ArrayList<Individuo> listaInds) {
		for (Individuo ind : listaInds) {
			ind.calculaFitness(listaInds);
			System.out.println("Ind impresso do mostraIndividuosGerados: "+ind);
		}
	}
	
}
