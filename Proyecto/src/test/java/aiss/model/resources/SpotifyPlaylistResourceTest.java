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
<<<<<<< HEAD
import aiss.model.spotifysearch.SpotifySearch;
import aiss.model.spotifytracks.Track;
import aiss.model.spotifytracks.TracksSearch;
=======
>>>>>>> branch 'master' of https://github.com/etsiiproyects/TravelExperts.git


public class SpotifyPlaylistResourceTest {

	private final static String access_token = "BQBWO1kVK3P3yUjXfq8Anik-kea4RcqW2cKghAPNEw698hKErhoHaVOQjQe7g5ceAXWTlyaPweg4Wbr-QJa2VO7dcVLdqG0NHEKUnEx5kcZhgMRx8Mb4_sA_eEeKiA8_LuoHa0FTpUvmt6KZHKkpd9Akb6A9TL2WrTpma-Y9Femzesqy9VGwc0lPSOEtCCme4T9JHP8_nrH7ZJdoWNXAEO_wHe9DF-U5";
	
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
	
<<<<<<< HEAD
=======
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
>>>>>>> branch 'master' of https://github.com/etsiiproyects/TravelExperts.git
}
