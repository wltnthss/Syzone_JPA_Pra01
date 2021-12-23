package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        try {
            tx.begin();
            //emmappingTestDelete(em);
            //emTestDetach(em);
            //emTestClear(em);
            //emEqualTest(em);
            //emUpdateTest(em);
            mappingTest2(em);
            //mappingTest3(em);
            //mappingTest4(em);
            //mappingTest5(em);
            //oneToOnemappingTest6(em);
            //oneToOneDirmappingTest7(em);
            //Member member = new Member(2L, "bbb");
            //em.persist(member);
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void mappingTest2(EntityManager em) {
        Team team = new Team();
        team.setName("TeamA");
        em.persist(team);

        Member member = new Member();
        member.setUsername("member1");
        member.setTeam(team);
        em.persist(member);

        em.flush();
        em.clear();

        Member findMember = em.find(Member.class, member.getId());
        System.out.println(findMember.getTeam().getName());

    }

//    private static void emUpdateTest(EntityManager em) {
//        Member member = em.find(Member.class, 2L);
//        member.setName("CCC");
//    }

    private static void emEqualTest(EntityManager em) {
        Member member1 = em.find(Member.class, 2L);
        Member member2 = em.find(Member.class, 2L);
        System.out.println(member1 == member2);
    }

    private static void emTestClear(EntityManager em) {

        Member member = em.find(Member.class, 2L);
        System.out.println("===========");
        // clear 한번요청시 한번만 나감
        //em.clear(); // 영속성 컨테스트의 정보를 지워줌
        System.out.println("===========");
        member = em.find(Member.class, 2L);
    }

    private static void emTestDetach(EntityManager em) {
        Member member = new Member(5L, "aaa");
        em.detach(member);
        System.out.println("======================");
        em.merge(member);
    }

    private static void emmappingTestDelete(EntityManager em) {
        //Member member = new Member(2L, "aaa");
        Member member1 = em.find(Member.class, 2L);
        //em.remove(member);
        em.remove(member1);
    }
}
