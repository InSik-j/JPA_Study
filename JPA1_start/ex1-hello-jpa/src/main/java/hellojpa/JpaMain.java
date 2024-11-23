package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            /* 등록 */
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");

            /* 수정 */
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

            /* 전체 회원 조회*/
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }

            /* 영속 */
              // 엔티티 등록
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);

            // 엔티티 수정 (변경 감지)
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZ");
            
            // 플러시
//            Member member = new Member(200L, "member200");
//            em.persist(member);

//            em.flush(); // 직접 호출

            // 준영속 상태
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");
//
//            em.detach(member);
//
//            System.out.println("===================");

            /* 객체를 테이블에 맞춰 모델링 */
//            //팀 저장
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            //회원 저장
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            // 조회
//            Member findMember = em.find(Member.class, member.getId());
//
//            //연관관계가 없음
//            Team findTeam = em.find(Team.class, team.getId());

            /* 객체 지향 모델링 */
//            // 팀 저장
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            // 회원 저장
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeam(team); //단방향 연관관계 설정, 참조 저장
//            em.persist(member);
//
//            // 조회
//            Member findMember = em.find(Member.class, member.getId());
//
//            //참조를 사용해서 연관관계 조회
//            Team findTeam = findMember.getTeam();
//
//            // 새로운 팀B
//            Team teamB = new Team();
//            teamB.setName("TeamB");
//            em.persist(teamB);
//
//            // 회원1에 새로운 팀B 설정
//            member.setTeam(teamB);

            /* 양방향 매핑 */
//            // 저장
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setName("member1");
//
//            team.addMember(member);
//
//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//
//            for (Member m : members) {
//                System.out.println("m = "+m.getName());
//            }
            /** 고급 매핑*/
//            Movie movie = new Movie();
//            movie.setDirector("AA");
//            movie.setActor("BB");
//            movie.setName("바람과 함께 사라지다");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Movie findMovie = em.find(Movie.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);
            /** Mapped Superclass */
//            Member member = new Member();
//            member.setName("user1");
//            member.setCreateBy("kim");
//            member.setCreatedDate(LocalDateTime.now());
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

            /** 프록시 */
//            Member member = new Member();
//            member.setName("userA");
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            //Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("findMember = " + findMember.getClass());
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

            /** 즉시로딩 & 지연로딩 */
//            Team team = new Team();
//            team.setName("team1");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member m = em.find(Member.class, member.getId());
//
//            System.out.println("m.getClass() = " + m.getTeam().getClass());
//
//            System.out.println("=====================");
//            m.getTeam().getName();
//            System.out.println("=====================");

            /** 영속성 전이 (CASCADE) & 고아 객체*/
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            em.remove(findParent);

            /** 임베디드 타입 */
//            Member member = new Member();
//            member.setName("user1");
//            member.setHomeAddress(new Address("city","street", "zipcode"));
//            member.setWorkPeriod(new Period());
//            em.persist(member);

            /** 값 타입과 불변 객체 */
//            Address address = new Address("city","street", "zipcode");
//
//            Member member1 = new Member();
//            member1.setName("user1");
//            member1.setHomeAddress(address);
//            em.persist(member1);
//
//            Address newAddress = new Address("city1","street1", "zipcode1");
//            member1.setHomeAddress(newAddress);

            Member member = new Member();
            member.setName("user1");
            member.setHomeAddress(new Address("City1", "street1", "zipcode1"));
            
            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("족발");

            member.getAddressHistory().add(new AddressEntity("City2", "street2", "zipcode2"));
            member.getAddressHistory().add(new AddressEntity("City3", "street3", "zipcode3"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("=======Start========");
            Member findMember = em.find(Member.class, member.getId());

            // City1 -> newCity
            Address oldAddress = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", oldAddress.getStreet(), oldAddress.getZipCode()));

            // 치킨 -> 한식
            System.out.println("=======Food========");
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

//            System.out.println("=======Address========");
//            findMember.getAddressHistory().remove(new AddressEntity("City2", "street2", "zipcode2"));
//            findMember.getAddressHistory().add(new AddressEntity("newCity2", "newStreet2", "newZipcode2"));

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        
        emf.close();
    }

    private static void printMember(Member member) {
        System.out.println("username = " + member.getName());
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getName();
        System.out.println("username = " + username);

//        Team team = member.getTeam();
//        System.out.println("team = " + team);
    }
}
