package study.jpashop.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @Enumerated(STRING)
    private CategoryName name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Item> products = new ArrayList<>();

    // 유효성 검사
    public void setName(CategoryName name) {
        if (name == null) {
            throw new IllegalArgumentException("Category name cannot be null");
        }
        this.name = name;
    }
}
