package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.WerknemerService;

@Controller
@RequestMapping("/werknemers")
class WerknemerController {
	private static final String WERKNEMER_VIEW = "werknemers/werknemer";
	
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
				modelAndView.addObject("ondergeschikten", werknemerService.findByChefId(chef.getId()));
			});		
		return modelAndView;
	}
}
