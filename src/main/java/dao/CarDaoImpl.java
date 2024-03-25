package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Car;
import util.JPAutil;

public class CarDaoImpl implements ICarDao {
    private EntityManager entityManager = JPAutil.getEntityManager("TP5_JEE_CARS");

    @Override
    public Car save(Car p) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(p);
        tx.commit();
        return p;
    }

    @Override
    public List<Car> CarsParMC(String mc) {
        List<Car> prods = entityManager.createQuery("select c from Car c where c.Carname like :mc",Car.class).setParameter("mc", "%" + mc + "%").getResultList();
        return prods;
    }

    @Override
    public Car getCar(Long id) {
        return entityManager.find(Car.class, id);
    }

    @Override
    public Car updateCar(Car p) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(p);
        tx.commit();
        return p;
    }

    @Override
    public void deleteCar(Long id) {
        Car car = entityManager.find(Car.class, id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(car);
        tx.commit();
    }
}
