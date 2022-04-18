package grad.design.dto;

import lombok.Data;
import org.apache.hadoop.fs.permission.FsPermission;
import org.springframework.stereotype.Component;

@Data
@Component
public class DirInfo {
    private String dirName;
    private long len;
    private FsPermission permission;
    private String group;
}
