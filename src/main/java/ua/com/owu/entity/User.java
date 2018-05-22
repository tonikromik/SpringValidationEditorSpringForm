package ua.com.owu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @JsonIgnore
    // коли буде формуватися json по юзеру, це поле не буде чіпатися
    @OneToMany(/*mappedBy = "user", */ cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_ref_car",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_car")
    )
    // костиль, щоб виправити помилку із реферальною таблицею
    // ми створюємо самі зв'язки, а не jpa
    private List<Car> cars = new ArrayList<Car>();

    public User() {
    }

//    public User(String name) {
//        this.name = name;
//    }

    //цей конструктор коментуємо, щоб спрінг не створював нового юзера при прив'язці його до машини з поля селект на сторінці джойн
    //якщо цей конструктор існує, то спрінг його використає

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
