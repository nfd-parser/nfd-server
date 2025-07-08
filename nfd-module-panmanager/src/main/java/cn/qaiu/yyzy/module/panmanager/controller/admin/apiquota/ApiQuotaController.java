package cn.qaiu.yyzy.module.panmanager.controller.admin.apiquota;

import cn.qaiu.yyzy.module.panmanager.service.ApiQuotaService;
import cn.qaiu.yyzy.module.panmanager.controller.admin.apiquota.vo.*;
import cn.qaiu.yyzy.framework.common.pojo.CommonResult;
import cn.qaiu.yyzy.framework.common.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/panmanager/apiQuota")
@Validated
public class ApiQuotaController {
    @Autowired
    private ApiQuotaService service;

    @PostMapping("/create")
    public CommonResult<Integer> create(@RequestBody @Validated ApiQuotaSaveReqVO reqVO) {
        return CommonResult.success(service.create(reqVO));
    }

    @PutMapping("/update")
    public CommonResult<Boolean> update(@RequestBody @Validated ApiQuotaSaveReqVO reqVO) {
        return CommonResult.success(service.update(reqVO));
    }

    @DeleteMapping("/delete")
    public CommonResult<Boolean> delete(@RequestParam("id") Integer id) {
        return CommonResult.success(service.delete(id));
    }

    @GetMapping("/get")
    public CommonResult<ApiQuotaRespVO> get(@RequestParam("id") Integer id) {
        return CommonResult.success(service.get(id));
    }

    @PostMapping("/page")
    public CommonResult<PageResult<ApiQuotaRespVO>> page(@RequestBody ApiQuotaPageReqVO pageReqVO) {
        return CommonResult.success(service.page(pageReqVO));
    }
} 