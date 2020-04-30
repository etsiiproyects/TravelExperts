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
import aiss.model.spotifytracks.TracksSearch;
import aiss.model.tmaster.TicketSearch;

public class SearchControllerGC extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(SearchControllerGC.class.getName());

	public SearchControllerGC() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessTokenGC = (String) req.getSession().getAttribute("GoogleCalendar-token");
		
		if (accessTokenGC != null && !"".equals(accessTokenGC)) {
//			String query = req.getParameter("searchQuery");
			RequestDispatcher rd = null;

//			log.log(Level.FINE, "Buscando eventos de " + query);
			
			GCalendarResource gcalendar = new GCalendarResource(accessTokenGC);
			GCalendarSearch gcSearch = gcalendar.getEvents("etsiiproyects@gmail.com");
			
			if(gcSearch != null) {
				req.setAttribute("eventos", gcSearch.getItems());
				rd = req.getRequestDispatcher("/success.jsp");
			} else {
				log.log(Level.SEVERE, "Objeto GCalendar: " + gcSearch);
				rd = req.getRequestDispatcher("/error.jsp");
				}
				rd.forward(req, resp);

		} else {
			log.info("Intenta acceder a GC sin token");
			req.getRequestDispatcher("AuthController/GoogleCalendar").forward(req, resp);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
