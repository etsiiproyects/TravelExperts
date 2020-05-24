package aiss;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.SpotifyPlaylistResource;


public class UnFollowSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UnFollowSongController() {
        super();
 
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accessTokenSpotify = (String) request.getSession().getAttribute("Spotify-token");
		request.setAttribute("tokenS", accessTokenSpotify);
		request.setAttribute("gc", "true");
		
		if((accessTokenSpotify != null && !"".equals(accessTokenSpotify))) {
			request.setAttribute("spot", "true");
			String songId=request.getParameter("songId");
			SpotifyPlaylistResource spr=new SpotifyPlaylistResource(accessTokenSpotify);
			boolean success=spr.unFollowSong(songId);
			
			if (success) {
				request.setAttribute("message", "Canción se ha dejado a seguir");
			
			}
			else {
				request.setAttribute("message", "La canción no se ha dejado a seguir");
			}
		}else {
			request.setAttribute("spot", "false");
		}
		
		request.getRequestDispatcher("/SearchControllerOption").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
