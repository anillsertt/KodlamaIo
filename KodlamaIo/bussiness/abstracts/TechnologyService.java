package kodlama.io.KodlamaIo.bussiness.abstracts;


import kodlama.io.KodlamaIo.bussiness.request.technology.CreateTechnologyRequest;
import kodlama.io.KodlamaIo.bussiness.request.technology.DeleteTechnologyRequest;
import kodlama.io.KodlamaIo.bussiness.request.technology.UpdateTechnologyRequest;
import kodlama.io.KodlamaIo.bussiness.response.GetAllTechnologyResponse;


import java.util.List;

public interface TechnologyService {
    List<GetAllTechnologyResponse> getAll();
    public void add(CreateTechnologyRequest createTechnologyRequest);
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest);
    public void update(int id, UpdateTechnologyRequest updateTechnologyRequest);
}
