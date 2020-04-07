- 默认显示10行数据

  ```bash
  [root@HongKong ~]# tail file.sh 
  Shell 传递参数
  Shell 数组
  Shell 运算符
  Shell echo命令
  Shell printf命令
  Shell test 命令
  Shell 流程控制
  Shell 函数
  Shell 输入/输出重定向
  Shell 文件包含
  ```

- -f 循环显示**[默认显示10行]**

  ```bash
  [root@HongKong ~]# tail -f file.sh
  Shell 传递参数
  Shell 传递参数
  Shell 传递参数
  Shell 传递参数
  Shell 传递参数
  Shell 教程
  Shell 教程
  Shell 教程
  Shell 教程
  Shell 教程
  ```

- -n 显示行数|*可以和-f参数结合*  **距离文件末尾处**

  ```bash
  tail -n 20 file.sh # 显示文件末尾20行
  ```

- -n 【+ 数字】|*可以和-f参数结合*  **距离文件开始处**

  ```bash
  tail -n +5 file.sh # 从第五行开始显示到文件末尾
  ```

  ​