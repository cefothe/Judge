package com.cefothe.judge.domain.entity.users;

import com.cefothe.judge.domain.entity.common.EntityAdapter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Stefan Angelov - Delta Source Bulgaria on 2/12/17.
 */
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class User extends EntityAdapter {

    @Getter
    private String username;

    @Getter
    private String email;

    @Getter
    private String password;

}
