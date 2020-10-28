package com.digital.epharmacy.repository.PharmacyBankAccountInformation;

/*
 * Author: Opatile Kelobang
 * Desc: PharmacyBankAccountInformation repository
 * Date: 29 August 2020
 */

import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PharmacyBankAccountInformationRepository extends JpaRepository<PharmacyBankAccountInformation, String> {
    PharmacyBankAccountInformation findByAccountNumber(int accountNumber);
}
