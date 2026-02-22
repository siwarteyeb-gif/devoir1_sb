package com.example.parfums22.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "parfum")
public class Parfum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marqueParfum;
    private String nomParfum;
    private int prixParfum;
    private String contenanceParfum;
    private String email;

    public Parfum() {
        super();
    }

    public Parfum(String marqueParfum, String nomParfum, int prixParfum,
                  String contenanceParfum, String email) {
        this.marqueParfum = marqueParfum;
        this.nomParfum = nomParfum;
        this.prixParfum = prixParfum;
        this.contenanceParfum = contenanceParfum;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setIdParfum(Long id) {
        this.id = id;
    }

    public String getMarqueParfum() {
        return marqueParfum;
    }

    public void setMarqueParfum(String marqueParfum) {
        this.marqueParfum = marqueParfum;
    }

    public String getNomParfum() {
        return nomParfum;
    }

    public void setNomParfum(String nomParfum) {
        this.nomParfum = nomParfum;
    }

    public int getPrixParfum() {
        return prixParfum;
    }

    public void setPrixParfum(int prixParfum) {
        this.prixParfum = prixParfum;
    }

    public String getContenanceParfum() {
        return contenanceParfum;
    }

    public void setContenanceParfum(String contenanceParfum) {
        this.contenanceParfum = contenanceParfum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Parfum [idParfum=" + id+
                ", marqueParfum=" + marqueParfum +
                ", nomParfum=" + nomParfum +
                ", prixParfum=" + prixParfum +
                ", contenanceParfum=" + contenanceParfum +
                ", email=" + email + "]";
    }
}