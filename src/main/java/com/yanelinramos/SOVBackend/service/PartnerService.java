package com.yanelinramos.SOVBackend.service;

import com.yanelinramos.SOVBackend.controller.DTO.PartnerDTO;
import com.yanelinramos.SOVBackend.model.Partner;

import java.util.List;

public interface PartnerService {
    boolean savePartnerDataInDB(PartnerDTO partnerDTO);

    List<Partner> allPartners();

    Partner findById(Integer id);

    boolean updatePartnerDataInDB(PartnerDTO partnerDTO);

    void deletePartnerDataInDB(Integer id);
}
