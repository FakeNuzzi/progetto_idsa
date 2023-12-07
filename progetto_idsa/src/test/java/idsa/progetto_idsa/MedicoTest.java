package idsa.progetto_idsa;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import idsa.progetto_idsa.entity.Medico;

@SpringBootTest
class MedicoTest {

    @Test
    void testEquals_SameObject() {
        Medico medico1 = new Medico(1L, "Francesco", "Resca", Date.valueOf("1999-11-05"), "RSCFNC99P11H501A", 2000.0f, "Chirurgo");
        assertTrue(medico1.equals(medico1));
    }

	
	@Test
	void testHashCode() {
		Medico medico1 = new Medico(1L, "Francesco", "Resca", Date.valueOf("1999-11-05"), "RSCFNC99P11H501A", 2000.0f, "Chirurgo");
		Medico medico2 = new Medico(1L, "Francesco", "Resca", Date.valueOf("1999-11-05"), "RSCFNC99P11H501A", 2000.0f, "Chirurgo");
		assertEquals(medico1.hashCode(), medico2.hashCode());
	}

    @Test
    void testEquals_DifferentNome() {
        Medico medico1 = new Medico(1L, "Francesco", "Resca", Date.valueOf("1999-11-05"), "RSCFNC99P11H501A", 2000.0f, "Chirurgo");
        Medico medico2 = new Medico(1L, "Different", "Resca", Date.valueOf("1999-11-05"), "RSCFNC99P11H501A", 2000.0f, "Chirurgo");
        assertFalse(medico1.equals(medico2));
    }

	@Test
	void testEquals_DifferentId_medico() {
		Medico medico1 = new Medico(1L, "Francesco", "Resca", Date.valueOf("1999-11-05"), "RSCFNC99P11H501A", 2000.0f, "Chirurgo");
		Medico medico2 = new Medico(2L, "Francesco", "Resca", Date.valueOf("1999-11-05"), "RSCFNC99P11H501A", 2000.0f, "Chirurgo");
		assertFalse(medico1.equals(medico2));
	}

    @Test
    void testEquals_DifferentCognome() {
        Medico medico1 = new Medico(1L, "Francesco", "Resca", Date.valueOf("1999-11-05"), "RSCFNC99P11H501A", 2000.0f, "Chirurgo");
        Medico medico2 = new Medico(1L, "Francesco", "Different", Date.valueOf("1999-11-05"), "RSCFNC99P11H501A", 2000.0f, "Chirurgo");
        assertFalse(medico1.equals(medico2));
    }

    @Test
    void testEquals_DifferentData_n() {
        Medico medico1 = new Medico(1L, "Francesco", "Resca", Date.valueOf("1999-11-05"), "RSCFNC99P11H501A", 2000.0f, "Chirurgo");
        Medico medico2 = new Medico(1L, "Francesco", "Resca", Date.valueOf("1999-11-06"), "RSCFNC99P11H501A", 2000.0f, "Chirurgo");
        assertFalse(medico1.equals(medico2));
    }

    @Test
    void testEquals_DifferentCf() {
        Medico medico1 = new Medico(1L, "Francesco", "Resca", Date.valueOf("1999-11-05"), "RSCFNC99P11H501A", 2000.0f, "Chirurgo");
        Medico medico2 = new Medico(1L, "Francesco", "Resca", Date.valueOf("1999-11-05"), "Different", 2000.0f, "Chirurgo");
        assertFalse(medico1.equals(medico2));
    }

	@Test
	void testEquals_DifferentStipendio() {
		Medico medico1 = new Medico(1L, "Francesco", "Resca", Date.valueOf("1999-11-05"), "RSCFNC99P11H501A", 2000.0f, "Chirurgo");
		Medico medico2 = new Medico(1L, "Francesco", "Resca", Date.valueOf("1999-11-05"), "RSCFNC99P11H501A", 3000.0f, "Chirurgo");
		assertFalse(medico1.equals(medico2));
	}

	@Test
	void testEquals_DifferentSpecializ() {
		Medico medico1 = new Medico(1L, "Francesco", "Resca", Date.valueOf("1999-11-05"), "RSCFNC99P11H501A", 2000.0f, "Chirurgo");
		Medico medico2 = new Medico(1L, "Francesco", "Resca", Date.valueOf("1999-11-05"), "RSCFNC99P11H501A", 2000.0f, "Different");
		assertFalse(medico1.equals(medico2));
	}
	

	@Test
	void testSetId_paziente(){
		Medico medico = new Medico();
		medico.setId_medico(1L);
		assertTrue(medico.getId_medico() == 1L);
	}
    @Test
    void testSetNome() {
        Medico medico = new Medico();
        medico.setNome("Francesco");
        assertEquals("Francesco", medico.getNome());
    }

    @Test
    void testSetCognome() {
        Medico medico = new Medico();
        medico.setCognome("Resca");
        assertEquals("Resca", medico.getCognome());
    }

        @Test
    void testSetData_n() {
        Date date = Date.valueOf("1999-11-05");
        Medico medico = new Medico();
        medico.setData_n(date);
        assertEquals(date, medico.getData_n());
    }

    @Test
    void testSetCf() {
        Medico medico = new Medico();
        medico.setCf("RSCFNC99P11H501A");
        assertEquals("RSCFNC99P11H501A", medico.getCf());
    }

    @Test
    void testSetStipendioo() {
        Medico medico = new Medico();
        medico.setStipendio(2000.0f);
        assertTrue(medico.getStipendio() == 2000.0f);
    }

    @Test
    void testSetSpecializzazione() {
        Medico medico = new Medico();
        medico.setSpecializ("Chirurgo");
        assertEquals("Chirurgo", medico.getSpecializ());
    }
}
