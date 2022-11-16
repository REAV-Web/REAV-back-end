package shop.reav.reavproj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import shop.reav.reavproj.model.Reviews;

@Mapper
public interface ReviewsMapper {
     
    ///review post
    @Insert("INSERT INTO reviews (itemID, user, email, review, rating, weight) VALUES (#{itemID}, #{user}, #{email}, #{review}, #{rating}, #{weight})")
    int insertReview(@Param("itemID") int itemID, @Param("user") String user, @Param("email") String email, @Param("review") String review, @Param("rating") int rating, @Param("weight") double weight);

    ///review get
    @Select("SELECT * FROM reviews Where itemID = #{itemID}")
    List<Reviews> getReviewsList(@Param("itemID") int itemID);

    ///weight get
    @Select("SELECT AVG(weight) FROM reviews WHERE itemID = #{itemID}")
    double getReviewWeight(@Param("itemID") int itemID);

    ///rating get
    @Select("SELECT AVG(rating) FROM reviews WHERE itemID = #{itemID}")
    double getReviewRating(@Param("itemID") int itemID);
}