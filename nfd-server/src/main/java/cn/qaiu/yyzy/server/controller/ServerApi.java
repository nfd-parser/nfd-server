package cn.qaiu.yyzy.server.controller;

import cn.qaiu.parser.ParserCreate;
import cn.qaiu.yyzy.module.panmanager.controller.admin.cachelinkinfo.vo.CacheLinkInfoRespVO;
import cn.qaiu.yyzy.server.util.URLParamUtil;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 服务API
 * <br>Create date 2021/4/28 9:15
 *
 * @author <a href="https://qaiu.top">QAIU</a>
 */
@Slf4j
@RestController
public class ServerApi {

//    @Autowired
//    private CacheService cacheService;

    @GetMapping("/parser")
    public void parse( HttpServletRequest request, HttpServletResponse response, @RequestParam String pwd) {

        // 分享链接
        String sUrl = URLParamUtil.parserParams(request);

        ParserCreate parserCreate = ParserCreate.fromShareUrl(sUrl).setShareLinkInfoPwd(pwd);
        Future<String> parse = parserCreate.createTool().parse();
        String downloadUrl = parse.toCompletionStage().toCompletableFuture().join();
        try {
            response.sendRedirect(downloadUrl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        cacheService.getCachedByShareUrlAndPwd(url, pwd, JsonObject.of("UA", request.getHeader("User-Agent")))
//                .onSuccess(res -> {
//                    HttpHeaders headers = new HttpHeaders();
//                    headers.add("nfd-cache-hit", res.getCacheHit().toString());
//                    headers.add("nfd-cache-expires", res.getExpires());
//                    headers.add("Location", res.getDirectLink());
//                    deferredResult.setResult(
//                            ResponseEntity.status(302).headers(headers).build()
//                    );
//                })
//                .onFailure(t -> {
//                    log.error("Redirect failed", t);
//                    deferredResult.setErrorResult(t);
//                });
//        return deferredResult;
    }

    @GetMapping("/json/parser")
    public DeferredResult<CacheLinkInfoRespVO> parseJson(
            HttpServletRequest request,
            @RequestParam String pwd) {

        DeferredResult<CacheLinkInfoRespVO> deferredResult = new DeferredResult<>();
        String url = URLParamUtil.parserParams(request);

//        cacheService.getCachedByShareUrlAndPwd(url, pwd, JsonObject.of("UA", request.getHeader("User-Agent")))
//                .onSuccess(deferredResult::setResult)
//                .onFailure(deferredResult::setErrorResult);
        return deferredResult;
    }

    @GetMapping("/json/{type}/{key}")
    public DeferredResult<CacheLinkInfoRespVO> parseKeyJson(
            HttpServletRequest request,
            @PathVariable String type,
            @PathVariable String key) {

        DeferredResult<CacheLinkInfoRespVO> deferredResult = new DeferredResult<>();
        String pwd = "";
        String actualKey = key;
        if (key.contains("@")) {
            String[] keys = key.split("@");
            actualKey = keys[0];
            pwd = keys[1];
        }

//        cacheService.getCachedByShareKeyAndPwd(type, actualKey, pwd,
//                        JsonObject.of("UA", request.getHeader("User-Agent")))
//                .onSuccess(deferredResult::setResult)
//                .onFailure(deferredResult::setErrorResult);
        return deferredResult;
    }

    @GetMapping("/{type}/{key}")
    public void parseKey(
            HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable String type,
            @PathVariable String key) {

        String pwd = "";
        String actualKey = key;
        if (key.contains("@")) {
            String[] keys = key.split("@");
            actualKey = keys[0];
            pwd = keys[1];
        }

        ParserCreate parserCreate = ParserCreate.fromType(type).shareKey(actualKey).setShareLinkInfoPwd(pwd);
        Future<String> parse = parserCreate.createTool().parse();
        parse.onComplete(ar -> {
            if (ar.succeeded()) {
                System.out.println(ar.result());
                log.info("成功");
            } else {
                log.error("失败");
            }
        });

        // 转成同步
        String url = parse.toCompletionStage().toCompletableFuture().join();
        response.setStatus(302);
        response.setHeader("Location", url);

//        cacheService.getCachedByShareKeyAndPwd(type, actualKey, pwd,
//                        JsonObject.of("UA", request.getHeader("User-Agent")))
//                .onSuccess(res -> {
//                    HttpHeaders headers = new HttpHeaders();
//                    headers.add("nfd-cache-hit", res.getCacheHit().toString());
//                    headers.add("nfd-cache-expires", res.getExpires());
//                    headers.add("Location", res.getDirectLink());
//                    deferredResult.setResult(
//                            ResponseEntity.status(302).headers(headers).build()
//                    );
//                })
//                .onFailure(t -> {
//                    log.error("Redirect failed", t);
//                    deferredResult.setErrorResult(t);
//                });
//        return deferredResult;
    }
}