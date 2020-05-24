package aiss.model.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.spotifyplaylist.Item;
import aiss.model.spotifyplaylist.PlaylistSearch;
import aiss.model.spotifytracks.Track;


public class SpotifyPlaylistResourceTest {

	private final static String access_token = "BQA5d8FOB_V_geCxa8smrM9Mzj1hSxdpQXGTLYxNW7VN8EjJwjnLIhFqsjQTX72z7El0yKLEBDGz7jf-ysXJFvcMhr7_V7FGMujeGkr0mdAJ4-ShBBnAqsoD7yb4NYNelUXAB_G9hNlptxiKBZ5ak5DL_RLr8llc8vGhyV33Q24g4mlwPsYQzjBYOSAPd33E33EiuyfBRGuDNB6HX6QMhkQpzYXUVVko";
	
	static SpotifyPlaylistResource sp = new SpotifyPlaylistResource(access_token);
	
	@Test
	public void testGetId() throws UnsupportedEncodingException {
		PlaylistSearch ps = sp.getPlaylists();
		String id = ps.getItems().get(0).getId();
		assertNotNull("No existe un ID para la playlist", id);
		System.out.println("ID de la playlist: " + id);
	}
	
	@Test
	public void testAddTrack() throws UnsupportedEncodingException {
		Item cancion = new Item();
		
		String id = "3Bh3zPB5OeoIvg9qWqJB0h";
		String uri = "spotify:track:2S93hylQBYLndMnaJuso8S";
		
		cancion.setId(id);
		cancion.setUri(uri);
		
		boolean c = sp.addSong(id, uri);
		assertEquals("No se ha añadido la cancion", true, c);
		System.out.println("Evento añadido: " + c);
	}
}
