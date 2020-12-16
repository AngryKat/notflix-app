package com.kate.notflixapp.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class ImageController {
    @Autowired
    ServletContext context;
    Logger log = Logger.getLogger(ImageController.class.getName());
    @ResponseBody
    @RequestMapping(value="/images/{imageId}",  method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable long imageId) throws IOException {
        InputStream in = context.getResourceAsStream("/images/"+imageId+".jpg");
        //log.log(Level.INFO, rpath);
        return IOUtils.toByteArray(in);

    }
}
