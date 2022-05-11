package grad.design.controller;


import grad.design.dto.FileInfo;
import grad.design.service.impl.HdfsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/hdfs")
@CrossOrigin
public class DownloadFileController {
    @Autowired
    private HdfsServiceImpl hdfsService;

    @PostMapping("/info/{id}")
    public ArrayList<FileInfo> receive(@PathVariable("id") Integer userid) throws Exception {
        // 判断 文件 还是 文件夹
        ArrayList<FileInfo> filesType = hdfsService.isFileType("/netdisk/wyh/");
        return filesType;
    }

    @GetMapping("/download/{filename}")
    public void download(@PathVariable("filename") String filename, HttpServletResponse response) throws IOException {
        hdfsService.getFileFromHDFS(response.getOutputStream(), filename);
    }


}
