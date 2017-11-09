using System; 
using System.Data;
using System.Data.OleDb;
using System.Configuration;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;

public partial class _Default : System.Web.UI.Page
{
    private static string conStr;
    OleDbConnection con;
    OleDbCommand com;
    protected void Page_Load(object sender, EventArgs e)
    {
        init();
        if (Application["user_online"] == null)
            Application["user_online"] = 0;
            Session["user_name"] = "";
        Label1.Text = "共有"+ReadOnlineCount()+"人在线";
    }
    protected void init()//在访问数据库前的一些准备工作
    {
        conStr = System.Configuration.ConfigurationManager.ConnectionStrings["conStr"].ConnectionString.ToString();
        con = new OleDbConnection(conStr);
    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        if (checkUserPWD())//检测用户名和密码正确性
        {
            lastLoginTimeUpdate();
            Session["user_name"] = TextBox1.Text;//记录用户名 
            Application.Lock();
            Application["user_online"] = int.Parse(Application["user_online"].ToString()) + 1;//在线人数加1
            Application.UnLock();
            string strTmp = RadioButtonList1.SelectedValue.ToString();
            if(checkUserPower() && strTmp == "admin")
            {
                Response.Redirect("admin.aspx");
            }
            else
                Response.Redirect("chat.aspx");//转到chat.aspx页面
        }
        else
            alert("密码错误!");
    }
    protected void lastLoginTimeUpdate()//更新最后一次登录时间
    {
        com = new OleDbCommand("", con);
        com.CommandText = "update users set lastLoginTime = @lastLoginTime where nickName = @nickName";
        com.Parameters.Add("lastLoginTime",OleDbType.VarChar);
        com.Parameters.Add("nickName",OleDbType.VarChar);
        com.Parameters["lastLoginTime"].Value = DateTime.Now;
        com.Parameters["nickName"].Value = TextBox1.Text;
        try
        {
            con.Open();
            com.ExecuteNonQuery();
        }
        catch (OleDbException errinfo)
        {
            Response.Write(errinfo.ToString());
        }
        finally
        {
            con.Close();
        }
    }
    protected Boolean checkUserPower()//检查是否具有管理员权限
    {
        com = new OleDbCommand("", con);
        com.CommandText = "select nickName from users where nickName=@checkNickName and power=@power";
        com.Parameters.Add("nickName", OleDbType.VarChar);
        com.Parameters.Add("power", OleDbType.VarChar);
        com.Parameters["nickName"].Value = TextBox1.Text;
        com.Parameters["power"].Value = RadioButtonList1.SelectedValue;
        try
        {
            con.Open();
            if (!com.ExecuteReader().Read())//执行结果返回true或false
            {
                return false;
            }
            else return true;
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
    protected Boolean checkUserPWD()//检测用户和密码正确性
    {
        com = new OleDbCommand("", con);
        com.CommandText = "select nickName from users where nickName=@checkNickName and userPassword=@checkPWD";
        com.Parameters.Add("checkNickName", OleDbType.VarChar);
        com.Parameters.Add("checkPWD", OleDbType.VarChar);
        com.Parameters["checkNickName"].Value = TextBox1.Text;
        com.Parameters["checkPWD"].Value = TextBox2.Text;
        try
        {
            con.Open();
            if (!com.ExecuteReader().Read())//执行结果返回true或false
            {
                return false;
            }
            else
                return true;
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
    protected String ReadOnlineCount()
    {
        return Application["user_online"].ToString();
    }
    protected void alert(string strTemp)//自定义警告模块
    {
        strTemp = "<script language='javascript' type='text/javascript'>alert('" + strTemp + "');</script>";
        Response.Write(strTemp);
    }
    protected void Button2_Click(object sender, EventArgs e)//注册按钮事件
    {
        Response.Redirect("register.aspx");//跳转到注册页面
    }
}
