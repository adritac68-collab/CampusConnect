package com.campusconnect;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface RegistrationRepository extends JpaRepository<Registration,Long> {
 List<Registration> findByEventIdOrderByRegisteredAtDesc(Long eventId);
 long countByEventId(Long eventId);
 boolean existsByEventIdAndEmailIgnoreCase(Long eventId,String email);
}