package com.example.policyApp.Controller;

import com.example.policyApp.Entity.Reviewer;
import com.example.policyApp.Service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviewers")
public class ReviewerController {

    @Autowired
    ReviewerService reviewerService;

    // Create a new Reviewer
    @PostMapping("/createReview")
    public ResponseEntity<Reviewer> createReviewer(@RequestBody Reviewer reviewer) {
        Reviewer savedReviewer = reviewerService.saveReviewer(reviewer);
        return new ResponseEntity<>(savedReviewer, HttpStatus.CREATED);
    }

    // Update an existing Reviewer
    @PutMapping("/updateReview/{id}")
    public ResponseEntity<Reviewer> updateReviewer(@PathVariable int id, @RequestBody Reviewer reviewer) {
        try {
            Reviewer updatedReviewer = reviewerService.updateReviewer(id, reviewer);
            return new ResponseEntity<>(updatedReviewer, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get a Reviewer by ID
    @GetMapping("/getReview/{id}")
    public ResponseEntity<Reviewer> getReviewerById(@PathVariable int id) {
        Optional<Reviewer> reviewer = reviewerService.getReviewerById(id);
        return reviewer.map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all Reviewers
    @GetMapping("/getallReview")
    public ResponseEntity<List<Reviewer>> getAllReviewers() {
        List<Reviewer> reviewers = reviewerService.getAllReviewers();
        return new ResponseEntity<>(reviewers, HttpStatus.OK);
    }

    // Delete a Reviewer by ID
    @DeleteMapping("/deleteReview/{id}")
    public ResponseEntity<Void> deleteReviewer(@PathVariable int id) {
        try {
            reviewerService.deleteReviewer(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
