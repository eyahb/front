package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.AnnonceReview;
import tn.esprit.spring.service.AnnReviewService;
import tn.esprit.spring.service.AnnService;
import tn.esprit.spring.service.UserSerivce;

@Controller
public class AnnonceController {

	@Autowired
	UserSerivce iuserService;
	@Autowired
	AnnService iannservice;
	@Autowired
	AnnReviewService iannRevservice;

	public String ajouterAnnonce(Annonce annonce) {
		iannservice.addAnnonce(annonce);
		return annonce.getAdresse();
	}


	public void deleteAnnonceById(String id)
	{
		iannservice.deleteAnnonce(id);
	}
	
	public Annonce getAnnonceById(String id) {

		return iannservice.retrieveAnnonce(id);
	}
	
	public long ajouterAnnonceReview(AnnonceReview annRev) {
		return iannservice.ajouterAnnReview(annRev);
	}
	
	/*
	public List<String> getAllReviewsByAnnonce(long annId) {
		return iannservice.getAllReviewsByAnnonce(annId);
	}
	*/
	

	public void deleteReviewById(String annrevId) {
		iannRevservice.deleteAnnonceReview(annrevId);

	}
}
