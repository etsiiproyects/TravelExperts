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

	public TicketSearch getTickets(String word) throws UnsupportedEncodingException {	
		
		String keyword = URLEncoder.encode(word, "UTF-8");
	
		String uri="https://app.ticketmaster.com/discovery/v2/events?apikey=" + TMASTER_API_KEY + "&keyword=" + keyword + "&locale=*";
		log.log(Level.FINE, "TMaster URI: " + uri);
		
		ClientResource cr= new ClientResource(uri);
		TicketSearch ticketSearch=cr.get(TicketSearch.class);
		
	    return ticketSearch;
		
	}
	
}
