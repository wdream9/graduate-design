package grad.design.service.impl;


import grad.design.service.hdfs.HdfsService;
import org.apache.dubbo.config.annotation.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Service(version = "hd-1.0.0")
public class HdfsDubboServiceImpl implements HdfsService {

    @Override
    public String mkdirDirHdfs(String userName) throws IOException {
        return null;
    }

    @Override
    public String mkdirFileHdfs(String fileName, String dirName) {
        return null;
    }

    @Override
    public String putFileToHDFS(InputStream fis, String fileName) throws IOException {
        return null;
    }

    @Override
    public String getFileFromHDFS(OutputStream fos, String fileName) throws IOException {
        return null;
    }
}
