package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.gcalendar.Event;
import aiss.model.gcalendar.GCalendarSearch;
import aiss.model.gcalendar.Item;

public class GCalendarResource {
	
	private static final String TCALENDAR_API_KEY = "AIzaSyCCN3peke43MoWxuVC7BDMNx3aX1RnWoQk";
	private static final Logger log = Logger.getLogger(GCalendarResource.class.getName());
	private final String access_token;
	
	public GCalendarResource(String access_token) {
		this.access_token = access_token;
	}
	

	public GCalendarSearch getEvents(String id) throws UnsupportedEncodingException {
		String mail = URLEncoder.encode(id, "UTF-8");
		String uri = "https://www.googleapis.com/calendar/v3/calendars/"+mail+"/events?&key="+TCALENDAR_API_KEY;
		
		log.log(Level.FINE, "Google Calendar URI:" + uri);
		
		ClientResource cr = new ClientResource(uri);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(access_token);
		
        cr.setChallengeResponse(chr);
        
        GCalendarSearch gcSearch = cr.get(GCalendarSearch.class);
		
		return gcSearch;
	}
	
    public GCalendarResource addEvent(GCalendarSearch event, String email) throws UnsupportedEncodingException  {
       
        String correo = URLEncoder.encode(email, "UTF-8");
        String uri = "https://www.googleapis.com/calendar/v3/calendars/" + correo + "/events?key=" + TCALENDAR_API_KEY;
        ClientResource cr = null;
        GCalendarResource events = null;
       
        try {
            cr = new ClientResource(uri);
            cr.setEntityBuffering(true);        // Needed for using RESTlet from JUnit tests
           
            events = cr.post(event,GCalendarResource.class);
        } catch (ResourceException re) {
            System.err.println("Error when adding the event: " + cr.getResponse().getStatus());
        }
        return events;
    }

	
	public boolean updateEvent(GCalendarResource gc, String id) throws UnsupportedEncodingException  {
		String mail = URLEncoder.encode(id,"UTF-8");
		String uri = "https://www.googleapis.com/calendar/v3/users/me/calendarList/"+mail+"?key="+ TCALENDAR_API_KEY;
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.put(gc);
			
			
		} catch (ResourceException re) {
			System.err.println("Error when updating the event: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	public boolean deleteEvent(String eventId, String id) throws UnsupportedEncodingException{
		String mail = URLEncoder.encode(id,"UTF-8");
		String uri = "https://www.googleapis.com/calendar/v3/users/me/calendarList/"+mail+"?key="+ TCALENDAR_API_KEY;
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + eventId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the event: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	
}




