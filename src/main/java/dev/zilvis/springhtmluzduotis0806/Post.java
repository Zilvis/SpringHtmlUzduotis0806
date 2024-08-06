package dev.zilvis.springhtmluzduotis0806;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Valid

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 10, message = "Title must be between 2 - 10")
    private String title;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 200, message = "Min 2 - Max 200 chars")
    private String content;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 12, message = "Contact number is not valid")
    private String contacts;

    private LocalDateTime createdAt;
}
