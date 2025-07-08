package cn.qaiu.yyzy.module.panmanager.controller.admin.blacklist;

import cn.qaiu.yyzy.module.panmanager.service.BlacklistService;
import cn.qaiu.yyzy.module.panmanager.controller.admin.blacklist.vo.*;
import cn.qaiu.yyzy.framework.common.pojo.CommonResult;
import cn.qaiu.yyzy.framework.common.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/panmanager/blacklist")
@Validated
public class BlacklistController {
    @Autowired
    private BlacklistService service;

    @PostMapping("/create")
    public CommonResult<Integer> create(@RequestBody @Validated BlacklistSaveReqVO reqVO) {
        return CommonResult.success(service.create(reqVO));
    }

    @PutMapping("/update")
    public CommonResult<Boolean> update(@RequestBody @Validated BlacklistSaveReqVO reqVO) {
        return CommonResult.success(service.update(reqVO));
    }

    @DeleteMapping("/delete")
    public CommonResult<Boolean> delete(@RequestParam("id") Integer id) {
        return CommonResult.success(service.delete(id));
    }

    @GetMapping("/get")
    public CommonResult<BlacklistRespVO> get(@RequestParam("id") Integer id) {
        return CommonResult.success(service.get(id));
    }

    @PostMapping("/page")
    public CommonResult<PageResult<BlacklistRespVO>> page(@RequestBody BlacklistPageReqVO pageReqVO) {
        return CommonResult.success(service.page(pageReqVO));
    }
} 