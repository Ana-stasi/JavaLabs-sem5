package service;

import application.domain.Category;
import application.domain.Color;
import application.domain.Product;
import application.model.dao.impl.ProductDAO;
import application.model.exception.MySQLException;
import application.model.exception.NoSuchProductException;
import application.model.service.ProductService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    ProductService productService;
    ProductDAO dao;

    @Before
    public void setUp() {
        dao = mock(ProductDAO.class);
        productService = new ProductService();
    }

    @Test(expected = NoSuchProductException.class)
    public void findProductByWrongIdTest() throws MySQLException {
        productService.findProduct(1008);
    }

    @Test
    public void findProductTest() throws MySQLException {

        Product expectedProduct = new Product(36,new Category("sweater`s"),"testProduct",
                99.99, new Color("black"),99.99);
        when(dao.findEntityById(36)).thenReturn(expectedProduct);
        Product product = productService.findProduct(36);
        assertEquals(product,expectedProduct);
    }

    @Test
    public void getAllProducts() throws MySQLException {
        assertNotNull(productService.getProductList("0"));
    }
}
