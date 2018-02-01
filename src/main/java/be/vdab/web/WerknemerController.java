package be.vdab.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Werknemer;
import be.vdab.services.WerknemerService;

@Controller
@RequestMapping("/werknemers")
class WerknemerController {
	private static final String WERKNEMER_VIEW = "werknemers/werknemer";
	private static final String OPSLAG_VIEW	= "werknemers/opslag";
	private static final String REDIRECT_NA_POST_OPSLAG = "redirect:/werknemers/werknemer/{werknemer}";
	
	private final WerknemerService werknemerService;
	
	protected WerknemerController(WerknemerService werknemerService) {
		this.werknemerService = werknemerService;
	}

	@GetMapping("/werknemer")
	ModelAndView toonChef() {
		ModelAndView modelAndView = new ModelAndView(WERKNEMER_VIEW);
		werknemerService.findByChefIsNull().ifPresent(chef -> 
			{
				modelAndView.addObject("werknemer", chef);
				modelAndView.addObject("ondergeschikten", 
					werknemerService.findByChefId(chef.getId()));
			});		
		return modelAndView;
	}
	
	@GetMapping("/werknemer/{werknemer}")
	ModelAndView toonWerknemer(@PathVariable Werknemer werknemer) {
		ModelAndView modelAndView = new ModelAndView(WERKNEMER_VIEW);
		if(werknemer != null) {
			modelAndView.addObject(werknemer);
			modelAndView.addObject("ondergeschikten", 
				werknemerService.findByChefId(werknemer.getId()));
		}	
		return modelAndView;
	}
	
	@GetMapping("/opslag/{werknemer}")
	ModelAndView opslagFormTonen(@PathVariable Werknemer werknemer) {
		return opslagForm(werknemer);
	}
	
	ModelAndView opslagForm(Werknemer werknemer) {
		ModelAndView modelAndView = new ModelAndView(OPSLAG_VIEW);
		if(werknemer != null) {
			modelAndView.addObject("opslagForm", new OpslagForm());
			modelAndView.addObject(werknemer);
		}
		return modelAndView;
	}
	
	@InitBinder("opslagForm")
	void initBinderOpslagForm(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
	
	@PostMapping("/opslag/{werknemer}")
	ModelAndView opslagFormVerwerken(@PathVariable Werknemer werknemer, 
		@Valid OpslagForm opslagForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return opslagForm(werknemer);
		}
		if(werknemer != null) {
			werknemer.geefOpslag(opslagForm.getOpslag());
			werknemerService.update(werknemer); // checken of nodig, checking voor locking
			return new ModelAndView(REDIRECT_NA_POST_OPSLAG);
		}
		return opslagForm(werknemer).addObject("fout","Er is geen correcte werknemer geselecteerd!");
	}
	
	// JSP schrijven voor deze controller, geen foutmelding vergeten geven indien
			// geen correcte werknemer geselecteerd is. JSoup en SafeHtml gebruiken om 
			// scripting tegen te gaan. Optimistic record locking doen. Checken indien
			// save method nodig is voor update, of enkel aanpassen in transactie genoeg is
			// Spring security nodig? 
			//@Valid gebruiken in post method
	// errorpagina's schrijven
}
