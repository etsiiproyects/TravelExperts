package aiss;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String accessToken = (String) req.getSession().getAttribute("Spotify-token");
		
		if (accessToken != null && !"".equals(accessToken)) {
			String query = req.getParameter("searchQuery");
			RequestDispatcher rd = null;

			log.log(Level.FINE, "Buscando eventos de " + query);
			
			TMasterResource tmaster = new TMasterResource();
			SpotifyResource spoty = new SpotifyResource(accessToken);
			SpotifyTrackResource spotytracks = new SpotifyTrackResource(accessToken);
			
			TicketSearch tmasterResults = tmaster.getTickets(query);
			String id = spoty.getArtistsId(query).getArtists().getItems().get(0).getId();
			TracksSearch spotyResults = spotytracks.getArtistTrack(id);
			if(tmasterResults != null || spotyResults != null) {
				if(tmasterResults != null) {
					req.setAttribute("tickets", tmasterResults.getEmbedded());
				}
				if(spotyResults != null) {
					req.setAttribute("tracks", spotyResults.getTracks());
				}
				rd = req.getRequestDispatcher("/success.jsp");
			}
			else {
					log.log(Level.SEVERE, "Objeto TMaster: " + tmasterResults);
					log.log(Level.SEVERE, "Objeto Spotify: " + id);
					rd = req.getRequestDispatcher("/error.jsp");
				}
				rd.forward(req, resp);

		} else {
			log.info("Intenta acceder a Spotify sin token");
			req.getRequestDispatcher("AuthController/Spotify").forward(req, resp);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
