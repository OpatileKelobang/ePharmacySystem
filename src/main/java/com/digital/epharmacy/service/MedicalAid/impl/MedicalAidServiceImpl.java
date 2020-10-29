package com.digital.epharmacy.service.MedicalAid.impl;

import com.digital.epharmacy.controller.ExceptionHandler.MyCustomExceptionHandler;
import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.repository.MedicalAid.MedicalAidRepository;
import com.digital.epharmacy.service.MedicalAid.MedicalAidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/*
 * Author: Opatile Kelobang
 * Desc: MedicalAid Service implementation gives access to repository
 *       in order to call operations and business logic
 * Date: 02 September 2020
 */
@Service
public class MedicalAidServiceImpl implements MedicalAidService {

    @Autowired
    private MedicalAidRepository repository;

    @Override
    public Set<MedicalAid> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public MedicalAid create(MedicalAid medicalAid) {
        return this.repository.save(medicalAid);
    }

    @Override
    public MedicalAid read(String medicalAid) {
        MedicalAid newMedicalAid = repository.findById(medicalAid).orElseGet(null);

        if(newMedicalAid == null)
            throw new MyCustomExceptionHandler("Medical aid name or id does not exist");

        return newMedicalAid;
    }

    @Override
    public MedicalAid update(MedicalAid medicalAid) {
        if (this.repository.existsById(medicalAid.getMedicalAidId())) {
            return this.repository.save(medicalAid);
        }
        else {
            throw new MyCustomExceptionHandler("Pharmacy does not exist.");
        }
    }

    @Override
    public boolean delete(String medicalAid) {
        this.repository.deleteById(medicalAid);
        if(this.repository.existsById(medicalAid)){
            throw new MyCustomExceptionHandler("Entry not deleted");
        }
        else {
            return true;
        }
    }
}
