package com.callcenter.controller;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.callcenter.domain.CallRecord;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/callrecord/**")
@Controller
public class CallRecordController {

    @RequestMapping(value = "/callrecord/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("callRecord", CallRecord.findCallRecord(id));
        return "callrecord/show";
    }

    @RequestMapping(value = "/callrecord", method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", required = false) Integer page,
                       @RequestParam(value = "size", required = false) Integer size, ModelMap modelMap) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            modelMap.addAttribute("callrecords", CallRecord.findCallRecordEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) CallRecord.countCallRecords() / sizeNo;
            modelMap.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            modelMap.addAttribute("callrecords", CallRecord.findAllCallRecords());
        }
        return "callrecord/list";
    }


}
