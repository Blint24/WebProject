package hu.unideb.inf.WebProject.service.impl;

import hu.unideb.inf.WebProject.DTO.VenueDTO;
import hu.unideb.inf.WebProject.entity.Venue;
import hu.unideb.inf.WebProject.repository.PerformerRepository;
import hu.unideb.inf.WebProject.repository.VenueRepository;
import hu.unideb.inf.WebProject.service.VenueService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VenueServiceImplementation implements VenueService {
    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private PerformerRepository performerRepository;

    @Override
    public VenueDTO create(VenueDTO venueDTO) {
        Venue venue = new Venue(venueDTO.venueId(), venueDTO.venueName(), venueDTO.venueLocation(), venueDTO.price(), performerRepository.getReferenceById(venueDTO.performerId()));
        venue = venueRepository.save(venue);
        return new VenueDTO(venue.getVenueId(), venue.getVenueName(), venue.getVenueLocation(), venue.getPrice(), venue.getPerformerDto().getPerformerId());
    }

    @Override
    public List<VenueDTO> readAll() {
        return venueRepository.findAll().stream().map((Venue venue) -> {
            return new VenueDTO(venue.getVenueId(), venue.getVenueName(), venue.getVenueLocation(), venue.getPrice(), venue.getPerformerDto().getPerformerId());
        }).toList();
    }

    @Override
    public VenueDTO update(VenueDTO venueDTO) {
        Venue venue = new Venue(venueDTO.venueId(), venueDTO.venueName(), venueDTO.venueLocation(), venueDTO.price(), performerRepository.getReferenceById(venueDTO.performerId()));
        venue = venueRepository.save(venue);
        return new VenueDTO(venue.getVenueId(), venue.getVenueName(), venue.getVenueLocation(), venue.getPrice(), venue.getPerformerDto().getPerformerId());
    }

    @Override
    public void delete(Long id) {
        venueRepository.delete(venueRepository.findById(id).get());
    }
}