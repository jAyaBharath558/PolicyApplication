package com.example.policyApp.Service;

import com.example.policyApp.Entity.Reviewer;

import java.util.List;
import java.util.Optional;

public interface ReviewerService {
    Reviewer saveReviewer(Reviewer reviewer);
    Reviewer updateReviewer(int id, Reviewer reviewer);
    Optional<Reviewer> getReviewerById(int id);
    List<Reviewer> getAllReviewers();
    void deleteReviewer(int id);
}
