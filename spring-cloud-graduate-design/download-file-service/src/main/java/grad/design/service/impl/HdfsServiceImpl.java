package grad.design.service.impl;

import grad.design.dto.DirInfo;
import grad.design.dto.FileInfo;
import grad.design.service.hdfs.HdfsService;
import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Service
public class HdfsServiceImpl implements HdfsService {
    @Value("${HDFS_URL}")
    private String hdfsUrl;

    /**
     * 下载文件
     * @param fos
     * @param fileName
     * @return
     * @throws IOException
     */
    @Override
    public String getFileFromHDFS(OutputStream fos, String fileName) throws IOException {
        // url: HDFS_URL/wyh/fileName
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
        FSDataInputStream fis = fs.open(new Path(hdfsUrl + "/netdisk/wyh/" + fileName));
        // 4 流对拷 org.apache.commons.io.IOUtils
        IOUtils.copy(fis, fos);
        // 5 关闭资源
        IOUtils.closeQuietly(fos);
        IOUtils.closeQuietly(fis);
//        fs.close();
        return "getFileFromHDFS";
    }

    /**
     * 获取文件的详细信息
     * @throws Exception
     */
    public void filesDetail() throws Exception {
        // 1 获取文件系统
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI(hdfsUrl), conf);
        // 2 获取文件详情
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/netdisk/wyh/"), true);
        while (listFiles.hasNext()) {
            LocatedFileStatus status = listFiles.next();
            // 输出详情
            DirInfo dirInfo = new DirInfo();
            dirInfo.setDirName(status.getPath().getName());
            dirInfo.setPermission(status.getPermission());
            dirInfo.setLen(status.getLen());
            dirInfo.setGroup(status.getGroup());
        }
    }

    /**
     * 判断是文件还是文件夹
     * f: 文件
     * d: 目录
     * @throws Exception
     */
    public ArrayList<FileInfo> isFileType(String path) throws Exception {
        // 1 获取文件配置信息
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI(hdfsUrl), configuration);
        // 2 判断是文件还是文件夹
        FileStatus[] listStatus = fs.listStatus(new Path(path));
        ArrayList<FileInfo> fileInfos = new ArrayList<>();
        for (FileStatus fileStatus : listStatus) {
            FileInfo fileInfo = new FileInfo();
            // 如果是文件
            if (fileStatus.isFile()) {
                fileInfo.setOriginName(fileStatus.getPath().getName());
                fileInfo.setFileType("f");
                fileInfos.add(fileInfo);
                System.out.println("f:" + fileStatus.getPath().getName());
            } else {
                fileInfo.setOriginName(fileStatus.getPath().getName());
                fileInfo.setFileType("d");
                fileInfos.add(fileInfo);
                System.out.println("d:" + fileStatus.getPath().getName());
            }
        }
        System.out.println("hdfs file or dir info =====>"+ fileInfos);
        // 3 关闭资源
        fs.close();
        return fileInfos;
    }

    /**
     * hdfs 创建目录
     * @param userName
     * @return
     * @throws IOException
     */
    @Override
    public String mkdirDirHdfs(String userName) throws IOException {
        return null;
    }

    /**
     * hdfs 创建文件
     * @param fileName
     * @param dirName
     * @return
     */
    @Override
    public String mkdirFileHdfs(String fileName, String dirName) {
        return null;
    }

    /**
     * hdfs 上传文件
     * @param fis
     * @param fileName
     * @return
     * @throws IOException
     */
    @Override
    public String putFileToHDFS(InputStream fis, String fileName) throws IOException {

        return "putFileToHDFS";
    }

}
