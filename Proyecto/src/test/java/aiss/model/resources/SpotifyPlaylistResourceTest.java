package aiss.model.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.spotifyplaylist.Item;
import aiss.model.spotifyplaylist.PlaylistSearch;
import aiss.model.spotifytracks.Track;


public class SpotifyPlaylistResourceTest {

	private final static String access_token = "BQD63S6KZl05O93czgYvtv631aZqJb5bHtv75BuNQMQcFb9Mst26hjtzjsHacbsQw6_ViSaf7mT9IPzCJRLxqHw-Z91dkqUAalGv6Ly5Q9gdRlHIhzzi-eZFELC8iFQUf4w1YYfK0f_Gjs1lgBWI1F59j3IIaGe-TG6VUABahOyjJQYdNlI78x0SsbVLL9FMtlyqn3StoBWbiMeJMLCFfMTcDAOzgNhL";
	
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
