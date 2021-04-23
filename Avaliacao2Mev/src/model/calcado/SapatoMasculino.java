package model.calcado;

import java.util.Random;


public class SapatoMasculino {
	private int materiaPrima=1;
	private int custoProducao=120;
	private int tempoProducao=30;
	private int lucro=80;
	private int quantidade;
	
	
	public SapatoMasculino(int qnt) {
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
	 * Este metodo sorteia um nro de 0 a 333
	 * que daria um total de custo de 39960
	 * e tempo de producao de 9990
	 * 
	 * */
	public static int sortQtd() {
		Random r = new Random();
		int nroSorteado;
		
		nroSorteado = r.nextInt(334);
		
		return nroSorteado;
	}
	
	
	@Override
	public String toString() {
		
		String msg = "Nome: Sapato Masculino"+"\n"+
					 "Quantidade: "+getQuantidade()+"\n"+
					 "Materia prima: "+getMateriaPrima()+"\n"+
					 "Custo de produção: "+getCustoProducao()+"\n"+
					 "Tempo de produção: "+getTempoProducao()+"\n"+
					 "Lucro total: "+getLucro();
		
		
		return msg;
	}
	
}
