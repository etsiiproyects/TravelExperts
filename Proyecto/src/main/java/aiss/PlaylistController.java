package aiss;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.SpotifyPlaylistResource;
import aiss.model.resources.SpotifyTrackResource;
import aiss.model.spotifyplaylist.PlaylistSearch;
import aiss.model.spotifytracks.TracksSearch;

public class PlaylistController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(PlaylistController.class.getName());
	
	public PlaylistController() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessTokenSpotify = (String) req.getSession().getAttribute("Spotify-token");
		req.setAttribute("tokenS", accessTokenSpotify);
		
		RequestDispatcher rd = null;
		
		if((accessTokenSpotify != null && !"".equals(accessTokenSpotify))) {
			req.setAttribute("spot", "true");
			SpotifyPlaylistResource spotyplaylists = new SpotifyPlaylistResource(accessTokenSpotify);
			SpotifyTrackResource spotytracks = new SpotifyTrackResource(accessTokenSpotify);
			PlaylistSearch playlists = spotyplaylists.getPlaylists();
			TracksSearch tracks = spotytracks.getSongsSaved();
			req.setAttribute("playlists", playlists.getItems());
			req.setAttribute("songssaved", tracks.getTracks());
		} else {
			req.setAttribute("spot", "false");
		}
		
		rd = req.getRequestDispatcher("/playlists.jsp");
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
