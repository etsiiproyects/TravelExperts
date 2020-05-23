package aiss.model.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.spotifyplaylist.Item;
import aiss.model.spotifyplaylist.PlaylistSearch;
import aiss.model.spotifytracks.Track;


public class SpotifyPlaylistResourceTest {

	private final static String access_token = "BQB0alAJ3G-JWGkmXycTwm7K_RMyE0IibFGMSKaxMowxl9yMwpr-hhd4xyBC7LpSpwRsO6rQoTz_Yzbvs9AjfO97DY4gCxpDr_qBgRRbe93iH6seipUVDN1ZiLOZyVWFBaEv8Qemu53sBCtOUC3v1n98VaiDNwvRt6lyKa6bVn9AcZbJOb2yCXuReOdqFpd2ka1WkCP48FSnm2ipfA";
	
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
		
		String id = "57wYoTRh3kC5y2cOQxuTMB";
		String uri = "spotify:track:2S93hylQBYLndMnaJuso8S";
		
		cancion.setId(id);
		cancion.setUri(uri);
		
		boolean c = sp.addSong(id, uri);
		assertEquals("No se ha añadido la cancion", true, c);
		System.out.println("Evento añadido: " + c);
	}
}
