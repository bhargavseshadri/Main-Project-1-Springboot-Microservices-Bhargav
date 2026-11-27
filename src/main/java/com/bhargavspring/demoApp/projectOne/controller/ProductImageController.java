package com.bhargavspring.demoApp.projectOne.controller;

import com.bhargavspring.demoApp.projectOne.model.ProjectProduct;
import com.bhargavspring.demoApp.projectOne.service.ProjectProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductImageController {

    private final ProjectProductService service;

    public ProductImageController(ProjectProductService service) {
        this.service = service;
    }

    @GetMapping({"/product/{id}/image", "/products/{id}/image", "/api/products/{id}/image"})
    public ResponseEntity<byte[]> getProductImage(@PathVariable int id) {
        ProjectProduct product = service.getProductById(id);
        if (product == null || product.getImageData() == null || product.getImageData().length == 0) {
            return ResponseEntity.notFound().build();
        }

        MediaType contentType = MediaType.APPLICATION_OCTET_STREAM;
        if (product.getImageType() != null) {
            try {
                contentType = MediaType.parseMediaType(product.getImageType());
            } catch (IllegalArgumentException ignored) {
                // Use a safe binary content type when the stored value is invalid.
            }
        }

        return ResponseEntity.ok()
                .contentType(contentType)
                .body(product.getImageData());
    }
}
