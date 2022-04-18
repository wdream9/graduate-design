package grad.design.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 王远辉
 */
@Data
@Component
public class FileInfo {
    /**
     * 文件根路径
     */
    private String fileRootPath;
    /**
     * 文件名称 包含拓展名
     */
    private String originName;
    /**
     * 文件名称 不包含文件拓展名
     */
    private String fileName;
    /**
     * 文件类型，是目录还是文件
     */
    private String fileType;
    /**
     * 子目录
     */
    private FileInfo[] children;
}
