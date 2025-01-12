package com.ApiBackEnd.java.Controller;

import com.ApiBackEnd.java.Model.CardModel;
import com.ApiBackEnd.java.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public CardModel addCard(@RequestBody CardModel card) {
        return cardService.addCard(card);
    }

    @GetMapping("/cards")
    public List<CardModel> getCards() {
        return cardService.getCards();
    }
}
