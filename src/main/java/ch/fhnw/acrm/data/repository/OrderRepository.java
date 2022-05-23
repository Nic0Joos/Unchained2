package ch.fhnw.acrm.data.repository;


import ch.fhnw.acrm.data.domain.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Author: Luca
@Repository
public interface OrderRepository extends JpaRepository<Ordering, Long> {

}
