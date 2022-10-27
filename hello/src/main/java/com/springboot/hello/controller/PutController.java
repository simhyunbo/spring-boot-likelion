package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Put";
    }

    //@RequestBody의 사용
    //Post에서는 @RequestBody를 주로 사용 합니다.
    //json(등)형식으로 넘어온 데이터를 사용할 수 있게 해줍니다.
    @PostMapping("/member")
    public String putMember(@RequestBody Map<String , Object> postData){
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map->sb.append(map.getKey()
        +":"+map.getValue()+"\n"));
        return sb.toString();
    }
    @PostMapping("/member2")
    public String putMember2(@RequestBody MemberDto memberDto){

        return memberDto.toString();
    }

    @PostMapping("/member3")
    public ResponseEntity<MemberDto> putMember3(@RequestBody MemberDto memberDto){

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }


}
