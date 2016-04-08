package es.upm.dit.isst.tfg;

import java.io.IOException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.tfg.dao.TFGDAO;
import es.upm.dit.isst.tfg.dao.TFGDAOImpl;
import es.upm.dit.isst.tfg.model.TFG;

@SuppressWarnings("serial")
public class ISST_TFG_T4Servlet extends HttpServlet {
	// TFGDAO dao = TFGDAOImpl.getInstance();
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		/*resp.setContentType("text/plain");
		for(TFG tfg: dao.read()) {
			resp.getWriter().println(tfg);
		}*/
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login";
		resp.setContentType("text/html");            
		if (req.getUserPrincipal() != null){
		    url = userService.createLogoutURL(req.getRequestURI());
		    urlLinktext = "Logout";
	        	    resp.getWriter().println("<p>Hola" + req.getUserPrincipal().getName() + "</p>");
		}	
		resp.getWriter().println("<p>Pulsa <a href=\"" + url + "\">" + urlLinktext + "</a>.</p>");

	}
}

