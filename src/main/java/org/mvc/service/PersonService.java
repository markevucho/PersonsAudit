package org.mvc.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import org.mvc.model.Person;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceContext;


@Service("personService")
@Transactional
public class PersonService{
	

private EntityManager em;

public PersonService(){}

@PersistenceContext
public void setEntityManager(EntityManager em){
 this.em=em;
}

public List<Person> getAll(){

TypedQuery<Person> query=em.createQuery("select c from Person c",Person.class);
return query.getResultList();
}

public Person getById(long id){
	
return em.find(Person.class, id);
}


public void add(Person person){

em.persist(person);

return;
}

public void delete(long id){

em.remove(getById(id));

return;
}

public void edit(Person person){

em.merge(person);

return;
}
	
}
