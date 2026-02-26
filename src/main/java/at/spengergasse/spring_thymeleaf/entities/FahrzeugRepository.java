package at.spengergasse.spring_thymeleaf.entities;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FahrzeugRepository extends JpaRepository<Fahrzeuge, Integer> {

}
