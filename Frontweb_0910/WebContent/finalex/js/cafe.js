//로그인
function login() {
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
		document.getElementById("profile_img").src = "img/william.png";
		document.getElementById("header_nav_confirmoff").style.display = "none";
		document.getElementById("header_nav_confirmon").style.display = "block";
	} else {
		alert("아이디 또는 비밀번호 확인!!!");
	}
}

//로그아웃
function logout() {
	/* document.getElementById("profile_img").src = "img/profile.png";
	document.getElementById("header_nav_confirmon").style.display = "none";
	document.getElementById("header_nav_confirmoff").style.display = "block"; */
	document.querySelector("#profile_img").setAttribute("src", "img/profile.png");
	document.querySelector("#header_nav_confirmon").setAttribute("style", "display: none");
	document.querySelector("#header_nav_confirmoff").setAttribute("style", "display: block");
}

//왼쪽 메뉴
var cnt = 0;
function slideDown(areaid) {
    if(areaid.style.display == 'none') {
    	areaid.style.display = 'block';
    	cnt++;
    } else if(areaid.style.display == 'block') { 
    	areaid.style.display = 'none';
    	cnt--;
    }

    if(cnt == 4) {
    	document.getElementsByClassName("store_display_off")[0].style.display = 'block';
    	document.getElementsByClassName("store_display_on")[0].style.display = 'none';
	} else {
		document.getElementsByClassName("store_display_off")[0].style.display = 'none';
    	document.getElementsByClassName("store_display_on")[0].style.display = 'block';
	}
}

function allSlide(onoff) {
    if(onoff == 'on') {
    	var subs = document.getElementsByClassName("store_item_sub")
    	for(var i=0;i<subs.length;i++) 
    		subs[i].style.display = 'block';
    	
    	document.getElementsByClassName("store_display_off")[0].style.display = 'block';
    	document.getElementsByClassName("store_display_on")[0].style.display = 'none';
    	cnt = 4;
    } else {
    	var subs = document.getElementsByClassName("store_item_sub")
    	for(var i=0;i<subs.length;i++) 
    		subs[i].style.display = 'none';
    	
    	document.getElementsByClassName("store_display_off")[0].style.display = 'none';
    	document.getElementsByClassName("store_display_on")[0].style.display = 'block';
    	cnt = 0;
    }
}

//투표하기
function poll() {
	var votes = document.getElementsByName("vote_answer");
	var sel_menu = "";
	
	for(var i=0;i<votes.length;i++) {
		if(votes[i].checked == true) {
			sel_menu = votes[i].value;
			break;
		}
	}
	alert(sel_menu + "를 선택했습니다.");
}

//투표만들기
function pollMake() {
	window.open("pollmake.html", "poll", "width=420,height=300,top=300,left=400");
}

function addAnswer() {
	var listDiv = document.getElementById("poll_answer_list");
	
	var divEl = document.createElement("div"); // <div></div>
	divEl.setAttribute("class", "poll_answer_item"); // <div class="poll_answer_item"></div>
	var inputEl = document.createElement("input");
	inputEl.setAttribute("type", "text");
	inputEl.setAttribute("name", "answer");
	var buttonEl = document.createElement("button");
	buttonEl.setAttribute("type", "button");
	buttonEl.setAttribute("class", "button");
	buttonEl.addEventListener("click", function(e) {
		var parent = this.parentNode;
		listDiv.removeChild(parent);
	});
	buttonEl.appendChild(document.createTextNode("삭제"));
	
	divEl.appendChild(inputEl);
	divEl.appendChild(buttonEl);
	listDiv.appendChild(divEl);
}
	
function makePoll() {
	if(!(document.querySelector("#question").value)) {
		alert("질문 내용 입력!!!");
		return;
	}
	
	var answers = document.getElementsByName("answer");
	for(var i=0;i<answers.length;i++) {
		if(!(answers[i].value)) {
			alert("답변 항목 입력!!!");
			return;
		}
	}
	
	alert("투표를 생성합니다.");
	self.close();
}
	
	