package hu.unideb.inf.WebProject.service;

import hu.unideb.inf.WebProject.DTO.VenueDTO;

import java.util.List;

public interface VenueService {
    public VenueDTO create(VenueDTO venueDTO);

    public List<VenueDTO> readAll();

    public VenueDTO update(VenueDTO order);

    public void delete(Long id);
}