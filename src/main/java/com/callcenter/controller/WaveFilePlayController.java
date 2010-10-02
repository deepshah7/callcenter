package com.callcenter.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callcenter.util.Constants;
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
    private ProcessedFile processedFile;

    @RequestMapping(value = "/wavefileplay/{id}")
    public void downloadWaveFile(@PathVariable final Long id, final HttpServletResponse response) {
        final byte[] waveFileData = processedFile.getProcessedWaveFileBuffer(id);
        // Write content type and also length (determined via byte array).
        response.setContentType(Constants.WaveFile.CONTENT_TYPE);
        response.setContentLength(waveFileData.length);

        // Flush byte array to servlet output stream.
        try {
            final ServletOutputStream out = response.getOutputStream();
            out.write(waveFileData);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
