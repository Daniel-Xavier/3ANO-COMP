package br.maua.model;

public class Cliente {

    private String email, name, id;

    public Cliente(String email, String name, String id) {
        this.email = email;
        this.name = name;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}