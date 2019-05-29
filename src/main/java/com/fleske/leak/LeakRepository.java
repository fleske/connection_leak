package com.fleske.leak;


import java.util.List;

public interface LeakRepository extends LeakCustomRepository {

    LeakEntity save(LeakEntity leakEntity);

    List<TestEntityDto> findLeakForTestSuccess();
}
