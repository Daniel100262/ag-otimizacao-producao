package model.calcado;

import java.util.Random;

public class SapatoFeminino {
	private int materiaPrima=1;
	private int custoProducao=120;
	private int tempoProducao=28;
	private int lucro=50;
	private int quantidade;
	
	
	public SapatoFeminino(int qnt) {
		quantidade = qnt;
	}
	
	public int getMateriaPrima() {
		return materiaPrima;
	}
	
	public int getCustoProducao() {
		return custoProducao;
	}
	
	public int getTempoProducao() {
		return tempoProducao;
	}
	
	public int getLucro() {
		return lucro;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	/*
	 * Este metodo sorteia um nro de 0 a 357
	 * que daria um total de custo max de 42840
	 * e tempo de producao de 9996
	 * 
	 * */
	public static int sortQtd() {
		Random r = new Random();
		int nroSorteado;
		
		nroSorteado = r.nextInt(358); //501 pq tem que dar 500 (500x100 = 50k)
		
		return nroSorteado;
	}
	
	
	
	
	@Override
	public String toString() {
		
		String msg = "Nome: Sapato Feminino"+"\n"+
					 "Quantidade: "+getQuantidade()+"\n"+
					 "Materia prima: "+getMateriaPrima()+"\n"+
					 "Custo de produção: "+getCustoProducao()+"\n"+
					 "Tempo de produção: "+getTempoProducao()+"\n"+
					 "Lucro total: "+getLucro();
		
		
		return msg;
	}
}
