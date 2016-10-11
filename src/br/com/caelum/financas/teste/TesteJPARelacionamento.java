package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financa.modelo.Conta;
import br.com.caelum.financa.modelo.Movimentacao;
import br.com.caelum.financa.modelo.TipoMovimentacao;
import br.com.caelum.financa.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {

		double inicio = System.currentTimeMillis();

		Conta conta = new Conta();
		conta.setTitular("Amanda");
		conta.setBanco("Bradesco");
		conta.setAgencia("777");
		conta.setNumero("11111");

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("134.9"));
		
		movimentacao.setConta(conta);
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		
	
			em.getTransaction().begin();
			
			em.persist(conta);
			
			em.persist(movimentacao);
			
				
			em.getTransaction().commit();
		em.close();

		

	}
}
