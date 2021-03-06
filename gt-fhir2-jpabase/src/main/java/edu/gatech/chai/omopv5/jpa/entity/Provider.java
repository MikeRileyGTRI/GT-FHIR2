package edu.gatech.chai.omopv5.jpa.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="provider")
@Inheritance(strategy=InheritanceType.JOINED)
public class Provider extends BaseEntity {

	public static final String RES_TYPE = "Provider";
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="provider_seq_gen")
	@SequenceGenerator(name="provider_seq_gen", sequenceName="provider_id_seq", allocationSize=1)

	@Column(name="provider_id")
	@Access(AccessType.PROPERTY)
	private Long id;
	
	@Column(name="provider_name", length = 50)
	private String providerName;

	@Column(name="npi", length = 20)
	private String npi;
	
	@Column(name="dea", length = 20)
	private String dea;
	
	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="specialty_concept_id")
	private Concept specialtyConcept;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="care_site_id")
	private CareSite careSite;
	
	@Column(name="year_of_birth")
	private Integer yearOfBirth;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.MERGE})
	@JoinColumn(name="gender_concept_id")
	private Concept genderConcept;

	@Column(name="provider_source_value", length = 50)
	private String providerSourceValue;
	
	@Column(name="specialty_source_value", length = 50)
	private String specialtySourceValue;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade={CascadeType.MERGE})
	@JoinColumn(name="specialty_source_concept_id")
	private Concept specialtySourceConcept;

	@Column(name="gender_source_value", length = 50)
	private String genderSourceValue;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade={CascadeType.MERGE})
	@JoinColumn(name="gender_source_concept_id")
	private Concept genderSourceConcept;

	public Provider() {
		super();
	}
	
	public Provider(Long id, String providerName, String npi, String dea, Concept specialtyConcept, 
			CareSite careSite, Integer yearOfBirth, Concept genderConcept, String providerSourceValue, 
			String specialtySourceValue, Concept specialtySourceConcept, String genderSourceValue,
			Concept genderSourceConcept) {
		this.id = id;
		this.providerName = providerName;
		this.npi = npi;
		this.dea = dea;
		this.specialtyConcept = specialtyConcept;
		this.careSite = careSite;
		this.yearOfBirth = yearOfBirth;
		this.genderConcept = genderConcept;
		this.providerSourceValue = providerSourceValue;
		this.specialtySourceValue = specialtySourceValue;
		this.specialtySourceConcept = specialtySourceConcept;
		this.genderSourceValue = genderSourceValue;
		this.genderSourceConcept = genderSourceConcept;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getProviderName() {
		return providerName;
	}
	
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
	public String getNpi() {
		return npi;
	}
	
	public void setNpi(String npi) {
		this.npi = npi;
	}
	
	public String getDea() {
		return dea;
	}
	
	public void setDea(String dea) {
		this.dea = dea;
	}
	
	public Concept getSpecialtyConcept() {
		return specialtyConcept;
	}
	
	public void setSpecialtyConcept(Concept specialtyConcept) {
		this.specialtyConcept = specialtyConcept;
	}
	
	public CareSite getCareSite() {
		return careSite;
	}
	
	public void setCareSite(CareSite careSite) {
		this.careSite = careSite;
	}
	
	public Integer getYearOfBirth() {
		return yearOfBirth;
	}
	
	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	
	public Concept getGenderConcept() {
		return genderConcept;
	}

	public void setGenderConcept(Concept genderConcept) {
		this.genderConcept = genderConcept;
	}
	
	public String getProviderSourceValue() {
		return providerSourceValue;
	}
	
	public void setProviderSourceValue(String providerSourceValue) {
		this.providerSourceValue = providerSourceValue;
	}

	public Concept getSpecialtySourceConcept() {
		return specialtySourceConcept;
	}

	public void setSpecialtySourceConcept(Concept specialtySourceConcept) {
		this.specialtySourceConcept = specialtySourceConcept;
	}

	public String getSpecialtySourceValue() {
		return specialtySourceValue;
	}
	
	public void setSpecialtySourceValue(String specialtySourceValue) {
		this.specialtySourceValue = specialtySourceValue;
	}
	
	public String getGenderSourceValue() {
		return genderSourceValue;
	}

	public void setGenderSourceValue(String genderSourceValue) {
		this.genderSourceValue = genderSourceValue;
	}

	public Concept getGenderSourceConcept() {
		return genderSourceConcept;
	}

	public void setGenderSourceConcept(Concept genderSourceConcept) {
		this.genderSourceConcept = genderSourceConcept;
	}
	
}
