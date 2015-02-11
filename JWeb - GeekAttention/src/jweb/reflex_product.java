package jweb;

import java.util.ArrayList;

public class reflex_product {
    private String nom;
    private String description;
    private String prix;
    private String image;
    private String id;
    private String categorie;
    private ArrayList<Reflex_review> reviews = new ArrayList<Reflex_review>();
    
	public ArrayList<Reflex_review> getReviews() {
		return reviews;
	}
	public void setReviews(ArrayList<Reflex_review> reviews) {
		this.reviews = reviews;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
}
