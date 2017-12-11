1、servlet的编写、注意doget，doPost的重写
2、在href 跳转servlet的时候要使用  ./  找到servlet的根目录 
3、页面的跳转要深刻理解
4、重定向直接定位到当前页面即可
5、action的跳转是跳转到servlet的名称
6、转发、重定向也是servlet的名称
EL Jstl版本
jstl通用标签
<c:set/>
<c:out/>
<c:remove/>
条件标签
<c:if></c:if>
<c:choce>
	<c:when></c:when>
	<c:when></c:when>
	<c:otherwise></c:otherwise>
</c:choce>

<c:foreach></c:foreach>
版本控制说明不是很规范，以后会注意从3.0开始注意

1.版本说明
$.ajax与JSON处理页面
1、在相应的jsp页面中编写$.ajax读取JSON数据
2、在相应的servletJSON数据格式的数据并发送给jsp页面（out.print(data)）

2.ajax交互版本说明：
1、使用$.ajax()技术{"data":"html"}
2、servlet中直接把html代码进行传递
3、而jsp只要直接显示就可以了

3、news03.01
showTopic.jsp版本
1、servlet把要处理的html代码转发给showTopic.jsp
2、ajax通过data：html直接接收显示
3、也就是说以后想要显示的页面可以直接EL，jstl技术编写好哪里需要可以发送到哪减少了复杂的html的拼接

4、news03.02
版本：.load
1、在jsp页面中直接使用.load请求页面（html）更加方便、简洁
