package com.cefothe.judge.domain.entity.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by Stefan Angelov - Delta Source Bulgaria on 2/12/17.
 */
@RequiredArgsConstructor
public class User {

    @Getter
    private String username;

    @Getter
    private String password;

}
