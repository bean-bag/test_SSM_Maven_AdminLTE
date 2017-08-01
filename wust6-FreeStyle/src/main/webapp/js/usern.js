$(document).ready(
			function() {
				//debugger;
						$.get("/fang/mvc/name.do", function(data,status) {
						//	alert(typeof(data));
							data=JSON.parse(data);
							$(".hidden-xs:first").html(data.username);
							$(".pull-left.info p").html(data.username);						
						})
			});