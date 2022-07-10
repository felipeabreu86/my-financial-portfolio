package portfolio.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import portfolio.application.controller.request.B3AssetCreateRequest;
import portfolio.domain.entity.b3.B3Asset;
import portfolio.service.B3Service;

/**
 * Controller that receives requests via '/b3' path and processes and redirects
 * them for its specific purposes
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Controller
@RequestMapping(value = "/b3")
public class B3Controller {

	/**
	 * Reference to B3 Service implementation
	 */
	@Autowired
	private B3Service b3Service;

	/**
	 * Receives a request via POST method, validates the data sent and registers a
	 * new asset in the database
	 * 
	 * @param model   - Interface that defines a holder for model attributes
	 * @param request - Data sent in the request body
	 * @return HTTP status 201 (Created) or some HTTP error if applicable
	 */
	@PostMapping(value = "/save")
	public ResponseEntity<Object> saveB3Asset(Model model, @RequestBody @Valid B3AssetCreateRequest request) {
		B3Asset asset = request.toB3Asset();
		
		b3Service
			.getB3Usecases()
			.saveAssetUsecase
			.call(asset);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
