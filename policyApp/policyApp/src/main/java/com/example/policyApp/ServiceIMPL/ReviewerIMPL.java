package com.example.policyApp.ServiceIMPL;

import com.example.policyApp.DTO.ReviewerDTO;
import com.example.policyApp.Entity.Reviewer;
import com.example.policyApp.Service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewerIMPL implements ReviewerService {
    @Autowired
    ReviewerDTO reviewerDTO;

    @Override
    public Reviewer saveReviewer(Reviewer reviewer) {
        return reviewerDTO.save(reviewer);
    }

    @Override
    public Reviewer updateReviewer(int id, Reviewer reviewer) {
        if (reviewerDTO.existsById(id)) {
            reviewer.setReviewer_id(id);
            return reviewerDTO.save(reviewer);
        } else {
            throw new RuntimeException("Reviewer with id " + id + " not found.");
        }
    }

    @Override
    public Optional<Reviewer> getReviewerById(int id) {
        return reviewerDTO.findById(id);
    }

    @Override
    public List<Reviewer> getAllReviewers() {
        return reviewerDTO.findAll();
    }

    @Override
    public void deleteReviewer(int id) {
        if (reviewerDTO.existsById(id)) {
            reviewerDTO.deleteById(id);
        } else {
            throw new RuntimeException("Reviewer with id " + id + " not found.");
        }
    }
}
