package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @BeforeEach
    void setUp() {
        // Inisialisasi sebelum melakukan testing
    }

    @InjectMocks
    ProductController productController;

    @Mock
    ProductServiceImpl productService;
    Model model = mock(Model.class);
    Product product = new Product();

    @Test
    void testCreateProductPage() {
        String result = productController.createProductPage(model);
        assertEquals("createProduct", result);
    }

    @Test
    void testCreateProductPost() {
        Mockito.when(productService.create(product)).thenReturn(product);
        String result = productController.createProductPost(product);
        assertEquals("redirect:list", result);
    }

    @Test
    void testProductListPage() {
        Mockito.when(productService.findAll()).thenReturn(null);
        String result = productController.productListPage(model);
        assertEquals("productList", result);
    }

    @Test
    void testEditProductPage() {
        Mockito.when(productService.findProductById("eb558e9f-1c39-460e-8860-71af6af63bd6")).thenReturn(product);
        String result = productController.editProductPage("eb558e9f-1c39-460e-8860-71af6af63bd6", model);
        assertEquals("editProduct", result);
    }

    @Test
    void testEditProductPost() {
        Mockito.when(productService.update(product)).thenReturn(product);
        String result = productController.editProductPost(product);
        assertEquals("redirect:list", result);
    }

    @Test
    void testDeleteProduct() {
        Mockito.when(productService.findProductById("eb558e9f-1c39-460e-8860-71af6af63bd6")).thenReturn(product);
        String result = productController.deleteProduct("eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertEquals("redirect:../list", result);
    }
}