package myStudyspring.myStudyspring.service;

import myStudyspring.myStudyspring.domain.member;
import myStudyspring.myStudyspring.repository.memoryMemberRepository;
import myStudyspring.myStudyspring.repository.memberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final memberRepository memberRepository;

    public MemberService(memberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     * */
    public Long join(member member){
        //중복 회원 검사
//        Optional<member> result = memberRepository.findByName(member.getName());

        validateDuplicateMember(member); // 중복 회원 검증

        //isPresent -> null이 아닌 존재하는 값이 있을 때 처리. // optional 메서드.
//        result.ifPresent(m ->{
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

        memberRepository.save(member);
        return member.getId();
        //회원가입 시 아이디 반환
    }

    //c+alt+m -< 리펙토링 메서드 추출
    private void validateDuplicateMember(member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m ->{
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     * 전체 회원 조회
     * */
    public List<member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
