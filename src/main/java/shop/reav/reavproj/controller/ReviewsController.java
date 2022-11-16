package shop.reav.reavproj.controller;

import shop.reav.reavproj.mapper.ReviewsMapper;
import shop.reav.reavproj.model.Reviews;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

import java.util.logging.Logger;

@RestController
public class ReviewsController {

    private final static Logger LOG = Logger.getGlobal();

    private ReviewsMapper mapper;

    public ReviewsController(ReviewsMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/review/{itemID}")
    public String postReview(@PathVariable("itemID") int itemID, @RequestParam("user") String user, @RequestParam("email") String email, @RequestParam("review") String review, @RequestParam("rating") int rating) {

        double weight = 0;

        mapper.insertReview(itemID, user, email, review, rating, weight);
        return review + " " + weight;
    }

    @GetMapping("/review")
    public List<Reviews> getUserProfileList() {
        return mapper.getReviewsList();
    }

    @GetMapping("/weight/{itemID}")
    public double getReviewWeight(@PathVariable("itemID") int itemID) {
        return mapper.getReviewWeight(itemID);
    }

    @GetMapping("/rating/{itemID}")
    public double getReviewRating(@PathVariable("itemID") int itemID) {
        return mapper.getReviewRating(itemID);
    }
}