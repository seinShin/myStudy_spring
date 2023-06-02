package myStudyspring.myStudyspring.service;

import myStudyspring.myStudyspring.domain.member;
import myStudyspring.myStudyspring.repository.memberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
//c+shi+t -> 자동으로 테스트 클래스 생성
class MemberServiceInTest {

    @Autowired
    MemberService memberService;

    @Autowired
    memberRepository repository;

    @Test
    void join() {
        //given
        member member = new member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        member findMember = repository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void 중복회원예외() {
        //given
        member member1 = new member();
        member1.setName("spring");

        member member2 = new member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        //방법 1 - assertThrows 사용
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


        //방법 1 - try-catch 사용
        /* try {
            memberService.join(member2);
            fail();
         }catch(IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/
    }
}