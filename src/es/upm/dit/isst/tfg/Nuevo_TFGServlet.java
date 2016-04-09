package es.upm.dit.isst.tfg;

import java.io.IOException;
import javax.servlet.http.*;

import es.upm.dit.isst.tfg.dao.TFGDAO;
import es.upm.dit.isst.tfg.dao.TFGDAOImpl;

@SuppressWarnings("serial")
public class Nuevo_TFGServlet extends HttpServlet {
	TFGDAO dao = TFGDAOImpl.getInstance();
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		String titulo = req.getParameter("titulo");
		String resumen = req.getParameter("resumen");
		String tutor = req.getParameter("tutor");
		dao.create(req.getUserPrincipal().getName(), titulo, resumen, tutor, "", "", 1);
		resp.sendRedirect("MostrarTFGView.jsp");
	}
}

