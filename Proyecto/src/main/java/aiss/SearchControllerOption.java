package aiss;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.gcalendar.GCalendarSearch;
import aiss.model.resources.GCalendarResource;
import aiss.model.resources.SpotifyPlaylistResource;
import aiss.model.resources.SpotifyResource;
import aiss.model.resources.SpotifyTrackResource;
import aiss.model.resources.TMasterResource;
import aiss.model.spotifyplaylist.PlaylistSearch;
import aiss.model.spotifysearch.SpotifySearch;
import aiss.model.spotifytracks.TracksSearch;
import aiss.model.tmaster.TicketSearch;

public class SearchControllerOption extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(SearchControllerOption.class.getName());

	public SearchControllerOption() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		
		String accessTokenSpotify = (String) req.getSession().getAttribute("Spotify-token");
		String accessTokenGC = (String) req.getSession().getAttribute("GoogleCalendar-token");
	
		req.setAttribute("tokenS", accessTokenSpotify);
		req.setAttribute("tokenGC", accessTokenGC);
		
		String artista = "";
		String correoE = "";
		
		if(req.getParameter("searchQuery")!=null) {
			if(req.getSession().getAttribute("artista") == null || req.getSession().getAttribute("artista") == "" || req.getParameter("searchQuery")!=artista) {
				req.getSession().setAttribute("artista", req.getParameter("searchQuery"));
			}
		}
		
		artista = (String) req.getSession().getAttribute("artista");
		
		if(req.getSession().getAttribute("correo") == null || req.getSession().getAttribute("correo") == "") {
			req.getSession().setAttribute("correo", req.getParameter("correoE"));
			correoE = (String) req.getSession().getAttribute("correo");
		}else {
			correoE = (String) req.getSession().getAttribute("correo");
		}
		
		RequestDispatcher rd = null;
		
		log.log(Level.FINE, "Buscando eventos de " + artista);
		
		TMasterResource tmaster = new TMasterResource();
		TicketSearch tmasterResults = tmaster.getTickets(artista);
		if(tmasterResults != null) {
			req.setAttribute("tickets", tmasterResults.getEmbedded());
		}else {
			log.log(Level.SEVERE, "Objeto TMaster: " + tmasterResults);
			rd = req.getRequestDispatcher("/error.jsp");
		}
		
		if((accessTokenSpotify != null && !"".equals(accessTokenSpotify))){
			
			SpotifyResource spoty = new SpotifyResource(accessTokenSpotify);
			SpotifySearch ss=spoty.getArtistsId(artista);
			String id = ss.getArtists().getItems().get(0).getId();
			String uri=ss.getArtists().getItems().get(0).getUri();
			req.setAttribute("artistUri", uri);
			SpotifyTrackResource spotytracks = new SpotifyTrackResource(accessTokenSpotify);
			TracksSearch spotyResults = spotytracks.getArtistTrack(id);
			req.setAttribute("tracks", spotyResults.getTracks());
			
			SpotifyPlaylistResource spoty1 = new SpotifyPlaylistResource(accessTokenSpotify);
			PlaylistSearch playlists = spoty1.getPlaylists();
			if(spoty!=null) req.setAttribute("spot", "true");
			req.setAttribute("playlists", playlists.getItems());
		}else {
			req.setAttribute("spot", "false");
		}
		
		
		if((accessTokenGC != null && !"".equals(accessTokenGC))) {
			
			GCalendarResource gcalendar = new GCalendarResource(accessTokenGC);
			GCalendarSearch gcSearch = gcalendar.getEvents(correoE);
			String email = URLEncoder.encode(correoE, "UTF-8");
			if(gcalendar!=null) req.setAttribute("gc", "true");
			req.setAttribute("email", email);
			req.setAttribute("eventos", gcSearch.getItems());
		}else {
			req.setAttribute("gc", "false");
		}
		
		rd = req.getRequestDispatcher("/success.jsp");
		rd.forward(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}