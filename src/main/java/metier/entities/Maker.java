package metier.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Maker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMaker;
	private String MakerName;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@OneToMany(mappedBy = "maker")
	private List<Car> Cars;

	public Maker() {
	super();
	}

	public Maker(String MakerName, Date dateCreation) {
	super();
	this.MakerName = MakerName;
	this.dateCreation = dateCreation;
	}

	public Long getIdMaker() {
		return idMaker;
	}

	public void setIdMaker(Long idMaker) {
		this.idMaker = idMaker;
	}

	public String getMakerName() {
		return MakerName;
	}

	public void setMakerName(String MakerName) {
		this.MakerName = MakerName;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Car> getCars() {
		return Cars;
	}

	public void setCars(List<Car> Cars) {
		this.Cars = Cars;
	}
}
