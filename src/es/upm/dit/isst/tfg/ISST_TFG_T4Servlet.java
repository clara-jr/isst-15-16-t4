package es.upm.dit.isst.tfg;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.tfg.dao.TFGDAO;
import es.upm.dit.isst.tfg.dao.TFGDAOImpl;
import es.upm.dit.isst.tfg.model.TFG;

@SuppressWarnings("serial")
public class ISST_TFG_T4Servlet extends HttpServlet {
	TFGDAO dao = TFGDAOImpl.getInstance();
	ArrayList<TFG> tfgs  = new ArrayList<TFG>();;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		for(TFG tfg: dao.read()) {
			tfgs.add(tfg);
		}
		req.getSession().setAttribute("tfgs", tfgs);
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login";
		String user = "";
		if (req.getUserPrincipal() != null){
			user = req.getUserPrincipal().getName();
			url = userService.createLogoutURL(req.getRequestURI());
			urlLinktext = "Logout";
		}
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("url", url);
		req.getSession().setAttribute("urlLinktext", urlLinktext);
		RequestDispatcher view = req.getRequestDispatcher("MostrarTFGView.jsp");
		view.forward(req, resp);
	}
}

