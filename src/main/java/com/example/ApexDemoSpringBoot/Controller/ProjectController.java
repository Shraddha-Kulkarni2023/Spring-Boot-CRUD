package com.example.ApexDemoSpringBoot.Controller;

import com.example.ApexDemoSpringBoot.Beans.User;
import com.example.ApexDemoSpringBoot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class ProjectController {

    @Autowired
    private UserService userService;
    @GetMapping("/hello")
    public String welcome() {

        return "Welcome to Spring Boot Application";
    }

    @GetMapping("/displayusers")

    public List<User> getUser() {
        User user = new User();
        user.setName("Shraddha");
        user.setAge(38);
        user.setAddress("Fremont CA");

        List<User> users = new ArrayList<>();
        users.add(user);

        User user2 = new User();
        user2.setName("Shubhaam");
        user2.setAge(11);
        user2.setAddress("Fremont CA");

        users.add(user2);
        return users;

    }

    @GetMapping("/addusers")

    public String addusers(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("address") String address) {

        int ans;
        ans = userService.userservice(name, String.valueOf(age),address);
        if(ans > 0) {

            return "User inserted successfully";
        } else {

            return "No user inserted";
        }
    }

    @GetMapping("/deleteuser")
    public String deleteuser(@RequestParam("id") int id) {
        int ans = userService.deleteservice(id);
        if(ans > 0) {
            return "User deleted successfully";
        } else {
            return "No user deleted";
        }
    }

    @GetMapping("/getusers")
    public List<User> getusers() {
        List<User> users = new ArrayList<>();

        users = userService.getUsers();
        return users;

    }

    @GetMapping("/updatebyname")
    public String updatebyname(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("nameval") String nameval) {
        int ans = userService.updatebyname(id,name,nameval);
        if(ans > 0) {
            return "User updated successfully";
        } else {
            return "No user updated";
        }
    }

    @GetMapping("/updatebyage")
    public String updatebyage(@RequestParam("id") int id, @RequestParam("newage") int newage) {
        int ans = userService.updatebyage(id,newage);
        if(ans > 0) {
            return "Age of person updated successfully";
        } else {
            return "No person updated";
        }
    }

    @GetMapping("/updatebyaddress")
    public String updatebyaddress(@RequestParam("id") int id, @RequestParam("newaddress") String newaddress) {
        int ans = userService.updatebyaddress(id, newaddress);
        if(ans > 0) {
            return "Address of person updated successfully";
        } else {
            return "No person updated";
        }
    }


}
