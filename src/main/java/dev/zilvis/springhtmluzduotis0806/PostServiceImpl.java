package dev.zilvis.springhtmluzduotis0806;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    public Post create(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    public Post update(Post post, long id) {
        // TODO
        return postRepository.save(post);
    }

    public void delete(Long id) {
        //TODO
        postRepository.deleteById(id);
    }

    public List<Post> findAll() {
        return new ArrayList<>(postRepository.findAll());
    }
}
