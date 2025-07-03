package cn.qaiu.yyzy.module.infra.controller.admin.logger.vo.apierrorlog;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - API 错误日志 Response VO")
@Data

public class ApiErrorLogRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "链路追踪编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "66600cb6-7852-11eb-9439-0242ac130002")
    private String traceId;

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    private Long userId;

    @Schema(description = "用户类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer userType;

    @Schema(description = "应用名", requiredMode = Schema.RequiredMode.REQUIRED, example = "dashboard")
    private String applicationName;

    @Schema(description = "请求方法名", requiredMode = Schema.RequiredMode.REQUIRED, example = "GET")
    private String requestMethod;

    @Schema(description = "请求地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "/xx/yy")
    private String requestUrl;

    @Schema(description = "请求参数", requiredMode = Schema.RequiredMode.REQUIRED)
    private String requestParams;

    @Schema(description = "用户 IP", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    private String userIp;

    @Schema(description = "浏览器 UA", requiredMode = Schema.RequiredMode.REQUIRED, example = "Mozilla/5.0")
    private String userAgent;

    @Schema(description = "异常发生时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime exceptionTime;

    @Schema(description = "异常名", requiredMode = Schema.RequiredMode.REQUIRED)
    private String exceptionName;

    @Schema(description = "异常导致的消息", requiredMode = Schema.RequiredMode.REQUIRED)
    private String exceptionMessage;

    @Schema(description = "异常导致的根消息", requiredMode = Schema.RequiredMode.REQUIRED)
    private String exceptionRootCauseMessage;

    @Schema(description = "异常的栈轨迹", requiredMode = Schema.RequiredMode.REQUIRED)
    private String exceptionStackTrace;

    @Schema(description = "异常发生的类全名", requiredMode = Schema.RequiredMode.REQUIRED)
    private String exceptionClassName;

    @Schema(description = "异常发生的类文件", requiredMode = Schema.RequiredMode.REQUIRED)
    private String exceptionFileName;

    @Schema(description = "异常发生的方法名", requiredMode = Schema.RequiredMode.REQUIRED)
    private String exceptionMethodName;

    @Schema(description = "异常发生的方法所在行", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer exceptionLineNumber;

    @Schema(description = "处理状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer processStatus;

    @Schema(description = "处理时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime processTime;

    @Schema(description = "处理用户编号", example = "233")
    private Integer processUserId;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
