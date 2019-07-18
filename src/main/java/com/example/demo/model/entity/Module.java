package main.java.com.example.demo.model.entity;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity

public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "val")
    private Project pj;

}
