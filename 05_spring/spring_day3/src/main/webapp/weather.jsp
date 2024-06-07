<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Insert title here</title>
<meta
	content='width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no'
	name='viewport'>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
lat = '';
lon = '';
if (navigator.geolocation) {
	  navigator.geolocation.getCurrentPosition(showPosition);
	} else {
	  console.log("Geolocation is not supported by this browser.");
	}

	function showPosition(position) {
	  console.log("Latitude: " + position.coords.latitude);
	  lat = position.coords.latitude;
	  console.log("Longitude: " + position.coords.longitude);
	  lon =position.coords.longitude;
	}

	$(function() {
		$('#b1').click(function() {
			$.ajax({
				url:'https://api.openweathermap.org/data/2.8/onecall?lat='+ lat +'&lon='+lon+'&exclude=hourly,daily,minutely&appid=c15f30119c342cc9f58cbb64e6267519',
				dataType : 'json',
				success: function(x){
					console.log(x);
					$('#result').html("현재 위도 경도 "+x.lat+ " , " + x.lon+"<br>"+
							"날씨"+x.current.weather[0].description+"<br>"+
							"풍속"+x.current.wind_speed+"<br>"+
							"기온"+x.current.temp+"<br>"+
							"체감 온도"+x.current.feels_like+"<br>"+
							"구름"+x.current.clouds+"<br>")
					let img = "<img src = 'resources/img/cool.jpg'>";		
							if(x.current.temp > 200){
								img = "<img src = 'resources/img/good.jpg'>";
							}else if(x.current.temp > 300){
								img = "<img src = 'resources/img/hot.jpg'>";
							}
					$('#result').append(img)
					
					$.ajax({
						url:"insert5",
						method : "POST",
						data: {
							lat : x.lat,
							lon : x.lon,
							weather : x.current.weather[0].description,
							wind : x.current.wind_speed,
							feels : x.current.feels_like,
							cloud : x.current.clouds
						},
						success: function(response) {
							alert('ajax호출 성공' + response)
							
						}
					})
				
				}
				
				
			})
		})
	})
	
	

					
</script>
</head>
<body>
	<button id="b1">날씨 알아오기!</button>
	<hr>
	<div id="result"></div>

</body>
</html>
