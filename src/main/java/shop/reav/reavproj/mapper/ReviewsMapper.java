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
    @Insert("INSERT INTO reviews (itemID, USER, email, review, rating) VALUES (#{itemID}, #{user}, #{email}, #{review}, #{rating})")
    int insertReview(@Param("itemID") int itemID, @Param("user") String user, @Param("email") String email, @Param("review") String review, @Param("rating") int rating);

    ///review get
    @Select("SELECT * FROM Reviews")
    List<Reviews> getReviewsList();

    ///weight get
    @Select("SELECT AVG(weight) FROM reviews WHERE itemID = #{itemID}")
    int getReviewWeight(@Param("itemID") int itemID);

    ///rating get
    @Select("SELECT AVG(rating) FROM reviews WHERE itemID = #{itemID}")
    int getReviewRating(@Param("itemID") int itemID);
}