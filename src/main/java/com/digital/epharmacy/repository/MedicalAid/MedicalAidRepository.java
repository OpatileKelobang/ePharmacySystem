package com.digital.epharmacy.repository.MedicalAid;

import com.digital.epharmacy.entity.User.MedicalAid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Set;

/*
 * Author: Opatile Kelobang
 * Desc: MedicalAid repository
 * Date: 29 August 2020
 */
@Repository
public interface MedicalAidRepository extends JpaRepository<MedicalAid, String> {
    MedicalAid findByMedicalAidName(String medicalAidName);
}
