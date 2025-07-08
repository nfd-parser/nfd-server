# API配额管理接口文档

## 基础信息

- 模块：API配额管理
- 基础路径：`/panmanager/apiQuota`
- 认证方式：需登录并携带Token
- 权限标识：`panmanager:api-quota:*`

---

## 1. 新增API配额

- **接口地址**：`POST /panmanager/apiQuota/create`
- **权限**：`panmanager:api-quota:create`
- **请求体**（JSON）：

| 字段名       | 类型    | 必填 | 说明                 |
|--------------|---------|------|----------------------|
| target       | string  | 是   | IP地址或域名         |
| isIp         | boolean | 是   | 是否是IP(1-IP,0-域名) |
| totalQuota   | int     | 是   | 总可用次数           |
| remaining    | int     | 是   | 剩余可用次数         |

- **响应体**：

```json
{
  "code": 0,
  "msg": "成功",
  "data": 1
}
```

---

## 2. 修改API配额

- **接口地址**：`PUT /panmanager/apiQuota/update`
- **权限**：`panmanager:api-quota:update`
- **请求体**：同"新增API配额"
- **响应体**：

```json
{
  "code": 0,
  "msg": "成功",
  "data": true
}
```

---

## 3. 删除API配额

- **接口地址**：`DELETE /panmanager/apiQuota/delete?id=xxx`
- **权限**：`panmanager:api-quota:delete`
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

## 4. 查询单条API配额

- **接口地址**：`GET /panmanager/apiQuota/get?id=xxx`
- **权限**：`panmanager:api-quota:query`
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
    "totalQuota": 100,
    "remaining": 80,
    "lastUpdate": "2024-06-01T12:00:00"
  }
}
```

---

## 5. 分页查询API配额

- **接口地址**：`POST /panmanager/apiQuota/page`
- **权限**：`panmanager:api-quota:query`
- **请求体**（JSON）：

| 字段名     | 类型    | 必填 | 说明                 |
|------------|---------|------|----------------------|
| pageNo     | int     | 是   | 页码                 |
| pageSize   | int     | 是   | 每页条数             |
| target     | string  | 否   | IP地址或域名         |
| isIp       | boolean | 否   | 是否是IP(1-IP,0-域名) |

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
        "totalQuota": 100,
        "remaining": 80,
        "lastUpdate": "2024-06-01T12:00:00"
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