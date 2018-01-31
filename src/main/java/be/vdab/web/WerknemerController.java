package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Werknemer;
import be.vdab.services.WerknemerService;

@Controller
@RequestMapping("/werknemers")
class WerknemerController {
	private static final String WERKNEMER_VIEW = "werknemers/werknemer";
	private static final String OPSLAG_VIEW	= "werknemers/opslag";
	
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
	ModelAndView opslagFormTonen(Werknemer werknemer) {
		ModelAndView modelAndView = new ModelAndView(OPSLAG_VIEW);
		if(werknemer != null) {
			modelAndView.addObject("opslagForm", new OpslagForm());
			modelAndView.addObject(werknemer);
		}
		return modelAndView;
		
		// JSP schrijven voor deze controller, geen foutmelding vergeten geven indien
		// geen correcte werknemer geselecteerd is.
	}
}
