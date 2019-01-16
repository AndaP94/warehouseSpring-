package com.pichlera.spring.warehousespring.repository;

import com.pichlera.spring.warehousespring.model.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArticleRepository extends CrudRepository<Article, Long> {

   // Article findArticleByName(String name);
    //void deleteByName(String name);



}
