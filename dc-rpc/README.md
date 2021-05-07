### 基于Netty实现的RPC框架
---

服务端：

+ MyRegisteryHandler 服务端处理器，注册
+ RpcRegistry 服务端启动程序，依赖Netty
---


客户端：

+ RpcClientProxy：RPC代理公共类
+ RpcConsumer： RPC调用Demo
+ RpcProxyHandler： RPC调用处理器
---


公共：
+ InvokerMessage： RPC约定远程调用DTO
---

业务代码：
+ BizApi 业务接口
+ BizApiImpl：业务接口实现
