package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;


import aiss.model.tmaster.TicketSearch;


public class TMasterResource {

	private static final String TMASTER_API_KEY = "iLoEEaWKhcfBwcfF4u825ExfLQgKkNmB";		// TODO: Change this API KEY for your personal Key
	private static final Logger log = Logger.getLogger(TMasterResource.class.getName());

	
//	public TicketSearch getTickets(String ciu, String s, String r) throws UnsupportedEncodingException{
	public TicketSearch getTickets(String ciu) throws UnsupportedEncodingException{	
		
		String ciudad=URLEncoder.encode(ciu, "UTF-8");
		
//		String sal[]=URLEncoder.encode(s, "UTF-8").split("/");
//		String salida=String.format("%d-%d-%dT00:00:00Z", sal[0], sal[1], sal[2]);
//		
//		String reg[]=URLEncoder.encode(r, "UTF-8").split("/");
//		String regreso=String.format("%d-%d-%dT00:00:00Z", reg[0], reg[1], reg[2]);
		
//		String uri="https://app.ticketmaster.com/discovery/v2/events?apikey=" + TMASTER_API_KEY + "&locale=*&startDateTime=" + salida + "&endDateTime=" + regreso +"&city=" + ciudad;
//		log.log(Level.FINE, "TMaster URI: " + uri);
		
		String uri="https://app.ticketmaster.com/discovery/v2/events?apikey=" + TMASTER_API_KEY + "&city=" + ciudad;
		log.log(Level.FINE, "TMaster URI: " + uri);
		
		ClientResource cr= new ClientResource(uri);
		TicketSearch ticketSearch=cr.get(TicketSearch.class);
		
	    return ticketSearch;
		
	}
	
}
