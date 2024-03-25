package dao;

import java.util.List;
import metier.entities.Car;

public class TestDao {
	public static void main(String[] args) {
		CarDaoImpl pdao = new CarDaoImpl();
		Car prod = pdao.save(new Car("BMW E46 M3", 80000));
		System.out.println(prod);
		List<Car> prods = pdao.CarsParMC("BMW");
		for (Car p : prods)
			System.out.println(p);
	}
}