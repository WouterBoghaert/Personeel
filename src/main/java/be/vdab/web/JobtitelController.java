package be.vdab.web;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Jobtitel;
import be.vdab.services.JobtitelService;
import be.vdab.services.WerknemerService;

@Controller
@RequestMapping("/jobtitels")
class JobtitelController {
	private static final String JOBTITELS_VIEW = "jobtitels/jobtitels";
	
	private final JobtitelService jobtitelService;
	private final WerknemerService werknemerService;
	
	protected JobtitelController(JobtitelService jobtitelService,
			WerknemerService werknemerService) {
		this.jobtitelService = jobtitelService;
		this.werknemerService = werknemerService;
	}
	
	@GetMapping("/jobtitels")
	ModelAndView toonJobtitels() {
		return new ModelAndView(JOBTITELS_VIEW, "jobtitels", 
			jobtitelService.findAll(new Sort("naam")));
	}
	
	@GetMapping("/jobtitels/{jobtitel}")
	ModelAndView toonWerknemersPerJobtitel(@PathVariable Jobtitel jobtitel) {
		ModelAndView modelAndView = new ModelAndView(JOBTITELS_VIEW);
		modelAndView.addObject("jobtitels", jobtitelService.findAll(new Sort("naam")));
		if(jobtitel != null) {
			modelAndView.addObject("werknemers", werknemerService.findByJobtitelId(jobtitel.getId()));
		}
		return modelAndView;
	}
	
	
}
