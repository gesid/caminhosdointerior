package br.ufc.crateus.madacarudev.country_town_paths.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.crateus.madacarudev.country_town_paths.models.FeedbackModel;

public interface FeedbackRepository extends JpaRepository<FeedbackModel, UUID> {
}
