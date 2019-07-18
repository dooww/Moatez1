package main.java.com.example.demo.model.entity;
import java.util.Date;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "type",discriminatorType= DiscriminatorType.STRING,length=2)
public class post implements Serializable {
    @Id
    private Long id;
    private String description ;
    private Date posthour;

    @ManyToOne
    @JoinColumn(name = "variab")
    private User user;


    @OneToMany(mappedBy = "User",fetch =FetchType.LAZY)
    private Collection<Comment> comment;

    public Long getId() {
        return id;
    }

    public post(String description, User user) {
        this.description = description;
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Comment> getComment() {
        return comment;
    }

    public void setComment(Collection<Comment> comment) {
        this.comment = comment;
    }
}
