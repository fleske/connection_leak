package com.fleske.leak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeakController {

    @Autowired
    private LeakRepository leakRepository;

    @PostMapping(value = "/create")
    public ResponseEntity<String> createData(@RequestParam Integer number) {
        for(int i=1; i<number; i++) {
            LeakEntity test = new LeakEntity();
            test.setName("Test" + i);
            test.setLast("Lastname" + i);
            test.setGender("Gender" + i);
            leakRepository.save(test);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/fail")
    public List<TestEntityDto> getAllLeaked() {
        return leakRepository.findLeakForTestFail();
    }

    @GetMapping("/success")
    public List<TestEntityDto> getAllSuccess() {
        return leakRepository.findLeakForTestSuccess();
    }
}
