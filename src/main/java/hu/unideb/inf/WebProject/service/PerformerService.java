package hu.unideb.inf.WebProject.service;

import hu.unideb.inf.WebProject.DTO.PerformerDTO;

import java.util.List;

public interface PerformerService {

    public PerformerDTO create(PerformerDTO performerDTO);

    public List<PerformerDTO> readAll();

    public PerformerDTO update(PerformerDTO performerDTO);

    public void delete(Long id);
}