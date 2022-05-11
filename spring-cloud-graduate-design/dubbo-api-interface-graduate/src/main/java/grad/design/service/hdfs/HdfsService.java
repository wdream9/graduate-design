package grad.design.service.hdfs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface HdfsService {
    /**
     * 根据用户名创建文件夹
     * @param userName
     * @return
     */
    String mkdirDirHdfs(String userName) throws IOException;

    /**
     * 创建文件夹
     * @param fileName
     * @return
     */
    String mkdirFileHdfs(String fileName,String dirName);

    /**
     * 文件上传到 Hdfs
     * @param fis
     * @param fileName
     * @return
     */
    String putFileToHDFS(InputStream fis, String fileName, Integer userid) throws IOException;

    /**
     * 文件下载到客户端
     * @param fos
     * @param fileName
     * @return
     */
    String getFileFromHDFS(OutputStream fos, String fileName) throws IOException;
}
