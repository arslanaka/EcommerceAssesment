package com.example.demo.service;

import com.example.demo.entity.Offer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OfferService {

    String addOffer(Offer offer);

    Offer updateOffer(Offer offer);

    Offer deleteOffer(Offer offer);

    List<Offer> deleteOffer();


}
