package com.mxz.supermarket.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.component.RegisterComponent;
import com.mxz.supermarket.model.Admin;
import com.mxz.supermarket.service.AdminService;
import com.mxz.supermarket.utils.APIResult;
import com.mxz.supermarket.utils.LogUtils;
import com.mxz.supermarket.utils.TokenUtil;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Zxw
 * @Description:
 * @Date: Created in 17:01 2020/1/14
 * @Modifued By:
 */
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RegisterComponent registerComponent;

    /**
     * 管理员登录
     * @param admin
     * @param response
     * @return
     */
    @RequestMapping("/admin/loginadmin")
    public APIResult loginAdmin(@RequestBody Admin admin, HttpServletResponse response){
        //判空操作
        if(admin.getEmail() == null || admin.getPassword() == null){
            return APIResult.genFailApiResponse400("登录邮箱或密码为空！");
        }
        System.out.println(admin);
        Admin login = adminService.login(admin);
        System.out.println(login);
        //如果查询出来的结果不为空 将管理员加入到本地token中
        if (login!=null){
            Map map1=new HashMap();
            map1.put("adminId",login.getAdminId());
            map1.put("adminName",login.getAdminName());
            map1.put("right","admin");
            String s = TokenUtil.becomeToken(map1);
            Cookie token=new Cookie("token",s);
            response.addCookie(token);
            LogUtils.getControllerLogger().info("getControllerLogger===管理员登录成功");
            return new APIResult(true);
        }else {
            //如果查询结果为空 则返回登录失败的结果
            APIResult apiResult = new APIResult();
            apiResult.setResult(false);
            LogUtils.getControllerLogger().info("getControllerLogger===用户登录失败");
            Admin email = adminService.findAdminByEmail(admin.getEmail());
            if (email==null){
                apiResult.setMessage("邮箱不存在！");
                return apiResult;
            }
            apiResult.setMessage("密码错误！");
            return apiResult;
        }

    }

    /**
     * 分页查询出所有的管理员
     * @param map
     * @return
     */
    @RequestMapping("/admin/loadalladmin")
    public APIResult loadAllAdmin(@RequestBody Map map){
        int page ;
        int limit;
        //对请求中的page 和limit做处理
        if(map.get("page") == null){
            page = 0;
        }else{
            page = Integer.parseInt(map.get("page").toString());
        }

        if(map.get("limit") == null){
            limit = 10;
        }else{
            limit = Integer.parseInt(map.get("limit").toString());
        }

        PageInfo<Admin> adminPageInfo = adminService.loadAllAdmin(page, limit);

        System.out.println("pageInfo:" + adminPageInfo);

        APIResult apiResult = new APIResult( "加载成功",true, 200, adminPageInfo);
        return apiResult;

    }

    /**
     * 根据id加载管理员信息
     * @param id
     * @return
     */
    @GetMapping("/admin/loadadminbyid/{id}")
    public APIResult loadAdminById(@PathVariable("id") Integer id){
        if(id == null){
            return APIResult.genFailApiResponse400("加载该管理员失败！");
        }
        Admin adminById = adminService.findAdminById(id);

        return APIResult.genSuccessApiResponse(adminById);
    }


    @RequestMapping("/admin/searchadminlikename")
    public APIResult searchAdminLikeName(@RequestBody Map map){
        int page ;
        int limit;
        String adminName ;
        //对请求中的page 和limit做处理
        if(map.get("page") == null){
            page = 0;
        }else{
            page = Integer.parseInt(map.get("page").toString());
        }

        if(map.get("limit") == null){
            limit = 10;
        }else{
            limit = Integer.parseInt(map.get("limit").toString());
        }
        if(map.get("adminName").toString() == null){
            adminName = null;
        }else{
          adminName = map.get("adminName").toString();
        }
        PageInfo<Admin> adminLikeName = adminService.findAdminLikeName(adminName , page, limit);

        return APIResult.genSuccessApiResponse(adminLikeName);
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @RequestMapping("admin/addadmin")
    public APIResult addAdmin(@RequestBody Admin admin){

        if(admin == null){
            LogUtils.getControllerLogger().info("getControllerLogger===添加管理员输入数据有误");
            return APIResult.genFailApiResponse400("输入数据有误！");
        }
        Admin adminByEmail = adminService.findAdminByEmail(admin.getEmail());
        if(adminByEmail != null){
            return APIResult.genFailApiResponse400("该邮箱已被注册！");
        }

        Admin adminByPhone = adminService.findAdminByPhone(admin.getPhone());
        if(adminByPhone != null){
            return APIResult.genFailApiResponse400("该电话已被注册！");
        }

        boolean b = adminService.addAdmin(admin);
        if(b){
            return APIResult.genSuccessApiResponse("添加管理员成功！");
        }
        LogUtils.getControllerLogger().info("getControllerLogger===添加管理员失败");
        return APIResult.genFailApiResponse400("添加管理员失败!");

    }

    /**
     * 管理员修改自己个人密码
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("/admin/updatepassword")
    public APIResult updatePassword(@RequestBody Map map, HttpServletRequest request){
        if(map.get("newPassword") == null || map.get("oldPassword")==null){
            return APIResult.genFailApiResponse400("修改密码失败!");
        }
        //获取原密码
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for(Cookie c:cookies){
            if("token".equals(c.getName())){
                cookie = c;
            }
        }
        String value = cookie.getValue();
        int adminId = (int) TokenUtil.getTokenValue(value, "adminId");
        Admin adminById = adminService.findAdminById(adminId);
        if(!adminById.getPassword().equals(map.get("oldPassword"))){
            return APIResult.genFailApiResponse400("原密码有误！");
        }
        adminById.setPassword(map.get("newPassword").toString());
        boolean b = adminService.updateAdmin(adminById);
        if(b){
            return APIResult.genSuccessApiResponse("修改密码成功！");
        }
        return APIResult.genFailApiResponse400("修改密码失败！");
    }

    /**
     * 管理员修改自己个人资料
     * @param admin
     * @param request
     * @return
     */
    @RequestMapping("/admin/updateadmin")
    public APIResult updateAdmin(@RequestBody Admin admin,HttpServletRequest request){
        //获取原密码
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for(Cookie c:cookies){
            if("token".equals(c.getName())){
                cookie = c;
            }
        }
        String value = cookie.getValue();
        int adminId = (int) TokenUtil.getTokenValue(value, "adminId");
        Admin adminById = adminService.findAdminById(adminId);
        //判断修改后邮箱是否已经存在
        if(!adminById.getEmail().equals(admin.getEmail())){
            Admin adminByEmail = adminService.findAdminByEmail(admin.getEmail());
            if(adminByEmail!= null){
                return APIResult.genFailApiResponse400("该邮箱已被注册！");
            }
        }
        //判断修改后电话号码是否已经存在
        if(!adminById.getPhone().equals(admin.getPhone())){
            Admin adminByPhone = adminService.findAdminByPhone(admin.getPhone());
            if(adminByPhone!= null){
                return APIResult.genFailApiResponse400("该电话已被注册！");
            }
        }

        boolean b = adminService.updateAdmin(admin);
        if(b){
            return APIResult.genSuccessApiResponse("修改个人资料成功！");
        }
        return APIResult.genFailApiResponse400("修改个人资料失败！");
    }

    /**
     * 加载管理员自己的信息
     * @return
     */
    @GetMapping("/admin/loadownadmin")
    public APIResult loadOwnAdmin(HttpServletRequest request){
        //获取原密码
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for(Cookie c:cookies){
            if("token".equals(c.getName())){
                cookie = c;
            }
        }
        String value = cookie.getValue();
        int adminId = (int) TokenUtil.getTokenValue(value, "adminId");
        Admin adminById = adminService.findAdminById(adminId);
        if(adminById == null){
            return APIResult.genFailApiResponse400("加载失败");
        }
        return APIResult.genSuccessApiResponse("加载成功",adminById);

    }

    @RequestMapping("admin/forgetpassword")
    public APIResult forgetPassword(@RequestBody JSONObject jsonObject){
        String verificationCode = (String) jsonObject.get("verificationCode");
        String email = (String) jsonObject.get("email");
        String password = (String) jsonObject.get("password");
        String codeByEmail = registerComponent.getCodeByEmail(email);
        System.out.println("codeByEmail--"+codeByEmail);
        System.out.println("GET----"+registerComponent.getCodeByEmail(email));
        if(codeByEmail == null){
            APIResult apiResult = new APIResult(false,200);
            apiResult.setMessage("验证码不正确");
            return apiResult;
        }

        if(!codeByEmail.equals(verificationCode)){
            APIResult apiResult = new APIResult(false,200);
            apiResult.setMessage("验证码不正确");
            return apiResult;
        }
        Admin adminByEmail = adminService.findAdminByEmail(email);
        adminByEmail.setPassword(password);
        boolean i = adminService.updateAdmin(adminByEmail);
        APIResult apiResult = new APIResult(i,200);
        return apiResult;
    }

    @RequestMapping("/admin/sendcode")
    public APIResult sendCode(@RequestBody Admin admin){
        registerComponent.sendCodeToEmail(admin.getEmail());
        Admin adminByEmail = adminService.findAdminByEmail(admin.getEmail());
        if(adminByEmail == null){
            APIResult apiResult = new APIResult(false,200);
            apiResult.setMessage("邮箱不存在！请确认你输入的邮箱号！");
            return apiResult;
        }
        APIResult apiResult = new APIResult(true,200);
        apiResult.setMessage("5分钟内验证码有效");
        return apiResult;
    }

    @GetMapping("/admin/deladmin/{id}")
    public APIResult delAdmin(@PathVariable("id") Integer id){
        if(id == null){
            return APIResult.genFailApiResponse400("删除失败！");
        }
        boolean b = adminService.delAdmin(id);
        if(b){
            return APIResult.genSuccessApiResponse("删除成功！");
        }
        return APIResult.genFailApiResponse400("删除失败！");
    }

    /**
     * 修改其他管理员的信息
     * @param admin
     * @return
     */
    @RequestMapping("admin/updateotheradmin")
    public APIResult updateOtherAdmin(@RequestBody Admin admin){

        if(admin == null){
            LogUtils.getControllerLogger().info("getControllerLogger===添加管理员输入数据有误");
            return APIResult.genFailApiResponse400("输入数据有误！");
        }
        Admin admin1 = adminService.findAdminById(admin.getAdminId());
        if(!admin1.getEmail().equals(admin.getEmail())){
            Admin adminByEmail = adminService.findAdminByEmail(admin.getEmail());
            if(adminByEmail != null){
                return APIResult.genFailApiResponse400("该邮箱已被注册！");
            }
        }

        if(!admin1.getPhone().equals(admin.getPhone())){
            Admin adminByPhone = adminService.findAdminByPhone(admin.getPhone());
            if(adminByPhone != null){
                return APIResult.genFailApiResponse400("该电话已被注册！");
            }
        }

        boolean b = adminService.updateAdmin(admin);
        if(b){
            return APIResult.genSuccessApiResponse("修改管理员成功！");
        }
        LogUtils.getControllerLogger().info("getControllerLogger===修改管理员失败");
        return APIResult.genFailApiResponse400("修改管理员失败!");

    }
}