package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import br.com.caelum.financa.modelo.Conta;
import br.com.caelum.financa.modelo.Movimentacao;
import br.com.caelum.financa.util.JPAUtil;

public class TesteMovimentacaoConta {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		/*Movimentacao movimentacao = em.find(Movimentacao.class, 2);
		
		System.out.println("Titular da conta: " + movimentacao.getConta().getTitular());*/
	
	    /*Conta conta = em.find(Conta.class, 4);
		System.out.println(conta.getMovimentacoes().size());*/
		
		Query query = em.createQuery("select c from Conta c join fetch c.movimentacoes");
		List<Conta> contas = query.getResultList();
		
		for (Conta conta : contas) {
			System.out.println("Número de movimentações: " + conta.getMovimentacoes().size());
		}
		
		
	}
}
