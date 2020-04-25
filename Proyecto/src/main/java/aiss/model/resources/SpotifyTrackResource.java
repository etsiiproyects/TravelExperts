package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.spotifytracks.TracksSearch;

public class SpotifyTrackResource {

	private static final Logger log = Logger.getLogger(SpotifyTrackResource.class.getName()); 
	
	public TracksSearch getArtistTrack(String id) throws UnsupportedEncodingException {
		
		String uri= "https://api.spotify.com/v1/artists/" + id + "/top-tracks?country=ES";
		
		log.log(Level.FINE, "SpotifyTrack URI: " + uri);
		ClientResource cr = new ClientResource(uri);
		
		TracksSearch tracksearch=cr.get(TracksSearch.class);
		
		return tracksearch;
	}
	
}
