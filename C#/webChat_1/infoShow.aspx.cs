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
using System.Data.Odbc;

public partial class infoShow : System.Web.UI.Page
{
    private static string conStr;
    OleDbConnection con;
    OleDbCommand com;
    OleDbDataReader dr;

    protected void Page_Load(object sender, EventArgs e)
    {
        init();
        infoDisplay();
    }
    protected void init()//在访问数据库前的一些准备工作
    {
        conStr = System.Configuration.ConfigurationManager.ConnectionStrings["conStr"].ConnectionString.ToString();
        con = new OleDbConnection(conStr);
    }
    protected void infoDisplay()
    {
        com = new OleDbCommand("",con);
        com.CommandText = "select * from users where nickName=@nickName";
        com.Parameters.Add("nickName",OleDbType.VarChar);
        com.Parameters["nickName"].Value = Session["user_name"].ToString();
        try
        {
            con.Open();
            dr = com.ExecuteReader();
            dr.Read();
            Response.Write("用户图标：<img alt='无法显示' src='" + dr["Icon"].ToString() + "'><br/>");
            Response.Write("呢称："+dr["nickName"].ToString()+"<br/>");
            Response.Write("性别：" + dr["sex"].ToString() + "<br/>");
            Response.Write("最近登录时间：" + dr["lastLoginTime"].ToString() + "<br/>");
            Response.Write("E-mail：" + dr["email"].ToString() + "<br/>");
            Response.Write("出生日期：" + dr["birth"].ToString() + "<br/>");
        }
        catch (OleDbException errinfo)
        {
            Response.Write(errinfo.ToString());
            alert("系统故障！");
        }
        finally
        {
            con.Close();
        }
    }
    protected void alert(string strTemp)//自定义警告模块
    {
        strTemp = "<script language='javascript' type='text/javascript'>alert('" + strTemp + "');</script>";
        Response.Write(strTemp);
    }
}
