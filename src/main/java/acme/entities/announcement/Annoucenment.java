package acme.entities.announcement;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Annoucenment extends AbstractEntity{

	//Serialisation identifier
	
	protected static final long serialVersionUID= 1L;
	
	
	//Attributes
	
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	protected Date creationMoment;
	
	@NotBlank
	@Length(min=1,max=101)
	protected String title;
	
	@NotBlank
	@Length(min=1,max=256)
	protected String body;
	
	
	protected Boolean flag;
	
	
	@URL
	protected String link;
	
	
}
