package br.edu.aesa.model;

public class product {
    private int id;
    private String name;
    private String description;

    public product(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getdescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}