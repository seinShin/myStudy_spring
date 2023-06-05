package myStudyspring.myStudyspring.repository;

import jakarta.persistence.EntityManager;
import myStudyspring.myStudyspring.domain.member;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements memberRepository
{
    private final EntityManager em;     //스프링부트가 자동으로 생성해줘서 주입받으면 된다.

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public member save(member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<member> findById(Long id) {
        member member=em.find(member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<member> findByName(String name) {
         List<member> result = em.createQuery("select m from member m where m.name = :name", member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<member> findAll() {
        return em.createQuery("select m from member m", member.class)
                .getResultList();
    }
}
