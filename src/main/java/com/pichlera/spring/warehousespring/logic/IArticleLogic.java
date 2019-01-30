package com.pichlera.spring.warehousespring.logic;

import com.pichlera.spring.warehousespring.model.Article;

import java.util.Optional;

public interface IArticleLogic {

    public Iterable<Article> findAllArticle();

    public Optional<Article> findArticleById(Long id);

    public void deleteArticle(Article article);

    public Article saveArticle(Article article);

    public Iterable<Article> findAllArticleById(Long id);
}
