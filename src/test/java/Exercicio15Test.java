import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.exer15.DecisionMaker;
import br.com.exer15.Usuario;

class Exercicio15Test {

	@Test
	void testShowAd_UserActive_NoRecentAd_LessThan1000Followers() {
		Usuario user = new Usuario(500, false, false);
		DecisionMaker decisionMaker = new DecisionMaker();
		boolean result = decisionMaker.mostrarAnuncio(user, true);
		assertTrue(result);
	}

	@Test
	void testShowAd_UserActive_NoRecentAd_MoreThan1000Followers() {
		Usuario user = new Usuario(1500, false, false);
		DecisionMaker decisionMaker = new DecisionMaker();
		boolean result = decisionMaker.mostrarAnuncio(user, true);
		assertTrue(result);
	}

	@Test
	void testShowAd_UserActive_RecentAd_LessThan1000Followers() {
		Usuario user = new Usuario(800, false, true);
		DecisionMaker decisionMaker = new DecisionMaker();
		boolean result = decisionMaker.mostrarAnuncio(user, true);
		assertFalse(result);
	}

	@Test
	void testShowAd_UserActive_RecentAd_MoreThan1000Followers() {
		Usuario user = new Usuario(1200, false, true);
		DecisionMaker decisionMaker = new DecisionMaker();
		boolean result = decisionMaker.mostrarAnuncio(user, true);
		assertFalse(result);
	}

}
