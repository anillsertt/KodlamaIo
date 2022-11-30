package kodlama.io.KodlamaIo.bussiness.concretes;

import kodlama.io.KodlamaIo.bussiness.abstracts.LanguageService;
import kodlama.io.KodlamaIo.bussiness.request.language.CreateLanguageRequest;
import kodlama.io.KodlamaIo.bussiness.request.language.DeleteLanguageRequest;
import kodlama.io.KodlamaIo.bussiness.request.language.UpdateLanguageRequest;
import kodlama.io.KodlamaIo.bussiness.response.GetAllLanguageResponse;
import kodlama.io.KodlamaIo.dataAccess.abstracts.LangugageRepository;
import kodlama.io.KodlamaIo.entities.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LanguageManager implements LanguageService {

    LangugageRepository langugageRepository;

    @Autowired
    public LanguageManager(LangugageRepository langugageRepository){
        this.langugageRepository = langugageRepository;
    }

    public boolean languageNameExist(Language languageName){
        List<Language> languageList = langugageRepository.findAll();
        for (Language language2 : languageList){
            if (language2.getName().toLowerCase().matches(languageName.getName().toLowerCase())){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<GetAllLanguageResponse> getAll() {
        List<Language> languages = langugageRepository.findAll();
        List<GetAllLanguageResponse> languageResponses = new ArrayList<GetAllLanguageResponse>();

        for (Language language : languages){
            GetAllLanguageResponse responseItem = new GetAllLanguageResponse();
            responseItem.setId(language.getId());
            responseItem.setName(language.getName());
            languageResponses.add(responseItem);
        }
        return languageResponses;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) {
        Language language = new Language();
        language.setName(createLanguageRequest.getName());
        if (!languageNameExist(language)){
            langugageRepository.save(language);
        }
        else {
            System.out.println("Name Exist");
        }
    }

    @Override
    public void delete(DeleteLanguageRequest deleteLanguageRequest) {
        Language language = new Language();
        language.setName(deleteLanguageRequest.getName());
        if (languageNameExist(language)){
            langugageRepository.delete(language);
        }
        else {
            System.out.println("There is no language registered to this name");
        }
    }

    @Override
    public void update(int id, UpdateLanguageRequest updateLanguageRequest) {
        for (Language language : langugageRepository.findAll()){
            if (language.getName().equals(updateLanguageRequest.getName())){
                Language language1 = langugageRepository.findById(id).get();
                language1.setName(updateLanguageRequest.getName());
                langugageRepository.save(language1);
            }
        }
    }
}
