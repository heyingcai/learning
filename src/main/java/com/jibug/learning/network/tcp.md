### 1.TCP三次握手流程
①第一次握手：Client端将标志位SYN置为1，随机产生一个seq值为x，并将数据包
发送给Server端，此时Client端的状态为SYN_SENT，等待Server确认
②第二次握手：Server端收到数据包后由表示为SYN=1知道Client端请求连接，
此时Server端将SYN和ACK都置为1，ack序号x+1，随机产生一个seq值为y，并将数据包
发送给Client端以确认连接请求，Server进入SYN_RCVD状态
③第三次握手：Client端收到确认后，检查ack序号是否为x+1，标志位ACK是否为1，
如果正确则将标志位ACK置为1，ack序号为y+1，并将数据包发送给Server端，Server端
检查标志位ACK是否为1，ack序号是否为y+1，如果正确，则连接建立成功，Client端和
Server端都进入ESTABLISHED状态，此时完成第三次握手，随后Client和Server之间
可以开始传输数据。

### 2.TCP四次挥手流程
①第一次挥手：Client发送一个标志位为FIN=1，seq=m的包，用来关闭Client到Server的
数据传送，Client进入FIN_WAIT_1状态
②第二次挥手：Server收到标志位FIN=1的包后，发送ACK=1，ack=m+1的包给Client，
Server进入CLOSE_WAIT状态
③第三次挥手：Server发送一个标志位FIN=1，seq=n，ack=m+1的包给Client，用来关闭
Server到Client的数据传送，Server进入LAST_ACK状态
④第四次挥手：Client收到FIN=1后，Client进入TIME_WAIT状态，接着发送一个ACK=1包给
Server，ack=n+1，此时Server进入Close状态