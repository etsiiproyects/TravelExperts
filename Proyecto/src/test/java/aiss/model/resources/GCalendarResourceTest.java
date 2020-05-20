package aiss.model.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.naming.ldap.UnsolicitedNotificationEvent;

import org.junit.Test;

import aiss.model.gcalendar.End;
import aiss.model.gcalendar.GCalendarSearch;
import aiss.model.gcalendar.Item;
import aiss.model.gcalendar.Start;

public class GCalendarResourceTest {
	
	private static final String access_token = "ya29.a0AfH6SMAn3X4_B3Ou9oEFuK2Ww6x46jaU-cgUF5sWSbLyyJ7EdFAp-fEsRQkTJz1_-mMun8bmkPKPPJfSYhZkA1uCpPxJ00PeIO3t49NCn3qKoaqZSv821Su-1A8M_XcDPFzWfKHHkMXgFedFODT_E1n3T0eJjKeIbXE";
	
	static GCalendarResource gcr = new GCalendarResource(access_token);
	private String correo = "etsiiproyects@gmail.com";
	
	@Test
	public void testGetEvents() throws UnsupportedEncodingException {
		GCalendarSearch gcs = gcr.getEvents(correo);
		assertNotNull("No hay eventos para el ID", gcs.getItems());
		System.out.println("Eventos para el ID: " + gcs.getItems());
	}
	
	@Test
	public void testAddEvent() throws UnsupportedEncodingException{
		Item evento = new Item();
		
		End end = new End();
		end.setDate("2020-06-05");
		Start start = new Start();
		start.setDate("2020-06-04");
		
		evento.setEnd(end);
		evento.setLocation("Direccion");
		evento.setStart(start);
		evento.setSummary("Prueba JUnit");
		
		boolean b = gcr.addEvent(evento, correo);
		assertEquals("No se ha añadido el evento", true, b);;
		System.out.println("Evento añadido: " + b);
	}

}
