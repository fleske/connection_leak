package com.fleske.leak;

import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaLeakRepositoryImpl implements LeakCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<TestEntityDto> findLeakForTestFail() {
        String sql = "select count(*) as counter, name as name, last as last from leak_entity group by name, last";
        return entityManager.createNativeQuery(sql)
                .unwrap(org.hibernate.SQLQuery.class)
                .addScalar("counter")
                .addScalar("name")
                .addScalar("last")
                .addSynchronizedQuerySpace("leak_entity")
                .setResultTransformer(Transformers.aliasToBean(TestEntityDto.class)).list();
    }
}
