package aiss.model.resources;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.spotifysearch.SpotifySearch;
import aiss.model.spotifytracks.TracksSearch;

public class SpotifyResourceTest {
	
	private final static String access_token = "";
	
	static SpotifyResource sr = new SpotifyResource(access_token);
	static SpotifyTrackResource str = new SpotifyTrackResource(access_token);
	
	@Test
	public void testGetId() throws UnsupportedEncodingException {
		SpotifySearch ss = sr.getArtistsId("Aitana");
		assertNotNull("No existe un ID para el artista", ss.getAdditionalProperties().get("Aitana"));
		System.out.println("ID del artista: " + ss.getAdditionalProperties().get("Aitana"));
	}
	
	@Test
	public void testGetTracks() throws UnsupportedEncodingException {
		SpotifySearch ss1 = sr.getArtistsId("Aitana");
		String id = (String) ss1.getAdditionalProperties().get("Aitana");
		TracksSearch ss2 = str.getArtistTrack(id);
		assertNotNull("No existen canciones para el artista", ss2.getTracks());
		System.out.println("Canciones del artista: " + ss2.getTracks());
	}
	

}
