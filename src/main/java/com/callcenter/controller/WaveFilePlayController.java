package com.callcenter.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callcenter.domain.CallRecord;
import com.callcenter.external.model.ProcessedFile;
import com.callcenter.wavefile.processor.WaveFileNamingStrategy;

@RequestMapping("/wavefileplay/**")
@Controller
public class WaveFilePlayController {


    @Autowired
    WaveFileNamingStrategy waveFileNamingStrategy;

    @Autowired
    ProcessedFile processedFile;

    private static final String FILE_DATA = "fileData";
    private static final String CONTENT_TYPE = "contentType";
    private final String WAVE_CONTENT_TYPE = "audio/x-wav";

    @RequestMapping
    public void get(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping(method = RequestMethod.POST, value = "/wavefileplay/{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {

    }

    @RequestMapping(value = "/wavefileplay/{id}")
    public String playWaveFile(@PathVariable Long id, Model model) {

        model.addAttribute(FILE_DATA, processedFile.getProcessedWaveFileBuffer(id));
        model.addAttribute(CONTENT_TYPE, WAVE_CONTENT_TYPE);
        return "wavPlayView";
    }

//    private byte[] getProcessedWaveFileBuffer(Long id) {
//        CallRecord callRecord = CallRecord.findCallRecord(id);
//        String waveFileName = callRecord.getWavefilename();
//        //get the file name
//        String waveFile = waveFileNamingStrategy.getFullFilePath(waveFileName);
//        // get the actual file
//        byte[] data = new byte[0];
//        try {
//            data = getFileData(waveFile);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return data;
//    }

    @RequestMapping
    public String index() {
        return "wavefileplay/index";
    }

//    protected byte[] getFileData(String fileNameWithPath) throws Exception {
//        File file = new File(fileNameWithPath);
//        FileInputStream fis = new FileInputStream(file);
//        byte[] buffer = new byte[fis.available()];
//        fis.read(buffer);
//        fis.close();
//        return buffer;
//    }
}
