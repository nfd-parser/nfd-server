# API黑名单管理接口文档

## 基础信息

- 模块：API黑名单管理
- 基础路径：`/panmanager/blacklist`
- 认证方式：需登录并携带Token
- 权限标识：`panmanager:blacklist:*`

---

## 1. 新增黑名单

- **接口地址**：`POST /panmanager/blacklist/create`
- **权限**：`panmanager:blacklist:create`
- **请求体**（JSON）：

| 字段名       | 类型    | 必填 | 说明                 |
|--------------|---------|------|----------------------|
| target       | string  | 是   | IP地址或域名         |
| isIp         | boolean | 是   | 是否是IP(1-IP,0-域名) |
| reason       | string  | 否   | 加入黑名单原因       |
| isActive     | boolean | 是   | 是否生效(1-是,0-否)  |
| blockCount   | int     | 是   | 拦截次数统计         |

- **响应体**：

```json
{
  "code": 0,
  "msg": "成功",
  "data": 1
}
```

---

## 2. 修改黑名单

- **接口地址**：`PUT /panmanager/blacklist/update`
- **权限**：`panmanager:blacklist:update`
- **请求体**：同"新增黑名单"
- **响应体**：

```json
{
  "code": 0,
  "msg": "成功",
  "data": true
}
```

---

## 3. 删除黑名单

- **接口地址**：`DELETE /panmanager/blacklist/delete?id=xxx`
- **权限**：`panmanager:blacklist:delete`
- **参数**：

| 参数名 | 类型   | 必填 | 说明     |
|--------|--------|------|----------|
| id     | int    | 是   | 记录ID   |

- **响应体**：

```json
{
  "code": 0,
  "msg": "成功",
  "data": true
}
```

---

## 4. 查询单条黑名单

- **接口地址**：`GET /panmanager/blacklist/get?id=xxx`
- **权限**：`panmanager:blacklist:query`
- **参数**：

| 参数名 | 类型   | 必填 | 说明     |
|--------|--------|------|----------|
| id     | int    | 是   | 记录ID   |

- **响应体**：

```json
{
  "code": 0,
  "msg": "成功",
  "data": {
    "id": 1,
    "target": "127.0.0.1",
    "isIp": true,
    "reason": "恶意请求",
    "isActive": true,
    "blockCount": 5,
    "lastUpdate": "2024-06-01 12:00:00"
  }
}
```

---

## 5. 分页查询黑名单

- **接口地址**：`POST /panmanager/blacklist/page`
- **权限**：`panmanager:blacklist:query`
- **请求体**（JSON）：

| 字段名     | 类型    | 必填 | 说明                 |
|------------|---------|------|----------------------|
| pageNo     | int     | 是   | 页码                 |
| pageSize   | int     | 是   | 每页条数             |
| target     | string  | 否   | IP地址或域名         |
| isIp       | boolean | 否   | 是否是IP(1-IP,0-域名) |
| isActive   | boolean | 否   | 是否生效(1-是,0-否)  |

- **响应体**：

```json
{
  "code": 0,
  "msg": "成功",
  "data": {
    "records": [
      {
        "id": 1,
        "target": "127.0.0.1",
        "isIp": true,
        "reason": "恶意请求",
        "isActive": true,
        "blockCount": 5,
        "lastUpdate": "2024-06-01 12:00:00"
      }
    ],
    "total": 1,
    "size": 10,
    "current": 1,
    "pages": 1
  }
}
```

---

## 6. 错误码说明

| code | 说明         |
|------|--------------|
| 0    | 成功         |
| 401  | 未认证/Token失效 |
| 403  | 无权限       |
| 500  | 服务器异常   |

---

## 7. 注意事项

- id为主键，新增/修改/删除/查询均需传递。
- 需携带有效Token，且有对应权限。
- 分页接口参数需传pageNo、pageSize。

---

如需补充接口文档、字段说明、权限配置、前端ts类型定义等，请随时告知！ 