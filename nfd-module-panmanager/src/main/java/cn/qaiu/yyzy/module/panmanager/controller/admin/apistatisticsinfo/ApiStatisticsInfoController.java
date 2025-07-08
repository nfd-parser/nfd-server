package cn.qaiu.yyzy.module.panmanager.controller.admin.apistatisticsinfo;

import cn.qaiu.yyzy.framework.common.pojo.CommonResult;
import cn.qaiu.yyzy.module.panmanager.controller.admin.apistatisticsinfo.vo.ApiStatisticsInfoReqVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.apistatisticsinfo.vo.ApiStatisticsInfoRespVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.apistatisticsinfo.vo.ApiStatisticsInfoSaveReqVO;
import cn.qaiu.yyzy.module.panmanager.service.ApiStatisticsInfoService;
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

@Tag(name = "管理后台 - API统计信息")
@RestController
@RequestMapping("/panmanager/apiStatisticsInfo")
@Validated
public class ApiStatisticsInfoController {

    @Resource
    private ApiStatisticsInfoService apiStatisticsInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建API统计信息")
    @PreAuthorize("@ss.hasPermission('panmanager:api-statistics-info:create')")
    public CommonResult<Long> createApiStatisticsInfo(@Valid @RequestBody ApiStatisticsInfoSaveReqVO createReqVO) {
        return success(apiStatisticsInfoService.createApiStatisticsInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新API统计信息")
    @PreAuthorize("@ss.hasPermission('panmanager:api-statistics-info:update')")
    public CommonResult<Boolean> updateApiStatisticsInfo(@Valid @RequestBody ApiStatisticsInfoSaveReqVO updateReqVO) {
        apiStatisticsInfoService.updateApiStatisticsInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除API统计信息")
    @Parameter(name = "shareKey", description = "分享key", required = true)
    @PreAuthorize("@ss.hasPermission('panmanager:api-statistics-info:delete')")
    public CommonResult<Boolean> deleteApiStatisticsInfo(@RequestParam("shareKey") String shareKey) {
        apiStatisticsInfoService.deleteApiStatisticsInfo(shareKey);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获取API统计信息")
    @Parameter(name = "shareKey", description = "分享key", required = true, example = "abcdefg")
    @PreAuthorize("@ss.hasPermission('panmanager:api-statistics-info:query')")
    public CommonResult<ApiStatisticsInfoRespVO> getApiStatisticsInfo(@RequestParam("shareKey") String shareKey) {
        ApiStatisticsInfoRespVO respVO = apiStatisticsInfoService.getApiStatisticsInfo(shareKey);
        return success(respVO);
    }

    @PostMapping("/page")
    @Operation(summary = "分页查询API统计信息")
    @PreAuthorize("@ss.hasPermission('panmanager:api-statistics-info:query')")
    public CommonResult<IPage<ApiStatisticsInfoRespVO>> getApiStatisticsInfoPage(@Valid @RequestBody ApiStatisticsInfoReqVO pageReqVO) {
        IPage<ApiStatisticsInfoRespVO> pageResult = apiStatisticsInfoService.getApiStatisticsInfoPage(pageReqVO);
        return success(pageResult);
    }
} 