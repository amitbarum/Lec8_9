package amit.barum.lec8_9;

import amit.barum.lec8_9.entity.Article;
import amit.barum.lec8_9.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaRepositories(basePackages = "amit.barum.lec8_9.repository")

public class Lec89Application implements CommandLineRunner {
    private final ArticleRepository articleRepository;

    public static void main(String[] args) {
        SpringApplication.run(Lec89Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        articleRepository.save(Article.builder()
                .title("Spring Boot DI")
                .description("Spring boot DI description")
                .level(1)
                .published(false)
                .build()
        );

        articleRepository.save(Article.builder()
                .title("Spring Data JPA")
                .description("Spring Data JPA description")
                .level(1)
                .published(false)
                .build()
        );

        articleRepository.save(Article.builder()
                .title("Spring Unit Testing")
                .description("Spring Unit description")
                .level(2)
                .published(false)
                .build()
        );

        articleRepository.save(Article.builder()
                .title("Spring Security")
                .description("Spring Security description")
                .level(3)
                .published(true)
                .build()
        );

        articleRepository.save(Article.builder()
                .title("Spring Micro Services")
                .description("Spring Micro Services description")
                .level(4)
                .published(false)
                .build()
        );

        articleRepository.save(Article.builder()
                .title("Spring Security OAuth2.0")
                .description("Spring  Security OAuth2.0 description")
                .level(5)
                .published(true)
                .build()
        );


        var all = articleRepository.findAll();
        var published = articleRepository.findByPublished(true);

        var all2 = articleRepository.findByTitleLike("prin");
        var all3 = articleRepository.findByLevelLargerThan(2);
        var all4 = articleRepository.findByLevelBetween(1, 3);
        System.out.println();

    }
}



