package com.callcenter.controller;

import com.callcenter.domain.Service;
import com.callcenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.callcenter.domain.Role;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/role/**")
@Controller
public class RoleController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public String create(final Role role) {
        role.persist();
        userService.addAssignableRoleToCurrentUser(role);
        return "redirect:/role/" + role.getId();
    }

    @RequestMapping(value = "/role/form", method = RequestMethod.GET)
    public String createForm(ModelMap modelMap) {
        modelMap.addAttribute("role", new Role());
        modelMap.addAttribute("roles", Role.findAllRoles());
        modelMap.addAttribute("services", Service.findAllServices());
        return "role/create";
    }

    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("role", Role.findRole(id));
        return "role/show";
    }

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, ModelMap modelMap) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            modelMap.addAttribute("roles", Role.findRoleEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Role.countRoles() / sizeNo;
            modelMap.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            modelMap.addAttribute("roles", Role.findAllRoles());
        }
        return "role/list";
    }

    @RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        Role.findRole(id).remove();
        return "redirect:/role?page=" + ((page == null) ? "1" : page.toString()) + "&size=" + ((size == null) ? "10" : size.toString());
    }


}
