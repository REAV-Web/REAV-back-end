package shop.reav.reavproj.controller;

import shop.reav.reavproj.mapper.UserProfileMapper;
import shop.reav.reavproj.model.UserProfile;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProfileController {

    private UserProfileMapper mapper;

    //생성자를 통해서 파라미터와 전달받은 mapper를 받아서 내부 mapper에 저장하도록 하면 스프링 부트가 알아서 mapper class를 만들고 그 객체를 UserProfileController를 만들면서 생성자를 만들어줌
    public UserProfileController(UserProfileMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id) {
        return mapper.getUserProfile(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
        return mapper.getUserProfileList();
    }

    @PutMapping("user/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        mapper.insertUserProfile(id, name, phone, address);
    }

    //이 코드에서는 put이 등록, post가 수정으로 됨
    @PostMapping("user/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        mapper.updateUserProfile(id, name, phone, address);
    }
    
    @DeleteMapping("user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id) {
        mapper.deleteUserProfile(id);
    }
}