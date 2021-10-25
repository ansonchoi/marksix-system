package io.ansonchoi.marksixsystem.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Service
public class CheckServiceImpl implements CheckService {

    private final static Logger logger = LoggerFactory.getLogger(CheckService.class);

    @Override
    public Map<Integer, Integer> checkSimilarity(List<List<Integer>> allNumbers) {
        final Map<Integer, Integer> result = new HashMap<>();
        result.put(1, checkSimilarity(allNumbers, 1).size());
        result.put(2, checkSimilarity(allNumbers, 2).size());
        result.put(3, checkSimilarity(allNumbers, 3).size());
        result.put(4, checkSimilarity(allNumbers, 4).size());
        result.put(5, checkSimilarity(allNumbers, 5).size());
        result.put(6, checkSimilarity(allNumbers, 6).size());
        return result;
    }

    @Override
    public List<Integer> checkMissing(List<List<Integer>> allNumbers) {
        final List<Integer> result = new ArrayList<>();
        IntStream.range(1, 50).forEach(n -> {
            boolean found = false;
            for (List<Integer> numbers : allNumbers) {
                if (numbers.contains(n)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result.add(n);
            }
        });
        return result;
    }

    private List<List<Integer>> checkSimilarity(List<List<Integer>> allNumbers, int targetCount) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> addedIndex = new ArrayList<>();
        for (int i = 0; i < allNumbers.size(); i++) {
            final List<Integer> currSixNumbers = allNumbers.get(i);
            for (int j = i + 1; j < allNumbers.size(); j++) {
                final List<Integer> compareSixNumbers = allNumbers.get(j);
                int count = 0;
                for (Integer number : currSixNumbers) {
                    if (compareSixNumbers.contains(number)) {
                        count++;
                    }
                }
                if (count >= targetCount) {
                    if (!addedIndex.contains(i)) {
                        result.add(currSixNumbers);
                        addedIndex.add(i);
                    }
                    if (!addedIndex.contains(j)) {
                        result.add(compareSixNumbers);
                        addedIndex.add(j);
                    }
                }
            }
        }

        return result;
    }
}
