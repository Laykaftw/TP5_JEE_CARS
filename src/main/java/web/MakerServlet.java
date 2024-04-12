package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import dao.MakerDaoImpl;
import dao.MakerDao;
import metier.entities.Maker;

@WebServlet(name = "catServ", urlPatterns = { "/Makers", "/saisieMaker", "/saveMaker", "/supprimerCat", "/editerCat",
		"/updateCat" })

public class MakerServlet extends HttpServlet {
	MakerDao metier;

	@Override
	public void init() throws ServletException {
		metier = new MakerDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println("PATH " + path);
		if (path.equals("/Makers")) {
			MakerModele model = new MakerModele();
			List<Maker> cats = metier.getAllMakers();
			model.setMakers(cats);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Makers.jsp").forward(request, response);
		} else if (path.equals("/saisieMaker")) {
			request.getRequestDispatcher("saisieMaker.jsp").forward(request, response);
		} else if (path.equals("/saveMaker") && request.getMethod().equals("POST"))

		{
			Date dateCat = new Date();
			String nom = request.getParameter("nom");
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new

			SimpleDateFormat(pattern);
			try {

				dateCat =

						simpleDateFormat.parse(request.getParameter("dateCat"));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			Maker cat = metier.save(new Maker(nom, dateCat));
			request.setAttribute("Maker", cat);
			response.sendRedirect("Makers");
		} else if (path.equals("/supprimerCat")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deleteMaker(id);
			response.sendRedirect("Makers");
		} else if (path.equals("/editerCat")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Maker cat = metier.getMaker(id);
			request.setAttribute("Maker", cat);
			request.getRequestDispatcher("editerMaker.jsp").forward(request, response);
		} else if (path.equals("/updateCat")) {
			Date dateCat = new Date();
			Long id = Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			Maker cat = new Maker();
			cat.setIdMaker(id);
			cat.setMakerName(nom);
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new

			SimpleDateFormat(pattern);
			try {

				dateCat =

						simpleDateFormat.parse(request.getParameter("dateCreation"));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			cat.setDateCreation(dateCat);
			metier.updateMaker(cat);
			response.sendRedirect("Makers");
		} else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,

			HttpServletResponse response) throws

	ServletException, IOException {
		doGet(request, response);
	}
}