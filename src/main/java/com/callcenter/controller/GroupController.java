package com.callcenter.controller;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.callcenter.domain.Group;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "group", automaticallyMaintainView = true, formBackingObject = Group.class)
@RequestMapping("/group/**")
@Controller
public class GroupController {
}
