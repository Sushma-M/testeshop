/**This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
package com.salesvision2_0.fileservice.controller;

import com.salesvision2_0.fileservice.FileService;
import java.lang.String;
import java.io.IOException;
import java.lang.Exception;
import com.wavemaker.runtime.file.model.DownloadResponse;
import javax.servlet.http.HttpServletRequest;
import com.salesvision2_0.fileservice.FileService.WMFile;
import org.springframework.web.multipart.MultipartFile;
import com.salesvision2_0.fileservice.FileService.FileUploadResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/downloadFileAsInline", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public DownloadResponse getDownloadFileAsInline(@RequestParam(value = "file", required = false) String file, @RequestParam(value = "returnName", required = false) String returnName) throws Exception {
        return fileService.getDownloadFileAsInline(file, returnName);
    }

    @RequestMapping(value = "/downloadFile", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public DownloadResponse getDownloadFile(@RequestParam(value = "file", required = false) String file, @RequestParam(value = "returnName", required = false) String returnName) throws Exception {
        return fileService.getDownloadFile(file, returnName);
    }

    @RequestMapping(value = "/file", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public boolean deleteFile(@RequestParam(value = "file", required = false) String file) throws IOException {
        return fileService.deleteFile(file);
    }

    @RequestMapping(value = "/uploadFile", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public FileUploadResponse[] uploadFile(@RequestPart MultipartFile[] files, @RequestParam(value = "relativePath", required = false) String relativePath, HttpServletRequest httpServletRequest) {
        return fileService.uploadFile(files, relativePath, httpServletRequest);
    }

    @RequestMapping(value = "/files", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public WMFile[] listFiles(HttpServletRequest httpServletRequest) throws IOException {
        return fileService.listFiles(httpServletRequest);
    }
}
