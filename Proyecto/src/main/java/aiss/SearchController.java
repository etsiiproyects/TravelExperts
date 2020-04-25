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
import aiss.model.resources.TMasterResource;
import aiss.model.spotifysearch.SpotifySearch;
import aiss.model.tmaster.TicketSearch;

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
	
	public SearchController() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String query = req.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		// Sample log
		log.log(Level.FINE, "Buscando eventos de " + query);
		TMasterResource tmaster = new TMasterResource();
		SpotifyResource spoty = new SpotifyResource();
		TicketSearch tmasterResults =tmaster.getTickets(query);
		SpotifySearch spotyResults = spoty.getArtistsId(query);
		 
		if(tmasterResults!=null && spotyResults!=null) {
			rd=req.getRequestDispatcher("/success.jsp");
			req.setAttribute("tickets", tmasterResults.getEmbedded());
			req.setAttribute("artist", spotyResults.getArtists());
		} else {
			log.log(Level.SEVERE, "Objeto TMaster: " + tmasterResults);
			log.log(Level.SEVERE, "Objeto Spotify: " + spotyResults);
			rd=req.getRequestDispatcher("/error.jsp");
		}
		
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
