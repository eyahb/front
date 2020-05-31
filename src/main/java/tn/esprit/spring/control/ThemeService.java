package tn.esprit.spring.control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ThemeService {

	private List<Theme> themes;

	@PostConstruct
	public void init() {
		themes = new ArrayList<>();
		themes.add(new Theme(0, "Appartement", "Appartement"));
		themes.add(new Theme(1, "House", "House"));
		themes.add(new Theme(2, "Terrain", "Terrain"));
		themes.add(new Theme(3, "Building", "Building"));
		themes.add(new Theme(4, "Parking", "Parking"));
		themes.add(new Theme(5, "Studio", "Studio"));
	}

	public List<Theme> getThemes() {
		return themes;
	}
}