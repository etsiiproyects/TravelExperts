package aiss;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.TMasterResource;
import aiss.model.tmaster.TicketSearch;

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
	
	public SearchController() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String ciudad = req.getParameter("searchQuery");
//		String salida = req.getParameter("searchSalida");
//		String regreso = req.getParameter("searchRegreso");
		RequestDispatcher rd=null;
		
		// Sample log
//		log.log(Level.FINE, "Buscando eventos en " + ciudad + "entre el " + salida + " y el " + regreso);
		log.log(Level.FINE, "Buscando eventos en " + ciudad);
		TMasterResource tmaster = new TMasterResource();
//		TicketSearch tmasterResults =tmaster.getTickets(ciudad, salida, regreso);
		TicketSearch tmasterResults =tmaster.getTickets(ciudad);
		 
		if(tmasterResults!=null) {
			rd=req.getRequestDispatcher("/success.jsp");
			req.setAttribute("tickets", tmasterResults.getEmbedded());
		} else {
			log.log(Level.SEVERE, "Objeto TMaster: " + tmasterResults);
			rd=req.getRequestDispatcher("/error.jsp");
		}
		
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
