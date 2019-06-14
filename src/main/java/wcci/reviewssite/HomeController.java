package wcci.reviewssite;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	public HomeController() {
	}

	@RequestMapping("/")
	public String renderRoot(Model model) {
		model.addAttribute("home");
		return "home";
	}

	@RequestMapping("/home")
	public String renderHomePage(Model model) {
		model.addAttribute("home");
		return "home";
	}

}
