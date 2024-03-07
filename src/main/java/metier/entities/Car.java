package metier.entities;

import java.io.Serializable;

public class Car implements Serializable {
	private Long idCar;
	private String Carname;
	private double Price;

	public Car() {
		super();
	}

	public Car(String Carname, double Price) {
		super();
		this.Carname = Carname;
		this.Price = Price;
	}

	public Long getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}

	public String getCarname() {
		return Carname;
	}

	public void setCarname(String Carname) {
		this.Carname = Carname;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double Price) {
		this.Price = Price;

	}

	@Override
	public String toString() {
		return "Car [idCar=" + idCar + ", Carname=" + Carname + ", Price=" + Price + "]";
	}

}