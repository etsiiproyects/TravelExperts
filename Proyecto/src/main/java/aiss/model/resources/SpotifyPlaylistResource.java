package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.spotifyplaylist.PlaylistSearch;

public class SpotifyPlaylistResource {
	
	private static final Logger log = Logger.getLogger(SpotifyPlaylistResource.class.getName());
	private final String access_token;
	
	public SpotifyPlaylistResource(String access_token) {
		this.access_token=access_token;
	}
	
	public PlaylistSearch getPlaylists() {
		String uri = "https://api.spotify.com/v1/me/playlists";
		log.log(Level.FINE, "SpotifyPlaylist URI: " + uri);
		ClientResource cr = new ClientResource(uri);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);
        PlaylistSearch pls = cr.get(PlaylistSearch.class);
		return pls;
	}
	
	public boolean addSong(String playlistId, String songURI) throws UnsupportedEncodingException {
		String song = URLEncoder.encode(songURI, "UTF-8");
		String uri = "https://api.spotify.com/v1/playlists/"+playlistId+"/tracks?uris="+song;
		ClientResource cr = null;
		boolean result = true;
		
		try {
			cr = new ClientResource(uri);
			ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
			chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);
			
			cr.setEntityBuffering(true);
			cr.post(" ");
		} catch(ResourceException e) {
			System.err.println("Error al añadir la canción con URI=" + songURI + " a la playlist con id=" + playlistId + ": " + cr.getResponse().getStatus());
			result = false;
		}
		return result;
	}
	
	public boolean followSong(String songId) {
		ClientResource cr=null;
		boolean success=true;
		String uri= "https://api.spotify.com/v1/me/tracks?ids=" + songId;
		try {
			cr = new ClientResource(uri);
			ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
			chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);
			
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.put(" ");
		}catch (ResourceException re){
			System.err.println("Error añadiendo la cancion: " + cr.getResponse().getStatus());
			success=false;
			throw re;
		}
		return success;
	}
	
	public boolean unFollowSong(String songId) {
		ClientResource cr=null;
		boolean success=true;
		String uri= "https://api.spotify.com/v1/me/tracks?ids=" + songId;
		try {
			cr = new ClientResource(uri);
			ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
			chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);
			
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
		}catch (ResourceException re){
			System.err.println("Error añadiendo la cancion: " + cr.getResponse().getStatus());
			success=false;
			throw re;
		}
		return success;
	}
	
	

}
