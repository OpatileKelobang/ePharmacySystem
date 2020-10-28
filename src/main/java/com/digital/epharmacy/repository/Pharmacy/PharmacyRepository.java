package com.digital.epharmacy.repository.Pharmacy;

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy repository
 * Date: 29 August 2020
 */
@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, String> {
    Pharmacy findPharmacyByPharmacyName(String pharmacyName);
}
