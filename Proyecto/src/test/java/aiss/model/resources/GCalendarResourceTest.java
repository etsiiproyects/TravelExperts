package aiss.model.resources;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.gcalendar.GCalendarSearch;

public class GCalendarResourceTest {
	
	private static final String access_token = "";
	
	static GCalendarResource gcr = new GCalendarResource(access_token);
	
	@Test
	public void testGetEvents() throws UnsupportedEncodingException {
		GCalendarSearch gcs = gcr.getEvents("etsiiprojects@gmail.com");
		assertNotNull("No hay eventos para el ID", gcs.getItems());
		System.out.println("Eventos para el ID: " + gcs.getItems());
	}

}
