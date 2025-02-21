package com.ApiBackEnd.java.Controller;

import com.ApiBackEnd.java.Model.CardModel;
import com.ApiBackEnd.java.Service.CardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private ValidationAutoConfiguration validationAutoConfiguration;

    @PostMapping("/register")
    public ResponseEntity<CardModel> addCard( @RequestBody CardModel card) {
        CardModel savedCard = cardService.addCard(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCard);
    }

    @GetMapping()
    public ResponseEntity<List<CardModel>> getCards() {
        List<CardModel>      cards = cardService.getCards();
        return ResponseEntity.ok(cards);
    }

    @PutMapping("/{id}")
    public ResponseEntity <CardModel> updateCard(@PathVariable Long id, @Valid @RequestBody CardModel card) {
        CardModel updateCard = cardService.updateCard(id, card);

        if (updateCard != null) {
            return ResponseEntity.ok(updateCard);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCard(@PathVariable Long id) {
        boolean deleted = cardService.deleteCard(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
