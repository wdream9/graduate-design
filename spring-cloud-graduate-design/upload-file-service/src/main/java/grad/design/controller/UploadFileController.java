package grad.design.controller;


import grad.design.service.impl.HdfsServiceImpl;
import grad.design.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/hdfs")
public class UploadFileController {
    @Autowired
    private HdfsServiceImpl uploadService;

    @PostMapping("/uploads")
    public String receive(MultipartFile file, HttpServletRequest request) throws IOException {
        uploadService.putFileToHDFS(file.getInputStream(), file.getOriginalFilename());
        String token = request.getHeader("netdisk");
        if (token != null && UserUtils.verify(token)){
            // todo 接收文件
            return "00000";
        }else {
            return "10008";
        }
    }
}
