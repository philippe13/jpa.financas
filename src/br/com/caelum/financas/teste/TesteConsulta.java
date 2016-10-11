package br.com.caelum.financas.teste;


import java.util.List;
import javax.persistence.Query;

import javax.persistence.EntityManager;


import br.com.caelum.financa.modelo.Conta;
import br.com.caelum.financa.modelo.Movimentacao;
import br.com.caelum.financa.util.JPAUtil;

public class TesteConsulta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(4);
		
		Query query = (Query) em.createQuery("select m from Movimentacao m where m.conta.id=:pConta");
		
		/*Positional Parameter Notation
		query.setParameter(1, conta);*/
		
		//Name Parameter Notation
		query.setParameter("pConta", conta);
		
		List<Movimentacao> movimentacoes = query.getResultList();
	
		for (Movimentacao m : movimentacoes) {
			System.out.println("\nDescricao:" + m.getDescricao());
			System.out.println("Valor:" + m.getValor());
			
		}
	}	

}
