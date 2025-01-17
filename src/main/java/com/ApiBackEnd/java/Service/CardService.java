package com.ApiBackEnd.java.Service;

import com.ApiBackEnd.java.Model.CardModel;
import com.ApiBackEnd.java.Model.UserModel;
import com.ApiBackEnd.java.Repository.CardRepository;
import com.ApiBackEnd.java.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    public CardService (CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public CardModel addCard(CardModel cardModel) {
      Optional < UserModel > user = userRepository.findByEmail(cardModel.getUser().getEmail());
        if(user.isPresent()){
            cardModel.setUser(user.get());
            return cardRepository.save(cardModel);
        }
        throw new RuntimeException("User not found");

    }

    public List<CardModel> getCards() {
        return cardRepository.findAll();
    }

    public CardModel updateCard(Long id, CardModel cardModel) {
        Optional<CardModel> existingCard = cardRepository.findById(id);

        if (existingCard.isPresent()) {

            Optional < UserModel > user = userRepository.findByEmail(cardModel.getUser().getEmail());
            if(user.isPresent()){

            CardModel cardToUpdate = existingCard.get();
            cardToUpdate.setCardNumber(cardModel.getCardNumber());
            cardToUpdate.setHolderName(cardModel.getHolderName());
            cardToUpdate.setExpiryDate(cardModel.getExpiryDate());
            cardToUpdate.setCvv(cardModel.getCvv());

            cardToUpdate.setUser(user.get());
            return cardRepository.save(cardToUpdate);

            }

            throw new RuntimeException("User not found");
        } else {

            throw new RuntimeException("Card not found with id:" + id);
        }
    }

    public boolean deleteCard(Long id) {
        Optional <CardModel> card = cardRepository.findById(id);
        if (card.isPresent()) {
            cardRepository.delete(card.get());
            return true;
        } else {
            return false;
        }
    }

}
