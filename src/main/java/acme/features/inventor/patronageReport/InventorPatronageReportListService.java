package acme.features.inventor.patronageReport;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportListService implements AbstractListService<Inventor, PatronageReport> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorPatronageReportRepository repository;

	@Override
	public boolean authorise(Request<PatronageReport> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public Collection<PatronageReport> findMany(Request<PatronageReport> request) {
		assert request != null;
		
		Collection<PatronageReport> result;
		int id = request.getModel().getInteger("patronageId");
		result = this.repository.findAllPatronageReportByPatronageId(id);
		
		return result;
	}

	@Override
	public void unbind(Request<PatronageReport> request, PatronageReport entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "sequenceNumber", "memorandum");
		
	}

}
