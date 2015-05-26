使用的是spring4才有的boot，只要运行Application的main函数就可以启动了。
使用curl测试，可能看起来不好看，所有rest接口都是post形式的，方便点可以改成get在浏览器上测试。
有点不是特别明白题目按照自己理解的写了一些，为方便暴露的接口没有考虑安全性

测试1：
1.创建用户zhangsan
curl -d "name=zhangsan" http://localhost:8080/createCustomer
2.创建交易，通过第一步可以获得zhangsan的id为1.
curl -d "customerid=1&amount=86.5&currency=RMB&status=WAIT&type=PAY" http://localhost:8080/createTranscation

测试2：
1.初始化数据
curl -d "customerid=1&amount=12.3&currency=RMB&status=SUCCESS&type=PAY" http://localhost:8080/createTranscation
curl -d "customerid=1&amount=22.4&currency=RMB&status=SUCCESS&type=PAY" http://localhost:8080/createTranscation
curl -d "customerid=1&amount=28.1&currency=RMB&status=SUCCESS&type=PAY" http://localhost:8080/createTranscation
curl -d "customerid=1&amount=97.2&currency=RMB&status=FAILURE&type=PAY" http://localhost:8080/createTranscation
curl -d "customerid=1&amount=1000&currency=RMB&status=FAILURE&type=PAY" http://localhost:8080/createTranscation
2.查询数据
 1》查询所有
curl -d "" http://localhost:8080/searchTransaction
 2》查询成功的
curl -d "status=SUCCESS" http://localhost:8080/searchTransaction
 3》查询失败的
curl -d "status=FAILURE" http://localhost:8080/searchTransaction