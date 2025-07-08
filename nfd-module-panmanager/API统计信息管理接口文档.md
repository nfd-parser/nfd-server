# API统计信息管理接口文档

## 基础信息

- 模块：API统计信息管理
- 基础路径：`/panmanager/apiStatisticsInfo`
- 认证方式：需登录并携带Token
- 权限标识：`panmanager:api-statistics-info:*`

---

## 1. 新增API统计信息

- **接口地址**：`POST /panmanager/apiStatisticsInfo/create`
- **权限**：`panmanager:api-statistics-info:create`
- **请求体**（JSON）：

| 字段名           | 类型     | 必填 | 说明                   |
|------------------|----------|------|------------------------|
| panType          | string   | 否   | 网盘类型标识（如lz）   |
| shareKey         | string   | 是   | 分享key（主键）        |
| cacheHitTotal    | integer  | 否   | 缓存命中总次数         |
| apiParserTotal   | integer  | 否   | API解析调用总次数      |
| updateTs         | long     | 否   | 最后更新时间（时间戳） |

- **响应体**：

```json
{
  "code": 0,
  "msg": "成功",
  "data": null
}
```

---

## 2. 修改API统计信息

- **接口地址**：`PUT /panmanager/apiStatisticsInfo/update`
- **权限**：`panmanager:api-statistics-info:update`
- **请求体**：同"新增API统计信息"
- **响应体**：

```json
{
  "code": 0,
  "msg": "成功",
  "data": true
}
```

---

## 3. 删除API统计信息

- **接口地址**：`DELETE /panmanager/apiStatisticsInfo/delete?shareKey=xxx`
- **权限**：`panmanager:api-statistics-info:delete`
- **参数**：

| 参数名   | 类型   | 必填 | 说明         |
|----------|--------|------|--------------|
| shareKey | string | 是   | 分享key主键  |

- **响应体**：

```json
{
  "code": 0,
  "msg": "成功",
  "data": true
}
```

---

## 4. 查询单条API统计信息

- **接口地址**：`GET /panmanager/apiStatisticsInfo/get?shareKey=xxx`
- **权限**：`panmanager:api-statistics-info:query`
- **参数**：

| 参数名   | 类型   | 必填 | 说明         |
|----------|--------|------|--------------|
| shareKey | string | 是   | 分享key主键  |

- **响应体**：

```json
{
  "code": 0,
  "msg": "成功",
  "data": {
    "panType": "lz",
    "shareKey": "abcdefg",
    "cacheHitTotal": 10,
    "apiParserTotal": 20,
    "updateTs": 1710000000000
  }
}
```

---

## 5. 分页查询API统计信息

- **接口地址**：`POST /panmanager/apiStatisticsInfo/page`
- **权限**：`panmanager:api-statistics-info:query`
- **请求体**（JSON）：

| 字段名           | 类型     | 必填 | 说明                   |
|------------------|----------|------|------------------------|
| pageNo           | integer  | 是   | 页码                   |
| pageSize         | integer  | 是   | 每页条数               |
| panType          | string   | 否   | 网盘类型标识           |
| shareKey         | string   | 否   | 分享key                |
| cacheHitTotal    | integer  | 否   | 缓存命中总次数         |
| apiParserTotal   | integer  | 否   | API解析调用总次数      |
| updateTs         | long     | 否   | 最后更新时间           |

- **响应体**：

```json
{
  "code": 0,
  "msg": "成功",
  "data": {
    "records": [
      {
        "panType": "lz",
        "shareKey": "abcdefg",
        "cacheHitTotal": 10,
        "apiParserTotal": 20,
        "updateTs": 1710000000000
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

- shareKey为主键，新增/修改/删除/查询均需传递。
- 需携带有效Token，且有对应权限。
- 时间戳字段建议用前端Date转long。
- 分页接口参数需传pageNo、pageSize。

---

## 8. 示例curl

```bash
# 新增
curl -X POST http://localhost:8080/panmanager/apiStatisticsInfo/create \
  -H "Authorization: Bearer {token}" \
  -H "Content-Type: application/json" \
  -d '{"panType":"lz","shareKey":"abcdefg","cacheHitTotal":10,"apiParserTotal":20,"updateTs":1710000000000}'

# 查询
curl -X GET "http://localhost:8080/panmanager/apiStatisticsInfo/get?shareKey=abcdefg" \
  -H "Authorization: Bearer {token}"

# 分页
curl -X POST http://localhost:8080/panmanager/apiStatisticsInfo/page \
  -H "Authorization: Bearer {token}" \
  -H "Content-Type: application/json" \
  -d '{"pageNo":1,"pageSize":10,"panType":"lz"}'
```

---

如需补充接口文档、字段说明、权限配置、前端ts类型定义等，请随时告知！ 