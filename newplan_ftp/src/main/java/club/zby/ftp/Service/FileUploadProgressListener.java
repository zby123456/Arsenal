package club.zby.ftp.Service;

import club.zby.ftp.Entity.Progress;
import org.apache.commons.fileupload.ProgressListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 赵博雅
 * @Date: 2019/11/18 17:44
 */

public class FileUploadProgressListener implements ProgressListener {

    @Autowired
    private HttpSession session;


    public void setSession(HttpSession session) {
        this.session = session;
        System.out.println("初始化");
        session.setAttribute("upload_percent", 0);
    }

    @Override
    public void update(long pBytesRead, long pContentLength, int pItems) {
        int percent = (int) (pBytesRead * 100.0 / pContentLength);
        System.out.println("当前状态：" + percent + "%");
        session.setAttribute("upload_percent", percent);
    }

}


