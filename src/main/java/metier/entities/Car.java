package metier.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARS")
public class Car implements Serializable {
	@Id
	@Column(name = "ID_CAR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCar;
	private Maker maker;

	@Column(name = "CAR_NAME")
	private String Carname;
	private double Price;
	
	public Car() {
		super();
	}

	public Car(String CarName, Double Prix, Maker mak) {
		super();
		this.Carname = CarName;
		this.Price = Prix;
		this.setMaker(mak);
	}

	public Car(String Carname, double Price) {
		super();
		this.Carname = Carname;
		this.Price = Price;
	}

	public Maker getMaker() {
		return maker;
	}

	public void setMaker(Maker maker) {
		this.maker = maker;
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