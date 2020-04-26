package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.Pais;
import service.PaisService;

public class PaisTest {
	Pais pais, copia;
	PaisService paisService;
	static int id = 0;

	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais();
		pais.setId(id);
		pais.setNome("Filipinas");
		pais.setPopulacao(Long.valueOf("107208000"));
		pais.setArea(Double.valueOf(300000));
		copia = new Pais();
		copia.setId(id);
		copia.setNome("Egito");
		copia.setPopulacao(Long.valueOf("98313500"));
		copia.setArea(Double.valueOf(1010000));
		paisService = new PaisService();
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}

	@Test
	public void testCriar() {
		System.out.println("criar");
		id = paisService.criar(pais);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);
	}

	@Test
	public void testCarregar() {
		System.out.println("carregar");
		Pais fixture = new Pais();
		fixture.setId(1);
		fixture.setNome("Turquia");
		fixture.setPopulacao(Long.valueOf("82003882"));
		fixture.setArea(Double.valueOf(783562));
		PaisService novoService = new PaisService();
		Pais novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void testAtualizar() {
		System.out.println("atualizar");
		pais.setPopulacao(Long.valueOf("126320000"));
		copia.setArea(Double.valueOf(98313500));
		paisService.atualizar(pais);
		pais = paisService.carregar(pais.getId());
		assertEquals("testa atualizacao", pais, copia);
	}

	@Test
	public void testExcluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao((Long) null);
		copia.setArea((Double) null);
		paisService.excluir(pais);
		pais = paisService.carregar(id);
		assertEquals("testa exclusao", pais, copia);
	}
}