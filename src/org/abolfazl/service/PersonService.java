package org.abolfazl.service;

import org.abolfazl.entity.Person;
import org.abolfazl.repository.DataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private DataAccess<Person, Long> personDB;

    @Transactional
    public void save(Person person){
        personDB.save(person);
    }

    @Transactional
    public void update(Person person){
        personDB.update(person);
    }

    @Transactional
    public void remove(Person person){
        personDB.remove(person);
    }

    public List<Person> findAll(){
        return personDB.findAll(Person.class);
    }

    public Person findOne(long id){
        return personDB.findOne(Person.class, id);
    }
}
