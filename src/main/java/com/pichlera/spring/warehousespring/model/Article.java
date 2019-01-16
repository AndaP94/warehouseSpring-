package com.pichlera.spring.warehousespring.model;


import javax.persistence.*;


@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long articleId;
    private String articleName;
    private String packageUnit;
    private double price;

    @ManyToOne
    private Supplier supplier;

    public Article(String articleName, String packageUnit, double price, Supplier supplier) {
        this.articleName = articleName;
        this.packageUnit = packageUnit;
        this.price = price;
        this.supplier = supplier;
    }

    public Article() {
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getPackageUnit() {
        return packageUnit;
    }

    public void setPackageUnit(String packageUnit) {
        this.packageUnit = packageUnit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
