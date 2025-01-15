package study.jpashop.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Address {

    @Id @GeneratedValue
    @Column(name = "address_id")
    private Long id;

    private String city;
    private String street;
    private String zipcode;

    @Column(name = "is_default")
    @Setter
    private boolean isDefault;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    @Setter
    private User user;

    public Address(String city, String street, String zipcode, boolean isDefault, User user) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.user = user;
        setDefaultAddress(isDefault);
    }

    // 기본 주소 설정
    public void setDefaultAddress(boolean isDefault){
        if(isDefault){
            List<Address> addresses = user.getAddresses();
            for (Address address : addresses) {
                address.isDefault = false;
            }
        }
        this.isDefault = isDefault;
    }
}
