using System;
using System.Data;
using System.Data.OleDb;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Drawing;

public partial class chatinput : System.Web.UI.Page
{
    private static string conStr;
    OleDbConnection con;
    OleDbCommand com;
    protected void Page_Load(object sender, EventArgs e)
    {
        init();
        GetFaces();
    }
    protected void init()//在访问数据库前的一些准备工作
    {
        conStr = System.Configuration.ConfigurationManager.ConnectionStrings["conStr"].ConnectionString.ToString();
        con = new OleDbConnection(conStr);
    }
    private void GetFaces()
    {
        for (int i = 0; i < 2; i++)
        {
            TableRow row = new TableRow();
            for (int j = 1; j <= 10; j++)
            {
                TableCell cell = new TableCell();
                cell.HorizontalAlign = System.Web.UI.WebControls.HorizontalAlign.Center;
                cell.Width = 50;
                cell.Height = 50;
                cell.Text = "<img style=\"cursor:hand\" width=50 height=50 onmouseout=\"this.width=24;this.height=24\" onclick=\"document.all.Icon.src=this.src;document.all.txtFaceUrl.value=this.src\" src=\"images\\faces\\" + (i * 10 + j).ToString() + ".Gif\">";
                row.Cells.Add(cell);
            }
            tabFaces.Rows.Add(row);
        }
    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        string say,textColor,myface,user_name;           //声明变量待用
        user_name = Session["user_name"].ToString();               //返回用户昵称
        say = Server.HtmlEncode(TxtChat.Text);     //返回发言，并用HtmlEncode编码
        TxtChat.Text = "";
        textColor = RadioButtonList1.SelectedValue;                  //返回本次发言的颜色
        myface = txtFaceUrl.Text;      //返回本次发言表情
        //下面三句将得到本次发言的字符串
        com = new OleDbCommand("",con);
        com.CommandText = "insert into msgInfo (chatRoom,msgFrom,chatTime,textColor,ordinaryFace,msgContent) values (@chatRoom,@msgFrom,@chatTime,@textColor,@ordinaryFace,@msgContent)";
        com.Parameters.Add("chatRoom",OleDbType.Integer);
        com.Parameters.Add("msgFrom",OleDbType.VarChar);
        com.Parameters.Add("chatTime",OleDbType.Date);
        com.Parameters.Add("textColor", OleDbType.VarChar);
        com.Parameters.Add("ordinaryFace",OleDbType.VarChar);
        com.Parameters.Add("msgContent", OleDbType.VarChar);
        com.Parameters["chatRoom"].Value = 1;
        com.Parameters["msgFrom"].Value = user_name;
        com.Parameters["chatTime"].Value = DateTime.Now;
        com.Parameters["textColor"].Value = textColor;
        com.Parameters["ordinaryFace"].Value = myface;
        com.Parameters["msgContent"].Value = say;
        try
        {
            con.Open();
            com.ExecuteNonQuery();
        }
        catch (OleDbException errinfo)
        {
            Response.Write(errinfo);
        }
        finally
        {
            con.Close();
        }
    }
    protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
    {
        Panel2.Visible = false;
        if (Panel1.Visible == true)
            Panel1.Visible = false;
        else
            Panel1.Visible = true;
    }
    protected void ImageButton2_Click(object sender, ImageClickEventArgs e)
    {
        Panel1.Visible = false;
        if (Panel2.Visible == true)
            Panel2.Visible = false;
        else
            Panel2.Visible = true;

    }
}
