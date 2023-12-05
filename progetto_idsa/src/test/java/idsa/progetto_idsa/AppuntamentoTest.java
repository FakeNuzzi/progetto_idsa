package idsa.progetto_idsa;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.repository.AppuntamentoRepository;

@SpringBootTest
class AppuntamentoTest {

	@Autowired
	private AppuntamentoRepository underTest;
	
	//@Ignore
	@Test
	void itShouldFindAppuntamentoById(){
		Paziente paziente = new Paziente(
			1L,
			"Francesco",
			"Resca",
			Date.valueOf("1999-11-05"),
			"RSCFNC99P11H501A"
		);
		Medico medico = new Medico(
			1L,
			"Francesco",
			"Resca",
			Date.valueOf("1999-11-05"),
			"RSCFNC99P11H501A",
            2000.0f,
            "Chirurgo"
		);
		Appuntamento appuntamento = new Appuntamento(
			1L,
			Date.valueOf("2021-05-05"),
			"Visita di controllo",
			paziente,
			medico
		);

		underTest.save(appuntamento);
		
		Appuntamento expected = underTest.findById(1L).get();

		assertEquals(appuntamento, expected);
	}

	@Test
	void itShouldFindAppuntamentoByPaziente(){
		Paziente paziente = new Paziente(
			1L,
			"Francesco",
			"Resca",
			Date.valueOf("1999-11-05"),
			"RSCFNC99P11H501A"
		);
		Medico medico = new Medico(
			1L,
			"Francesco",
			"Resca",
			Date.valueOf("1999-11-05"),
			"RSCFNC99P11H501A",
            2000.0f,
            "Chirurgo"
		);
		Appuntamento appuntamento = new Appuntamento(
			1L,
			Date.valueOf("2021-05-05"),
			"Visita di controllo",
			paziente,
			medico
		);

		underTest.save(appuntamento);
		
		Appuntamento expected = underTest.findById(1L).get();

		assertEquals(appuntamento, expected);
	}

}
