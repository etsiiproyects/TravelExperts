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
import aiss.model.resources.SpotifyResource;
import aiss.model.resources.SpotifyTrackResource;
import aiss.model.resources.TMasterResource;
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
			req.setAttribute("spot", "true");
			SpotifyResource spoty = new SpotifyResource(accessTokenSpotify);
			String id = spoty.getArtistsId(artista).getArtists().getItems().get(0).getId();
			SpotifyTrackResource spotytracks = new SpotifyTrackResource(accessTokenSpotify);
			TracksSearch spotyResults = spotytracks.getArtistTrack(id);
			req.setAttribute("tracks", spotyResults.getTracks());
		}else {
			req.setAttribute("spot", "false");
		}
		
		
		if((accessTokenGC != null && !"".equals(accessTokenGC))) {
			req.setAttribute("gc", "true");
			GCalendarResource gcalendar = new GCalendarResource(accessTokenGC);
			GCalendarSearch gcSearch = gcalendar.getEvents(correoE);
			String email = URLEncoder.encode(correoE, "UTF-8");
			req.setAttribute("email", email);
			req.setAttribute("eventos", gcSearch.getItems());
		}else {
			req.setAttribute("gc", "false");
		}
		
		rd = req.getRequestDispatcher("/success.jsp");
		rd.forward(req, resp);
		
//		if ((accessTokenSpotify != null && !"".equals(accessTokenSpotify)) && (accessTokenGC != null && !"".equals(accessTokenGC))) {
//
//			log.log(Level.FINE, "Buscando calendario de " + correo);
//			
//			
//			GCalendarResource gcalendar = new GCalendarResource(accessTokenGC);
//				
//			
//			
//			GCalendarSearch gcSearch = gcalendar.getEvents(correo);
//			
//			if(spotyResults != null || gcSearch!=null) {
//				if(spotyResults != null) {
//					req.setAttribute("tracks", spotyResults.getTracks());
//				}
//				if(gcSearch != null) {
//					String email = URLEncoder.encode(correo, "UTF-8");
//					req.setAttribute("email", email);
//					req.setAttribute("eventos", gcSearch.getItems());
//				}
//				rd = req.getRequestDispatcher("/success.jsp");
//			}else {
//					log.log(Level.SEVERE, "Objeto TMaster: " + tmasterResults);
//					log.log(Level.SEVERE, "Objeto Spotify: " + id);
//					log.log(Level.SEVERE, "Objeto GCalendar: " + gcSearch);
//					rd = req.getRequestDispatcher("/error.jsp");
//				}
//				rd.forward(req, resp);
//
//		} else {
//			if(accessTokenSpotify == null || "".equals(accessTokenSpotify)){
//				log.info("Intenta acceder a Spotify sin token");
//				req.getRequestDispatcher("AuthController/Spotify").forward(req, resp);
//			}
//			if(accessTokenGC == null || "".equals(accessTokenGC)){
//				log.info("Intenta acceder a GCalendar sin token");
//				req.getRequestDispatcher("AuthController/GoogleCalendar").forward(req, resp);
//			}
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}