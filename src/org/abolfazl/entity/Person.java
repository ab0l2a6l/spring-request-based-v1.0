package org.abolfazl.entity;

import javax.persistence.*;

@Table(name ="person")
@Entity(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String family;

    public long getId() {
        return id;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }
}
