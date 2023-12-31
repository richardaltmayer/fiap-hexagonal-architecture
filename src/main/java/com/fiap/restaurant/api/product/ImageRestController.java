package com.fiap.restaurant.api.product;

import com.fiap.restaurant.controller.product.ImageController;
import com.fiap.restaurant.entity.product.Image;
import com.fiap.restaurant.types.dto.product.ImagePresenterDTO;
import com.fiap.restaurant.types.dto.product.SaveProductImageDTO;
import com.fiap.restaurant.types.dto.product.UpdateImageDTO;
import com.fiap.restaurant.types.exception.ResourceNotFoundException;
import com.fiap.restaurant.types.interfaces.db.product.ImageDatabaseConnection;
import com.fiap.restaurant.types.interfaces.db.product.ProductDatabaseConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageRestController {

    private final ImageDatabaseConnection imageDatabaseConnection;
    private final ProductDatabaseConnection productDatabaseConnection;

    public ImageRestController(ImageDatabaseConnection imageDatabaseConnection, ProductDatabaseConnection productDatabaseConnection) {
        this.imageDatabaseConnection = imageDatabaseConnection;
        this.productDatabaseConnection = productDatabaseConnection;
    }

    @PostMapping(path = "/")
    public Image saveProductImage(@RequestBody SaveProductImageDTO saveProductImageDTO) {
        return ImageController.saveProductImage(saveProductImageDTO, this.imageDatabaseConnection, this.productDatabaseConnection);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody UpdateImageDTO updateImageDTO) {
        try {
            Image image = ImageController.update(id, updateImageDTO, this.imageDatabaseConnection, this.productDatabaseConnection);
            return ResponseEntity.ok().body(image);
        } catch (ResourceNotFoundException resourceNotFoundException) {
            return new ResponseEntity<>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            ImageController.delete(id, this.imageDatabaseConnection);
            return ResponseEntity.ok().body(true);
        } catch (ResourceNotFoundException resourceNotFoundException) {
            return new ResponseEntity<>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/productId={productId}")
    public ResponseEntity<Object> findAllByProductId(@PathVariable Long productId) {
        List<ImagePresenterDTO> imagePresenterDTOList = ImageController.findAllByProductId(productId, this.imageDatabaseConnection);
        return ResponseEntity.ok(imagePresenterDTOList);
    }
}
