package com.next.dcmm.framework.compiler;


import java.io.InputStream;
import java.net.URL;
import java.util.Locale;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
@Component
public class TableTemplate implements InitializingBean
{
    public Template getTemplate() {
        return template;
    }

    private Template template;
    @Override
    public void afterPropertiesSet() throws Exception {
        URL u = ResourceUtils.getURL("classpath:template/table.ftl");
        InputStream is = u.openStream();
        String content = IOUtils.toString(is, "utf8");
        is.close();

        Configuration cfg = new Configuration(new Version(2, 3, 20));
        StringTemplateLoader dummyLoader = new StringTemplateLoader();
        dummyLoader.putTemplate("table", content);
        cfg.setTemplateLoader(dummyLoader);
        //cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        template = cfg.getTemplate("table");
    }
}
