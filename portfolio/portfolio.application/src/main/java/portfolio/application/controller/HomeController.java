package portfolio.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import portfolio.domain.entity.b3.B3Asset;
import portfolio.domain.entity.b3.Stock;

@Controller
public class HomeController {

	@GetMapping(value = "/")
	public String index(Model model) {
		B3Asset asset = new Stock("BBAS3");

		model.addAttribute("ticker", asset.getAssetData().getTicker());

		return "index";
	}

}
