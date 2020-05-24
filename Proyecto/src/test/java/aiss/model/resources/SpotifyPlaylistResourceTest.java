package aiss.model.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.spotifyplaylist.Item;
import aiss.model.spotifyplaylist.PlaylistSearch;
import aiss.model.spotifytracks.Track;


public class SpotifyPlaylistResourceTest {

	private final static String access_token = "BQDJN8HXUsGXgALztYhrKDji7qdTDJqaRgUJ3ZqwYIRb0onf4y1-lSzwL8hp-VdTkz5ga1Sn2affiWodnztYKR5hUVS6AB_1EzfhPGCnv19st6GD0Dymp97pD4pu7TZNFgLTkP92kvg_-741aJOhNoRvUYj0xvnQlB2A1Q6XRoDVDq66_a01wjwPWtMCb6pqQULI8unmURPX4bVI2Va3fe3N";
	
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
