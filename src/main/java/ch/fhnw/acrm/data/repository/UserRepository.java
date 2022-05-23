package ch.fhnw.acrm.data.repository;


import ch.fhnw.acrm.data.domain.UnchainedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Author: Alex
@Repository
public interface UserRepository extends JpaRepository<UnchainedUser, Long> {

    UnchainedUser findByEmail(String email);
}
