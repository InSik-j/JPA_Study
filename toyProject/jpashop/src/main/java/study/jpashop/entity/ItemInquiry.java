package study.jpashop.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "item_inquiry")
@NoArgsConstructor(access = PROTECTED)
@Getter
public class ItemInquiry {
    @Id @GeneratedValue
    @Column(name = "item_inquiry_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private String title;
    private String content;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    public ItemInquiry(User user, Item item, String title, String content) {
        this.user = user;
        this.item = item;
        this.title = title;
        this.content = content;
        this.createAt = LocalDateTime.now();
    }
}
