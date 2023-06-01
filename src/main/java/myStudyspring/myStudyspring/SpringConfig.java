package myStudyspring.myStudyspring;

import myStudyspring.myStudyspring.repository.JdbcMemberRepository;
import myStudyspring.myStudyspring.repository.JdbcTemplateMemberRepository;
import myStudyspring.myStudyspring.repository.memberRepository;
import myStudyspring.myStudyspring.repository.memoryMemberRepository;
import myStudyspring.myStudyspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository()
        );
    }

    @Bean
    public memberRepository memberRepository(){

//        return new memoryMemberRepository();

//        return new JdbcMemberRepository(dataSource);  //jdbc

        return new JdbcTemplateMemberRepository(dataSource);
    }
}
