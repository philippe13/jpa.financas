package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financa.modelo.Conta;
import br.com.caelum.financa.modelo.TipoMovimentacao;

public class MovimentacaoDao {
	
	private EntityManager manager;

	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;
	}

	public Double mediaDaContaPeloTipo(Conta conta, TipoMovimentacao tipo) {
		
		TypedQuery<Double> query = manager.
				createNamedQuery("mediaDaContaPeloTipoMovimentacao", Double.class);
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
		
		Double media = query.getSingleResult();
		return media;
	}
}
