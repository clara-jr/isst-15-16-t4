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
	ArrayList<TFG> tfgs  = new ArrayList<TFG>();
	TFG tfg = null;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		tfgs.clear();
		for(TFG tfg: dao.read()) {
			if (tfg != null)
				tfgs.add(tfg);
		}
		if (tfgs.size() != 0)
			req.getSession().setAttribute("tfgs", tfgs);
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login";
		String user = "";
		if (req.getUserPrincipal() != null){
			user = req.getUserPrincipal().getName();
			url = userService.createLogoutURL(req.getRequestURI());
			urlLinktext = "Logout";
			tfg = dao.readAlumno(user);
		}
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("url", url);
		req.getSession().setAttribute("urlLinktext", urlLinktext);
		if (tfg != null)
			req.getSession().setAttribute("tfg", tfg);
		RequestDispatcher view = req.getRequestDispatcher("MostrarTFGView.jsp");
		view.forward(req, resp);
	}
}

