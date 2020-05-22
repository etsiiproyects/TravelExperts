package aiss;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.SpotifyPlaylistResource;

public class AddSongController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(AddSongController.class.getName());
	
	public AddSongController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accessTokenSpotify = (String) req.getSession().getAttribute("Spotify-token");
		req.setAttribute("tokenS", accessTokenSpotify);
		
		if((accessTokenSpotify != null && !"".equals(accessTokenSpotify))) {
			req.setAttribute("spot", "true");
			String playlistID = req.getParameter("id_play");
			String songURI = req.getParameter("uri_song");
			SpotifyPlaylistResource plr = new SpotifyPlaylistResource(accessTokenSpotify);
			boolean success = plr.addSong(playlistID, songURI);
			super.doGet(req, resp);
			
			if (success) {
				req.setAttribute("message", "Canción añadida correctamente");
				log.log(Level.FINE, "La canción con URI=" + songURI + " añadida a la playlist con id=" + playlistID + ". Llevando a la lista de playlists.");
			}
			else {
				req.setAttribute("message", "La canción no ha sido añadida");
				log.log(Level.FINE, "La canción con URI=" + songURI + " no añadida a la playlist con id=" + playlistID + ". Quizás la canción ya existía en la playlist. Llevando a la lista de playlists.");
			}
		} else {
			req.setAttribute("spot", "false");
		}
		
		// Forward to contact list view
		req.getRequestDispatcher("success.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
	

}
