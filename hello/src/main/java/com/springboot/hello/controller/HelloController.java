package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController {

    //컨트롤러에 어떤 메소드를 할당할지 정해준다
    //@RestController : dispatcherServlet이 매핑해준 Controller 등록
    //@RequestMapping("path") : controller가 할당 된 후 어떤 method를 실행할지 연결해주는 어노테이션
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName(){
        return "name";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return "variable";
    }

    @GetMapping(value = "/request1")
    public String getVariable2(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String organization){
        return name + " " + email + " " + organization;
    }
    @GetMapping(value = "/request2")
    public String getVariable2(@RequestParam Map<String, String> param) {
        param.entrySet().forEach((map) -> {
            System.out.printf("key:%s value:%s\n", map.getKey(), map.getValue());
        });
        return "request2가 호출 완료 되었습니다";
    }

    @GetMapping(value ="/request3")
    public String getVariable3(MemberDto memberDto){
        return memberDto.toString();
    }

}
