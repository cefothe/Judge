package com.cefothe.judge.rest;

import com.cefothe.judge.domain.dto.SolutionTO;
import com.cefothe.judge.services.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by cefothe on 11.01.17.
 */
@RestController
@RequestMapping("/solution")
public class SolutionController {

    @Autowired
    private SolutionService solutionService;

    @PostMapping
    public void submit(@RequestBody SolutionTO solutionTO) throws IOException {
        solutionService.execute(solutionTO);
    }
}
