package toy.toyboard.repository;

import toy.toyboard.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    Post update(Post post);
    void delete(Post post);
    Optional<Post> findById(Long id);
    Optional<Post> findByAuthor(String author);
    List<Post> findAll();
}
