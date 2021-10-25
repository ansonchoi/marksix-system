package io.ansonchoi.marksixsystem.rest;

import io.ansonchoi.marksixsystem.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/check")
public class CheckController {

    @Autowired
    private CheckService checkService;

    @PostMapping("/similarity")
    public Map<Integer, Integer> checkSimilarity(@RequestBody List<List<Integer>> allNumbers) {
        return checkService.checkSimilarity(allNumbers);
    }

    @PostMapping("/missing")
    public List<Integer> checkMissing(@RequestBody List<List<Integer>> allNumbers) {
        return checkService.checkMissing(allNumbers);
    }
}
