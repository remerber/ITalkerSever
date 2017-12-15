package net.ww.web.italker.push;


import com.sun.media.jfxmedia.logging.Logger;
import net.ww.web.italker.push.provider.AuthRequestFilter;
import net.ww.web.italker.push.provider.GsonProvider;
import net.ww.web.italker.push.service.AccountService;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by HP on 2017/10/25.
 */
public class Application extends ResourceConfig{
    public Application(){
        // 注册逻辑处理的包名
        //packages("net.ww.web.italker.push.service");
        packages(AccountService.class.getPackage().getName());

        register(AuthRequestFilter.class);

        // 注册Json解析器
        // register(JacksonJsonProvider.class);
        // 替换解析器为Gson
        register(GsonProvider.class);

        // 注册日志打印输出
        register(Logger.class);

    }
}
