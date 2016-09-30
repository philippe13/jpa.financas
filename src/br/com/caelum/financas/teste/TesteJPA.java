package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financa.modelo.Conta;
import br.com.caelum.financa.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {

		double inicio = System.currentTimeMillis();

		/*Conta conta = new Conta();
		conta.setTitular("Amanda");
		conta.setBanco("Bradesco");
		conta.setAgencia("777");
		conta.setNumero("11111");*/

		EntityManager em = new JPAUtil().getEntityManager();
		
	
		em.getTransaction().begin();

			// em.persist(conta);
			Conta conta = em.find(Conta.class, 1);
		
			System.out.println(conta.getTitular());
			
			conta.setTitular("Pedro Pedrinho");
			/*em.merge(conta);*/
			
			em.getTransaction().commit();
		em.close();

		double fim = System.currentTimeMillis();
		System.out.println("Executa em: " + (fim - inicio) / 1000 + "s");

	}
}
