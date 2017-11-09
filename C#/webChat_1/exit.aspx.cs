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

public partial class exit : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        Application.Lock();                    //先锁定
        Application["user_online"] = int.Parse(Application["user_online"].ToString()) - 1;		//在线人数减1	
        Application.UnLock();
        Response.Redirect("Default.aspx");
    }
}
