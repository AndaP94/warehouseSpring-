package com.pichlera.spring.warehousespring.logic;


import com.pichlera.spring.warehousespring.model.Article;
import com.pichlera.spring.warehousespring.repository.IArticleRepository;
import com.pichlera.spring.warehousespring.repository.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ArticleLogic implements IArticleLogic {

    private IArticleRepository iArticleRepository;

    @Autowired
    public ArticleLogic(IArticleRepository iArticleRepository, ISupplierRepository iSupplierRepository) {
        this.iArticleRepository = iArticleRepository;
    }


    public void deleteArticle(Article article){
        iArticleRepository.delete(article);
    }

    public Article saveArticle(Article article) {
        return iArticleRepository.save(article);
    }


    public Iterable<Article> findAllArticle(){
        return iArticleRepository.findAll();
    }

    public Optional<Article> findArticleById(Long id){
        return iArticleRepository.findById(id);
    }

    @Override
    public Iterable<Article> findAllArticleById(Long id) {
        return iArticleRepository.findAllById(Collections.singleton(id));
    }
}
