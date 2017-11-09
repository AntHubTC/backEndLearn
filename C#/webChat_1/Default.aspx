<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" enableEventValidation="false" viewStateEncryptionMode ="Never" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <title>聊天室</title>
<script language="javascript" type="text/javascript" src="js/changSize.js"></script>
<script language="javascript" type="text/javascript">
    var str = "欢迎来到聊天室！";
    function titleShow()
	{	//每一次从前面取出一个元素放在了最后
			str=str.substring(1,str.length)+str.substring(0,1);
			document.title=str;
	}
	setInterval("titleShow()",200);
</script>
<link rel="icon" href="images/title.ico" type="image/x-icon"/>
</head>
<body style="background-image:url('images/bg1.jpg');background-repeat:no-repeat;color:#00c957;">
    <form id="form2" runat="server">
    <div style="width:400px;height:250px;background-color:#7a9b26;position:absolute;top:40%;left:50%;margin:-100px 0px 0px -200px;">
        <table>
            <tr>
                <td colspan="2" style="text-align:center;">
                    <h2 id="chatRoom">聊天室</h2></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center;">
    <asp:Label ID="Label1" runat="server"></asp:Label></td>
            </tr>
            <tr>
                <td style="width: 100px">
                    用户名：</td>
                <td style="width: 305px">
                    <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox><asp:RequiredFieldValidator
            ID="RequiredFieldValidator1" runat="server" ControlToValidate="TextBox1" ErrorMessage="不能为空！"></asp:RequiredFieldValidator></td>
            </tr>
            <tr>
                <td style="width: 100px">
        密码：</td>
                <td style="width: 305px">
                    <asp:TextBox ID="TextBox2" runat="server" TextMode="Password"></asp:TextBox><asp:RequiredFieldValidator
            ID="RequiredFieldValidator2" runat="server" ControlToValidate="TextBox2" ErrorMessage="不能为空！"></asp:RequiredFieldValidator></td>
            </tr>
            <tr>
                <td style="width: 100px; height: 18px">
                    权限：</td>
                <td style="width: 305px; height: 18px">
                    <asp:RadioButtonList ID="RadioButtonList1" runat="server" RepeatDirection="Horizontal">
                        <asp:ListItem Selected="True" Value="user">一般用户</asp:ListItem>
                        <asp:ListItem Value="admin">管理员</asp:ListItem>
                    </asp:RadioButtonList></td>
            </tr>
            <tr>
                <td style="width: 100px; height: 18px">
                </td>
                <td style="width: 305px; height: 18px">
        <asp:Button ID="Button1" runat="server" Text="登录" OnClick="Button1_Click" />
        <asp:Button ID="Button2" runat="server" Text="注册" CausesValidation="False" OnClick="Button2_Click" /></td>
            </tr>
        </table>
    </div>

    </form>
</body>
</html>
