package grad.design.service.impl;

import grad.design.service.hdfs.HdfsService;
import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author 王远辉
 */
@Service
public class HdfsServiceImpl implements HdfsService {
    @Value("${HDFS_URL}")
    private String hdfsUrl;

    @Override
    public String mkdirDirHdfs(String dirName) throws IOException {
        //配置项
        Configuration configuration = new Configuration();
        //设置要连接的hdfs集群
        configuration.set("fs.defaultFS", hdfsUrl);
        //获得文件系统
        FileSystem fileSystem = FileSystem.get(configuration);
        // 获取用户名称
//        userService.findUserById()
        //调用方法创建目录；若目录已经存在，则创建失败，返回false
        boolean mkdirs = fileSystem.mkdirs(new Path("/netdisk/wyh/" + dirName));
        //释放资源
        fileSystem.close();
        return "HdfsService创建目录";
    }

    @Override
    public String mkdirFileHdfs(String fileName, String dirName) {

        return "";
    }

    /**
     * 文件上传
     *
     * @param fis
     * @param fileName
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    @Override
    public String putFileToHDFS(InputStream fis, String fileName) throws IOException {
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = null;
        try {
            fs = FileSystem.get(new URI(hdfsUrl), configuration);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        // 3 获取输出流 父目录不存在，会自动创建
        FSDataOutputStream fos = fs.create(new Path(hdfsUrl + "/netdisk/wyh/" + fileName));
        // 4 流对拷 org.apache.commons.io.IOUtils
        IOUtils.copy(fis, fos);
        // 5 关闭资源
        IOUtils.closeQuietly(fos);
        IOUtils.closeQuietly(fis);
        fs.close();
        return "putfileHdfs";
    }

    @Override
    public String getFileFromHDFS(OutputStream fos, String fileName) throws IOException {

        return "getFileFromHDFS";
    }
}
