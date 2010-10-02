package com.callcenter.controller;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.callcenter.domain.CallRecord;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "callrecord", automaticallyMaintainView = false, formBackingObject = CallRecord.class)
@RequestMapping("/callrecord/**")
@Controller
public class CallRecordController {
}
