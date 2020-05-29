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
	
	private final static String access_token = "BQDuWePyfSJ0OgkC_dN36JVhAYTkjMKeM3MGWwJ-C3YxgzIkaMkjjie_XLD2Z9lgoas9rd46wIvFu83w3LMId7Ga5PQdIKn4L3Dru_ZiyTrBuWD2ExTMeEkb0v489fuL3XN4P5ucxFtspL-d5w5hV3zFCvZhsryoFJIt0bN_WTHYxeJPh9SfGowiBd9CWhYXnz6PAWHEFaGvoXwCsF83bEJym6ZPcFwE";
	
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
