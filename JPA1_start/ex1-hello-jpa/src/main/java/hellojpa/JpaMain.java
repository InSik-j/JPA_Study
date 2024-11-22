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
            //팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            Member member = new Member();
            member.setName("member1");
            member.setTeamId(team.getId());
            em.persist(member);

            // 조회
            Member findMember = em.find(Member.class, member.getId());

            //연관관계가 없음
            Team findTeam = em.find(Team.class, team.getId());


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        
        emf.close();
    }
}
