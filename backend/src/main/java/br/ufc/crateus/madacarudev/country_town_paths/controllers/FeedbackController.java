package br.ufc.crateus.madacarudev.country_town_paths.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi.FeedbackControllerOpenApi;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateFeedbackDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.FeedbackOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.InformativeMessageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BadRequestException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.services.FeedbackService;

@RestController
@RequestMapping("api/feedbacks")
public class FeedbackController implements FeedbackControllerOpenApi{
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<List<FeedbackOutputDto>> getAll() {
        List<FeedbackOutputDto> feedbacks = feedbackService.getAll();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackOutputDto> getFeedbackById(@PathVariable UUID id) throws EntityNotFoundException{
        FeedbackOutputDto feedback = feedbackService.getFeedbackById(id);
        return ResponseEntity.ok(feedback);
    }

    @PostMapping
    public ResponseEntity<InformativeMessageOutputDto> create(@Valid @RequestBody CreateFeedbackDto feedback) throws BadRequestException {
        feedbackService.create(feedback);
        InformativeMessageOutputDto message = new InformativeMessageOutputDto("Feedback enviado.");
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
}
