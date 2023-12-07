package idsa.progetto_idsa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import idsa.progetto_idsa.entity.Paziente;

@SpringBootTest
class PazienteTest {

    @Test
    void testEquals_SameObject() {
        Paziente paziente1 = new Paziente(1L, "Franco", "Ancona", Date.valueOf("1990-11-05"), "NCNFRN90P05H501A");
        assertTrue(paziente1.equals(paziente1));
    }

    @Test
    void testEquals_DifferentNome() {
        Paziente paziente1 = new Paziente(1L, "Franco", "Ancona", Date.valueOf("1990-11-05"), "NCNFRN90P05H501A");
        Paziente paziente2 = new Paziente(1L, "Different", "Ancona", Date.valueOf("1990-11-05"), "NCNFRN90P05H501A");
        assertFalse(paziente1.equals(paziente2));
    }

    @Test
    void testEquals_DifferentCognome() {
        Paziente paziente1 = new Paziente(1L, "Franco", "Ancona", Date.valueOf("1990-11-05"), "NCNFRN90P05H501A");
        Paziente paziente2 = new Paziente(1L, "Franco", "Different", Date.valueOf("1990-11-05"), "NCNFRN90P05H501A");
        assertFalse(paziente1.equals(paziente2));
    }

    @Test
    void testEquals_DifferentData_n() {
        Paziente paziente1 = new Paziente(1L, "Franco", "Ancona", Date.valueOf("1990-11-05"), "NCNFRN90P05H501A");
        Paziente paziente2 = new Paziente(1L, "Franco", "Ancona", Date.valueOf("1990-11-06"), "NCNFRN90P05H501A");
        assertFalse(paziente1.equals(paziente2));
    }

    @Test
    void testEquals_DifferentCf() {
        Paziente paziente1 = new Paziente(1L, "Franco", "Ancona", Date.valueOf("1990-11-05"), "NCNFRN90P05H501A");
        Paziente paziente2 = new Paziente(1L, "Franco", "Ancona", Date.valueOf("1990-11-05"), "Different");
        assertFalse(paziente1.equals(paziente2));
    }

	@Test
	void testSetId_paziente(){
		Paziente paziente = new Paziente();
		paziente.setId_paziente(1L);
		assertEquals(1L, paziente.getId_paziente());
	}
	
	@Test	
	void testSetNome() {
		Paziente paziente = new Paziente();
		paziente.setNome("Franco");
		assertEquals("Franco", paziente.getNome());
	}

	@Test
	void testSetCognome() {
		Paziente paziente = new Paziente();
		paziente.setCognome("Ancona");
		assertEquals("Ancona", paziente.getCognome());
	}

	@Test
	void testSetData_n() {
		Date date = Date.valueOf("1990-11-05");
		Paziente paziente = new Paziente();
		paziente.setData_n(date);
		assertEquals(date, paziente.getData_n());
	}

	@Test
	void testSetCf() {
		Paziente paziente = new Paziente();
		paziente.setCf("NCNFRN90P05H501A");
		assertEquals("NCNFRN90P05H501A", paziente.getCf());
	}
}