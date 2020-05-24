package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;

import aiss.model.spotifytracks.TracksSearch;

public class SpotifyTrackResource {

	private static final Logger log = Logger.getLogger(SpotifyTrackResource.class.getName()); 
	private final String access_token;
	
	public SpotifyTrackResource(String access_token) {
		this.access_token=access_token;
	}
	
	public TracksSearch getArtistTrack(String id) {
		
		String uri= "https://api.spotify.com/v1/artists/" + id + "/top-tracks?country=ES";
		
		log.log(Level.FINE, "SpotifyTrack URI: " + uri);
		ClientResource cr = new ClientResource(uri);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);
		TracksSearch tracksearch=cr.get(TracksSearch.class);
		
		return tracksearch;
	}
	
	public TracksSearch getSongsSaved() {
		String uri = "https://api.spotify.com/v1/me/tracks";
		log.log(Level.FINE, "Spotify URI: " + uri);
		ClientResource cr = new ClientResource(uri);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);
		TracksSearch tracksearch=cr.get(TracksSearch.class);
		return tracksearch;
	}
	
}
