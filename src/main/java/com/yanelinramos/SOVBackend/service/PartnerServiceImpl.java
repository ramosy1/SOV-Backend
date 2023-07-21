package com.yanelinramos.SOVBackend.service;

import com.yanelinramos.SOVBackend.controller.DTO.PartnerDTO;
import com.yanelinramos.SOVBackend.model.Partner;
import com.yanelinramos.SOVBackend.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerServiceImpl implements PartnerService{

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public boolean savePartnerDataInDB(PartnerDTO partnerDTO){
        Partner partner = partner(partnerDTO);
        Partner saved = partnerRepository.save(partner);
        return true;
    }

    private Partner partner(PartnerDTO partnerDTO){
        Partner partner=new Partner();
        partner.setFirstName(partnerDTO.getFirstName());
        partner.setLastName(partnerDTO.getLastName());
        partner.setCompany(partnerDTO.getCompany());
        partner.setTitle(partnerDTO.getTitle());
        partner.setPhoneNumber(partnerDTO.getPhoneNumber());
        partner.setEmail(partnerDTO.getEmail());
        partner.setWebsite(partnerDTO.getWebsite());
        return partner;
    }

    @Override
    public List<Partner> allPartners() {
        return partnerRepository.findAll();
    }

    @Override
    public Partner findById(Integer id) {
        Optional<Partner> findById = partnerRepository.findById(id);
        return findById.orElse(null);
    }

    @Override
    public boolean updatePartnerDataInDB(PartnerDTO partnerDTO) {
        Integer id = partnerDTO.getId();
        Optional<Partner> findById = partnerRepository.findById(id);
        if(findById.isPresent()){
            Partner partner=new Partner();
            partner.setFirstName(partnerDTO.getFirstName());
            partner.setLastName(partnerDTO.getLastName());
            partner.setCompany(partnerDTO.getCompany());
            partner.setTitle(partnerDTO.getTitle());
            partner.setPhoneNumber(partnerDTO.getPhoneNumber());
            partner.setEmail(partnerDTO.getEmail());
            partner.setWebsite(partnerDTO.getWebsite());

            partnerRepository.save(partner);
            return true;
        }
        return false;
    }

    @Override
    public void deletePartnerDataInDB(Integer id) {
        Optional<Partner> finById = partnerRepository.findById(id);
        if (finById.isPresent()){
            Partner partner = finById.get();
            partnerRepository.delete(partner);
        }
    }

}
