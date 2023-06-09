package mk.ukim.finki.emt.eshop.repository;

import mk.ukim.finki.emt.eshop.model.Category;
import mk.ukim.finki.emt.eshop.model.Product;
import mk.ukim.finki.emt.eshop.model.views.ProductPerManufacturerView;
import mk.ukim.finki.emt.eshop.model.views.ProductsPerCategoryView;
import mk.ukim.finki.emt.eshop.repository.views.ProductsPerCategoryViewRepository;
import mk.ukim.finki.emt.eshop.repository.views.ProductsPerManufacturerViewRepository;
import mk.ukim.finki.emt.eshop.service.CategoryService;
import mk.ukim.finki.emt.eshop.service.ManufacturerService;
import mk.ukim.finki.emt.eshop.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsPerManufacturerViewRepositoryTest {

    @Autowired
    private ProductsPerManufacturerViewRepository productsPerManufacturerViewRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ProductService productService;

    // Идејата на ова е дали при повикување на save методот е дали ќе имаме промена
    // Не треба да биде веднаш туку на секои 5 секунди, не би требало да имаме разлика
    @Test
    public void testCreateNewProduct() {
        List<ProductPerManufacturerView> list1 = this.productsPerManufacturerViewRepository.findAll();

        Product product = new Product();
        product.setName("Ski Jacket 557");
        product.setManufacturer(this.manufacturerService.findAll().get(0));
        product.setCategory(this.categoryService.listCategories().get(0));

        this.productService.save(product.getName(), product.getPrice(), product.getQuantity(), product.getCategory().getId(), product.getManufacturer().getId());

        List<ProductPerManufacturerView> list2 = this.productsPerManufacturerViewRepository.findAll();
    }

}


