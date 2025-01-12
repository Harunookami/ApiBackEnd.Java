package com.ApiBackEnd.java.Controller;

import com.ApiBackEnd.java.Model.CardModel;
import com.ApiBackEnd.java.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{id}")
    public CardModel updateCard(@PathVariable Long id, @RequestBody CardModel card) {
        return cardService.updateCard(card);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCard(@PathVariable("id") Long id) {
        boolean deleted = cardService.deleteCard(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
