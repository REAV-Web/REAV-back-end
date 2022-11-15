package shop.reav.reavproj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import shop.reav.reavproj.model.UserProfile;

@Mapper
public interface UserProfileMapper {
    
    //전달된 id를 가지고 db table에서 조회해서 UserProfile 객체를 return함
    @Select("SELECT * FROM UserProfile WHERE id=#{id}")
    UserProfile getUserProfile(@Param("id") String id);
    //@param이라고 annotation을 주면 String id가 SQL mapping 문장에 ${id}에 mapping됨

    @Select("SELECT * FROM UserProfile")
    List<UserProfile> getUserProfileList();

    //insert, update, delete는 그 결과를 SQL문에 의해서 적용되거나 영향을 받은 레코드의 개수를 int로 반환함
    @Insert("INSERT INTO UserProfile VALUES(#{id}, #{name}, #{phone}, #{address})")
    int insertUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);

    @Update("UPDATE UserProfile SET name=#{name}, phone=#{phone}, address=#{address} WHERE id=#{id}")
    int updateUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);

    @Delete("DELETE FROM UserProfile WHERE id=#{id}")
    int deleteUserProfile(@Param("id") String id);
}