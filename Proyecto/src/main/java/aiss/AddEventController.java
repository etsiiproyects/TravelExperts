package aiss;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.gcalendar.End;
import aiss.model.gcalendar.Event;
import aiss.model.gcalendar.Start;
import aiss.model.resources.GCalendarResource;



public class AddEventController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		RequestDispatcher rd = null;
		
		String accessTokenGC = (String) req.getSession().getAttribute("GoogleCalendar-token");

		String email = (String) req.getSession().getAttribute("correo");
		  
		GCalendarResource gc = new GCalendarResource(accessTokenGC);
		
		String name = req.getParameter("nombre").toString();
		String date = req.getParameter("fecha").toString();
		String time = req.getParameter("hora").toString();
		String address = req.getParameter("direccion").toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH/mm/ss");
		
		String fin = time.replace(time.charAt(1), String.valueOf(Integer.valueOf(time.charAt(1)+2)).charAt(0));
		
		Start start = new Start();
		start.setDate(date);
		start.setDateTime(time);
		End end = new End();
		end.setDate(fin.toString());
		
		
		Event event = new Event();
		
		event.setSummary(name);
		event.setStart(start);
		event.setEnd(end);
		event.setLocation(address);
		
		gc.addEvent(event, email);
		
		rd = req.getRequestDispatcher("/SearchControllerOption");
		rd.forward(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
