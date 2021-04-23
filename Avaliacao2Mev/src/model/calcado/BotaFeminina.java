package model.calcado;

import java.util.Random;

public class BotaFeminina {
	private int materiaPrima=1;
	private int custoProducao=150;
	private int tempoProducao=25;
	private int lucro=90;
	private int quantidade;
	
	
	public BotaFeminina(int qnt) {
		quantidade = qnt;
	}

	public int getMateriaPrima() {
		return materiaPrima*quantidade;
	}
	
	public int getCustoProducao() {
		return custoProducao*quantidade;
	}
	
	public int getTempoProducao() {
		return tempoProducao*quantidade;
	}
	
	public int getLucro() {
		return lucro*quantidade;
	}

	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/*
	 * Este metodo sorteia um nro de 0 a 333
	 * que daria um total de custo max de 4950
	 * e tempo de producao de 8325
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
		
		String msg = "Nome: Bota Feminina"+"\n"+
					 "Quantidade: "+getQuantidade()+"\n"+
					 "Materia prima: "+getMateriaPrima()+"\n"+
					 "Custo de produção: "+getCustoProducao()+"\n"+
					 "Tempo de produção: "+getTempoProducao()+"\n"+
					 "Lucro total: "+getLucro();
		
		
		return msg;
	}
	
}
