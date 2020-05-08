package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.AnnonceReview;
import tn.esprit.spring.service.AnnReviewService;
import tn.esprit.spring.service.AnnService;
import tn.esprit.spring.service.UserSerivce;

@Controller
public class AnnonceReviewController {

	@Autowired
	UserSerivce iuserService;
	@Autowired
	AnnService iannservice;
	@Autowired
	AnnReviewService iannRevservice;

	public String ajouterAnnonceReview(AnnonceReview annonceReview) {
		iannRevservice.addAnnonceReview(annonceReview);
		return annonceReview.getText();
	}


	public void deleteAnnonceReviewById(String id)
	{
		iannRevservice.deleteAnnonceReview(id);
	}
	
	public AnnonceReview getAnnonceReviewById(String id) {

		return iannRevservice.retrieveAnnonceReview(id);
	}
	
	
	
	/*
	public List<String> getAllReviewsByAnnonce(long annId) {
		return iannservice.getAllReviewsByAnnonce(annId);
	}
	*/
	

	
}
