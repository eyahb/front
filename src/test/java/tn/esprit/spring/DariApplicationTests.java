package tn.esprit.spring;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.State;
import tn.esprit.spring.service.AnnReviewServiceImpl;
import tn.esprit.spring.service.AnnServiceImpl;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.entity.Type;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.UserSerivce;
import tn.esprit.spring.service.UserServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DariApplicationTests {
	@Autowired
	UserSerivce us;
	@Autowired
	AnnServiceImpl as;
	@Autowired
	AnnReviewServiceImpl ars;
	
	
	
	 @Test
	public void contextLoads() {
		 User u = new User ("hela","deg","hela@gmail.com");
		 User u2 = new User("user","simple","user@gmail.com","user",Type.SimpleUser);
		//us.addUser(u2);
		
	}
	
	
	@Test
	public void contextLoads3() {
		Annonce u = new Annonce("Ann2220",new Date(),State.sold);
	//	as.addAnnonce(u);
	//	as.retrieveAllAnnonces();
	//	as.deleteAnnonce("3");
	//	as.retrieveAnnonce("4");
		
	}
	
	
	@Test
	public void contextLoads2() {
		
	//	AnnonceReview u = new AnnonceReview ("annonce22 review",new Date() );
	//	ars.addAnnonceReview(u);
	//	ars.retrieveAllAnnonceReviews();
	//	ars.deleteAnnonceReview("2");
	//	ars.retrieveAnnonce("4");
		
	}
	
}
