package myStudyspring.myStudyspring.repository;

import myStudyspring.myStudyspring.domain.member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class memoryMemberRepository implements memberRepository{

    private static Map<Long, member> store = new HashMap<>();
    private static long sequence = 0L; // key 값을 생성하는 시퀀스


    @Override
    public member save(member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        // 자바 람다 -> 파라미터로 넘어온 이름과 getName과 일치하는 것을 찾아 optional로 반환
    }

    @Override
    public List<member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
