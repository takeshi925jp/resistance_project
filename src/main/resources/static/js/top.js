function hideForm(){
document.getElementById("formblock").style.display = "none";
}

function showForm() {
document.getElementById("formblock").style.display = "block";
}

function disp() {
	// 入力ダイアログを表示 ＋ 入力内容を user に代入
	val user = window.prompt("プレイヤー名を入力してください", "");
	document.getElementById('player_name').innerHTML = user;

}


window.onload = function(){
hideForm();
};


