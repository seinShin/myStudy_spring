package myStudyspring.myStudyspring.repository;

import myStudyspring.myStudyspring.domain.member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<member, Long>, memberRepository {
    @Override
    Optional<member> findByName(String name);
}
