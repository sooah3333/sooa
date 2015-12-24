var i;
var link = new Array();
var title = new Array();
var description = new Array();
//var pubDate = new Array();



function Function() {

	var keyword = document.getElementById("search").value;
	
	var url = 'http://openapi.naver.com/search?key=7dd029811972c17a67730de51c157d7f&query='
			+ keyword + '&target=news&start=1&display=100';
	//var url = 'http://openapi.naver.com/search?key=7dd029811972c17a67730de51c157d7f&query=열무&target=news&start=1&display=100';
	$.ajax({
		url : document.location.protocol
			+ '//ajax.googleapis.com/ajax/services/feed/load?v=1.0&num=100&callback=?&q='
			+ encodeURIComponent(url),
			dataType : 'json',
			success : function(data) {
			if (data.responseData.feed && data.responseData.feed.entries) {
				$.each(data.responseData.feed.entries, function(i, e) {
					title[i] = e.title
					link[i] = e.link;
					description[i] = e.content;
					//pubDate[i] = e.publishedDate;
				});
				i=0;
				display(i);
			}
		}
	});
}

function display(i) {
	var html = "";
	if(i != 16){
		for (var k = (i * 6); k < (i * 6) + 6; k++) {
			//for(var k =0;k<100;k++){
			html += '<h3><a href="' + link[k] + '" target="_blank">' + title[k]
				+ '</a><h3><h5>' + description[k] + '<br><h5>';
		}
		document.getElementById('navernews').innerHTML = html;
	}else{
		for (var k = (i * 6); k < (i * 6) + 4; k++) {
			//for(var k =0;k<100;k++){
			html += '<h3><a href="' + link[k] + '" target="_blank">' + title[k]
				+ '</a><h3><h5>' + description[k] + '<br><h5>';
		}
	}
}

function next() {
	if (i < 16) {
		i++;
		display(i);
		console.log(i)
	}else if(i == 16){
		i = 0;
		display(i);
		console.log(i)
	}
}
function previous() {
	if (i > 0) {
		i--;
		display(i);
		console.log(i)
	}else if(i == 0){
		i = 16;
		display(i);
		console.log(i)
	}
}