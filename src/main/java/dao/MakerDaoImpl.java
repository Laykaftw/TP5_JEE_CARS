package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Maker;
import util.JPAutil;

public class MakerDaoImpl implements MakerDao {
	private EntityManager entityManager = JPAutil.getEntityManager("TP6_JEE_CARS");

	@Override
	public Maker save(Maker cat) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(cat);
		tx.commit();
		return cat;
	}

	@Override
	public Maker getMaker(Long id) {
		return entityManager.find(Maker.class, id);
	}

	@Override
	public Maker updateMaker(Maker cat) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(cat);
		tx.commit();
		return cat;
	}

	@Override
	public void deleteMaker(Long id) {
		Maker Maker = entityManager.find(Maker.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(Maker);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Maker> getAllMakers() {
		List<Maker> cats =

				entityManager.createQuery("select m from Maker m").getResultList();
		return cats;
	}
}
