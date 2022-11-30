package kodlama.io.KodlamaIo.webApi;


import kodlama.io.KodlamaIo.bussiness.abstracts.LanguageService;
import kodlama.io.KodlamaIo.bussiness.request.language.CreateLanguageRequest;
import kodlama.io.KodlamaIo.bussiness.request.language.DeleteLanguageRequest;
import kodlama.io.KodlamaIo.bussiness.request.language.UpdateLanguageRequest;
import kodlama.io.KodlamaIo.bussiness.response.GetAllLanguageResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/languages")
public class LanguageController {
    private LanguageService languageService;

    @Autowired
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
    
   @GetMapping("/getAll")
	public List<GetAllLanguageResponse> getAll(){
		return languageService.getAll();
	}
    
   @PostMapping("/add")
   public void add(@RequestBody CreateLanguageRequest createLanguageRequest) {
	   languageService.add(createLanguageRequest);
   }
   
   @DeleteMapping
   public void delete(@RequestBody DeleteLanguageRequest deleteLanguageRequest) {
	   languageService.delete(deleteLanguageRequest);
   }
   
   @PutMapping("/update/{id}")
   public void update(@PathVariable int id, @RequestBody UpdateLanguageRequest updateLanguageRequest) {
	   languageService.update(id, updateLanguageRequest);
   }
   

	

}
