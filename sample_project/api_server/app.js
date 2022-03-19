const express = require("express");
const app = express();

// 导入并配置 cors 中间件
const cors = require("cors");
app.use(cors());

app.use(express.urlencoded({ extended: false }));

// 一定要在路由之前封装 res.cc 函数
app.use((req, res, next) => {
  // status 默认值为 1，表示失败的情况
  // err 的值，可能是一个错误对象，也可能是一个错误的描述字符串
  res.cc = function (err, status = 1) {
    res.send({
      status,
      message: err instanceof Error ? err.message : err,
    });
  };
  next();
});

// 一定要在路由之前配置解析 Token 的中间件
const expressJWT = require("express-jwt");
const config = require("./config");

app.use(
  expressJWT({ secret: config.jwtSecretKey }).unless({ path: [/^\/api\//] })
);

// 定义错误级别的中间件
app.use((err, req, res, next) => {
  // 身份认证失败后的错误
  if (err.name === "UnauthorizedError") return res.cc("身份认证失败！");
  // 未知的错误
  res.cc(errs);
});

// 导入并注册用户路由模块
const userRouter = require("./router/user");
app.use("/api", userRouter);
// 导入并注册用户信息路由模块
const userinfoRouter = require("./router/userinfo");
app.use("/my", userinfoRouter);

app.listen(3007, () => {
  console.log("api server running at http://127.0.0.1:3007");
});
