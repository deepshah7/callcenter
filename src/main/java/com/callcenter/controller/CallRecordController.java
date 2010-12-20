package com.callcenter.controller;

import com.callcenter.converter.StringToCalendarConverter;
import com.callcenter.domain.CallRecord;
import com.callcenter.service.CallRecordService;
import com.callcenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RequestMapping("/callrecord/**")
@Controller
public class CallRecordController {

    @Autowired
    private CallRecordService callRecordService;

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        binder.registerCustomEditor(Calendar.class, new StringToCalendarConverter());
    }

    @RequestMapping(value = "/callrecord/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("callRecord", CallRecord.findCallRecord(id));
        return "callrecord/show";
    }

    @RequestMapping(value = "/callrecord", method = RequestMethod.GET)
    public String list(ModelMap modelMap) {
        final CallRecord callRecord = new CallRecord();
        modelMap.put("callRecord", callRecord);
        modelMap.put("availableFields", userService.getAvailableFieldsForCurrentUser());

        modelMap.addAttribute("callrecords", callRecordService
                .getCallRecordsFilteredByRoleAndSearchCriteria(callRecord,
                        userService.getCurrentUserRole()));

        return "callrecord/list";
    }

    @RequestMapping(value = "/callrecord/search", method = RequestMethod.GET)
    public @ResponseBody List<CallRecord> search(final CallRecord callRecord) {
        callRecord.prepareValuesForPartialSearch();
        return callRecordService
                .getCallRecordsFilteredByRoleAndSearchCriteria(callRecord,
                        userService.getCurrentUserRole());
    }
}
