package model;

import java.util.ArrayList;

import model.calcado.BotaFeminina;
import model.calcado.Sandalia;
import model.calcado.SapatoFeminino;
import model.calcado.SapatoMasculino;

public class Populacao {
	public ArrayList<Individuo> individuos = new ArrayList<Individuo>();
	
	
	public ArrayList<Individuo> geraIndividuosPopulacao(int qntInd) {
		ArrayList<Individuo> listaInds = new ArrayList<Individuo>();
		for (int i = 0; i < qntInd; i++) {
			
			Individuo ind = new Individuo();
			
			ind.setBotaFem(new BotaFeminina(BotaFeminina.sortQtd()));
			ind.setSandalia(new Sandalia(Sandalia.sortQtd()));
			ind.setSapatoFem(new SapatoFeminino(SapatoFeminino.sortQtd()));
			ind.setSapatoMasc(new SapatoMasculino(SapatoMasculino.sortQtd()));
			
			ind.populaIndividuo();
			
			
			ind.verificaViabilidade();
			if(ind.isSolucaoViavel()) {
				listaInds.add(ind);
				individuos.add(ind);
				//ind.cromossomo.add(ind); --> parado de preencher com individuos e começado a preencher com cromossomos
				
			} else {
				i--;
			}
			
		}
		
		return listaInds;
	}
	
	
	public int menorFitnessPopulacao() {
		int menor = individuos.get(0).getFitness();
		for (Individuo ind : individuos) {
			if(ind.getFitness() < menor)
				menor = ind.getFitness();
		}
		return menor;
	}
	
	
	
	public int somaFitnessPopulacao() {
		int soma = 0;
		for (Individuo ind : individuos) {
			soma += ind.getFitness();
		}
		return soma;
	}
	
	public void calculaProbabilidades(){
		int soma = somaFitnessPopulacao();
		int menor = menorFitnessPopulacao();
		for (Individuo ind : individuos) {
			int temp = ind.getFitness() - menor; //Formula mostrada em aula que faz parte da teoria de AG (slide 16)
			temp = temp == 0 ? 1 : temp; // Impede fitness zerado, onde tiver atribui 1
			ind.setProbabilidade(((double)temp/(double)soma) * 100.0);
		}
	}

}
