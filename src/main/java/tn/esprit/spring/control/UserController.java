package tn.esprit.spring.control;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.*;
import tn.esprit.spring.service.*;


@Scope(value = "session") 
@Controller(value = "userController") 
@ELBeanName(value = "userController") 
@Join(path = "/", to = "/login.jsf")

public class UserController  {
	@Autowired
	UserSerivce userservice;
	

	
	
	public long ajouterUser(User user)
	{
		userservice.addUser(user);
		return user.getId();
	}
    

	
	public void deleteUserById(String userId) {
		userservice.deleteUser(userId);
		
	}


	public List<User> getAllUsers() {
		
		return userservice.retrieveAllUsers();
				}

	
	private String login;
	private String password;
	private User user;
	private Boolean loggedIn;
	private User authenticatedUser;
	 private boolean actif; 
	
	

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}
	

	

	public UserSerivce getUserservice() {
		return userservice;
	}

	public void setUserservice(UserSerivce userservice) {
		this.userservice = userservice;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	

	public User getAuthenticatedUser() {
		return authenticatedUser;
	}

	public void setAuthenticatedUser(User authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

	public String doLogin() {
		String navigateTo = "null";
		authenticatedUser= userservice.authenticate(login, password); 
		if (authenticatedUser != null  && authenticatedUser.getType() == Type.Admin)
		{ 
			navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
			loggedIn = true;
		}
		else if (authenticatedUser != null  && authenticatedUser.getType() == Type.SimpleUser)
		{ 
			navigateTo = "/pages/user/welcomeUser.xhtml?faces-redirect=true";
			loggedIn = true;
		}
		
		else {
			FacesMessage facesMessage =

					new FacesMessage("Login Failed: please check your username/password and try again.");

			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		}
		return navigateTo;
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}
	public String gotoLogin(){
		return "/login.xhtml?faces-redirect=true";
	}
	public String gotoUserProfile(){
		return "/pages/user/UserProfile.xhtml?faces-redirect=true";
	}
	public String gotoRent(){
		return "/pages/user/salsabil.xhtml?faces-redirect=true";
	}
	public String gotoBuy(){
		return "/pages/user/eya.xhtml?faces-redirect=true";
	}
	public String gotoSubscribe(){
		return "/pages/user/amir.xhtml?faces-redirect=true";
	}
	public String gotoMeuble(){
		return "/pages/user/oumema.xhtml?faces-redirect=true";
	}
	public String gotoVirtualVisit(){
		return "/pages/user/chaima.xhtml?faces-redirect=true";
	}
	
	public String gotolistAdvertisement(){
		return "/pages/user/AnnoncesListing.xhtml?faces-redirect=true";
	}
	public String gotoHomepageUser(){
		return "/pages/user/welcomeUser.xhtml?faces-redirect=true";
	}
	
	
}
