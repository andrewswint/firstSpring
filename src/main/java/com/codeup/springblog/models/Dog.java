package com.codeup.springblog.models;
import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11, columnDefinition = "int(11) unsigned")
    private int id;
    @Column(nullable = false, length = 3, unique = true, columnDefinition = "tinyint(3) unsigned")
    private int age;
    @Column(nullable = false, length = 200)
    private String name;
    @Column(nullable = false, length = 2, columnDefinition = "char(2) default 'XX'")
    private String resideState;

    public Dog(){}

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}
