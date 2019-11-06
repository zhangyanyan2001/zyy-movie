<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>电影列表</title>
</head>
<link href="/resource/css/index3.css" rel="stylesheet">
<body>
	<form action="/selects" method="post">
		影片名称:<input type="text" name="name" value="${movieVo.name}">
		上映时间:<input type="date" name="startDate" value="${movieVo.startDate}">--
				<input type="date" name="endDate" value="${movieVo.endDate}"><br><br>
		导演:<input type="text" name="actor" value="${movieVo.actor}">
		影片价格:<input type="text" name="startPrice" value="${movieVo.startPrice}">--
				<input type="text" name="endPrice" value="${movieVo.endPrice}"><br><br>
		电影年代:<select name="year" id="year">
				<option value="">请选择</option>
				<option value="2010">2010</option>
				<option value="2019">2019</option>
				<option value="2018">2018</option>
				<option value="2017">2017</option>
			</select>
		电影时长<input type="text" name="startLongtime" value="${movieVo.startLongtime}">--
				<input type="text" name="endLongtime" value="${movieVo.endLongtime}">
				<button type="submit">查询</button><br><br>
	</form>
	<table>
		<tr>
			<td><input type="checkbox" onclick="chkAll(1)">全选 <input
				type="checkbox" onclick="chkAll(-1)">反选</td>
			<td>名称</td>
			<td>导演</td>
			<td>票价</td>
			<td><a href="javascript:query('uptime')"></a>上映时间</td>
			<td><a href="javascript:query('longtime')"></a>时间长度</td>
			<td>类型</td>
			<td><a href="javascript:query('year')"></a>年代</td>
			<td>区域</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${movies}" var="m">
			<tr>
				<td><input type="checkbox" value="${m.id}" class="ck"></td>
				<td>${m.name}</td>
				<td>${m.actor}</td>
				<td>${m.price}</td>
				<td><fmt:formatDate value="${m.uptime}" pattern="yyyy-MM-dd"/></td>
				<td>${m.longtime}</td>
				<td>${m.type}</td>
				<td>${m.year}</td>
				<td>${m.area}</td>
				<td>${m.status}</td>
				<td></td>
			</tr>
		</c:forEach>
		<tr >
			<td colspan="11">${page}</td>
		</tr>
	</table>
	
</body>
<script type="text/javascript">
	/* var orderMethod='${movieVo.orderMethod=='asc'?'desc':'asc'}'
	
	function query(orderField){
		location.href="/selects?orderField="+orderField+"&orderMethod"+orderMethod
	}  */
	
	//全选/反选
	function chkAll(flag){
		if(flag==1){//全选
			$(".ck").prop("checked",true);
		}else{//反选
			$(".ck").each(function(){
				this.checked=!this.checked;
			})	
		}
		
		function del(){
			var ids = new Array();
			
			$(".ck:checked").each(function(i){
				ids[i]=$(this).val();
			})
			$.post("del",{ids:ids},function(flag){
				if(flag){
					alert("成功");
					location.raload();
				}else{
					alert("失败")
				}
			})
		}
	}
</script>
</html>