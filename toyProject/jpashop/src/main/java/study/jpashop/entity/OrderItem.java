package study.jpashop.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Getter @Setter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int quantity;

    @Column(name = "order_Price")
    private int orderPrice;

    public int getTotalPrice() {
        return quantity * orderPrice;
    }

    public static OrderItem createOrderItem(Item item, int quantity) {
        OrderItem orderItem = new OrderItem();

        orderItem.setItem(item);
        orderItem.setQuantity(quantity);
        orderItem.setOrderPrice(item.getPrice());

        return orderItem;
    }
}
