package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Images {


//    id (typical primary key annotations)
//    image_title VARCHAR(100) NOT NULL
//    url VARCHAR(1000) NOT NULL - the url is for simple hot linking of images for now
//    post_id (a FK that will be created with the proper One-To-Many mapping)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11, columnDefinition = "int(11) unsigned")
    private long id;

    @Column(nullable = false, length = 100, columnDefinition = "VARCHAR(100) NOT NULL")
    private String image_title;

    @Column(nullable = false, length = 1000, columnDefinition = "VARCHAR(1000) NOT NULL")
    private String url;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Images() {}

    public Images(String image_title, String url) {
        this.image_title = image_title;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage_title() {
        return image_title;
    }

    public void setImage_title(String image_title) {
        this.image_title = image_title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
