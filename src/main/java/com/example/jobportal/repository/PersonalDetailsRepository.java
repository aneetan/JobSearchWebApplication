package com.example.jobportal.repository;

import com.example.jobportal.model.Company;
import com.example.jobportal.model.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Integer> {
    PersonalDetails findByEmail(@Param("email") String email);
    boolean existsByEmail(String email);

    PersonalDetails findAllByUserId(int userId);

}
