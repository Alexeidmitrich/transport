package com.example.transport.service;

import com.example.transport.domain.Inspector;
import com.example.transport.exception.PersonNotFoundException;
import com.example.transport.repository.InspectorRepo;
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
    public void updateInspector(int id, Inspector inspector){
        Inspector inspect = inspectorRepo.getReferenceById(id);
        inspect.setFIO(inspector.getFIO());
        inspectorRepo.save(inspect);
    }
    public void addNewInspector(Inspector inspector){
        inspectorRepo.save(inspector);
    }
    public Inspector getInspectorById(int id){
        return inspectorRepo.findById(id).orElseThrow(()->new PersonNotFoundException("Inspector with id " + id + " was not found"));
    }
    public void deleteInspector(int id){
        inspectorRepo.deleteById(id);
    }
}
