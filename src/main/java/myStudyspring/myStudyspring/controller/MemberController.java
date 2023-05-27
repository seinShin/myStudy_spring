package myStudyspring.myStudyspring.controller;

import myStudyspring.myStudyspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Member;

//컴포넌트 스캔 방식
@Controller
public class MemberController {
    // 필드 주입
//    @Autowired
//    private MemberService memberService;

    //세터 주입
//    private MemberService memberService;
//
//      @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    //생성자 주입
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
