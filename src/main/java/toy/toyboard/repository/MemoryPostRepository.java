package toy.toyboard.repository;

import toy.toyboard.domain.Post;

import java.util.*;

public class MemoryPostRepository implements PostRepository {

    private static Map<Long, Post> store = new HashMap<>();
    private static  long sequence = 0L;

    @Override
    public Post save(Post post) {
        post.setId(++sequence);
        store.put(post.getId(), post);
        return post;
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public void delete(Post post) {
        store.remove(post.getId());
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Post> findByAuthor(String author) {
        return store.values().stream()
                .filter(post -> post.getAuthor().equals(author))
                .findAny();
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }
}
