package io.ansonchoi.marksixsystem.service;

import java.util.List;
import java.util.Map;

public interface CheckService {

    Map<Integer, Integer> checkSimilarity(List<List<Integer>> allNumbers);

    List<Integer> checkMissing(List<List<Integer>> allNumbers);
}
