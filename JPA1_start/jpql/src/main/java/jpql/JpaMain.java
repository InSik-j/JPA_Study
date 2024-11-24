package jpql;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("user1");
            member.setAge(10);

            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            // 기본 case 식
            String query1 = "select case when m.age <= 10 then '학생요금' when m.age <= 60 then '경로요금' else '일반요금' end from Member m";

            // 조건식 - case 식
                // COALESCE: 하나씩 조회해서 null이 아니면 반환
            String query2 = "select coalesce(m.username,'이름 없는 회원') from Member m";

                // NULLIF: 두 값이 같으면 null 반환, 다르면 첫번째 값 반환
            String query3 = "select NULLIF(m.username, '관리자') from Member m";

            List<Member> result = em.createQuery(query1, Member.class)
                    .getResultList();

            System.out.println("result.size() = " + result.size());
            for (Member member1 : result) {
                System.out.println("member1 = " + member1);
            }


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
