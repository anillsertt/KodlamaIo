package kodlama.io.KodlamaIo.bussiness.abstracts;


import kodlama.io.KodlamaIo.bussiness.request.language.CreateLanguageRequest;
import kodlama.io.KodlamaIo.bussiness.request.language.DeleteLanguageRequest;
import kodlama.io.KodlamaIo.bussiness.request.language.UpdateLanguageRequest;
import kodlama.io.KodlamaIo.bussiness.response.GetAllLanguageResponse;

import java.util.List;

public interface LanguageService {
	List<GetAllLanguageResponse> getAll();
    void add(CreateLanguageRequest createLanguageRequest);
    void delete(DeleteLanguageRequest deleteLanguageRequest);
    void update(int id, UpdateLanguageRequest updateLanguageRequest);

}
