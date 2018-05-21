package co.simplon.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Enfant {

	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO)
	private long id;

	@ManyToMany( mappedBy = "enfants",fetch = FetchType.EAGER)
	private List<Utilisateur> geniteurs;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn ( name = "id_enfant_info")
	private EnfantInfo enfantInfo;

	@ManyToOne
	@JsonBackReference
	@JoinColumn ( name = "id_section")
	private Section section;

	@OneToMany(mappedBy = "enfant", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<JourneeEnfant> journees = new ArrayList<>();

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

	public List<JourneeEnfant> getJournees() {
		return journees;
	}

	public void setJournees(List<JourneeEnfant> journees) {
		this.journees = journees;
	}

	public boolean isJourneeEnCours(){
		for( JourneeEnfant journeeEnfant : this.getJournees()){
			if (journeeEnfant.isJourneeEnCours()){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Enfant{" +
				"enfantInfo=" + enfantInfo.toString() +
				'}';
	}
}
