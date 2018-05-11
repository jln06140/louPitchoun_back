package co.simplon.model;

import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Enfant {

	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO)
	private long id;

	@ManyToMany( mappedBy = "enfants")
	private List<Utilisateur> geniteurs;
	
	@OneToOne
	@MapsId
	@JoinColumn ( name = "id_enfant_info")
	private EnfantInfo enfantInfo;

	@ManyToOne
	@JoinColumn ( name = "id_section")
	private Section section;

	@CreatedDate
	private LocalDateTime createdDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public List<Utilisateur> getGeniteurs() {
		return geniteurs;
	}

	public void setGeniteurs(List<Utilisateur> geniteurs) {
		this.geniteurs = geniteurs;
	}

	public EnfantInfo getEnfantInfo() {
		return enfantInfo;
	}

	public void setEnfantInfo(EnfantInfo enfantInfo) {
		this.enfantInfo = enfantInfo;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Enfant{" +
				"enfantInfo=" + enfantInfo.toString() +
				'}';
	}
}
