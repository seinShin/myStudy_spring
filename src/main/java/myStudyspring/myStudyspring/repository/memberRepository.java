package myStudyspring.myStudyspring.repository;

import myStudyspring.myStudyspring.domain.member;
import java.util.List;
import java.util.Optional;

public interface memberRepository {
    member save(member member);
    Optional<member> findById(Long id);
    Optional<member> findByName(String name);
    List<member> findAll();

}
