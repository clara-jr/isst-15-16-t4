package es.upm.dit.isst.tfg;

import java.io.IOException;
import javax.servlet.http.*;

import es.upm.dit.isst.tfg.dao.TFGDAO;
import es.upm.dit.isst.tfg.dao.TFGDAOImpl;
import es.upm.dit.isst.tfg.model.TFG;

@SuppressWarnings("serial")
public class Es_upm_dit_isst_tfgServlet extends HttpServlet {
	TFGDAO dao = TFGDAOImpl.getInstance();
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		for(TFG tfg: dao.read()) {
			resp.getWriter().println(tfg);
		}
	}
}
