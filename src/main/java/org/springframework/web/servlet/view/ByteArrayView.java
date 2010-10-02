package org.springframework.web.servlet.view;

import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class ByteArrayView extends AbstractView {

    public ByteArrayView() {
    }

    protected final void renderMergedOutputModel(
        Map model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        byte[] bytes = (byte[]) model.get("fileData");
        String contentType = (String) model.get("contentType");

        // Write content type and also length (determined via byte array).
        response.setContentType(contentType);
        response.setContentLength(bytes.length);

        // Flush byte array to servlet output stream.
        ServletOutputStream out = response.getOutputStream();
        out.write(bytes);
        out.flush();
    }
}