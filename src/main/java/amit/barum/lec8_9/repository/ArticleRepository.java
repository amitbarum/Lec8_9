package amit.barum.lec8_9.repository;


import amit.barum.lec8_9.entity.Article;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface ArticleRepository extends JpaRepository<Article,Long> {

    @Query("SELECT a FROM Article a")
    List<Article> findAll();

    //query with params:
    @Query("SELECT a FROM Article a WHERE a.published = ?1")
    List<Article> findByPublished(boolean published);

    //LIKE:
    @Query("SELECT a FROM Article a WHERE a.title LIKE %?1%")
    List<Article> findByTitleLike(String title);

    //equality and comparison:
    @Query("SELECT a FROM Article a WHERE a.level >= ?1")
    List<Article> findByLevelLargerThan(int level);

    //between:
    @Query("SELECT a from Article a WHERE a.level BETWEEN ?1 AND ?2")
    List<Article> findByLevelBetween(int start, int end);

    //Sort:
    @Query("SELECT a from Article a")
    List<Article> findAllOrdered(Sort sort);


}