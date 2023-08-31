package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateFeedbackDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.FeedbackOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.FeedbackModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Objects;

@Service
public class FeedbackService {

  private final ModelMapper modelMapper;

  public FeedbackService(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Autowired
  private FeedbackRepository feedbackRepository;

  public List<FeedbackOutputDto> getAll() {
    List<FeedbackModel> feedbacksModel = feedbackRepository.findAll();
    List<FeedbackOutputDto> feedbackOutputDto = new ArrayList<FeedbackOutputDto>();

    for (FeedbackModel feedbackModel : feedbacksModel) {
      feedbackOutputDto.add(modelMapper.map(feedbackModel,FeedbackOutputDto.class));
    }

    return feedbackOutputDto;
  }

  public FeedbackOutputDto getFeedbackById(UUID id) throws EntityNotFoundException {
    FeedbackModel feedbackModel = feedbackRepository.findById(id).orElse(null);
    checkIfNotExistisFeedbackById(feedbackModel, id);

    FeedbackOutputDto regionOutputDto = modelMapper.map(feedbackModel,FeedbackOutputDto.class);

    return regionOutputDto;
  }

  public void create(CreateFeedbackDto feedback) throws EntityConflictException{
    UUID uuid = UUID.randomUUID();

    FeedbackModel feedbackCreate = new FeedbackModel(
      uuid,
      feedback.getName(),
      feedback.getSurname(),
      feedback.getEmail(),
      feedback.getMessage()
      );
    
      feedbackRepository.save(feedbackCreate);
  }

  private void checkIfNotExistisFeedbackById(FeedbackModel existingFeedback,UUID id) throws EntityNotFoundException{
    if (Objects.isNull(existingFeedback)) {
        String errorMessage = "Não existe feedback com o id: " + id + ".";
        throw new EntityNotFoundException(errorMessage);
    }
  }
}
