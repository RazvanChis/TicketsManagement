package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Spectacol")
public class Spectacol {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "spectacol_Id", unique = true, nullable = true)
	private int spectacolId;

	@Column(name = "name", nullable = true, length = 30)
	private String name;

	@Column(name = "gen", nullable = true)
	private double gen;

	@Column(name = "stil", nullable = true)
	private String stil;

	@Column(name = "regie", nullable = true)
	private String regie;
	
	@Column(name = "data_Premierei", nullable = true)
	private String dataPremierei;
	
	@Column(name = "nr_bilete", nullable = true)
	private int nrBilete;

	public int getSpectacolId() {
		return spectacolId;
	}

	public void setSpectacolId(int spectacolId) {
		this.spectacolId = spectacolId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGen() {
		return gen;
	}

	public void setGen(double gen) {
		this.gen = gen;
	}

	public String getStil() {
		return stil;
	}

	public void setStil(String stil) {
		this.stil = stil;
	}

	public String getRegie() {
		return regie;
	}

	public void setRegie(String regie) {
		this.regie = regie;
	}

	public String getDataPremierei() {
		return dataPremierei;
	}

	public void setDataPremierei(String dataPremierei) {
		this.dataPremierei = dataPremierei;
	}

	public int getNrBilete() {
		return nrBilete;
	}

	public void setNrBilete(int nrBilete) {
		this.nrBilete = nrBilete;
	}

}
