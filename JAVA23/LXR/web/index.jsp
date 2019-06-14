<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>名片自动绑定系统</title>
    <link rel="stylesheet" href="./style/lxr-qrcode.css"/>
    <script type="text/javascript" src="./js/jquery-1.4.3.js"></script>
    <script type="text/javascript">
//      二维码通讯录联系格式 构造字典
      var lxrKeyCode = {
        begin:"BEGIN:VCARD",
        name:"\nFN:",
        nickname:"\nNICKNAME:",
        company:"\nORG:",
        title:"\nTITLE:",
        tel:"\nTEL:",
        address:"\nADDR:",
        url:"\nURL:",
        email:"\nEMAIL:",
        homefax:"\nTELL;HOME;FAX:",
        workfax:"\nTELL;WORK;FAX:",
        end:"\nEND:VCARD"
      };
      function createCode(){
        var formDataArr = $("#form").serializeArray();
        var data = lxrKeyCode.begin;
        for(var i = 0; i<formDataArr.length; i++){
          if(formDataArr[i].name)
            data += lxrKeyCode[formDataArr[i].name] + formDataArr[i].value;
        }
        data += lxrKeyCode.end;
        $.ajax({
          type:"post",
          url:"/lxr/getQrcode",
          data:{
            content:data
          },
          success:function(data){
            $("#resultImg").attr("src", "${contextPath}/images/qrcode"+data);
            $("#resultImg").show();
          }
        });
      }
      $(function(){
        $("input.input_btn").click(function(){
          createCode();
        });
      });
    </script>
  </head>
  <body>
    <div class="box">
      <h1>名片自动绑定系统</h1>
      <form id="form" action="#">
        <div class="field-container">
          <div class="left">
            <p><span>姓名：</span><input name="name" class="input_box" type="text"/></p>
            <p><span>昵称：</span><input name="nickname" class="input_box" type="text"/></p>
            <p><span>公司：</span><input name="company" class="input_box" type="text"/></p>
            <p><span>职务：</span><input name="title" class="input_box" type="text"/></p>
            <p><span>电话：</span><input name="tel" class="input_box" type="text"/></p>
          </div>
          <div class="right">
            <p><span>地址：</span><input name="address" class="input_box" type="text"/></p>
            <p><span>家庭FAX：</span><input name="homefax" class="input_box" type="text"/></p>
            <p><span>工作FAX：</span><input name="workfax" class="input_box" type="text"/></p>
            <p><span>个人主页：</span><input name="url" class="input_box" type="text"/></p>
            <p><span>e-mail：</span><input name="email" class="input_box" type="text"/></p>
          </div>
        </div>
      </form>
      <input type="submit" value="生成名片" class="input_btn"/>
      <img id="resultImg" src="#" alt="" class="qrCode-img"/>
    </div>
  </body>
</html>