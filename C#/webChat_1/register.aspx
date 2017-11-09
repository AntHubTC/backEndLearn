<%@ Page Language="C#" AutoEventWireup="true" CodeFile="register.aspx.cs" Inherits="register" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>无标题页</title>
    <script language="javascript" type="text/javascript">
    function init()
    {
        var i = 0;
        while(i++<33)
        {
            document.write("<br/>");
        }
    }
    init();
    </script>
</head>
<body style="filter:progid:DXImageTransform.Microsoft.Gradient (gradientType=0,startColorStr=#ffffff,endColorStr=#da43f1);">
    <div style="width:600px;background-color:#ffffff;position:absolute;top:20%;left:50%;margin:-100px 0px 0px -300px;">
       <center>
        <form id="form1" runat="server">
        <table style="height:100%;">
            <tr>
                <td colspan="2" style="text-align:center; height: 42px;">
                    <h1>用户注册</h1></td>
            </tr>
            <tr>
                <td style="width:92px;" align="right">
        <asp:Label ID="Label1" runat="server" Text="用户名"></asp:Label>:</td>
                <td style="width: 339px;text-align:left;">
                    <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>&nbsp;
        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="TextBox1"
            ErrorMessage="*"></asp:RequiredFieldValidator></td>
            </tr>
            <tr>
                <td style="width: 92px" align="right">
        <asp:Label ID="Label2" runat="server" Text="密码"></asp:Label>:</td>
                <td style="width: 339px;text-align:left;">
                    <asp:TextBox ID="TextBox2" runat="server" TextMode="Password"></asp:TextBox>
        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="TextBox2"
            ErrorMessage="*"></asp:RequiredFieldValidator></td>
            </tr>
            <tr>
                <td style="width: 92px; height: 28px;" align="right">
        <asp:Label ID="Label3" runat="server" Text="确认密码"></asp:Label>:</td>
                <td style="width: 339px;text-align:left; height: 28px;">
                    <asp:TextBox ID="TextBox3" runat="server" TextMode="Password"></asp:TextBox>
        <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ControlToValidate="TextBox3"
            ErrorMessage="*"></asp:RequiredFieldValidator>
        <asp:CompareValidator ID="CompareValidator2" runat="server" ControlToCompare="TextBox3"
            ControlToValidate="TextBox2" ErrorMessage="密码不匹配！"></asp:CompareValidator>
                </td>
            </tr>
            <tr>
                <td align="right" style="width: 92px; height: 28px">
                    <asp:Label ID="Label8" runat="server" Text="权限:"></asp:Label></td>
                <td style="width: 339px; height: 28px; text-align: left">
                    <asp:RadioButtonList ID="RadioButtonList2" runat="server" RepeatDirection="Horizontal">
                        <asp:ListItem Selected="True" Value="user">一般用户</asp:ListItem>
                        <asp:ListItem Value="admin">管理员</asp:ListItem>
                    </asp:RadioButtonList></td>
            </tr>
            <tr>
                <td style="width: 92px" align="right">
                    <asp:Label ID="Label5" runat="server" Text="出生日期:"></asp:Label></td>
                <td style="width: 339px; text-align: left">
                    <asp:TextBox ID="TextBox4" runat="server"></asp:TextBox></td>
            </tr>
            <tr>
                <td style="width: 92px; height: 20px" align="right">
                    <asp:Label ID="Label6" runat="server" Text="性别:"></asp:Label></td>
                <td style="width: 339px; height: 20px; text-align: left">
                    <asp:RadioButtonList ID="RadioButtonList1" runat="server" RepeatDirection="Horizontal">
                        <asp:ListItem Selected="True">男</asp:ListItem>
                        <asp:ListItem>女</asp:ListItem>
                    </asp:RadioButtonList></td>
            </tr>
            <tr>
                <td style="width: 92px; height: 20px" align="right">
                    <asp:Label ID="Label7" runat="server" Text="邮箱:"></asp:Label></td>
                <td style="width: 339px; height: 20px; text-align: left">
                    <asp:TextBox ID="TextBox5" runat="server"></asp:TextBox>
                    <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" ControlToValidate="TextBox5"
                        ErrorMessage="格式错误！" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></asp:RegularExpressionValidator></td>
            </tr>
            <tr valign="top">
                <td style="width: 92px; height: 294px;" align="right">
        <asp:Label ID="Label4" runat="server" Text="选择头像"></asp:Label><br />
                    <img alt=" " id="Icon" src="images/1.bmp" /></td>
                <td style="width: 339px; height: 294px">
                    <asp:table id="tabFaces" runat="server" BorderColor="Desktop" BorderWidth="1px"
		BorderStyle="Dotted" BackColor="#C7E4FF" GridLines="Both" CellSpacing="0" CellPadding="0"></asp:table>
                    &nbsp;&nbsp;
		<asp:textbox id="txtFaceUrl" runat="server" Width="0px" ></asp:textbox><!--不能用visible隐藏-->
		</td>
            </tr>
            <tr>
                <td style="width: 92px; height: 15px;" align="right">
                    验证码：</td>
                <td style="width: 339px; height: 15px;" align="left">
                    <asp:TextBox ID="checkCodeBox" runat="server"></asp:TextBox>&nbsp;
                    <img alt=" " id="checkImg" src="checkCode.aspx"  runat="server"/>
                    <asp:LinkButton ID="LinkButton1" runat="server" OnClick="LinkButton1_Click" CausesValidation="False">换一张</asp:LinkButton>&nbsp;
                </td>
            </tr>
            <tr>
                <td style="width: 92px">
        </td>
                <td style="width: 339px" align="left">
                    &nbsp;<asp:Button ID="Button1" runat="server" Text="提交" OnClick="Button1_Click" />
                    &nbsp; &nbsp; &nbsp; &nbsp;
        <asp:Button ID="Button2" runat="server" Text="重置" OnClick="Button2_Click" /></td>
            </tr>
        </table>
		</form>
		</center>
    </div>
</body>
</html>
