package com.codeup.springblog.models;
import javax.persistence.*;

@Entity
@Table(name="postDetails")
public class PostDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,
            length = 11,
            columnDefinition = "int(11) unsigned")
    private Long id;
    @Column(nullable = false,
            columnDefinition = "boolean")
    private boolean isAwesome;
    @Column(nullable = false,
            length = 1000)
    private String historyOfPost;
    @Column(nullable = false,
            length = 250,
            columnDefinition = "VARCHAR(255)")
    private String topicDescription;

    @OneToOne
    private Post post;

    public PostDetails() {}

    public PostDetails(boolean isAwesome,
                       String historyOfPost,
                       String topicDescription) {
        this.isAwesome = isAwesome;
        this.historyOfPost = historyOfPost;
        this.topicDescription = topicDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAwesome() {
        return isAwesome;
    }

    public void setAwesome(boolean awesome) {
        isAwesome = awesome;
    }

    public String getHistoryOfPost() {
        return historyOfPost;
    }

    public void setHistoryOfPost(String historyOfPost) {
        this.historyOfPost = historyOfPost;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

}
