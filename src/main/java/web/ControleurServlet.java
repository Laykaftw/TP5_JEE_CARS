package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.ICarDao;
import dao.CarDaoImpl;
import metier.entities.Car;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICarDao metier;

	@Override
	public void init() throws ServletException {
		metier = new CarDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/index.do")) {
			request.getRequestDispatcher("Cars.jsp").forward(request, response);
		} else if (path.equals("/chercher.do")) {
			String motCle = request.getParameter("motCle");
			CarModele modele = new CarModele();
			modele.setMotCle(motCle);
			List<Car> prods = metier.CarsParMC(motCle);
			modele.setCars(prods);
			request.setAttribute("modele", modele);
			request.getRequestDispatcher("Cars.jsp").forward(request, response);
		} else if (path.equals("/saisie.do")) {
			request.getRequestDispatcher("saisieCar.jsp").forward(request, response);
		} else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Car c = metier.save(new Car(nom, prix));
			request.setAttribute("Car", c);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		} else if (path.equals("/supprimer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deleteCar(id);
			response.sendRedirect("chercher.do?motCle=");
		} else if (path.equals("/editer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Car c = metier.getCar(id);
			request.setAttribute("car", c);
			request.getRequestDispatcher("EditCar.jsp").forward(request, response);
		} else if (path.equals("/update.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Car c = new Car();
			c.setIdCar(id);
			c.setCarname(nom);
			c.setPrice(prix);
			metier.updateCar(c);
			request.setAttribute("car", c);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		} else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
