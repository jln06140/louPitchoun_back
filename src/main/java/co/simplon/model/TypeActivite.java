package co.simplon.model;

import javax.persistence.*;

import co.simplon.enums.ActiviteEnum;

@Entity
public class TypeActivite {

	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	private ActiviteEnum typeActivite;
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public ActiviteEnum getTypeActivite() {
		return typeActivite;
	}
	public void setTypeActivite(ActiviteEnum typeActivite) {
		this.typeActivite = typeActivite;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
