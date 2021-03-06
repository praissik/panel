package com.project.app;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Named
@RequestScoped
public class Worker {
	
    private int id;
    
    @NotNull(message = "Wpisz imię")
    @Pattern(regexp = "\\p{Lu}\\p{Ll}+", message = "Niepoprawny format imienia!")
    private String firstname;
    
    @NotNull(message = "Wpisz nazwisko")
    @Pattern(regexp = "\\p{Lu}\\p{Ll}+(-\\p{Lu}\\p{Ll}+)?", message = "Niepoprawny format nazwiska!")
    private String lastname;
    
    @NotNull(message = "Wpisz ulicę")
    private String street;

    @NotNull(message = "Wpisz numer budynku")
    private String number;
    private String flat;
    
    @NotNull(message = "Wpisz kod pocztowy")
    private String postcode;
    
    @NotNull(message = "Wpisz miejscowość")
    private String city;
    
    @Email(message = "Niepoprawny format adresu e-mail")
    private String email;

    public Worker(String firstname, String lastname, String street, String number, String flat, String postcode, String city, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.number = number;
        this.flat = flat;
        this.postcode = postcode;
        this.city = city;
        this.email = email;
    }

    public Worker(int id, String firstname, String lastname, String street, String number, String flat, String postcode, String city, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.number = number;
        this.flat = flat;
        this.postcode = postcode;
        this.city = city;
        this.email = email;
    }

	public int getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFlat() {
		return flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
