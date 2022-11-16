package shop.reav.reavproj.controller;

import shop.reav.reavproj.mapper.ReviewsMapper;
import shop.reav.reavproj.model.Reviews;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLDecoder;

import java.nio.charset.*;

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

        String response = "";

        try{
           
            String original_url = "http://7ef6-59-12-219-18.ngrok.io/" + review;
            original_url = original_url.trim();
            original_url = original_url.replace(" ", "%20");
            URL url = new URL(original_url);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setConnectTimeout(5000); // 연결 타임아웃 설정(5초) 
			conn.setReadTimeout(5000); // 읽기 타임아웃 설정(5초)
			conn.setDoOutput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;			
			StringBuffer sb = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {

                System.out.println("input liner: " + inputLine);
                System.out.println("input liner: " + inputLine);
                System.out.println("input liner: " + inputLine);
                System.out.println("input liner: " + inputLine);
                System.out.println("input liner: " + inputLine);

				sb.append(inputLine);
			}
			br.close();

            response = sb.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
 
        String parsed = response.substring(response.indexOf(":") + 1, response.indexOf("}"));
        double weight = Double.parseDouble(parsed);

        mapper.insertReview(itemID, user, email, review, rating, weight);
        return review + " " + weight;
    }

    @GetMapping("/review/{itemID}")
    public List<Reviews> getUserProfileList(@PathVariable("itemID") int itemID) {
        return mapper.getReviewsList(itemID);
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