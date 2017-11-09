using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Data.OleDb;

public partial class register : System.Web.UI.Page{

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
        for (int i = 0; i < 10; i++)
        {
            TableRow row = new TableRow();
            for (int j = 1; j <= 10; j++)
            {
                TableCell cell = new TableCell();
                cell.HorizontalAlign = System.Web.UI.WebControls.HorizontalAlign.Center;
                cell.Width = 20;
                cell.Height = 20;
                cell.Text = "<img style=\"cursor:hand\" width=20 height=20 onmouseover=\"this.width=50;this.height=50 \" onmouseout=\"this.width=24;this.height=24\" onclick=\"document.all.Icon.src=this.src;document.all.txtFaceUrl.value=this.src\" src=\"images\\" + (i * 10 + j).ToString() + ".bmp\">";
                row.Cells.Add(cell);
            }
            tabFaces.Rows.Add(row);
        }
    }
 
    protected void Button1_Click(object sender, EventArgs e)//提交表单数据
    {
        if (!checkCode())
        {
            alert("验证码错误");
            return;
        }
        if (checkUserExist())//检测用户是否已经存在
            alert("用户已存在");
        else
        {
            registerModule();//注册用户资料入user数据库
            Response.Redirect("Default.aspx");
        }
    }
    protected Boolean checkCode()
    {
        string code1 = Session["CheckCode"].ToString().Trim();
        string code2 = checkCodeBox.Text.ToString().Trim();
        return (code1 == code2);
    }
    protected Boolean checkUserExist()//检测用户是否已经存在
    {
        com = new OleDbCommand("", con);
        com.CommandText = "select nickName from users where nickName=@checkNickName";
        com.Parameters.Add("checkNickName",OleDbType.VarChar);
        com.Parameters["checkNickName"].Value = TextBox1.Text;
        try
        {
            con.Open();
            return com.ExecuteReader().Read();//执行结果返回true或false
        }
        catch (OleDbException errinfo)
        {
            Response.Write(errinfo.ToString());
            alert("系统故障!");
            return false;
        }
        finally
        {
            con.Close();
        }
    }
    protected void accessReady()
    {
        com = new OleDbCommand("", con);
        com.CommandText = "insert into users (nickName,userPassword,power,Icon,birth,sex,email) values (@nickName,@userPassword,@power,@Icon,@birth,@sex,@email)";
        com.Parameters.Add("nickName", OleDbType.VarChar);
        com.Parameters.Add("userPassword", OleDbType.VarChar);
        com.Parameters.Add("power", OleDbType.VarChar);
        com.Parameters.Add("Icon", OleDbType.VarChar);
        com.Parameters.Add("birth", OleDbType.Date);
        com.Parameters.Add("sex", OleDbType.VarChar);
        com.Parameters.Add("email", OleDbType.VarChar);
        com.Parameters["nickName"].Value = TextBox1.Text;
        com.Parameters["userPassword"].Value = TextBox2.Text;
        com.Parameters["power"].Value = RadioButtonList2.SelectedValue;
        com.Parameters["Icon"].Value = txtFaceUrl.Text;
        com.Parameters["birth"].Value = DateTime.Parse(TextBox4.Text);
        com.Parameters["sex"].Value = RadioButtonList1.SelectedValue;
        com.Parameters["email"].Value = TextBox5.Text;
    }
    protected void registerModule() //注册模块
    {
        alert("恭喜！注册成功!");
        con.Open();
        accessReady();
        try
        {
            com.ExecuteNonQuery();
            alert("恭喜！注册成功!");
        }
        catch (OleDbException errinfo)
        {
            Response.Write(errinfo.ToString());
            alert("系统故障!");
        }
        finally
        {
            con.Close();
        }
    }
    protected void alert(string strTemp)//自定义警告模块
    {
        strTemp = "<script language='javascript' type='text/javascript'>alert('"+strTemp+"');</script>";
        Response.Write(strTemp);
    }
    protected void Button2_Click(object sender, EventArgs e)//重置表单数据
    {
        Response.Write("<script language='javascript' type='text/javascript'>location.replace(location)</script>");
    }
    protected void LinkButton1_Click(object sender, EventArgs e)
    {
        ;
    }
}
