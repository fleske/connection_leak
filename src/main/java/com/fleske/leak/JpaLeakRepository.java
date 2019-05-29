package com.fleske.leak;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaLeakRepository extends JpaRepository<LeakEntity, Long>, LeakRepository {

    @Query("select new com.fleske.leak.TestEntityDto(count(t), t.name, t.last) from LeakEntity t group by t.name, t.last")
    List<TestEntityDto> findLeakForTestSuccess();
}
