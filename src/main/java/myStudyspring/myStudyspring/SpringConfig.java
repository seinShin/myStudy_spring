package myStudyspring.myStudyspring;

import myStudyspring.myStudyspring.aop.TimeTraceAop;
import myStudyspring.myStudyspring.repository.*;
import myStudyspring.myStudyspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final memberRepository memberRepository;

    public SpringConfig(myStudyspring.myStudyspring.repository.memberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//     private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public memberRepository memberRepository(){
//
////        return new memoryMemberRepository();
//
////        return new JdbcMemberRepository(dataSource);  //jdbc
//
////        return new JdbcTemplateMemberRepository(dataSource);
//
////          return new JpaMemberRepository(em);
//
//    }

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
