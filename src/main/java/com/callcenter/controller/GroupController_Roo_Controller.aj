package com.callcenter.controller;

import com.callcenter.domain.Group;
import com.callcenter.domain.User;
import java.lang.Long;
import java.lang.String;
import javax.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect GroupController_Roo_Controller {
    
    @RequestMapping(value = "/group", method = RequestMethod.POST)
    public String GroupController.create(@Valid Group group, BindingResult result, ModelMap modelMap) {
        if (group == null) throw new IllegalArgumentException("A group is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("group", group);
            modelMap.addAttribute("users", User.findAllUsers());
            return "group/create";
        }
        group.persist();
        return "redirect:/group/" + group.getId();
    }
    
    @RequestMapping(value = "/group/form", method = RequestMethod.GET)
    public String GroupController.createForm(ModelMap modelMap) {
        modelMap.addAttribute("group", new Group());
        modelMap.addAttribute("users", User.findAllUsers());
        return "group/create";
    }
    
    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    public String GroupController.show(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("group", Group.findGroup(id));
        return "group/show";
    }
    
    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public String GroupController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, ModelMap modelMap) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            modelMap.addAttribute("groups", Group.findGroupEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Group.countGroups() / sizeNo;
            modelMap.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            modelMap.addAttribute("groups", Group.findAllGroups());
        }
        return "group/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String GroupController.update(@Valid Group group, BindingResult result, ModelMap modelMap) {
        if (group == null) throw new IllegalArgumentException("A group is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("group", group);
            modelMap.addAttribute("users", User.findAllUsers());
            return "group/update";
        }
        group.merge();
        return "redirect:/group/" + group.getId();
    }
    
    @RequestMapping(value = "/group/{id}/form", method = RequestMethod.GET)
    public String GroupController.updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("group", Group.findGroup(id));
        modelMap.addAttribute("users", User.findAllUsers());
        return "group/update";
    }
    
    @RequestMapping(value = "/group/{id}", method = RequestMethod.DELETE)
    public String GroupController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        Group.findGroup(id).remove();
        return "redirect:/group?page=" + ((page == null) ? "1" : page.toString()) + "&size=" + ((size == null) ? "10" : size.toString());
    }
    
}
