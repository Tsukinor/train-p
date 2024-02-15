package com.jiawa.train.member.controller;


import com.jiawa.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;
    @RequestMapping("/count")
    public Integer count(){
        return memberService.count();
    }
}
