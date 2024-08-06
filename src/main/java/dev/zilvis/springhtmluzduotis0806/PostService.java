package dev.zilvis.springhtmluzduotis0806;

import java.util.List;

public interface PostService {
    Post create(Post post);
    Post update(Post post, long id);
    void delete(Long id);
    List<Post> findAll();
}
