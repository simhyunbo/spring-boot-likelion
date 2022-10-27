package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post";
    }

    //@RequestBody의 사용
    //Post에서는 @RequestBody를 주로 사용 합니다.
    //json(등)형식으로 넘어온 데이터를 사용할 수 있게 해줍니다.
    @PostMapping("/member")
    public String postMember(@RequestBody Map<String , Object> postData){
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map->sb.append(map.getKey()
        +":"+map.getValue()+"\n"));
        return sb.toString();
    }
    @PostMapping("/member2")
    public String postMember2(@RequestBody MemberDto memberDto){

        return memberDto.toString();
    }
}
