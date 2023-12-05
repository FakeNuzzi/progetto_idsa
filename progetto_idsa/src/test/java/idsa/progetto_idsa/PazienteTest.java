package idsa.progetto_idsa;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.repository.PazienteRepository;

@SpringBootTest
class PazienteTest {

	@Autowired
	private PazienteRepository underTest;
	
	//@Ignore
	@Test
	void itShouldFindPazienteById(){
		Paziente paziente = new Paziente(
			1L,
			"Francesco",
			"Resca",
			Date.valueOf("1999-11-05"),
			"RSCFNC99P11H501A"
		);

		underTest.save(paziente);
		
		Paziente expected = underTest.findById(1L).get();

		assertEquals(paziente, expected);
	}

}
