package myStudyspring.myStudyspring;

import myStudyspring.myStudyspring.repository.memberRepository;
import myStudyspring.myStudyspring.repository.memoryMemberRepository;
import myStudyspring.myStudyspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository()
        );
    }

    @Bean
    public memberRepository memberRepository(){
        return new memoryMemberRepository();
    }
}
