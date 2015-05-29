package com.battlenex.game;

import net.sf.javainetlocator.InetAddressLocator;
import net.sf.javainetlocator.InetAddressLocatorException;

public class Address {
	
	private String address;
	private String countryOfOrigin;

	public Address(String address) {
		this.address = address;
		try {
			this.countryOfOrigin = InetAddressLocator.getLocale(address).getDisplayCountry();
		} catch (InetAddressLocatorException ex) {
			this.countryOfOrigin = "Unknown";
		}
		if (this.countryOfOrigin.equals(null) || this.countryOfOrigin.equals("**") || this.countryOfOrigin.equals("")) {
			this.countryOfOrigin = "Unknown";
		}
	}

	public String getAddress() {
		return address;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
}
