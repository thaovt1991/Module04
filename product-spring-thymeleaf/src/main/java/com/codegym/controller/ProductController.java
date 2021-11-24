package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
//    private final IProductService productService = new ProductService();
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String show(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirect) {
        int id = 0;
        do {
            id = (int) (Math.random() * 10000);
        } while (productService.findById(id) != null);
        product.setId(id);
        productService.save(product);
        redirect.addFlashAttribute("success", "Create success !");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

        @GetMapping("/search")
    public String search(@RequestParam String search, Model model) {
         List<Product> productsSearch = productService.findByName(search) ;
        model.addAttribute("productsSearch", productsSearch);
        return "/search";
    }
//    @PostMapping("/search")
//    public String search(@RequestParam String search,  RedirectAttributes redirect) {
//        List<Product> productsSearch = productService.findByName(search);
//        redirect.addFlashAttribute("products", productsSearch);
//        return "redirect:/product";
//    }
}
