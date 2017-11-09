var X=2;
var Y=2;
var availX=window.screen.availWidth;
var availY=window.screen.availHeight;
var dX=1;
var dY=1;
var lockX = false;
var lockY = false;
var intervalId = window.setInterval("changeSize()",50);
function changeSize()
{
	dX = (availX-dX)/50;
	dY = (availY-dY)/50;
	if(X<availX)
	{
		X+=dX;
	}
	else	lockX= true;
	 if(Y<availY)
	 {
		 Y+=dY;
	 }
	 else	lockY= true;
	if(lockX && lockY)
	{
		clearInterval(intervalId);
	}
		self.resizeTo(X,Y);
}