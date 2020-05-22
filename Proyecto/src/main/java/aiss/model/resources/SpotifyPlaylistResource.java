package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;

import aiss.model.spotifyplaylist.PlaylistSearch;

public class SpotifyPlaylistResource {
	
	private static final Logger log = Logger.getLogger(SpotifyPlaylistResource.class.getName());
	private final String access_token;
	
	public SpotifyPlaylistResource(String access_token) {
		this.access_token=access_token;
	}
	
	public PlaylistSearch getPlaylists() throws UnsupportedEncodingException {
		String uri = "https://api.spotify.com/v1/me/playlists";
		log.log(Level.FINE, "SpotifyPlaylist URI: " + uri);
		ClientResource cr = new ClientResource(uri);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);
        PlaylistSearch pls = cr.get(PlaylistSearch.class);
		return pls;
	}

}
