package acme.features.administrator.AdminDashboard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import acme.Dashboard.AdminDashboard;
import acme.artifact.Artifact;
import acme.artifact.ArtifactType;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdminDashboardShowService implements AbstractShowService<Administrator, AdminDashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdminDashboardRepository repository;

	// AbstractShowService<Anonymous, Announcement> interface --------------------------

	@Override
	public boolean authorise(final Request<AdminDashboard> request) {
		assert request != null;

		

		return true;
	}

	@Override
	public void unbind(final Request<AdminDashboard> request, final AdminDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		model.setAttribute("adminDashboard", entity);
		final List<String> currencies = new ArrayList<>();
		currencies.add("EUR");
		currencies.add("USD");
		currencies.add("GBP");
		model.setAttribute("currencies", currencies);
		model.setAttribute("technologies", this.findTechnologies());
		request.unbind(entity, model, "totalNumberOfComponents", "avgPrize");
	}

	


	@Override
	public AdminDashboard findOne(final Request<AdminDashboard> request) {
		final AdminDashboard result= new AdminDashboard();
		final int n = this.repository.findArtifact(ArtifactType.COMPONENT).size();

		
		final Map<Pair<String, String>, Double> mTechCurr= new HashMap<Pair<String, String>, Double>();
		final Set<String> technologies = this.findTechnologies();
		for(final String technology: technologies) {
			int nEur= 0;
			int nUsd= 0;
			int nGbp= 0;
			Double totalEur= 0.;
			Double totalUsd= 0.;
			Double totalGbp= 0.;
			final Collection<Artifact> componentList = this.repository.findArtifactTechnologyCurrency(technology, ArtifactType.COMPONENT);
			for(final Artifact c: componentList) {
				
				switch (c.getRetailPrice().getCurrency()) {
				case "EUR":
					totalEur+=c.getRetailPrice().getAmount();
					nEur++;
					break;
				case "USD":
					totalUsd+=c.getRetailPrice().getAmount();
					nUsd++;
					break;
				case "GBP":
					totalGbp+=c.getRetailPrice().getAmount();
					nGbp++;
					break;
				}
				
			}
			final Pair<String, String> pEur = Pair.of(technology, "EUR");
			final Pair<String, String> pUsd = Pair.of(technology, "USD");
			final Pair<String, String> pGbp = Pair.of(technology, "GBP");
			
			mTechCurr.put(pEur, totalEur!=0?totalEur/nEur:0);
			mTechCurr.put(pUsd, totalUsd!=0?totalUsd/nUsd:0);
			mTechCurr.put(pGbp, totalGbp!=0?totalGbp/nGbp:0);
		}
		result.setTotalNumberOfComponents(n);
		result.setAvgPrize(mTechCurr);
		return result;
	}

	

	private HashSet<String> findTechnologies(){
		final HashSet<String> s= new HashSet<String>();
		final Collection<Artifact> lis = this.repository.findArtifact(ArtifactType.COMPONENT);
		for(final Artifact c: lis) {
			s.add(c.getTechnology());			
		}
		return s;
	}
}
