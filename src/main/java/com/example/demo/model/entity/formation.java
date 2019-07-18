package main.java.com.example.demo.model.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Collection;

@Entity
@DiscriminatorValue("CE")

public class formation extends  post {

    private String domaine;
    private Skill skill;
    private String formateuur_linkedin_url;
    private Collection<User> postuler;



    public formation(String description, User user, String domaine, Skill skill, String formateuur_linkedin_url, Collection<User> postuler) {
        super(description, user);
        this.domaine = domaine;
        this.skill = skill;
        this.formateuur_linkedin_url = formateuur_linkedin_url;
        this.postuler = postuler;

    }


    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getFormateuur_linkedin_url() {
        return formateuur_linkedin_url;
    }

    public void setFormateuur_linkedin_url(String formateuur_linkedin_url) {
        this.formateuur_linkedin_url = formateuur_linkedin_url;
    }

    public Collection<User> getPostuler() {
        return postuler;
    }

    public void setPostuler(Collection<User> postuler) {
        this.postuler = postuler;
    }

    public formation(String description, User user) {
        super(description, user);
    }

}
