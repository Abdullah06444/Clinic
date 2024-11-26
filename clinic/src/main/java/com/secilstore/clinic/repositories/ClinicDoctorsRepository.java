package com.secilstore.clinic.repositories;

import com.secilstore.clinic.entities.ClinicDoctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicDoctorsRepository extends JpaRepository<ClinicDoctors, Integer> {


}
