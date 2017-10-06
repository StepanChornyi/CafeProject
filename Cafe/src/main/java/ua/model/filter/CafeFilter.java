package ua.model.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import ua.entity.Type;


public class CafeFilter {

	private static final Pattern RATE_PATTERN = Pattern.compile("^[0-9]([,.][0-9]{1,2})?|10([,.]0{1,2})?$");

	private static final Pattern TIME_PATTERN = Pattern.compile("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$");

	private String minRate = "";

	private String maxRate = "";

	private List<Type> types = new ArrayList<>();

	private String minOpen = "";

	private String maxOpen = "";

	private String minClose = "";

	private String maxClose = "";
	
	private String search = "";
	

	public String getMinRate() {
		return minRate;
	}

	public void setMinRate(String minRate) {
		if (RATE_PATTERN.matcher(minRate).matches()) {
			this.minRate = minRate;
		}
	}

	public String getMaxRate() {
		return maxRate;
	}

	public void setMaxRate(String maxRate) {
		if (RATE_PATTERN.matcher(maxRate).matches()) {
			this.maxRate = maxRate;
		}
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public String getMinOpen() {
		return minOpen;
	}

	public void setMinOpen(String minOpen) {
		if (TIME_PATTERN.matcher(minOpen).matches()) {
			this.minOpen = minOpen;
		}
	}

	public String getMaxOpen() {
		return maxOpen;
	}

	public void setMaxOpen(String maxOpen) {
		if (TIME_PATTERN.matcher(maxOpen).matches()) {
			this.maxOpen = maxOpen;
		}
	}

	public String getMinClose() {
		return minClose;
	}

	public void setMinClose(String minClose) {
		if (TIME_PATTERN.matcher(minClose).matches()) {
		this.minClose = minClose;
		}
	}

	public String getMaxClose() {
		return maxClose;
	}

	public void setMaxClose(String maxClose) {
		if (TIME_PATTERN.matcher(maxClose).matches()) {
			this.maxClose = maxClose;
		}
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}