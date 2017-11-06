/**
 * 退出功能
 */
function quit(){
					var userId = delCookie("userId");
					if(userId==null) {
						window.location.href="login.html";
			}	
}
function out(){
		window.location.href="index.html";
}