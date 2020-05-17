package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;

import aiss.model.gcalendar.GCalendarSearch;

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

}
