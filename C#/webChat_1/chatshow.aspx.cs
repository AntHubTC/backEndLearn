using System;
using System.Data;
using System.Data.Odbc;
using System.Data.OleDb;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;

public partial class chatshow : System.Web.UI.Page
{
    private static string conStr;
    OleDbConnection con;
    OleDbCommand com1;
    OleDbCommand com2;
    OleDbDataReader dr;
    string say;
    protected void Page_Load(object sender, EventArgs e)
    {
 
        conStr = System.Configuration.ConfigurationManager.ConnectionStrings["conStr"].ConnectionString.ToString();
        con = new OleDbConnection(conStr);
        com1 = new OleDbCommand("", con);
        com1.CommandText = "select top 10 * from msgInfo order by chatTime desc";
        com2 = new OleDbCommand("", con);
        try
        {
            con.Open();
            dr = com1.ExecuteReader();
            while (dr.Read())//如果dr.Read（）为true，继续循环
            {
                com2.CommandText = "select Icon from users where nickName=@nickName";
                com2.Parameters.Add("nickName", OleDbType.VarChar);
                com2.Parameters["nickName"].Value = dr["msgFrom"];
                say = "<small>" + dr["msgFrom"] + dr["chatTime"] + "说：</small>";
                say += "<font color='" + dr["textColor"] + "'>" + dr["msgContent"] + "</font><br/>";
                say = "<img alt='无法显示' src='" + com2.ExecuteScalar().ToString() + "'/>" + say;
                if (dr["ordinaryFace"].ToString()!="")
                    say += "<img alt='无法显示' src='" + dr["ordinaryFace"] + "'/><br/>";
                Response.Write(say);
            }
        }
        catch (OleDbException errinfo)
        {
            Response.Write(errinfo);
        }
        finally
        {
            con.Close();
        }
         //(chatRoom,msgFrom,chatTime,textColor,ordinaryFace,msgContent)
    }
    protected void updateOnlineCount()//响应body的onUnload()事件
    {
        Application.Lock();                    //先锁定
        Application["user_online"] = int.Parse(Application["user_online"].ToString()) - 1;		//在线人数减1	
        Application.UnLock();
    }
}
