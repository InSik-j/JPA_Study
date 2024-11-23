package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;

    // 기간 Period
    @Embedded
    private Period workPeriod;
    // 주소 Address
    @Embedded
    private Address homeAddress;

    // 주소 Address
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name="city", column = @Column(name = "WORK_CITY")),
//            @AttributeOverride(name="street", column = @Column(name = "WORK_STREET")),
//            @AttributeOverride(name="zipCode", column = @Column(name = "WORK_ZIPCODE"))
//    })
//    private Address workAddress;


//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;
//
//    @OneToMany(mappedBy = "member")
//    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    /** getter & setter */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
}


