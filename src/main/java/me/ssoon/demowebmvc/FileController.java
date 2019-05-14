package me.ssoon.demowebmvc;

import java.io.File;
import java.io.IOException;
import org.apache.tika.Tika;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {

    private ResourceLoader resourceLoader;

    public FileController(final ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/file")
    public String fileUploadForm(final Model model) {
        return "files/index";
    }

    @PostMapping("/file")
    public String fileUpload(final @RequestParam MultipartFile file,
        final RedirectAttributes attributes) {
        System.out.println("file name: " + file.getName());
        System.out.println("file original name: " + file.getOriginalFilename());
        final String message = file.getOriginalFilename() + " is uploaded.";
        attributes.addFlashAttribute("message", message);
        return "redirect:/file";
    }

    @GetMapping("/file/{filename}")
    public ResponseEntity fileDownload(final @PathVariable String filename) throws IOException {
        final Resource resource = resourceLoader.getResource("classpath:" + filename);
        final File file = resource.getFile();
        final Tika tika = new Tika();
        final String mediaType = tika.detect(file);
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
            .header(HttpHeaders.CONTENT_TYPE, mediaType)
            .header(HttpHeaders.CONTENT_LENGTH, file.length() + "")
            .body(resource);
    }
}
