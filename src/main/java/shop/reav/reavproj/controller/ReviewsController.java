package shop.reav.reavproj.controller;

import shop.reav.reavproj.mapper.ReviewsMapper;
import shop.reav.reavproj.model.Reviews;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewsController {

    private ReviewsMapper mapper;

    public ReviewsController(ReviewsMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/review/{itemID}")
    public void postReview(@PathVariable("itemID") int itemID, @RequestParam("user") String user, @RequestParam("email") String email, @RequestParam("review") String review, @RequestParam("rating") int rating) {
        mapper.insertReview(itemID, user, email, review, rating);
    }

    @GetMapping("/review")
    public List<Reviews> getUserProfileList() {
        return mapper.getReviewsList();
    }

    @GetMapping("/weight/{itemID}")
    public int getReviewWeight(@PathVariable("itemID") int itemID) {
        return mapper.getReviewWeight(itemID);
    }

    @GetMapping("/rating/{itemID}")
    public int getReviewRating(@PathVariable("itemID") int itemID) {
        return mapper.getReviewRating(itemID);
    }
}