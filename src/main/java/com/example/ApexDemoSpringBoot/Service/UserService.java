package com.example.ApexDemoSpringBoot.Service;


import com.example.ApexDemoSpringBoot.Beans.User;
import com.example.ApexDemoSpringBoot.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public int userservice(String name, String age, String address) {
        int ans;
        ans = userDAO.addData(name,age,address);
        return ans;
    }

    public int deleteservice(int id) {
        int ans;
        ans = userDAO.deleteUser(id);
        return ans;
    }

    public List<User> getUsers() {
        ArrayList<User> arr1 = new ArrayList<User>();
        arr1 = (ArrayList<User>) userDAO.getUsers();
        return arr1;
    }

    public int updatebyname(int id,String name, String nameval) {
        return userDAO.updatebyname(id,name,nameval);
    }

    public int updatebyage(int id, int newage) {
        return userDAO.updatebyage(id, newage);
    }

    public int updatebyaddress(int id, String newaddress) {
        return userDAO.updatebyaddress(id, newaddress);
    }



}
