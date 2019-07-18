package main.java.com.example.demo.model.entity;
import main.java.com.example.demo.model.entity.post;
import main.java.com.example.demo.model.entity.Skill;
import main.java.com.example.demo.model.entity.User;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Date;

@Entity
@DiscriminatorValue("CC")
public class Project extends post {
@OneToMany(mappedBy = "")
    private Collection<Skill> skills;
@OneToMany(mappedBy = "")
private  Module module ;


@OneToMany(mappedBy = "")
    private Collection<User> abonne;
private Date deadline;

    public Project(String description, User user, Collection<Skill> skills, Collection<User> abonne) {
        super(description, user);
        this.skills = skills;
        this.abonne = abonne;
    }

    public Collection<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Collection<Skill> skills) {
        this.skills = skills;
    }

    public Collection<User> getAbonne() {
        return abonne;
    }

    public void setAbonne(Collection<User> abonne) {
        this.abonne = abonne;
    }

    public Project(String description, User user) {
        super(description, user);
    }
}
