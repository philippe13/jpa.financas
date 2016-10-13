package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financa.modelo.Movimentacao;
import br.com.caelum.financa.util.JPAUtil;

public class TesteMovimentacaoConta {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 1);
		
		System.out.println("Titula da conta" + movimentacao.getConta().getTitular());
	}
}
