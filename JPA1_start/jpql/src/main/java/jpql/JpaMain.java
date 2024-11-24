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
            Team team1 = new Team();
            team1.setName("teamA");
            em.persist(team1);

            Team team2 = new Team();
            team2.setName("teamB");
            em.persist(team2);

            Member member1 = new Member();
            member1.setUsername("user1");
            member1.setTeam(team1);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("user2");
            member2.setTeam(team1);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("user3");
            member3.setTeam(team2);
            em.persist(member3);

            em.flush();
            em.clear();

            String query1 = "select m from Member m join fetch m.team";

            List<Member> result = em.createQuery(query1, Member.class)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member = " + member.getUsername()+", "+ member.getTeam().getName());
            }

            String query2 = "select distinct t from Team t join fetch t.members";

            List<Team> result2 = em.createQuery(query2, Team.class)
                    .getResultList();

            for (Team team : result2) {
                System.out.println("team = " + team.getName()+", "+ team.getMembers().size());
                for( Member member : team.getMembers()){
                    System.out.println("member = " + member);
                }
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
