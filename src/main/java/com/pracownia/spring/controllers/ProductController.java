package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Product;
import com.pracownia.spring.entities.Seller;
import com.pracownia.spring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Product controller.
 */
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;


    /**
     * List all products.
     *
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> list(Model model) {
        return productService.listAllProducts();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/products", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> redirect(Model model) {
        return productService.listAllProducts();
    }

    @RequestMapping(value = "/products/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return productService.listAllProductsPaging(pageNr, howManyOnPage.orElse(2));
    }


    /**
     * View a specific product by its id.
     *
     */
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getByPublicId(@PathVariable("id") Integer publicId) {
        return productService.getProductById(publicId);
    }

    /**
     * View a specific product by its id.
     *
     */
    @RequestMapping(value = "/product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getByParamPublicId(@RequestParam("id") Integer publicId) {
        return productService.getProductById(publicId);
    }

    /**
     * Save product to database.
     *
     */
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Product> create(@RequestBody @Valid @NotNull Product product) {
        product.setProductId(UUID.randomUUID().toString());
        productService.saveProduct(product);
        return ResponseEntity.ok().body(product);
    }


    /**
     * Edit product in database.
     *
     */
    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Product product) {
        if(!productService.checkIfExist(product.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            productService.saveProduct(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete product by its id.
     *
     */
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        productService.deleteProduct(id);
        return new RedirectView("/api/sellers", true);
    }

}
