package org.mvc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="PERSON")
public class Person{

private long id;
private String name;
private String surname;
private Date birthday;
private double money;

public Person(){}
public Person(String name, String surname, Date birthday, double money){
this.name=name;
this.surname=surname;
this.birthday=birthday;
this.money=money;
}

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="ID")
public long getId(){return this.id; }
    @Size(min=2, max=15, message="Name must be between 2 and 15 characters long")
    @Pattern(regexp="^[а-яА-ЯёЁa-zA-Z]+$", message="Name must contain only letters without spaces")
    @Column(name="NAME")
public String getName(){return this.name; }
@Column(name="SURNAME")
@Size(min=2, max=20, message="Surname must be between 2 and 20 characters long")
@Pattern(regexp="^[а-яА-ЯёЁa-zA-Z]+$", message="Surame must contain only letters without spaces")
public String getSurname(){return this.surname; }
@Column(name="BIRTHDAY")
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern="yyyy-mm-dd")
public Date getBirthday(){return this.birthday; }
@Column(name="MONEY")
public double getMoney(){return this.money; }

public void setId(long id){this.id=id;}
public void setName(String name){this.name=name;}
public void setSurname(String surname){this.surname=surname;}
public void setBirthday(Date birthday){this.birthday=birthday;}
public void setMoney(double money){this.money=money;}
}
