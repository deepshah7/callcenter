package com.callcenter.controller;

import com.callcenter.domain.CallRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public String list(ModelMap modelMap) {
        modelMap.put("callRecord", new CallRecord());
        modelMap.addAttribute("callrecords", CallRecord.findAllCallRecords());

        return "callrecord/list";
    }

    @RequestMapping(value = "/callrecord/search", method = RequestMethod.GET)
    public
    @ResponseBody
    List<CallRecord> search(final CallRecord callRecord) {
        callRecord.nullifyEmptyValues();
        return CallRecord.findAllByExample(callRecord);
    }


}
