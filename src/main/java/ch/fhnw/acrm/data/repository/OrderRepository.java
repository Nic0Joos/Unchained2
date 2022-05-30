package ch.fhnw.acrm.data.repository;


import ch.fhnw.acrm.data.domain.Ordering;
import ch.fhnw.acrm.data.domain.UnchainedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Author: Luca
@Repository
public interface OrderRepository extends JpaRepository<Ordering, Long> {
    List<Ordering> findByUserId(Long userId);

}
