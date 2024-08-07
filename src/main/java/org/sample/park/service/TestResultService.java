package org.sample.park.service;

import org.sample.park.model.TestResult;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TestResultService {

    private final LinkedList<TestResult> recentResults = new LinkedList<>();

    public void addResult(TestResult result) {
        if (recentResults.size() >= 10) {
            recentResults.removeFirst();
        }
        recentResults.addLast(result);
    }

    public List<TestResult> getRecentResults() {
        return new LinkedList<>(recentResults);
    }
}
