package hu.unideb.inf.WebProject.repository;

import hu.unideb.inf.WebProject.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
}