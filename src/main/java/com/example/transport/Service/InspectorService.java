package com.example.transport.Service;

import com.example.transport.Domain.Inspector;
import com.example.transport.Repository.InspectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InspectorService {
    @Autowired
    private InspectorRepo inspectorRepo;

    public List<Inspector> getAllInspector(){
        return inspectorRepo.findAll();
    }
    private void updateInspector(Inspector inspector, int id){
        Inspector inspect = inspectorRepo.getReferenceById(id);
        inspect.setFirstname(inspector.getFirstname());
        inspectorRepo.save(inspect);
    }
    public void addNewInspector(Inspector inspector){
        inspectorRepo.save(inspector);
    }
    public Optional<Inspector> getInspectorById(int id){
        return inspectorRepo.findById(id);
    }
    public void deleteInspector(int id){
        inspectorRepo.deleteById(id);
    }
}
