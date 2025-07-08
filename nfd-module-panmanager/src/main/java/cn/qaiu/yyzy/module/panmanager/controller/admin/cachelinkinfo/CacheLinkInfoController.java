package cn.qaiu.yyzy.module.panmanager.controller.admin.cachelinkinfo;

import cn.qaiu.yyzy.framework.common.pojo.CommonResult;
import cn.qaiu.yyzy.module.panmanager.controller.admin.cachelinkinfo.vo.CacheLinkInfoReqVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.cachelinkinfo.vo.CacheLinkInfoRespVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.cachelinkinfo.vo.CacheLinkInfoSaveReqVO;
import cn.qaiu.yyzy.module.panmanager.service.CacheLinkInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.qaiu.yyzy.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 直链缓存信息")
@RestController
@RequestMapping("/panmanager/cacheLinkInfo")
@Validated
public class CacheLinkInfoController {

    @Resource
    private CacheLinkInfoService cacheLinkInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建直链缓存信息")
    @PreAuthorize("@ss.hasPermission('panmanager:cache-link-info:create')")
    public CommonResult<Long> createCacheLinkInfo(@Valid @RequestBody CacheLinkInfoSaveReqVO createReqVO) {
        return success(cacheLinkInfoService.createCacheLinkInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新直链缓存信息")
    @PreAuthorize("@ss.hasPermission('panmanager:cache-link-info:update')")
    public CommonResult<Boolean> updateCacheLinkInfo(@Valid @RequestBody CacheLinkInfoSaveReqVO updateReqVO) {
        cacheLinkInfoService.updateCacheLinkInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除直链缓存信息")
    @Parameter(name = "shareKey", description = "分享key", required = true)
    @PreAuthorize("@ss.hasPermission('panmanager:cache-link-info:delete')")
    public CommonResult<Boolean> deleteCacheLinkInfo(@RequestParam("shareKey") String shareKey) {
        cacheLinkInfoService.deleteCacheLinkInfo(shareKey);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获取直链缓存信息")
    @Parameter(name = "shareKey", description = "分享key", required = true, example = "abcdefg")
    @PreAuthorize("@ss.hasPermission('panmanager:cache-link-info:query')")
    public CommonResult<CacheLinkInfoRespVO> getCacheLinkInfo(@RequestParam("shareKey") String shareKey) {
        CacheLinkInfoRespVO respVO = cacheLinkInfoService.getCacheLinkInfo(shareKey);
        return success(respVO);
    }

    @PostMapping("/page")
    @Operation(summary = "分页查询直链缓存信息")
    @PreAuthorize("@ss.hasPermission('panmanager:cache-link-info:query')")
    public CommonResult<IPage<CacheLinkInfoRespVO>> getCacheLinkInfoPage(@Valid @RequestBody CacheLinkInfoReqVO pageReqVO) {
        IPage<CacheLinkInfoRespVO> pageResult = cacheLinkInfoService.getCacheLinkInfoPage(pageReqVO);
        return success(pageResult);
    }
} 