package com.callcenter.controller;

import com.callcenter.domain.Field;
import com.callcenter.domain.RecordingLibraryService;
import com.callcenter.editor.CustomCalendarEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@Controller
@Transactional
public class RecordingLibraryServiceController {

    @InitBinder
    public void initDataBinder(final WebDataBinder binder) {
        binder.registerCustomEditor(Calendar.class, new CustomCalendarEditor());
    }

    @RequestMapping(value = "/recordinglibrary", method = RequestMethod.POST)
    public String create(final RecordingLibraryService service) {
        service.prepareRestrictions();
        service.persist();
        return "redirect:/recordinglibrary/" + service.getId();
    }

    @RequestMapping(value = "/recordinglibrary/form", method = RequestMethod.GET)
    public String createForm(final ModelMap modelMap) {
        modelMap.addAttribute("service", new RecordingLibraryService());
        modelMap.addAttribute("fields", Field.findAllFields());
        return "recordinglibrary/create";
    }

    @RequestMapping(value = "/recordinglibrary/{id}", method = RequestMethod.GET)
    public String show(final @PathVariable("id") Long id, final ModelMap modelMap) {
        modelMap.addAttribute("service", RecordingLibraryService.findRecordingLibraryService(id));
        return "recordinglibrary/show";
    }

    @RequestMapping(value = "/recordinglibrary", method = RequestMethod.GET)
    public String list(final ModelMap modelMap) {
        modelMap.addAttribute("services", RecordingLibraryService.findAllRecordingLibraryServices());
        return "recordinglibrary/list";
    }
}
