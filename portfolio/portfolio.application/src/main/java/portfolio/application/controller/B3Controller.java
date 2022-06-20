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
import portfolio.dataprovider.model.B3AssetModel;
import portfolio.domain.usecase.B3Usecases;

@Controller
@RequestMapping(value = "/b3")
public class B3Controller {

	@Autowired
	private B3Usecases b3Usecases;

	@PostMapping(value = "/save")
	public ResponseEntity<Object> saveB3Asset(Model model, @RequestBody @Valid B3AssetCreateRequest request) {
		B3AssetModel assetModel = B3AssetModel.from(request.toB3Asset());
		b3Usecases.saveAssetUsecase.call(assetModel);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
