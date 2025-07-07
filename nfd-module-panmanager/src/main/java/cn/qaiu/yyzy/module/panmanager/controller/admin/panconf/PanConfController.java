package cn.qaiu.yyzy.module.panmanager.controller.admin.panconf;

import cn.qaiu.yyzy.framework.common.pojo.CommonResult;
import cn.qaiu.yyzy.module.panmanager.controller.admin.panconf.vo.PanConfReqVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.panconf.vo.PanConfRespVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.panconf.vo.PanConfSaveReqVO;
import cn.qaiu.yyzy.module.panmanager.service.PanConfService;
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

@Tag(name = "管理后台 - 网盘配置")
@RestController
@RequestMapping("/panmanager/panConf")
@Validated
public class PanConfController {

    @Resource
    private PanConfService panConfService;

    @PostMapping("/create")
    @Operation(summary = "创建网盘配置")
    @PreAuthorize("@ss.hasPermission('panmanager:pan-conf:create')")
    public CommonResult<Long> createPanConf(@Valid @RequestBody PanConfSaveReqVO createReqVO) {
        return success(panConfService.createPanConf(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新网盘配置")
    @PreAuthorize("@ss.hasPermission('panmanager:pan-conf:update')")
    public CommonResult<Boolean> updatePanConf(@Valid @RequestBody PanConfSaveReqVO updateReqVO) {
        panConfService.updatePanConf(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除网盘配置")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('panmanager:pan-conf:delete')")
    public CommonResult<Boolean> deletePanConf(@RequestParam("id") Long id) {
        panConfService.deletePanConf(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得网盘配置")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('panmanager:pan-conf:query')")
    public CommonResult<PanConfRespVO> getPanConf(@RequestParam("id") Long id) {
        PanConfRespVO panConf = panConfService.getPanConf(id);
        return success(panConf);
    }

    @PostMapping("/page")
    @Operation(summary = "分页查询网盘配置")
    @PreAuthorize("@ss.hasPermission('panmanager:pan-conf:query')")
    public CommonResult<IPage<PanConfRespVO>> getPanConfPage(@Valid @RequestBody PanConfReqVO pageReqVO) {
        IPage<PanConfRespVO> pageResult = panConfService.getPanConfPage(pageReqVO);
        return success(pageResult);
    }

}
