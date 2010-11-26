package com.callcenter.controller;

import com.callcenter.domain.Field;
import com.callcenter.domain.RecordingLibraryService;
import com.callcenter.domain.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecordingLibraryServiceController {

    @RequestMapping(value = "/recordinglibrary", method = RequestMethod.POST)
    public String create(final Service service) {
        service.persist();
        return "redirect:/recordinglibrary/" + service.getId();
    }

    @RequestMapping(value = "/recordinglibrary/form", method = RequestMethod.GET)
    public String createForm(ModelMap modelMap) {
        modelMap.addAttribute("service", new RecordingLibraryService());
        modelMap.addAttribute("fields", Field.findAllFields());
        return "recordinglibrary/create";
    }

    @RequestMapping(value = "/recordinglibrary/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("service", RecordingLibraryService.findRecordingLibraryService(id));
        return "recordinglibrary/show";
    }

    @RequestMapping(value = "/recordinglibrary", method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", required = false) Integer page,
                       @RequestParam(value = "size", required = false) Integer size, ModelMap modelMap) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            modelMap.addAttribute("services", RecordingLibraryService.findRecordingLibraryServiceEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) RecordingLibraryService.countRecordingLibraryServices() / sizeNo;
            modelMap.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            modelMap.addAttribute("services", RecordingLibraryService.findAllServices());
        }
        return "recordinglibrary/list";
    }

    @RequestMapping(value = "/recordinglibrary/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page,
                         @RequestParam(value = "size", required = false) Integer size) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        RecordingLibraryService.findRecordingLibraryService(id).remove();
        return "redirect:/recordinglibrary?page=" + ((page == null) ? "1" : page.toString()) + "&size=" + ((size == null) ? "10" : size.toString());
    }

}
