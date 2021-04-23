package model;

import java.util.ArrayList;
import java.util.Random;

public class Pais {

	public ArrayList<Individuo> individuos = new ArrayList<Individuo>();
	
	public void populaListaPais(int qtPais, Roleta roleta) {
		int qtInseridos = 0;
		while (qtInseridos < qtPais) {
			Individuo pai = roleta.sorteia();
			individuos.add(pai);
			qtInseridos++;
		}
	}
	
	public Populacao reproduz(int tamCromossomo) {
		Populacao p = new Populacao();
		p.individuos.addAll(individuos);
		
		
		
		Random r = new Random();
		int posCross = r.nextInt(tamCromossomo);
		
		
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
	
	public ArrayList<Individuo> fazCrossover(int posCrossover, Pais pai1, Pais pai2) {
		ArrayList<Individuo> filhos = new ArrayList<Individuo>();
		
		Individuo f1 = new Individuo();
		Individuo f2 = new Individuo();
		
		for (int i = 0; i < posCrossover; i++) {
			f1.cromossomo.set(i, pai1.individuos.get(i));
			f2.cromossomo.set(i, pai2.individuos.get(i));
		}
		
		for (int i = posCrossover; i < pai1.individuos.size(); i++) {
			f1.cromossomo.set(i, pai2.individuos.get(i));
			f2.cromossomo.set(i, pai1.individuos.get(i));
		}
		
		
		
		return filhos;
	}
	
}
