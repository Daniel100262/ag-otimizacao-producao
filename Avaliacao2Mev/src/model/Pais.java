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
	
	
	//public Individuo fazCrossover(int posCrossover, Pais pai1, Pais pai2) {
	
	//}
	
}
