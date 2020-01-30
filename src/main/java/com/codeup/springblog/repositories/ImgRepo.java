package com.codeup.springblog.repositories;
import com.codeup.springblog.models.Images;
import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImgRepo extends JpaRepository<Images, Long> {

}