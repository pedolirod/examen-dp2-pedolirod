Pedro Oliva
juanlo017, ThisIsCaku, alefr99, aqh2000, alfonso_cade5

ThisIsCaku — 16/03/2022
Imagen
aqh2000
 ha iniciado una llamada que ha durado una hora.
 — 19/03/2022
Pedro Oliva — 19/03/2022
you need a map of the form Map<Pair<String/Technology/, String/Currency/>, Double/Average/> to model the requested average
juanlo017
 ha iniciado una llamada que ha durado una hora.
 — 20/03/2022
ThisIsCaku — 20/03/2022
spring.application.display-name = Acme Toolkit
spring.application.name = acme-toolkit
src/main/resources.application.properties
juanlo017 — 20/03/2022
Imagen
aqh2000 — 20/03/2022
anoncment-> boolean
aqh2000
 ha iniciado una llamada que ha durado 2 horas.
 — 21/03/2022
Pedro Oliva — 21/03/2022
Imagen
Imagen
alefr99 — 21/03/2022
Imagen
Pedro Oliva — 21/03/2022
Imagen
alefr99 — 21/03/2022
Imagen
aqh2000 — 21/03/2022
por cierto llevo un rato hablando q parece q no me va el micro
tragico
voy a ver si lo arreglo
aqh2000 — 21/03/2022
Tipo de archivo adjunto: unknown
Group_deliverables.docm
82.61 KB
ThisIsCaku — 21/03/2022
DXX - Title
1) Group deliverable
2) Project folder
alfonso_cade5
 ha iniciado una llamada que ha durado 2 horas.
 — 31/03/2022
ThisIsCaku — 31/03/2022
https://github.com/users/diecrequi/projects/1
GitHub
Build software better, together
GitHub is where people build software. More than 73 million people use GitHub to discover, fork, and contribute to over 200 million projects.
Build software better, together
ThisIsCaku — 31/03/2022
https://twitter.com/la__neoo/status/1509593263568732164

neo 🫶 (@la__neoo)
chicos no hay estrim hoy
Imagen

Twitter•31/03/2022
alfonso_cade5 — 31/03/2022
Imagen
Tienes una llamada perdida de 
aqh2000
 que ha durado 2 horas.
 — 19/04/2022
aqh2000 — 19/04/2022
@Query("select a from Artifact a where a.type = :arifact_type")
    Collection<Artifact> findManyTool(ArtifactType arifact_type);
final Artifact entity, final Model model
aqh2000 — 19/04/2022
super.addCommand("list-tool","list", this.listService);
http://localhost:8080/acme-toolkit-22.1/any/artifact/list-tool
Tienes una llamada perdida de 
aqh2000
 que ha durado 3 horas.
 — 20/04/2022
alfonso_cade5 — 20/04/2022
https://twitter.com/unisevilla/status/1516390355284934656?t=oJAns19SsSrTdm8Vj3nk9w&s=19

Universidad de Sevilla (@unisevilla)
🔴 ¡Atención! Información sobre el uso de mascarillas en la US.

#infoCOVID19US
Likes
201
Retweets
106
Imagen

Twitter•19/04/2022
aqh2000 — 20/04/2022
select p.artifact from partof p where p.toolkit.id = :toolkit 
Tienes una llamada perdida de 
juanlo017
 que ha durado unos segundos.
 — 20/04/2022
alfonso_cade5
 ha iniciado una llamada que ha durado una hora.
 — 21/04/2022
aqh2000 — 21/04/2022
package acme.testing.any.artifact;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyArtifactListTest extends TestHarness {

    // Lifecycle management ---------------------------------------------------

    // Test cases -------------------------------------------------------------

    @ParameterizedTest
    @CsvFileSource(resources = "any/artifact/list-tool.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(10)
    public void positive(final int recordIndex, final String Name, final String Code, final String Description, final String RetailPrice, final String Link) {
        super.clickOnMenu("Artifact", "Tool");
        super.checkListingExists();
        super.sortListing(0, "asc");
        super.checkColumnHasValue(recordIndex, 0, Name);
        super.checkColumnHasValue(recordIndex, 1, Code);
        super.checkColumnHasValue(recordIndex, 2, Description);

        super.clickOnListingRecord(recordIndex);
        super.checkFormExists();
        super.checkInputBoxHasValue("name", Name);
        super.checkInputBoxHasValue("code", Code);
        super.checkInputBoxHasValue("retail-price", RetailPrice);
        super.checkInputBoxHasValue("description", Description);
        super.checkInputBoxHasValue("link", Link);
    }

    // Ancillary methods ------------------------------------------------------

} 
Tienes una llamada perdida de 
juanlo017
 que ha durado una hora.
 — 23/04/2022
juanlo017 — 23/04/2022
@aqh2000
aqh2000 — 23/04/2022
se me ha caido??
aqh2000 — 23/04/2022
request.getPrincipal().getActiveRoleId();
aqh2000
 ha iniciado una llamada que ha durado una hora.
 — ayer a las 20:03
aqh2000 — ayer a las 20:14
Imagen
ThisIsCaku — ayer a las 20:21
Imagen
map.entrySet()
aqh2000 — ayer a las 20:24
<acme:input-textbox code="mapa.key.first+mapa.key.second"" path="mapa.value"/> 
aqh2000 — ayer a las 20:43
Imagen
<acme:button code="any.toolkit.form.button.partOf" action="/any/part-of/list?masterId=${id}"/>
aqh2000 — ayer a las 21:08
<acme:menu-option code="any.menu.artifact" access="isAnonymous()">
            <acme:menu-suboption code="any.menu.artifact.tool" action="/any/artifact/list-tool"/>
            <acme:menu-suboption code="any.menu.artifact.component" action="/any/artifact/list-component"/>
        </acme:menu-option>
aqh2000
 ha iniciado una llamada.
 — hoy a las 18:33
aqh2000 — hoy a las 19:20
Imagen
aqh2000 — hoy a las 20:09
package acme.features.administrator.AdminDashboard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
Expandir
AdminDashboardShowService.java
12 KB
﻿
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
import acme.datatypes.StatusType;
import acme.entities.patronage.Patronage;
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
		request.unbind(entity, model, "totalNumberOfComponents", "avgPrize");
	}

	


	@Override
	public AdminDashboard findOne(final Request<AdminDashboard> request) {
		final AdminDashboard result= new AdminDashboard();
		//All properties regarding the components:
		final int n = this.repository.findArtifact(ArtifactType.COMPONENT).size();

		
		final Map<Pair<String, String>, Double> mTechCurr= new HashMap<Pair<String, String>, Double>();
		final Map<Pair<String, String>, Double> mDesviation= new HashMap<Pair<String, String>, Double>();
		final Map<Pair<String, String>, Double> mMax= new HashMap<Pair<String, String>, Double>();
		final Map<Pair<String, String>, Double> mMin= new HashMap<Pair<String, String>, Double>();

		for(final String technology: this.findTechnologies(ArtifactType.COMPONENT)) {
			int nEur= 0;
			int nUsd= 0;
			int nGbp= 0;
			Double totalEur= 0.;
			Double totalUsd= 0.;
			Double totalGbp= 0.;
			Double maxEur= 0.;
			
			Double desviationEur= 0.;
			Double desviationUsd= 0.;
			Double desviationGbp= 0.;
			
			final Collection<Artifact> componentList = this.repository.findArtifactTechnologyCurrency(technology, ArtifactType.COMPONENT);
			final List<Artifact> cl= new ArrayList<Artifact>(componentList);
			
			Double maxUsd=cl.get(0).getRetailPrice().getAmount();
			Double maxGbp=cl.get(0).getRetailPrice().getAmount();
			Double minEur= cl.get(0).getRetailPrice().getAmount();
			Double minUsd= cl.get(0).getRetailPrice().getAmount();
			Double minGbp= cl.get(0).getRetailPrice().getAmount();
			
			for(final Artifact c: componentList) {
				final Double prize = c.getRetailPrice().getAmount(); 
				switch (c.getRetailPrice().getCurrency()) {
				case "EUR":
					totalEur+=c.getRetailPrice().getAmount();
					nEur++;
					
					maxEur= prize>maxEur?prize:maxEur;
					minEur= prize<minEur?prize:minEur;
					
					break;
				case "USD":
					totalUsd+=c.getRetailPrice().getAmount();
					nUsd++;

					maxUsd= prize>maxUsd?prize:maxUsd;
					minUsd= prize<minUsd?prize:minUsd;
					
					break;
				case "GBP":
					totalGbp+=c.getRetailPrice().getAmount();
					nGbp++;

					maxGbp= prize>maxGbp?prize:maxGbp;
					minGbp= prize<minGbp?prize:minGbp;
					
					break;
				}
				
			}
			for(final Artifact c: componentList) {
				switch (c.getRetailPrice().getCurrency()) {
				case "EUR":
					desviationEur+=(c.getRetailPrice().getAmount() - totalEur!=0?totalEur/nEur:0.)
						  *(c.getRetailPrice().getAmount() - totalEur!=0?totalEur/nEur:0.);
					break;
				case "USD":
					desviationUsd+=(c.getRetailPrice().getAmount() - totalUsd!=0?totalUsd/nUsd:0.)
						  *(c.getRetailPrice().getAmount() - totalUsd!=0?totalUsd/nUsd:0.);
					break;
				case "GBP":
					desviationGbp+=(c.getRetailPrice().getAmount() - totalGbp!=0?totalGbp/nGbp:0.)
						  *(c.getRetailPrice().getAmount() - totalGbp!=0?totalGbp/nGbp:0.);
					break;
				}
			}
			final Pair<String, String> pEur = Pair.of(technology, "EUR");
			final Pair<String, String> pUsd = Pair.of(technology, "USD");
			final Pair<String, String> pGbp = Pair.of(technology, "GBP");
			
			mTechCurr.put(pEur, totalEur!=0?totalEur/nEur:0.);
			mTechCurr.put(pUsd, totalUsd!=0?totalUsd/nUsd:0.);
			mTechCurr.put(pGbp, totalGbp!=0?totalGbp/nGbp:0.);
			mMax.put(pEur, maxEur);
			mMax.put(pEur, maxUsd);
			mMax.put(pEur, maxGbp);
			mMin.put(pEur, minEur);
			mMin.put(pEur, minUsd);
			mMin.put(pEur, minGbp);
			mDesviation.put(pEur, nEur!=0?Math.sqrt(desviationEur/nEur):0);
			mDesviation.put(pUsd, nUsd!=0?Math.sqrt(desviationUsd/nUsd):0);
			mDesviation.put(pGbp, nGbp!=0?Math.sqrt(desviationGbp/nGbp):0);
		}
		
		//All properties regarding the tool:
		final int nTools = this.repository.findArtifact(ArtifactType.TOOL).size();

		
		final Map<String, Double> mTechCurrTools= new HashMap<String, Double>();
		final Map<String, Double> mDesviationTools= new HashMap<String, Double>();
		final Map<String, Double> mMaxTools= new HashMap<String, Double>();
		final Map<String, Double> mMinTools= new HashMap<String, Double>();

		
		int nEur= 0;
		int nUsd= 0;
		int nGbp= 0;
		Double totalEur= 0.;
		Double totalUsd= 0.;
		Double totalGbp= 0.;
		Double maxEur= 0.;
		
		Double desviationEur= 0.;
		Double desviationUsd= 0.;
		Double desviationGbp= 0.;
			
		final Collection<Artifact> toolList = this.repository.findArtifact(ArtifactType.TOOL);
		final List<Artifact> cl= new ArrayList<Artifact>(toolList);
		
		Double maxUsd=cl.get(0).getRetailPrice().getAmount();
		Double maxGbp=cl.get(0).getRetailPrice().getAmount();
		Double minEur= cl.get(0).getRetailPrice().getAmount();
		Double minUsd= cl.get(0).getRetailPrice().getAmount();
		Double minGbp= cl.get(0).getRetailPrice().getAmount();
		
		for(final Artifact c: toolList) {
			final Double prize = c.getRetailPrice().getAmount(); 
			switch (c.getRetailPrice().getCurrency()) {
			case "EUR":
				totalEur+=c.getRetailPrice().getAmount();
				nEur++;
				
				maxEur= prize>maxEur?prize:maxEur;
				minEur= prize<minEur?prize:minEur;
				
				break;
			case "USD":
				totalUsd+=c.getRetailPrice().getAmount();
				nUsd++;

				maxUsd= prize>maxUsd?prize:maxUsd;
				minUsd= prize<minUsd?prize:minUsd;
				
				break;
			case "GBP":
				totalGbp+=c.getRetailPrice().getAmount();
				nGbp++;

				maxGbp= prize>maxGbp?prize:maxGbp;
				minGbp= prize<minGbp?prize:minGbp;
				
				break;
			}
			
		}
		for(final Artifact c: toolList) {
			switch (c.getRetailPrice().getCurrency()) {
			case "EUR":
				desviationEur+=(c.getRetailPrice().getAmount() - totalEur!=0?totalEur/nEur:0.)
					  *(c.getRetailPrice().getAmount() - totalEur!=0?totalEur/nEur:0.);
				break;
			case "USD":
				desviationUsd+=(c.getRetailPrice().getAmount() - totalUsd!=0?totalUsd/nUsd:0.)
					  *(c.getRetailPrice().getAmount() - totalUsd!=0?totalUsd/nUsd:0.);
				break;
			case "GBP":
				desviationGbp+=(c.getRetailPrice().getAmount() - totalGbp!=0?totalGbp/nGbp:0.)
					  *(c.getRetailPrice().getAmount() - totalGbp!=0?totalGbp/nGbp:0.);
				break;
			}
		}
		
		
		mTechCurrTools.put("EUR", totalEur!=0?totalEur/nEur:0.);
		mTechCurrTools.put("USD", totalUsd!=0?totalUsd/nUsd:0.);
		mTechCurrTools.put("GBP", totalGbp!=0?totalGbp/nGbp:0.);
		mMaxTools.put("EUR", maxEur);
		mMaxTools.put("USD", maxUsd);
		mMaxTools.put("GBP", maxGbp);
		mMinTools.put("EUR", minEur);
		mMinTools.put("USD", minUsd);
		mMinTools.put("GBP", minGbp);
		mDesviationTools.put("EUR", nEur!=0?Math.sqrt(desviationEur/nEur):0);
		mDesviationTools.put("USD", nUsd!=0?Math.sqrt(desviationUsd/nUsd):0);
		mDesviationTools.put("GBP", nGbp!=0?Math.sqrt(desviationGbp/nGbp):0);
	
		//All properties regarding the patronages:
			final Map<StatusType, Integer> mPatronage= new HashMap<StatusType, Integer>();
			final Map<StatusType, Double> mAvgPatronage= new HashMap<StatusType, Double>();
			final Map<StatusType, Double> mDesviationPatronage= new HashMap<StatusType, Double>();
			final Map<StatusType, Double> mMaxPatronage= new HashMap<StatusType, Double>();
			final Map<StatusType, Double> mMinPatronage= new HashMap<StatusType, Double>();
			
			for (int i=0; i<3;i++) {
				final Collection<Patronage> patronages= this.repository.findPatronage(StatusType.values()[i]);
				final List<Patronage> pl= new ArrayList<Patronage>(patronages);
				
				final int nPatronage = patronages.size();
				Double totalPatronage= 0.;
				Double maxPatronage= pl.get(0).getBudget().getAmount();
				Double minPatronage= pl.get(0).getBudget().getAmount();
				Double desviationPatronage= 0.;
							
				for(final Patronage p:patronages) {
					final double prize= p.getBudget().getAmount();
					
					totalPatronage+=prize;
					maxPatronage= prize>maxPatronage?prize:maxPatronage;
					minPatronage= prize<maxPatronage?prize:maxPatronage;
					
				}
				for(final Patronage p:patronages) {
					final double prize= p.getBudget().getAmount();
					
					desviationPatronage+=(prize - totalPatronage/nPatronage)
						  *(prize - totalPatronage/nPatronage);
				}
				
				mPatronage.put(StatusType.values()[i], nPatronage);
				mMaxPatronage.put(StatusType.values()[i], maxPatronage);
				mMinPatronage.put(StatusType.values()[i], minPatronage);
				mAvgPatronage.put(StatusType.values()[i], totalPatronage/nPatronage);
				mDesviationPatronage.put(StatusType.values()[i], Math.sqrt(desviationPatronage/nPatronage));
			}
		
		result.setTotalNumberOfComponents(n);
		result.setDeviationPrize(mDesviation);
		result.setAvgPrize(mTechCurr);
		result.setMaxPrize(mMax);
		result.setMinPrize(mMin);
		result.setTotalNumberOfTools(nTools);
		result.setAvgPrize(mTechCurr);
		result.setDeviationTools(mDesviationTools);
		result.setMaxTools(mMaxTools);
		result.setMinTools(mMinTools);
		result.setTotalNumberOfPatronages(mPatronage);
		result.setAvgBudget(mAvgPatronage);
		result.setDeviationBudget(mDesviationPatronage);
		result.setMaxdBudget(mMaxPatronage);
		result.setMinBudget(mMinPatronage);
		return result;
	}

	

	private HashSet<String> findTechnologies(final ArtifactType a){
		final HashSet<String> s= new HashSet<String>();
		final Collection<Artifact> lis = this.repository.findArtifact(a);
		for(final Artifact c: lis) {
			s.add(c.getTechnology());			
		}
		return s;
	}
}
AdminDashboardShowService.java
12 KB
