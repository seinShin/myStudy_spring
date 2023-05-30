package myStudyspring.myStudyspring.controller;

import myStudyspring.myStudyspring.domain.member;
import myStudyspring.myStudyspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Member;
import java.util.List;

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

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        member member = new member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String List(Model model){
        List<member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
