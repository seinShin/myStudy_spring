package myStudyspring.myStudyspring.service;

import myStudyspring.myStudyspring.domain.member;
import myStudyspring.myStudyspring.repository.memoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

//c+shi+t -> 자동으로 테스트 클래스 생성
class MemberServiceTest {

    MemberService memberService;
    memoryMemberRepository repository;

    @BeforeEach
    public void beforeEach(){
        repository = new memoryMemberRepository();
        memberService = new MemberService(repository);
    }

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void join() {
        //given
        member member = new member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원예외(){
        //given
        member member1 = new member();
        member1.setName("spring");

        member member2 = new member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");



       /* try {
            memberService.join(member2);
            fail();
        }catch(IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}