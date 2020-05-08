package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.AnnonceReview;
import tn.esprit.spring.entity.*;

public interface AnnService {
	List<Annonce> retrieveAllAnnonces();
	Annonce addAnnonce(Annonce r);
	void deleteAnnonce(String id);
	Annonce updateAnnonce(Annonce r);
	Annonce retrieveAnnonce(String id);
	
	
	public long ajouterAnnReview(AnnonceReview annRev);
	// List<AnnonceReview> getAllReviewsByAnnonce (String id);
}

