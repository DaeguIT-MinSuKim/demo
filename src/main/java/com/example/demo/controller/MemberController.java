package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import com.example.demo.service.MemberService;

@Controller
public class MemberController {
	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

}
