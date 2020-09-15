$(document).ready(function() {
	
	//로그인
	$("#loginBtn").click(function() {
		var userid = prompt("아이디입력", "ssafy");
		if(userid.length == 0) {
			alert("아이디 입력!!!");
			return;
		}
		var userpass = prompt("비밀번호입력", "ssafy");
		if(userpass.length == 0) {
			alert("비밀번호 입력!!!");
			return;
		}
		if(userid == "ssafy" && userpass == "ssafy") {
			alert("로그인 성공!!!");
			$("#profile_img").attr("src", "img/william.png");
			$("#header_nav_confirmoff").css("display", "none");
			$("#header_nav_confirmon").css("display", "block");
		} else {
			alert("아이디 또는 비밀번호 확인!!!");
		}
	});
	
	//로그아웃
	$("#logoutBtn").click(function() {
		$("#profile_img").attr("src", "img/profile.png");
		$("#header_nav_confirmoff").css("display", "block");
		$("#header_nav_confirmon").css("display", "none");
	});
	
	//왼쪽메뉴
	//전국매장
	var storeView = true;
	$("#store_display").click(function() {
		if(storeView) {
			$(".store_item_sub").slideDown(300);
			$("#store_display").text("전국매장접기");
			storeView = false;
		} else {
			$(".store_item_sub").slideUp(600);
			$("#store_display").text("전국매장펼치기");
			storeView = true;
		}
	});
	
	/*
	$(".store_display_on").click(function() {
		$(".store_item_sub").slideDown(300);
		$(this).css("display", "none");
		$(".store_display_off").css("display", "block");
	});
	
	$(".store_display_off").click(function() {
		$(".store_item_sub").slideUp(600);
		$(this).css("display", "none");
		$(".store_display_on").css("display", "block");
	});
	*/
	
	//지역매장
	$(".store_area").click(function() {
		$(this).siblings("div.store_item_sub").slideDown(300).parent().siblings("li").children("div.store_item_sub").slideUp(500);
	});
	
	//투표하기
	$("#voteBtn").click(function() {
		var sel_menu = $("input[name='vote_answer']:checked").val();
		alert(sel_menu + "를 선택했습니다.");
	});
	
	//인기메뉴이동
	setInterval(function() {
		$(".popular_menu_li").first().appendTo(".popular_menu_ul");
	}, 3000);
	
	//신메뉴이동
	/*
	var interval;
	
	function play() {
		interval = setInterval(function() {
			next();
		}, 3000);
	}
	
	function stop() {
		clearInterval(interval);
	}
	
	var images = $(".new_menu_ul");
	function next() {
		images.stop(false, true).animate({left : "0px"}, 400, function() {
			$(this).children(":first").insertAfter($(this).children(":last")); //last 뒤에 first 삽입.
			$(this).css("left", "0");
		});
	}
	
	images.children().hover(function() {
		stop();
	}, function() {
		play();
	});
	
	play();
	*/
	
	//투표만들기
	$("#voteMakeBtn").click(function() {
		window.open("pollmake.html", "poll", "width=420,height=300,top=300,left=400");
	});
	
	$("#addAnswerBtn").click(function() {
		var div = $('<div class="poll_answer_item">').append('<input type="text" name="answer">').append('<button type="button" class="minus_btn button">삭제</button>');
		$("#poll_answer_list").append(div);
	});
	
	$(document).on("click", ".minus_btn", function() {
		$(this).parent(".poll_answer_item").remove();
	});
	
	$("#pollMakeBtn").click(function() {
		if(!($("#question").val())) {
			alert("질문 내용 입력!!!");
			return;
		}
		
		var flag = true;
		$("input[name='answer']").each(function(i, element) {
			if(!($(this).val())) {
				alert("답변 항목 입력!!!");
				flag = false;
			}
		});
		
		if(flag) {
			alert("투표를 생성합니다.");
			self.close();
		}
	});

});