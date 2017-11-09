<%@ Page Language="C#" AutoEventWireup="true" CodeFile="chat.aspx.cs" Inherits="chat" %>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <script language="javascript" type="text/javascript" src="js/changSize.js">
    </script>
    <title>无标题页</title>
</head>
<frameset rows="*,16%">
     <frameset cols="*,30%">
		   <frame name="cshow" src="chatshow.aspx" noresize="noresize"/>
		   <frame name="cshow" src="infoShow.aspx" noresize="noresize"/>
     </frameset>
	 <frame name="cinput" src="chatinput.aspx" noresize="noresize"/>
</frameset>
</html>
