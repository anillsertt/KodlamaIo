package kodlama.io.KodlamaIo.bussiness.concretes;

import kodlama.io.KodlamaIo.bussiness.abstracts.TechnologyService;
import kodlama.io.KodlamaIo.bussiness.request.technology.CreateTechnologyRequest;
import kodlama.io.KodlamaIo.bussiness.request.technology.DeleteTechnologyRequest;
import kodlama.io.KodlamaIo.bussiness.request.technology.UpdateTechnologyRequest;
import kodlama.io.KodlamaIo.bussiness.response.GetAllTechnologyResponse;
import kodlama.io.KodlamaIo.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.KodlamaIo.entities.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TechnologyManager implements TechnologyService {

    public TechnologyRepository technologyRepository;

    @Autowired
    public TechnologyManager(TechnologyRepository technologyRepository){
        super();
        this.technologyRepository = technologyRepository;
    }



    @Override
    public List<GetAllTechnologyResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        List<GetAllTechnologyResponse> technologyResponses = new ArrayList<GetAllTechnologyResponse>();

        for (Technology technology : technologies){
            GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();
            responseItem.setId(technology.getId());
            responseItem.setName(technology.getName());
            technologyResponses.add(responseItem);
        }
        return technologyResponses;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) {
        Technology technology = new Technology();
        technology.setName(createTechnologyRequest.getName());
        if (!TechnologyNameExist(technology)){
            technologyRepository.save(technology);
        }
        else {
            System.out.println("Name Exist");
        }
    }

    @Override
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
        Technology technology = new Technology();
        technology.setName(deleteTechnologyRequest.getName());

        if (TechnologyNameExist(technology)){
            technologyRepository.delete(technology);
        }
        else {
            System.out.println("Name doen't exist");
        }
    }

    @Override
    public void update(int id, UpdateTechnologyRequest updateTechnologyRequest) {
        for (Technology technology : technologyRepository.findAll()){

            if (TechnologyNameExist(technology)){
                Technology technology1 = technologyRepository.findById(id).get();
                technologyRepository.save(technology1);
            }
        }
    }
    public boolean TechnologyNameExist (Technology technology){
        List<Technology> technologies = technologyRepository.findAll();
        for (Technology technology1 : technologies){
            if(technology.getName().toLowerCase().matches(technology1.getName().toLowerCase())){
                return true;
            }
        }
        return false;
    }
}
