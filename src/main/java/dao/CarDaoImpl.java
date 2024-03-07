package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.SingletonConnection;
import metier.entities.Car;

public class CarDaoImpl implements ICarDao {
	@Override
	public Car save(Car p) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTOCarS(Car_Name,Price) VALUES(?,?)");
			ps.setString(1, p.getCarname());
			ps.setDouble(2, p.getPrice());
			ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement("SELECT MAX(ID_Car) as MAX_ID FROM CarS");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setIdCar(rs.getLong("MAX_ID"));
			}
			ps.close();
			ps2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Car> CarsParMC(String mc) {
		List<Car> prods = new ArrayList<Car>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from CarS where Car_Name LIKE ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Car p = new Car();
				p.setIdCar(rs.getLong("ID_Car"));
				p.setCarname(rs.getString("Car_Name"));
				p.setPrice(rs.getDouble("Price"));
				prods.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public Car getCar(Long id) {

	 Connection conn=SingletonConnection.getConnection();
	 Car p = new Car();
	 try {
	PreparedStatement ps= conn.prepareStatement("select * from CarS where ID_Car = ?");
	ps.setLong(1, id);
	ResultSet rs = ps.executeQuery();
	if (rs.next()) {
	p.setIdCar(rs.getLong("ID_Car"));
	p.setCarname(rs.getString("CAR_NAME"));
	p.setPrice(rs.getDouble("Price"));
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return p;
	}

	@Override
	public Car updateCar(Car p) {
	Connection conn=SingletonConnection.getConnection();
	 try {
	PreparedStatement ps= conn.prepareStatement("UPDATE CarS SET CAR_NAME=?,Price=? WHERE ID_Car=?");
	ps.setString(1, p.getCarname());
	ps.setDouble(2, p.getPrice());
	ps.setLong(3, p.getIdCar());
	ps.executeUpdate();
	ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return p;
	}

	@Override
	public void deleteCar(Long id) {
	Connection conn=SingletonConnection.getConnection();
	 try {
	PreparedStatement ps= conn.prepareStatement("DELETE FROM CarS WHERE ID_Car = ?");
	ps.setLong(1, id);
	ps.executeUpdate();
	ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	}
}