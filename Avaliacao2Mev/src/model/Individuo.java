package model;

import java.util.ArrayList;

import model.calcado.BotaFeminina;
import model.calcado.Sandalia;
import model.calcado.SapatoFeminino;
import model.calcado.SapatoMasculino;

public class Individuo {
	private BotaFeminina botaFem;
	private Sandalia sandalia;
	private SapatoFeminino sapatoFem;
	private SapatoMasculino sapatoMasc;
	private boolean solucaoViavel;
	
	
	/*
	 * Esse arraylist é composto por objetos de varios tipos, sao eles:
	 * 
	 * BotaFeminina, Sandalia, SapatoFeminino e SapatoMasculino
	 * 
	 * pos0 = Sandalia (e seus atributos)
	 * pos1 = SapatoFemino (e seus atributos)
	 * pos2 = SapatoMasculino (e seus atributos)
	 * pos3 = BotaFeminina (e seus atributos)
	 * 
	 * */
	public ArrayList<Object> cromossomo = new ArrayList<Object>();																	
	 																	
	
	int custoTotal;
	int tempoTotal;
	int lucroTotal;
	

	private int fitness;
	private double probabilidade;
	
	public void calculaFitness(ArrayList<Individuo> listaInds) {
		for (Individuo ind : listaInds) {
			
			int fit = ind.getLucroTotal() - ind.getCustoTotal() - ind.getTempoTotal();
			
			fit = fit*(-1);
			
			ind.setFitness(fit);
		}
		
	}
	
	public void populaIndividuo() {
		custoTotal = sandalia.getCustoProducao()+sapatoFem.getCustoProducao()+sapatoMasc.getCustoProducao()+botaFem.getCustoProducao();
		tempoTotal = sandalia.getTempoProducao()+sapatoFem.getTempoProducao()+sapatoMasc.getTempoProducao()+botaFem.getTempoProducao();
		lucroTotal = sandalia.getLucro()+sapatoFem.getLucro()+sapatoMasc.getLucro()+botaFem.getLucro();
		
		cromossomo.add(sandalia);
		cromossomo.add(sapatoFem);
		cromossomo.add(sapatoMasc);
		cromossomo.add(botaFem);
		
	}
	
	public BotaFeminina getBotaFem() {
		return botaFem;
	}
	public void setBotaFem(BotaFeminina botaFem) {
		this.botaFem = botaFem;
	}
	public Sandalia getSandalia() {
		return sandalia;
	}
	public void setSandalia(Sandalia sandalia) {
		this.sandalia = sandalia;
	}
	public SapatoFeminino getSapatoFem() {
		return sapatoFem;
	}
	public void setSapatoFem(SapatoFeminino sapatoFem) {
		this.sapatoFem = sapatoFem;
	}
	public SapatoMasculino getSapatoMasc() {
		return sapatoMasc;
	}
	public void setSapatoMasc(SapatoMasculino sapatoMasc) {
		this.sapatoMasc = sapatoMasc;
	}
	
	public double getProbabilidade() {
		return probabilidade;
	}

	public void setProbabilidade(double probabilidade) {
		this.probabilidade = probabilidade;
	}
	
	
	

	
	public int getCustoTotal() {
		return custoTotal;
	}
	
	public void setCustoTotal(int custoTotal) {
		this.custoTotal = custoTotal;
	}
	
	public int getTempoTotal() {
		return tempoTotal;
	}
	
	public void setTempoTotal(int tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
	
	public int getLucroTotal() {
		return lucroTotal;
	}
	
	public void setLucroTotal(int lucroTotal) {
		this.lucroTotal = lucroTotal;
	}
	
	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	public boolean isSolucaoViavel() {
		return solucaoViavel;
	}

	public void setSolucaoViavel(boolean solucaoViavel) {
		this.solucaoViavel = solucaoViavel;
	}
	
	
	
	@Override
	public String toString() {
		
		String msg = "============= Totais para a solução ==========\n";
			  msg += "";
			  msg += "Custo total: "+getCustoTotal()+"\n";
			  msg += "Tempo total: "+getTempoTotal()+"\n";
			  msg += "Lucro total: "+getLucroTotal()+"\n";
			  msg += "Fitness: "+getFitness()+"\n";
			  
		return msg;
	}
	
	public void verificaViabilidade() {
		if(custoTotal > 50000) {
			//System.err.println("\nSolução não viável! Custo maior que 50 mil!");
			setSolucaoViavel(false);
		}
		else if(tempoTotal > 10000) {
			//System.err.println("\nSolução não viável! Tempo de produção maior que 10 mil!");
			setSolucaoViavel(false);
		}
		else {
			//System.out.println("\nSolução viável!");
			setSolucaoViavel(true);
		}
	}
	
}
