package com.callcenter.controller;

import com.callcenter.domain.CallRecord;
import java.lang.Long;
import java.lang.String;
import javax.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect CallRecordController_Roo_Controller {
    
    @RequestMapping(value = "/callrecord", method = RequestMethod.POST)
    public String CallRecordController.create(@Valid CallRecord callRecord, BindingResult result, ModelMap modelMap) {
        if (callRecord == null) throw new IllegalArgumentException("A callRecord is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("callRecord", callRecord);
            return "callrecord/create";
        }
        callRecord.persist();
        return "redirect:/callrecord/" + callRecord.getId();
    }
    
    @RequestMapping(value = "/callrecord/form", method = RequestMethod.GET)
    public String CallRecordController.createForm(ModelMap modelMap) {
        modelMap.addAttribute("callRecord", new CallRecord());
        return "callrecord/create";
    }
    
    @RequestMapping(value = "/callrecord/{id}", method = RequestMethod.GET)
    public String CallRecordController.show(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("callRecord", CallRecord.findCallRecord(id));
        return "callrecord/show";
    }
    
    @RequestMapping(value = "/callrecord", method = RequestMethod.GET)
    public String CallRecordController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, ModelMap modelMap) {
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
    
    @RequestMapping(method = RequestMethod.PUT)
    public String CallRecordController.update(@Valid CallRecord callRecord, BindingResult result, ModelMap modelMap) {
        if (callRecord == null) throw new IllegalArgumentException("A callRecord is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("callRecord", callRecord);
            return "callrecord/update";
        }
        callRecord.merge();
        return "redirect:/callrecord/" + callRecord.getId();
    }
    
    @RequestMapping(value = "/callrecord/{id}/form", method = RequestMethod.GET)
    public String CallRecordController.updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("callRecord", CallRecord.findCallRecord(id));
        return "callrecord/update";
    }
    
    @RequestMapping(value = "/callrecord/{id}", method = RequestMethod.DELETE)
    public String CallRecordController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        CallRecord.findCallRecord(id).remove();
        return "redirect:/callrecord?page=" + ((page == null) ? "1" : page.toString()) + "&size=" + ((size == null) ? "10" : size.toString());
    }
    
}
