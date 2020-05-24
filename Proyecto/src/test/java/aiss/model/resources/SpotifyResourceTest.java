package aiss.model.resources;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.mail.Session;

import org.junit.Test;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;

import aiss.model.spotifysearch.SpotifySearch;
import aiss.model.spotifytracks.Track;
import aiss.model.spotifytracks.TracksSearch;

public class SpotifyResourceTest {
	
	private final static String access_token = "BQA5d8FOB_V_geCxa8smrM9Mzj1hSxdpQXGTLYxNW7VN8EjJwjnLIhFqsjQTX72z7El0yKLEBDGz7jf-ysXJFvcMhr7_V7FGMujeGkr0mdAJ4-ShBBnAqsoD7yb4NYNelUXAB_G9hNlptxiKBZ5ak5DL_RLr8llc8vGhyV33Q24g4mlwPsYQzjBYOSAPd33E33EiuyfBRGuDNB6HX6QMhkQpzYXUVVko";
	
	static SpotifyResource sr = new SpotifyResource(access_token);
	static SpotifyTrackResource str = new SpotifyTrackResource(access_token);	
	
	@Test
	public void testGetId() throws UnsupportedEncodingException {
		SpotifySearch ss = sr.getArtistsId("aitana");
		String id = ss.getArtists().getItems().get(0).getId();
		assertNotNull("No existe un ID para el artista", id);
		System.out.println("ID del artista: " + id);
	}
	
	@Test
	public void testGetTracks() throws UnsupportedEncodingException {
		SpotifySearch ss1 = sr.getArtistsId("Aitana");
		String id = (String) ss1.getArtists().getItems().get(0).getId();
		TracksSearch ss2 = str.getArtistTrack(id);
		assertNotNull("No existen canciones para el artista", ss2.getTracks());
		
		List<String> ls = new ArrayList<String>();
		for(Track cancion : ss2.getTracks()) {
			ls.add(cancion.getName());
		}
		System.out.println("Canciones del artista: " + ls);
	}
	

}
