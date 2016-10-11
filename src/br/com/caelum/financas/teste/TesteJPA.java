package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financa.modelo.Conta;
import br.com.caelum.financa.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {

		double inicio = System.currentTimeMillis();

		Conta conta = new Conta();
		conta.setTitular("Rita");
		conta.setBanco("Bradesco");
		conta.setAgencia("222");
		conta.setNumero("44544");

		EntityManager em = new JPAUtil().getEntityManager();
		
		
		em.getTransaction().begin();
			//persist estado transient
			//em.persist(conta);
		
			//só é possível remover se a entidade esta no estado managed, para isso usando o find
			/*Conta contaARemover = em.find(Conta.class, 1);
			em.remove(contaARemover);*/
		
			em.persist(conta);
			
			//conta.setTitular("Philippe");
			
		/*	conta.setTitular("Pedro Pedrinho");
		 * merge estado detached
			em.merge(conta);*/
			
			em.getTransaction().commit();
		em.close();

		double fim = System.currentTimeMillis();
		System.out.println("Executa em: " + (fim - inicio) / 1000 + "s");

	}
}
