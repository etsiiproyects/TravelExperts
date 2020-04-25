package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.spotifysearch.SpotifySearch;

public class SpotifyResource {
	
	private static final Logger log = Logger.getLogger(SpotifyResource.class.getName());
	
	public SpotifySearch getArtistsId(String nombre) throws UnsupportedEncodingException {
		String artista = URLEncoder.encode(nombre, "UTF-8");
		String uri = "https://api.spotify.com/v1/search?q="+artista+"&type=artist";
		log.log(Level.FINE, "Spotify URI: " + uri);
		ClientResource cr = new ClientResource(uri);
		SpotifySearch spotiSearch = cr.get(SpotifySearch.class);
		return spotiSearch;
	}

}
