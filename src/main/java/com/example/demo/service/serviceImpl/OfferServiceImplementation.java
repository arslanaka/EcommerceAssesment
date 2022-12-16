package com.example.demo.service.serviceImpl;

import com.example.demo.controllers.City.CityController;
import com.example.demo.entity.Offer;
import com.example.demo.repository.OfferRepository;
import com.example.demo.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImplementation implements OfferService {

    @Autowired
    OfferRepository offerRepository;

    private static final Logger log = LoggerFactory.getLogger(OfferServiceImplementation.class);


    @Override
    public String addOffer(Offer offer) {
        String res = "";
        try{
            res = validateOffer(offer);
            if (res.equalsIgnoreCase("success")){
                offerRepository.save(offer);
                res = "Offer added Successfully";
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            log.error("Exception :: "+e.getLocalizedMessage());
        }
        return res;
    }

    private String validateOffer(Offer offer) {

        String response = "success";

        if (offer.getActive() == null)
            response = "Active status cannot be empty";
        if (offer.getFeatured() == null){
            response = "Featured status cannot be empty";
        }
        if (offer.getLocationsOffered() == null){
            response = "Please input locations offered";
        }
        if (offer.getCategory() == null){
            response = "please input category";
        }
        if (offer.getOfferName() == null){
            response = "Plase input offer name";
        }
        if (offer.getDescription() ==  null){
            response = "Please add description";
        }
        if (offer.getCurrency() == null){
            response = "Please add currency type";
        }
        if (offer.getImage() == null){
            response = "Please add image";
        }
        if (offer.getPrice() == null){
            response = "Please add price";
        }
        if (offer.getTagline() ==  null){
            response = "Please add tagline";
        }
        if (offer.getPriorityRanking() == null){
            response = "Plase add priority ranking";
        }
        if (offer.getTags() == null){
            response = "Please add tags";
        }
        //updated by and created by to be filled after user roles addition
            return response;
    }

    @Override
    public Offer updateOffer(Offer offer) {
        return null;
    }

    @Override
    public Offer deleteOffer(Offer offer) {
        return null;
    }

    @Override
    public List<Offer> deleteOffer() {
        return null;
    }
}
