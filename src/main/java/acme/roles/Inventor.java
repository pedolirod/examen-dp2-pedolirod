package acme.roles;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.artifact.Artifact;
import acme.framework.roles.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Inventor extends UserRole{

	//Serialisation identifier 
	
	protected static final long serialVersionUID = 1L;
	
	
	
	//Attributes
	
	@NotBlank
	@Length(min=1,max=101)
	protected String company;
	
	@NotBlank
	@Length(min=1,max=256)
	protected String statement;
	
	@URL
	protected String link;
	
	//Relationships
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected Artifact artifact;
	
	
	
	
}
