package web;

import java.util.ArrayList;
import java.util.List;
import metier.entities.Car;

public class CarModele {
	private String motCle;
	List<Car> Cars = new ArrayList<>();

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public List<Car> getCars() {
		return Cars;
	}

	public void setCars(List<Car> Cars) {
		this.Cars = Cars;
	}
}