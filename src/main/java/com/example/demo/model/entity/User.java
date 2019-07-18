package main.java.com.example.demo.model.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import lombok.*;

@Entity //Touche Ctr+Espacement pour afficher les bibliothèques
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "type",discriminatorType= DiscriminatorType.STRING,length=2)

@Table(name="utilisteur") //cette annotation permet d'imposer le nom de l'entité afin que le logiciel ne choisisse pas un nom par défaut
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class User implements Serializable{ // pour importer l'interface serializable. Ici on a rendu toute la classe sérializable.
    @Id //pour indiquer lequel des attributs est l'Id

    @GeneratedValue(strategy=GenerationType.IDENTITY) //incrémentation automatique de l'identifiant

    private Long id;
    private String first_name;
    private  String last_name;
    @Column(name="email")
    private String email ;
    @Column(name="phone")
    private String phone ;
    private String password ;










    @OneToMany(mappedBy = "user_skill")
    private Collection<Skill> skillls;

    @OneToMany(mappedBy = "user_post")
    private Collection<post> posts;




}