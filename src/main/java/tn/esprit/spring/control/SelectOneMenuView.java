package tn.esprit.spring.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Inject;
import javax.inject.Named;



@Named
@RequestScoped

public class SelectOneMenuView {

	private String console;
	private String rtl;

	private String car;
	private List<SelectItem> cars;

	private String city;
	private Map<String, String> cities = new HashMap<String, String>();

	private Theme theme;
	private List<Theme> themes;

	private String option;
	private List<String> options;

	private String longItemLabel;

	@Inject
	private ThemeService service;

	@PostConstruct
	public void init() {
		// cars
		SelectItemGroup g1 = new SelectItemGroup("German Cars");
		g1.setSelectItems(new SelectItem[] { new SelectItem("BMW", "BMW"), new SelectItem("Mercedes", "Mercedes"),
				new SelectItem("Volkswagen", "Volkswagen") });

		SelectItemGroup g2 = new SelectItemGroup("American Cars");
		g2.setSelectItems(new SelectItem[] { new SelectItem("Chrysler", "Chrysler"), new SelectItem("GM", "GM"),
				new SelectItem("Ford", "Ford") });

		cars = new ArrayList<SelectItem>();
		cars.add(g1);
		cars.add(g2);

		// cities
		cities = new HashMap<String, String>();
		cities.put("Tunis", "Tunis");
		cities.put("Ariana", "Ariana");
		cities.put("Ben Arous", "Ben Arous");
		cities.put("Manouba", "Manouba");
		cities.put("Nabeul", "Nabeul");
		cities.put("Zaghouan", "Zaghouan");
		cities.put("Bizerte", "Bizerte");
		cities.put("Béja", "Béja");
		cities.put("Jendouba", "Jendouba");
		cities.put("Kef", "Kef");
		cities.put("Siliana", "Siliana");
		cities.put("Sousse", "Sousse");
		cities.put("Monastir", "Monastir");
		cities.put("Mahdia", "Mahdia");
		cities.put("Sfax", "Sfax");
		cities.put("Kairouan", "Kairouan");
		cities.put("Kasserine", "Kasserine");
		cities.put("Sidi Bouzid", "Sidi Bouzid");
		cities.put("Gabès", "Gabès");
		cities.put("Mednine", "Mednine");
		cities.put("Tataouine", "Tataouine");
		cities.put("Gafsa", "Gafsa");
		cities.put("Tozeur", "Tozeur");
		cities.put("Kebili", "Kebili");

		// themes
		themes = service.getThemes();

		// options
		options = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			options.add("Option " + i);
		}
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public String getRtl() {
		return rtl;
	}

	public void setRtl(String rtl) {
		this.rtl = rtl;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public List<SelectItem> getCars() {
		return cars;
	}

	public Map<String, String> getCities() {
		return cities;
	}

	public List<Theme> getThemes() {
		return themes;
	}

	public void setService(ThemeService service) {
		this.service = service;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getLongItemLabel() {
		return longItemLabel;
	}

	public void setLongItemLabel(String longItemLabel) {
		this.longItemLabel = longItemLabel;
	}
}