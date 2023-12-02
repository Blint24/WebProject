package hu.unideb.inf.WebProject.repository;

import hu.unideb.inf.WebProject.entity.Performer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformerRepository extends JpaRepository<Performer, Long> {
}