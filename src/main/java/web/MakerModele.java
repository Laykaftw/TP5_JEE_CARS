package web;

import java.util.ArrayList;
import java.util.List;
import metier.entities.Maker;

public class MakerModele {
	List<Maker> Makers = new ArrayList<>();

	public List<Maker> getMakers() {
		return Makers;
	}

	public void setMakers(List<Maker> Makers) {
		this.Makers = Makers;
	}
}