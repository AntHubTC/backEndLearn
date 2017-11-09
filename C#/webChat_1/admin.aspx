<%@ Page Language="C#" AutoEventWireup="true" CodeFile="admin.aspx.cs" Inherits="admin" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>无标题页</title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <br />
        <table>
            <tr>
                <td style="width: 100px; height: 18px">
                    <asp:ImageButton ID="ImageButton1" runat="server" Height="45px" ImageUrl="~/images/returnBack.png" OnClick="ImageButton1_Click" Width="46px" /></td>
                <td style="width: 100px; height: 18px">
                </td>
                <td style="width: 100px; height: 18px">
                </td>
            </tr>
        </table>
        <br />
        <asp:AccessDataSource ID="AccessDataSource1" runat="server" DataFile="~/App_Data/user.mdb"
            SelectCommand="SELECT * FROM [msgInfo]" DeleteCommand="DELETE FROM [msgInfo] WHERE [ID] = ?" InsertCommand="INSERT INTO [msgInfo] ([ID], [chatRoom], [msgFrom], [chatTime], [textColor], [ordinaryFace], [msgContent]) VALUES (?, ?, ?, ?, ?, ?, ?)" UpdateCommand="UPDATE [msgInfo] SET [chatRoom] = ?, [msgFrom] = ?, [chatTime] = ?, [textColor] = ?, [ordinaryFace] = ?, [msgContent] = ? WHERE [ID] = ?">
            <DeleteParameters>
                <asp:Parameter Name="ID" Type="Int32" />
            </DeleteParameters>
            <UpdateParameters>
                <asp:Parameter Name="chatRoom" Type="Int32" />
                <asp:Parameter Name="msgFrom" Type="String" />
                <asp:Parameter Name="chatTime" Type="DateTime" />
                <asp:Parameter Name="textColor" Type="String" />
                <asp:Parameter Name="ordinaryFace" Type="String" />
                <asp:Parameter Name="msgContent" Type="String" />
                <asp:Parameter Name="ID" Type="Int32" />
            </UpdateParameters>
            <InsertParameters>
                <asp:Parameter Name="ID" Type="Int32" />
                <asp:Parameter Name="chatRoom" Type="Int32" />
                <asp:Parameter Name="msgFrom" Type="String" />
                <asp:Parameter Name="chatTime" Type="DateTime" />
                <asp:Parameter Name="textColor" Type="String" />
                <asp:Parameter Name="ordinaryFace" Type="String" />
                <asp:Parameter Name="msgContent" Type="String" />
            </InsertParameters>
        </asp:AccessDataSource>
        
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="ID"
            DataSourceID="AccessDataSource1" BackColor="LightGoldenrodYellow" BorderColor="Tan" BorderWidth="1px" CellPadding="2" ForeColor="Black" GridLines="None">
            <Columns>
                <asp:BoundField DataField="ID" HeaderText="ID" InsertVisible="False" ReadOnly="True"
                    SortExpression="ID" />
                <asp:BoundField DataField="chatRoom" HeaderText="chatRoom" SortExpression="chatRoom" />
                <asp:BoundField DataField="msgFrom" HeaderText="msgFrom" SortExpression="msgFrom" />
                <asp:BoundField DataField="chatTime" HeaderText="chatTime" SortExpression="chatTime" />
                <asp:BoundField DataField="textColor" HeaderText="textColor" SortExpression="textColor" />
                <asp:BoundField DataField="ordinaryFace" HeaderText="ordinaryFace" SortExpression="ordinaryFace" />
                <asp:BoundField DataField="msgContent" HeaderText="msgContent" SortExpression="msgContent" />
                <asp:ButtonField CommandName="Delete" HeaderText="删除" ShowHeader="True" Text="删除" />
            </Columns>
            <FooterStyle BackColor="Tan" />
            <PagerStyle BackColor="PaleGoldenrod" ForeColor="DarkSlateBlue" HorizontalAlign="Center" />
            <SelectedRowStyle BackColor="DarkSlateBlue" ForeColor="GhostWhite" />
            <HeaderStyle BackColor="Tan" Font-Bold="True" />
            <AlternatingRowStyle BackColor="PaleGoldenrod" />
        </asp:GridView>
        &nbsp;</div>
    </form>
</body>
</html>
