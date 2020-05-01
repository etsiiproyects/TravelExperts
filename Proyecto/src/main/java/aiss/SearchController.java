package aiss;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.gcalendar.GCalendarSearch;
import aiss.model.resources.GCalendarResource;
import aiss.model.resources.SpotifyResource;
import aiss.model.resources.SpotifyTrackResource;
import aiss.model.resources.TMasterResource;
import aiss.model.spotifysearch.SpotifySearch;
import aiss.model.spotifytracks.TracksSearch;
import aiss.model.tmaster.TicketSearch;

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(SearchController.class.getName());

	public SearchController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessTokenSpotify = (String) req.getSession().getAttribute("Spotify-token");
		String accessTokenGC = (String) req.getSession().getAttribute("GoogleCalendar-token");
		
		if ((accessTokenSpotify != null && !"".equals(accessTokenSpotify)) && (accessTokenGC != null && !"".equals(accessTokenGC))) {
			String artista = req.getParameter("searchQuery");
			String correo = req.getParameter("correoE");
			RequestDispatcher rd = null;

			log.log(Level.FINE, "Buscando eventos de " + artista);
			log.log(Level.FINE, "Buscando calendario de " + correo);
			
			TMasterResource tmaster = new TMasterResource();
			SpotifyResource spoty = new SpotifyResource(accessTokenSpotify);
			SpotifyTrackResource spotytracks = new SpotifyTrackResource(accessTokenSpotify);
			GCalendarResource gcalendar = new GCalendarResource(accessTokenGC);
			
			
			TicketSearch tmasterResults = tmaster.getTickets(artista);
			String id = spoty.getArtistsId(artista).getArtists().getItems().get(0).getId();
			TracksSearch spotyResults = spotytracks.getArtistTrack(id);
			GCalendarSearch gcSearch = gcalendar.getEvents(correo);
			if(tmasterResults != null || spotyResults != null || gcSearch!=null) {
				if(tmasterResults != null) {
					req.setAttribute("tickets", tmasterResults.getEmbedded());
				}
				if(spotyResults != null) {
					req.setAttribute("tracks", spotyResults.getTracks());
				}
				if(gcSearch != null) {
					req.setAttribute("eventos", gcSearch.getItems());
				}
				rd = req.getRequestDispatcher("/success.jsp");
			}
			else {
					log.log(Level.SEVERE, "Objeto TMaster: " + tmasterResults);
					log.log(Level.SEVERE, "Objeto Spotify: " + id);
					log.log(Level.SEVERE, "Objeto GCalendar: " + gcSearch);
					rd = req.getRequestDispatcher("/error.jsp");
				}
				rd.forward(req, resp);

		} else {
			if(accessTokenSpotify == null || "".equals(accessTokenSpotify)){
				log.info("Intenta acceder a Spotify sin token");
				req.getRequestDispatcher("AuthController/Spotify").forward(req, resp);
			}
			if(accessTokenGC == null || "".equals(accessTokenGC)){
				log.info("Intenta acceder a GCalendar sin token");
				req.getRequestDispatcher("AuthController/GoogleCalendar").forward(req, resp);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
