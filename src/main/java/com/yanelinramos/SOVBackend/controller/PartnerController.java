package com.yanelinramos.SOVBackend.controller;

import com.yanelinramos.SOVBackend.controller.DTO.PartnerDTO;
import com.yanelinramos.SOVBackend.controller.DTO.PartnerResponse;
import com.yanelinramos.SOVBackend.model.Partner;
import com.yanelinramos.SOVBackend.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partners")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @CrossOrigin("*")
    @PostMapping("/")
    public ResponseEntity<PartnerResponse> addPartner(@RequestBody PartnerDTO partnerDTO) {
        if(partnerService.savePartnerDataInDB(partnerDTO))
            return ResponseEntity.status(HttpStatus.OK).body(new PartnerResponse("200", "Partner has been successfully added."));
        return ResponseEntity.status(HttpStatus.OK).body(new PartnerResponse("200", "Partner NOT added. Please try again!"));
    }

    @GetMapping("/all")
    public List<Partner> getAllPartners() {
        return partnerService.allPartners();
    }

    @CrossOrigin("*")
    @GetMapping("/{id}")
    public Partner findPartnerById( @PathVariable Integer id ) {
        return partnerService.findById(id);
    }


    @CrossOrigin("*")
    @PutMapping( "/{id}" )
    public ResponseEntity<PartnerResponse> updatePartner(@RequestBody PartnerDTO partnerDTO ) {
        if(partnerService.updatePartnerDataInDB(partnerDTO))
            return ResponseEntity.status(HttpStatus.OK).body(new PartnerResponse("200", "Partner has been successfully updated."));
        return ResponseEntity.status(HttpStatus.OK).body(new PartnerResponse("200", "Partner NOT updated. Please try again!"));
    }

    @CrossOrigin("*")
    @DeleteMapping( "/{id}" )
    public void deletePartner( @PathVariable Integer id ) {
        partnerService.deletePartnerDataInDB( id );
    }
}
