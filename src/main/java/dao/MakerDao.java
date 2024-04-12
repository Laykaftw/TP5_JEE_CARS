package dao;

import java.util.List;
import metier.entities.Maker;

public interface MakerDao {
	public Maker save(Maker mak);
	public Maker getMaker(Long id);
	public Maker updateMaker(Maker mak);
	public void deleteMaker(Long id);
	public List<Maker> getAllMakers();
}
