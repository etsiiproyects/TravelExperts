package aiss.model.resources;

import static org.junit.Assert.assertEquals;


import java.io.UnsupportedEncodingException;


import org.junit.Test;


import aiss.model.tmaster.TicketSearch;

public class TMasterResourceTest {
	
	static TicketSearch ticket1, ticket2, ticket3;
	static TMasterResource tmr = new TMasterResource();
	static String name = "Aitana";  
	

	@Test
	public void testGetTicket() throws UnsupportedEncodingException {
		TicketSearch ts = tmr.getTickets(name);
		
		assertEquals("The events of the artist do not match", ticket1.getEmbedded().getEvents(), ts.getEmbedded().getEvents());
		
		// Show result
		System.out.println("Events of the artists: " +  ts.getEmbedded().getEvents());
		
	}
}
