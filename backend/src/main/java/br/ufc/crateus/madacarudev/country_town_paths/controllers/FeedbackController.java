package br.ufc.crateus.madacarudev.country_town_paths.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi.FeedbackControllerOpenApi;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateFeedbackDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.FeedbackOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.InformativeMessageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BadRequestException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.services.FeedbackService;

public class FeedbackController implements FeedbackControllerOpenApi{
    @Autowired
    private FeedbackService feedbackService;

    @Override
    public ResponseEntity<List<FeedbackOutputDto>> getAll() {
        List<FeedbackOutputDto> feedbacks = feedbackService.getAll();
        return new ResponseEntity<List<FeedbackOutputDto>>(feedbacks, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FeedbackOutputDto> getFeedbackById(UUID id) throws EntityNotFoundException{
        FeedbackOutputDto feedback = feedbackService.getFeedbackById(id);
        return ResponseEntity.ok(feedback);
    }

    @Override
    public ResponseEntity<InformativeMessageOutputDto> create(CreateFeedbackDto feedback) throws BadRequestException {
        InformativeMessageOutputDto message = new InformativeMessageOutputDto("Feedback enviado.");
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
    
    
}
