package acme.systemSetting;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.type.CurrencyType;
import org.hibernate.validator.constraints.Range;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class systemSetting extends AbstractEntity{

	
	 //Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;
				
		
		
		//Attributes
		
		@Range(min=0,max=100)
		protected Integer weakSpamThreshold;
		
		
		@Range(min=0,max=100)
		protected Integer strongSpamThreshold;
		
		
		protected CurrencyType currency;
		
		@Pattern(regexp = "^[a-zA-Z0-9]{1,64}(,s[a-zA-Z0-9]{1,64})$",  message = "default.error.conversion")
		@NotBlank
		protected String weakSpam;
		
		
		@Pattern(regexp = "^[a-zA-Z0-9]{1,64}(,s[a-zA-Z0-9]{1,64})$",  message = "default.error.conversion")
		@NotBlank
		protected String strongSpam;
}
