package com.pichlera.spring.warehousespring.bootstrap;

import com.pichlera.spring.warehousespring.model.Article;
import com.pichlera.spring.warehousespring.model.Supplier;
import com.pichlera.spring.warehousespring.repository.IArticleRepository;
import com.pichlera.spring.warehousespring.repository.ISupplierRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Init implements ApplicationListener <ContextRefreshedEvent> {

    private IArticleRepository iArticleRepository;
    private ISupplierRepository iSupplierRepository;

    public Init(IArticleRepository iArticleRepository, ISupplierRepository iSupplierRepository) {
        this.iArticleRepository = iArticleRepository;
        this.iSupplierRepository = iSupplierRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();

    }

    public void initData(){
        Supplier hoffmann = new Supplier("Hoffmann");
        iSupplierRepository.save(hoffmann);
        Supplier schmid = new Supplier("Schmid");
        iSupplierRepository.save(schmid);
        Article article = new Article("Schraube", "M6", 10.5, hoffmann );
        iArticleRepository.save(article);
    }
}
