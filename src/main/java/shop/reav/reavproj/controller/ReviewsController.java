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
@CrossOrigin("*")
public class ReviewsController {

    private final static Logger LOG = Logger.getGlobal();

    private ReviewsMapper mapper;

    public ReviewsController(ReviewsMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/review/{itemID}")
    public String postReview(@PathVariable("itemID") int itemID, @RequestParam("user") String user, @RequestParam("email") String email, @RequestParam("review") String review, @RequestParam("rating") int rating) {

        double weight = 0;
        try{
            URL url = new URL("http://17a1-59-12-219-18.ngrok.io/" + review);
            LOG.info(url + " ");
            LOG.info(url + " ");
            LOG.info(url + " ");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while((line = in.readLine()) != null) { // response를 차례대로 출력
                LOG.info(url + " : " + line);
                LOG.info(url + " : " + line);
                LOG.info(url + " : " + line);
            }
            weight = Double.parseDouble(line);
        }catch(Exception e){
            e.printStackTrace();
        }

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