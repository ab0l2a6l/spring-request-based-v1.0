package org.abolfazl.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DataAccess<T, E> {
    @PersistenceContext
    private EntityManager entityManager;

    public void save (T t){
        entityManager.persist(t);
    }

    public void update (T t){
        entityManager.merge(t);
    }

    public void remove(T t){
        entityManager.remove(entityManager.merge(t));
    }

    public List<T> findAll(Class<T> tClass){
        Entity entity = tClass.getAnnotation(Entity.class);
        Query query = entityManager.createQuery("select entity from "+ entity.name()+" entity" );
        return query.getResultList();
    }

    public T findOne(Class<T> tClass, E id){
        return entityManager.find(tClass,id);
    }
}
