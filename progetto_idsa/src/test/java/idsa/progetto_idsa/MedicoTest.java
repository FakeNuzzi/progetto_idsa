package idsa.progetto_idsa;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.repository.MedicoRepository;

@SpringBootTest
class MedicoTest {

	@Autowired
	private MedicoRepository underTest;
	
	//@Ignore
	@Test
	void itShouldFindMedicoById(){
		Medico medico = new Medico(
			1L,
			"Francesco",
			"Resca",
			Date.valueOf("1999-11-05"),
			"RSCFNC99P11H501A",
            2000.0f,
            "Chirurgo"
		);

		underTest.save(medico);
		
		Medico expected = underTest.findById(1L).get();

		assertEquals(medico, expected);
	}

}
