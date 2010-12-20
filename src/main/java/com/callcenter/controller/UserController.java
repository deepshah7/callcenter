package com.callcenter.controller;

import com.callcenter.domain.Role;
import com.callcenter.domain.User;
import com.callcenter.service.CallcenterUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private CallcenterUserDetailsService callcenterUserDetailsService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String create(final User user) {
        user.setRole(Role.findRole(user.getRole().getId()));
        user.persist();
        return "redirect:/user/" + user.getId();
    }

    @RequestMapping(value = "/user/form", method = RequestMethod.GET)
    public String createForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("roles", Role.findAllRoles());
        return "user/create";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", User.findUser(id));
        return "user/show";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String list(final ModelMap modelMap) {
        modelMap.addAttribute("users", callcenterUserDetailsService.getUsersForCurrentRole());
        return "user/list";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(User user) {
        user.merge();
        return "redirect:/user/" + user.getId();
    }

    @RequestMapping(value = "/user/{id}/form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", User.findUser(id));
        modelMap.addAttribute("roles", Role.findAllRoles());
        return "user/update";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
        User.findUser(id).remove();
        return "redirect:/user";
    }
}
