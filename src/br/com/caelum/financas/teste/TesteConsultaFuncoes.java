package br.com.caelum.financas.teste;


import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;


import br.com.caelum.financa.modelo.Conta;
import br.com.caelum.financa.modelo.Movimentacao;
import br.com.caelum.financa.modelo.TipoMovimentacao;
import br.com.caelum.financa.util.JPAUtil;
import br.com.caelum.financas.dao.MovimentacaoDao;




public class TesteConsultaFuncoes {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(1);
		
		MovimentacaoDao dao = new MovimentacaoDao(em);
		
		Double media = dao.mediaDaContaPeloTipo(conta, TipoMovimentacao.ENTRADA);
		System.out.println(media);
		
	}	

}
