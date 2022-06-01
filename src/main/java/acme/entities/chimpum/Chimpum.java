package acme.entities.chimpum;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.artifact.Artifact;
import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Chimpum extends AbstractEntity{

	//Serialisation identifier
	
	protected static final long serialVersionUID= 1L;
	
	
	//Attributes announcement
	
		@Column(unique=true)
		@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$",  message = "default.error.conversion")
		protected  String code;
	
		@Temporal(TemporalType.TIMESTAMP)
		@Past
		protected Date creationMoment;
		
		@NotBlank
		@Length(min=1,max=100)
		protected String title;
		
		@NotBlank
		@Length(min=1,max=255)
		protected String description;
		
		@Temporal(TemporalType.TIMESTAMP)
		protected Date period;
		
		protected Money budget;
		
		@URL
		protected String link;
		
		
		//Relationships
		@Valid
		@OneToOne(optional = true)
		protected Artifact artefact;	
		
	
}
