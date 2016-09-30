package br.com.caelum.financas.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financa.modelo.Conta;
import br.com.caelum.financa.modelo.Movimentacao;
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
		movimentacao.setDescricao();
		EntityManager em = new JPAUtil().getEntityManager();
		
	
		em.getTransaction().begin();
		
		em.persist(conta);
		
			
		em.getTransaction().commit();
		em.close();

		double fim = System.currentTimeMillis();
		System.out.println("Executa em: " + (fim - inicio) / 1000 + "s");

	}
}
