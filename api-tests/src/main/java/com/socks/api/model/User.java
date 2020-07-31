package com.socks.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class User{

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	@JsonProperty("firstname")
	private String firstname;

	@JsonProperty("lastname")
	private String lastname;

	@JsonProperty("language")
	private String language;

	@JsonProperty("country")
	private String country;

	@JsonProperty("birthdate")
	private String birthdate;

	@JsonProperty("salutation")
	private String salutation;

	@JsonProperty("countryCode")
	private int countryCode;

	@JsonProperty("postCode")
	private String postCode;

	@JsonProperty("streetName")
	private String streetName;

	@JsonProperty("city")
	private String city;

	@JsonProperty("streetNr")
	private String streetNr;

	@JsonProperty("limitAmount")
	private String limitAmount;

}