package com.callcenter.controller;

import com.callcenter.domain.User;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.callcenter.domain.Group;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@RequestMapping("/group/**")
@Controller
public class GroupController {

    @RequestMapping(value = "/group", method = RequestMethod.POST)
    public String create(final Group group, final ModelMap modelMap) {
        group.persist();
        return "redirect:/group/" + group.getId();
    }

    @RequestMapping(value = "/group/form", method = RequestMethod.GET)
    public String createForm(ModelMap modelMap) {
        modelMap.addAttribute("group", new Group());
        modelMap.addAttribute("users", User.findAllUsers());
        modelMap.addAttribute("groups", Group.findAllGroups());
        return "group/create";
    }

    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("group", Group.findGroup(id));
        return "group/show";
    }

    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, ModelMap modelMap) {
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

    @RequestMapping(value = "/group/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        Group.findGroup(id).remove();
        return "redirect:/group?page=" + ((page == null) ? "1" : page.toString()) + "&size=" + ((size == null) ? "10" : size.toString());
    }

}
