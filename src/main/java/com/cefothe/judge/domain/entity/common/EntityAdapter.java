package com.cefothe.judge.domain.entity.common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by cefothe on 10.01.17.
 */
@MappedSuperclass
public class EntityAdapter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    public EntityAdapter() {
    }

    public long getId() {
        return id;
    }
}
