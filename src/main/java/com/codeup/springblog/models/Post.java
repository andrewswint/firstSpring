package com.codeup.springblog.models;
import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post<image> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11, columnDefinition = "int(11) unsigned")
    private Long id;
    @Column(nullable = false, length = 200)
    private String title;
    @Column(nullable = false, length = 1000)
    private String body;

    @OneToOne(mappedBy = "post")
    private PostDetails postDetails;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Images> images;


    public Post(){}

    public Post(String title, String body, Long id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
