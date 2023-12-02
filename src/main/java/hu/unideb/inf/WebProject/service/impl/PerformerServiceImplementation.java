package hu.unideb.inf.WebProject.service.impl;

import hu.unideb.inf.WebProject.DTO.PerformerDTO;
import hu.unideb.inf.WebProject.entity.Performer;
import hu.unideb.inf.WebProject.repository.PerformerRepository;
import hu.unideb.inf.WebProject.service.PerformerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PerformerServiceImplementation implements PerformerService {

    @Autowired
    private PerformerRepository performerRepository;

    @Override
    public PerformerDTO create(PerformerDTO performerDTO) {
        Performer performer = new Performer(performerDTO.performerId(), performerDTO.firstName(), performerDTO.lastName(), performerDTO.nickname(), performerDTO.password(), new ArrayList<>());
        performer = performerRepository.save(performer);
        return new PerformerDTO(performer.getPerformerId(), performer.getFirstName(), performer.getLastName(), performer.getNickname(), performer.getPassword());
    }

    @Override
    public List<PerformerDTO> readAll() {
        return performerRepository.findAll().stream().map((Performer performer) -> {
            return new PerformerDTO(performer.getPerformerId(), performer.getFirstName(), performer.getLastName(), performer.getNickname(), performer.getPassword());
        }).toList();
    }

    @Override
    public PerformerDTO update(PerformerDTO performerDTO) {
        Performer performer = new Performer(performerDTO.performerId(), performerDTO.firstName(), performerDTO.lastName(), performerDTO.nickname(), performerDTO.password(), new ArrayList<>());
        performer = performerRepository.save(performer);
        return new PerformerDTO(performer.getPerformerId(), performer.getFirstName(), performer.getLastName(), performer.getNickname(), performer.getPassword());
    }

    @Override
    public void delete(Long id) {
        performerRepository.delete(performerRepository.getReferenceById(id));
    }
}