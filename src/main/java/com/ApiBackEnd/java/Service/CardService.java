package com.ApiBackEnd.java.Service;

import com.ApiBackEnd.java.Model.CardModel;
import com.ApiBackEnd.java.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {


    @Autowired
    private CardRepository cardRepository;

    public CardService (CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public CardModel addCard(CardModel cardModel) {
        return cardRepository.save(cardModel);
    }

    public List<CardModel> getCards() {
        return cardRepository.findAll();
    }
}
