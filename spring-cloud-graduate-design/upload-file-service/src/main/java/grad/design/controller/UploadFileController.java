package grad.design.controller;


import grad.design.service.impl.HdfsServiceImpl;
import grad.design.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/hdfs")
public class UploadFileController {
    @Autowired
    private HdfsServiceImpl uploadService;

    @PostMapping("/uploads/{id}")
    public String receive(MultipartFile file, @PathVariable("id") Integer userId) throws IOException {
        uploadService.putFileToHDFS(file.getInputStream(), file.getOriginalFilename(),userId);
        if (userId != null){
            // todo 接收文件
            return "00000";
        }else {
            return "10008";
        }
    }
}
