package main.java.com.example.demo.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Comment {
    @Id
    @GeneratedValue()
    private int id;

    private String comment;
    @ManyToOne
    @JoinColumn(name = "var")
    private User owner;
    private Date date;




}
