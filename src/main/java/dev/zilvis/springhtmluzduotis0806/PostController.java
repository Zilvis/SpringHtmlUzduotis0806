package dev.zilvis.springhtmluzduotis0806;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Post post, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        postService.create(post);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> read() {
        List<Post> allPosts = postService.findAll();
        if (allPosts.isEmpty()) {
            return new ResponseEntity<>("No posts found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Post post, @RequestParam Long id) {
        postService.update(post, id);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Long id) {
        postService.delete(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((org.springframework.validation.FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
