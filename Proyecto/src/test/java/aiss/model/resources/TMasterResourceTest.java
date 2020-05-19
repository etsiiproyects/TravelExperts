package aiss.model.resources;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import aiss.model.tmaster.TicketSearch;

public class TMasterResourceTest {
	
	static TMasterResource tmr = new TMasterResource();

	@Test
	public void testGetTicket() throws UnsupportedEncodingException {
		TicketSearch ts = tmr.getTickets("Aitana");
		
		assertNotNull("No hay eventos para el artista", ts.getEmbedded().getEvents());
		
		System.out.println("Events of the artists: " +  ts.getEmbedded().getEvents());
		
	}
}
