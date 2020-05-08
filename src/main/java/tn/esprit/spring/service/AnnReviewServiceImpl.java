package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.AnnonceReview;
import tn.esprit.spring.repository.AnnonceReviewRepository;

@Service
public class AnnReviewServiceImpl implements AnnReviewService{

	@Autowired
	AnnonceReviewRepository annReviewRepository;

	private static final Logger L=LogManager.getLogger(AnnServiceImpl.class);

	
	public List<AnnonceReview> retrieveAllAnnonceReviews() {
		List<AnnonceReview> AnnonceReviews=(List<AnnonceReview>) annReviewRepository.findAll();
		for(AnnonceReview annonceRev:AnnonceReviews){
		L.info("user +++ : "+ annonceRev);}
		return AnnonceReviews;
	}
	
	public AnnonceReview addAnnonceReview(AnnonceReview r){
		return annReviewRepository.save(r);
		
	}
	
	public AnnonceReview updateAnnonceReview(AnnonceReview r){
		return annReviewRepository.save(r);
		
	}

	
	public void deleteAnnonceReview(String id) {
		annReviewRepository.deleteById(Long.parseLong(id));
		
	}
	
	public AnnonceReview retrieveAnnonceReview(String id) {
		AnnonceReview r;
		r=annReviewRepository.findById(Long.parseLong(id)).orElse(null);
		return r;
		
	}

}
