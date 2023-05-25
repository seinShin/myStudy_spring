package myStudyspring.myStudyspring.repository;

import myStudyspring.myStudyspring.domain.member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//테스트는 순서의 의존관계 없이 설계가 되어야함
class memoryMemberRepositoryTest {

     memoryMemberRepository repository = new memoryMemberRepository();

     @AfterEach
     public void afterEach(){
          repository.clearStore();
          //테스트가 실행되고 끝날 때마다 저장소 클리어 -> 테스트 시 필요
     }
     @Test
     public void save(){
          member member = new member();
          member.setName("spring");

          repository.save(member);

          //optional로 리턴되므로 get으로 데이터를 꺼냄
          member result = repository.findById(member.getId()).get();
          assertThat(member).isEqualTo(result);
     }


     @Test
     public void findByName(){
          member member1 = new member();
          member1.setName("spring1");
          repository.save(member1);

          member member2 = new member();
          member2.setName("spring2");
          repository.save(member2);

          member result = repository.findByName("spring1").get();

          assertThat(result).isEqualTo(member1);
     }

     @Test
     public void findAll() {
          member member1 = new member();
          member1.setName("spring1");
          repository.save(member1);

          member member2 = new member();
          member2.setName("spring2");
          repository.save(member2);

          List<member> result = repository.findAll();

          assertThat(result.size()).isEqualTo(2);
     }
}
