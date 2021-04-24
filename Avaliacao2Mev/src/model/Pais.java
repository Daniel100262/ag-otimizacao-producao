package model;

import java.util.ArrayList;
import java.util.Random;

import model.calcado.BotaFeminina;
import model.calcado.Sandalia;
import model.calcado.SapatoFeminino;
import model.calcado.SapatoMasculino;

public class Pais {

	public ArrayList<Individuo> individuos = new ArrayList<Individuo>(); //Preenchido com pais sorteados pela roleta
	
	
	
	public void populaListaPais(int qtPais, Roleta roleta) { //qtPais é qtInds/2 e roleta é uma roleta já com os inds gerados
		int qtInseridos = 0;
		while (qtInseridos < qtPais) {
			Individuo pai = roleta.sorteia();
			individuos.add(pai);
			qtInseridos++;
		}
	}
	
	public Populacao reproduz(int tamCromossomo) {
		Populacao p = new Populacao();
		p.individuos.addAll(individuos); //Preenche populacao com 8 pais (enviados da main), os prox 8 serao filhos
		
		Random r = new Random();
		int posCross = r.nextInt(tamCromossomo); //Crossover (corte) em posicao aleatoria
		
		int pos = 0;
		
		while (pos < individuos.size()-1) {
			Individuo pai1 = individuos.get(pos);
			Individuo pai2 = individuos.get(pos+1);
			
			//System.out.println("\n*************** Fazendo a reprodução ****************\n");
			
			//System.out.println("\n====== Pai 1 ========\n");
			//System.out.println(pai1);
			
			//System.out.println("\n====== Pai 2 ========\n");
			//System.out.println(pai2);
		
			ArrayList<Individuo> indsFilhos = fazCrossover(posCross, pai1, pai2);
			
			p.individuos.add(indsFilhos.get(0));
			
			//System.out.println("\n====== Filho 1 ========\n");
			//indsFilhos.get(0).toString();
			
			p.individuos.add(indsFilhos.get(1));
			
			//System.out.println("\n====== Filho 2 ========\n");
			//indsFilhos.get(1).toString();
			
			pos += 2;
		}
		

		return p;
	}
	
	/* 
	 * posCrossover = 2
	 * pai1 = 10 Botas, 15 Sandalias,8 sapatos femininos e 12 sapatos masculinos
	 * pai2 = 12 Botas, 25 Sandalias,5 sapatos femininos e 8 sapatos masculinos
	 * 
	 * 
	 * for pos in pai1 until posAteCorte(2) -- 
	 * 										 |-> filho1.set(pos1) = pai1.get(pos1)
	 * 											 filho1.set(pos2) = pai1.get(pos2)
	 * 											 filho1.set(pos3) = pai2.get(pos3)
	 *  										 filho1.set(pos4) = pai2.get(pos4)
	 *  										 
	 *  										 filho2.set(pos1) = pai2.get(pos1)
	 * 											 filho2.set(pos2) = pai2.get(pos2)
	 * 											 filho2.set(pos3) = pai1.get(pos3)
	 *  										 filho2.set(pos4) = pai1.get(pos4)
	 * 
	 * filho1 = 10 Botas, 15 Sandalias,5 sapatos femininos e 8 sapatos masculinos
	 * filho2 = 12 Botas, 25 Sandalias,8 sapatos femininos e 12 sapatos masculinos
	 *  
	 * */
	
	public ArrayList<Individuo> fazCrossover(int posCrossover, Individuo pai1, Individuo pai2) {
		ArrayList<Individuo> filhos = new ArrayList<Individuo>();
		
		Individuo f1 = new Individuo();
		Individuo f2 = new Individuo();
		
		for (int i = 0; i < posCrossover; i++) {
			//f1.cromossomo.set(i, pai1.cromossomo.get(i));
			f1.cromossomo.add(i, pai1.cromossomo.get(i));
			
			//f2.cromossomo.set(i, pai2.cromossomo.get(i));
			f2.cromossomo.add(i, pai2.cromossomo.get(i));
		}
		
		for (int i = posCrossover; i < pai1.cromossomo.size(); i++) {
			//f1.cromossomo.set(i, pai2.cromossomo.get(i));
			f1.cromossomo.add(i, pai2.cromossomo.get(i));
			
			//f2.cromossomo.set(i, pai2.cromossomo.get(i));
			f2.cromossomo.add(pai1.cromossomo.get(i));
		}
		
		f1.setSandalia((Sandalia) f1.cromossomo.get(0));
		f1.setSapatoFem((SapatoFeminino) f1.cromossomo.get(1));
		f1.setSapatoMasc((SapatoMasculino) f1.cromossomo.get(2));
		f1.setBotaFem((BotaFeminina) f1.cromossomo.get(3));
		f1.populaIndividuo();
		
		f2.setSandalia((Sandalia) f2.cromossomo.get(0));
		f2.setSapatoFem((SapatoFeminino) f2.cromossomo.get(1));
		f2.setSapatoMasc((SapatoMasculino) f2.cromossomo.get(2));
		f2.setBotaFem((BotaFeminina) f2.cromossomo.get(3));
		f2.populaIndividuo();
		
		filhos.add(f1);
		filhos.add(f2);
		
		return filhos;
	}
	
}
