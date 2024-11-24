package com.secilstore.clinic.repositories;

import com.secilstore.clinic.entities.ClinicPatients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicPatientsRepository extends JpaRepository<ClinicPatients, Integer> {


}
