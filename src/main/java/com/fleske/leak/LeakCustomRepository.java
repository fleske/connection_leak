package com.fleske.leak;

import java.util.List;

public interface LeakCustomRepository {

    List<TestEntityDto> findLeakForTestFail();
}
