package id.ac.ui.cs.advprog.eshop.controller;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.CarServiceImpl;
import id.ac.ui.cs.advprog.eshop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    // Create a new product
    @GetMapping("/create")
    public String createProductPage (Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost (@ModelAttribute Product product) {
        service.create(product);
        return "redirect:list";
    }

    // List all products
    @GetMapping("/list")
    public String productListPage (Model model) {
        List <Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }

    // Edit a product
    @GetMapping("/edit/{productId}")
    public String editProductPage (@PathVariable String productId, Model model) {
        Product product = service.findProductById(productId);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PutMapping("/edit")
    public String editProductPost (@ModelAttribute Product product) {
        service.update(product);
        return "redirect:list";
    }

    // Delete a product
    @DeleteMapping("/delete/{productId}")
    public String deleteProduct (@PathVariable String productId) {
        Product product = service.findProductById(productId);
        service.delete(product);
        return "redirect:../list";
    }
}

@Controller
@RequestMapping("/car")
class CarController extends ProductController {
    @Autowired
    private CarServiceImpl carService;

    @GetMapping("/createCar")
    public String createCarPage (Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "createCar";
    }

    @PostMapping("/createCar")
    public String createCarPost (@ModelAttribute Car car, Model model) {
        carService.create(car);
        return "redirect:listCar";
    }

    @GetMapping("/listCar")
    public String carListPage (Model model) {
        List <Car> allCars = carService.findAll();
        model.addAttribute("cars", allCars);
        return "carList";
    }

    @GetMapping("/editCar/{carId}")
    public String editCarPage (@PathVariable String carId, Model model) {
        Car car = carService.findById(carId);
        model.addAttribute("car", car);
        return "editCar";
    }

    @PostMapping("/editCar")
    public String editCarPost (@ModelAttribute Car car, Model model) {
        carService.update(car.getCarId(), car);
        return "redirect:listCar";
    }

    @PostMapping("/deleteCar")
    public String deleteCar (@RequestParam("carId") String carId) {
        carService.deleteCarById(carId);
        return "redirect:listCar";
    }
}