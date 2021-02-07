package com.example.votescoutachbel;

public class user {
    private String id_user;
    private String name;
    private String vote_rep;

    public user(String id_user, String name, String vote_rep) {
        this.id_user = id_user;
        this.name = name;
        this.vote_rep = vote_rep;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVote_rep() {
        return vote_rep;
    }

    public void setVote_rep(String vote_rep) {
        this.vote_rep = vote_rep;
    }
}
