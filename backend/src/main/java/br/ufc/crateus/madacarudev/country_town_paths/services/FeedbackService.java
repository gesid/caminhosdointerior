package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateFeedbackDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.FeedbackOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.FeedbackModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FeedbackService {
  private final ModelMapper modelMapper;
  private final FeedbackRepository feedbackRepository;

  public List<FeedbackOutputDto> getAll() {
    List<FeedbackModel> feedbacksModel = feedbackRepository.findAll();
    List<FeedbackOutputDto> feedbackOutputDto = new ArrayList<FeedbackOutputDto>();

    for (FeedbackModel feedbackModel : feedbacksModel) {
      feedbackOutputDto.add(modelMapper.map(feedbackModel,FeedbackOutputDto.class));
    }

    return feedbackOutputDto;
  }

  public FeedbackOutputDto getFeedbackById(Long id) throws EntityNotFoundException {
    FeedbackModel feedbackModel = feedbackRepository.findById(id).orElse(null);
    checkIfNotExistsFeedbackById(feedbackModel, id);

    return modelMapper.map(feedbackModel,FeedbackOutputDto.class);
  }

  public void create(CreateFeedbackDto input) {
    FeedbackModel feedbackCreate = this.modelMapper.map(input, FeedbackModel.class);
    feedbackRepository.save(feedbackCreate);
  }

  private void checkIfNotExistsFeedbackById(FeedbackModel existingFeedback, Long id) throws EntityNotFoundException{
    if (Objects.isNull(existingFeedback)) {
        String errorMessage = "Não existe feedback com o id: " + id + ".";
        throw new EntityNotFoundException(errorMessage);
    }
  }
}
