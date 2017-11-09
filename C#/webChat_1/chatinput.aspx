<%@ Page Language="C#" AutoEventWireup="true" CodeFile="chatinput.aspx.cs" Inherits="chatinput" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>无标题页</title>
</head>
<body style="overflow:hidden; background-image:url('images/83025aafa40f4bfb1fb5a61d024f78f0f7361815.jpg')">
    <form id="form1" runat="server">
    <div id="DIV1">
    发言:<asp:TextBox ID="TxtChat" runat="server" Width="436px"></asp:TextBox>
        <asp:Button ID="Button1" runat="server" Text="发送" OnClick="Button1_Click" /><br/>    
        <asp:ImageButton ID="ImageButton2" runat="server" ImageUrl="~/images/0019b91ec932102c33823d.png" OnClick="ImageButton2_Click" />
        <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl="~/images/155934nyoqmnkplgfoppzd.jpg.middle.png" OnClick="ImageButton1_Click" />
    <div id="Div2"  style="position:absolute;left:50%;top:1%;">
     <img id="Icon" alt=" " src="images/faces/space.png" />
    </div>
    <div id="p1"  style="position:absolute;right:0%;top:1%;height:auto;background-color:#EE82EE;">
        <asp:Panel ID="Panel1" runat="server" Visible="false">
         <asp:table id="tabFaces" runat="server" BorderColor="Desktop" BorderWidth="1px"
		BorderStyle="Dotted" BackColor="#C7E4FF" GridLines="Both" CellSpacing="0" CellPadding="0">
		</asp:table>
		    <asp:TextBox id="txtFaceUrl" runat="server" Width="1px"></asp:TextBox>
　　    </asp:Panel>
    </div>
    <div id="Div3"  style="position:absolute;right:0%;top:1%;height:auto;background-color:#EE82EE;">
        <asp:Panel ID="Panel2" runat="server" Visible="false">
            <asp:RadioButtonList ID="RadioButtonList1" runat="server" RepeatColumns="5" RepeatDirection="Horizontal">
                <asp:ListItem Value="#ff0000" Selected="True">红</asp:ListItem>
                <asp:ListItem Value="#00ff00">绿</asp:ListItem>
                <asp:ListItem Value="#0000ff">蓝</asp:ListItem>
                <asp:ListItem Value="#F28500">橘色</asp:ListItem>
                <asp:ListItem Value="#8CE600">苹果绿</asp:ListItem>
                <asp:ListItem Value="#4DE680">绿松石绿</asp:ListItem>
                <asp:ListItem Value="#007FFF">湛蓝</asp:ListItem>
                <asp:ListItem Value="#DDA0DD">梅红色</asp:ListItem>
                <asp:ListItem Value="#FF80BF">浅珊瑚红</asp:ListItem>
                <asp:ListItem Value="#8B00FF">紫罗兰色</asp:ListItem>
                <asp:ListItem Value="#5000B8">缬草紫</asp:ListItem>
                <asp:ListItem Value="#000080">藏青</asp:ListItem>
            </asp:RadioButtonList>
　　    </asp:Panel>
    </div>
        <a href="exit.aspx" target="_top" runat="server"><asp:Image ID="Image1" runat="server" Height="49px" ImageUrl="~/images/iconpng.png"
            Width="49px" /></a>
        </div>
    </form>
</body>
</html>
