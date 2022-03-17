package acme.artifact;

import java.awt.Toolkit;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import acme.framework.entities.AbstractEntity;

public class PartOf extends AbstractEntity{
	
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;
	
	//Attributes
	protected Integer quantity;
	
	
	
	//Relationships
	
	@NotNull
	@Valid 
	@ManyToOne(optional=false)
	protected Artifact artifact;
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected Toolkit toolkit;
	
	

}
