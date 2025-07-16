package cn.qaiu.yyzy.server.controller;

import cn.qaiu.parser.ParserCreate;
import cn.qaiu.yyzy.framework.common.pojo.CommonResult;
import cn.qaiu.yyzy.framework.common.util.servlet.ServletUtils;
import io.vertx.core.Future;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;

import static cn.qaiu.yyzy.framework.common.exception.enums.GlobalErrorCodeConstants.NOT_IMPLEMENTED;

/**
 * 默认 Controller，解决部分 module 未开启时的 404 提示。
 * 例如说，/bpm/** 路径，工作流
 *
 * @author 芋道源码
 */
@RestController
@Slf4j
public class ParserController {

    @GetMapping("/")
    public static void main(String[] args) {
        ParserCreate parserCreate = ParserCreate.fromShareUrl("https://wwht.lanzouw.com/i3yKg30d5m1a").setShareLinkInfoPwd("2vbz");
        Future<String> parse = parserCreate.createTool().parse();
        parse.onComplete(ar -> {
            if (ar.succeeded()) {
                System.out.println(ar.result());
                log.info("成功");
            } else {
                log.error("失败");
            }
        });

    }

}
