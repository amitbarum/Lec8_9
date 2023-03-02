package amit.barum.lec8_9.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;
    private String description;

    private int level; //1, 2, 3, 4, 5

    private boolean published;
}
