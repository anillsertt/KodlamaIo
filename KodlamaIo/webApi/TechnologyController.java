package kodlama.io.KodlamaIo.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kodlama.io.KodlamaIo.bussiness.abstracts.TechnologyService;
import kodlama.io.KodlamaIo.bussiness.request.technology.CreateTechnologyRequest;import kodlama.io.KodlamaIo.bussiness.request.technology.DeleteTechnologyRequest;
import kodlama.io.KodlamaIo.bussiness.request.technology.UpdateTechnologyRequest;
import kodlama.io.KodlamaIo.bussiness.response.GetAllTechnologyResponse;

public class TechnologyController {
	
	private TechnologyService technologyService;

	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	
	@GetMapping("/getAll")
	public List<GetAllTechnologyResponse> getAll(){
		return technologyService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		technologyService.add(createTechnologyRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyService.delete(deleteTechnologyRequest);
	}
	
	@PutMapping("/update")
	public void update(@PathVariable int id,@RequestBody UpdateTechnologyRequest updateTechnologyRequest) {
		technologyService.update(id, updateTechnologyRequest);
	}
	
}
