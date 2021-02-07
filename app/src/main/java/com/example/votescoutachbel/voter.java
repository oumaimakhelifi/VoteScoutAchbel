package com.example.votescoutachbel;

public class voter {
    private String classe;
    private int id_leader;
    private String nom_leader;
    private int nombre_vote;
    private String id_leader_vote;
    private String region;


    public voter(String classe, int id_leader, String nom_leader, int nombre_vote, String region) {
        this.classe = classe;
        this.id_leader = id_leader;
        this.nom_leader = nom_leader;
        this.nombre_vote = nombre_vote;
        this.region = region;
    }

    public voter(int id_leader, String nom_leader, int nombre_vote, String id_leader_vote) {
        this.id_leader = id_leader;
        this.nom_leader = nom_leader;
        this.nombre_vote = nombre_vote;
        this.id_leader_vote = id_leader_vote;
    }

    public String getId_leader_vote() {
        return id_leader_vote;
    }

    public void setId_leader_vote(String id_leader_vote) {
        this.id_leader_vote = id_leader_vote;
    }

    public voter(int id_leader, String nom_leader, int nombre_vote) {
        this.id_leader = id_leader;
        this.nom_leader = nom_leader;
        this.nombre_vote = nombre_vote;
    }

    public voter(String nom_leader, int nombre_vote) {
        this.nom_leader = nom_leader;
        this.nombre_vote = nombre_vote;
    }

    public voter(String classe) {
        this.classe = classe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getId_leader() {
        return id_leader;
    }

    public void setId_leader(int id_leader) {
        this.id_leader = id_leader;
    }

    public String getNom_leader() {
        return nom_leader;
    }

    public void setNom_leader(String nom_leader) {
        this.nom_leader = nom_leader;
    }

    public int getNombre_vote() {
        return nombre_vote;
    }

    public void setNombre_vote(int nombre_vote) {
        this.nombre_vote = nombre_vote;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}

