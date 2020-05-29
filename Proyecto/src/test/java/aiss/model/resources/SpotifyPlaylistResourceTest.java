package aiss.model.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import aiss.model.spotifyplaylist.Item;
import aiss.model.spotifyplaylist.PlaylistSearch;



public class SpotifyPlaylistResourceTest {

	private final static String access_token = "BQDuWePyfSJ0OgkC_dN36JVhAYTkjMKeM3MGWwJ-C3YxgzIkaMkjjie_XLD2Z9lgoas9rd46wIvFu83w3LMId7Ga5PQdIKn4L3Dru_ZiyTrBuWD2ExTMeEkb0v489fuL3XN4P5ucxFtspL-d5w5hV3zFCvZhsryoFJIt0bN_WTHYxeJPh9SfGowiBd9CWhYXnz6PAWHEFaGvoXwCsF83bEJym6ZPcFwE";
	
	static SpotifyPlaylistResource sp = new SpotifyPlaylistResource(access_token);
	
	@Test
	public void testGetPlaylists() {
		PlaylistSearch ps = sp.getPlaylists();
		Integer total = ps.getTotal();
		assertNotNull("No existen canciones en la playlist", total==0);
		System.out.println("Canciones totales de la playlist: " + total);
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
	
	@Test
	public void testFollowSong() {
		String songId = "3DYm7Lp7Fc3xf6WSCq5ntE";
		boolean b = sp.followSong(songId);
		assertTrue("No se ha comenzado a seguir la canción", b);
		System.out.println("Canción seguida: " + b);
	}
	
	@Test
	public void testUnFollowSong() {
		String songId = "3DYm7Lp7Fc3xf6WSCq5ntE";
		boolean b = sp.unFollowSong(songId);
		assertTrue("No se ha dejado de seguir la canción", b);
		System.out.println("Canción dejada de seguir: " + b);
	}

}
