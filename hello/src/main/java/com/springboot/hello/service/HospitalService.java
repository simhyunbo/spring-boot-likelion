package com.springboot.hello.service;

import com.springboot.hello.Parser.ReadLineContext;
import com.springboot.hello.dao.HospitalDao;
import com.springboot.hello.domain.dto.Hospital;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;


//    Provider.ServicePresentation → Service(Business) → Data
//    Presentation과 비즈니스 로직을 분리하기 위한 계층(간단한 예제를 만들때는 필요가 x)
//    @Component 어노테이션과 같은 기능
//    @ComponentScan 할때 Bean으로 등록 됩니다.
@Service
public class HospitalService {

    private final ReadLineContext<Hospital> hospitalReadLineContext;

    private final HospitalDao hospitalDao;

    public HospitalService(ReadLineContext<Hospital> hospitalReadLineContext, HospitalDao hospitalDao) {
        this.hospitalReadLineContext = hospitalReadLineContext;
        this.hospitalDao = hospitalDao;
    }


    public int insertLargeVolumeHospitalData(String filename) {
        int cnt = 0;
        try {
            List<Hospital> hospitalList = hospitalReadLineContext.readByLine(filename);
            System.out.println("파싱이 끝났습니다.");
            for (Hospital hospital : hospitalList) { // loop구간
                try {
                    this.hospitalDao.add(hospital); // db에 insert하는 구간
                    cnt++;
                } catch (Exception e) {
                    System.out.printf("id:%d 레코드에 문제가 있습니다.",hospital.getId());
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cnt;
    }
}

