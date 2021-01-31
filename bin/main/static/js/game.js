
function hideForm(){
document.getElementById("formblock").style.display = "none";
}

function showForm() {
document.getElementById("formblock").style.display = "block";
}


//開始オンオフのセッション情報を取得して、オン状態ならタイマー起動する
//開始ボタンを押したときは開始セッションをオン状態にするだけでよい
function gameStart() {

	// 開始フラグオン
	sessionStorage.setItem('startFlg', 1);
	sessionStorage.setItem('playTime', document.getElementById('playTime').value);

	countDown();
}

function countDown() {

	// スタート押下後
	if (sessionStorage.getItem('startFlg') == '1') {

		// 役職情報等を開示
		showForm();

	    var count = sessionStorage.getItem('playTime');

		document.getElementById('count').innerHTML = count;

		parseInt(count, 10);

		var countdown = function() {
			count--;
			document.getElementById('count').innerHTML = count;

			// セッションにタイマーデータを保存
			sessionStorage.setItem('playTime', count);
		}

		setInterval(countdown, 1000);
	}

}

window.onload = function() {
	hideForm();
	setInterval(countDown(), 3000);
};