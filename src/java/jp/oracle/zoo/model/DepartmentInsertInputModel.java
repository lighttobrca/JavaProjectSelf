
package jp.oracle.zoo.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jp.oracle.zoo.exception.EmptyStringException;
import jp.oracle.zoo.exception.LimitMaxCharacter;
import jp.oracle.zoo.exception.TypeNumberException;
import jp.oracle.zoo.util.InputValidation;

/**
 * 部門情報追加の入力ページ
 * /oracle-zoo/department_insert/inputのModel
 *
 * @author kiaamaaio
 */
public class DepartmentInsertInputModel implements ZooModelInterface {
    
    public String messege = "";
    public String messege1 = "";
    public String messege2 = "";
    public String messege3 = "";
    public String messege4 = "";
    public String messege5 = "";
    public String messege6 = "";
    public String messege7 = "";
    public String messege8 = "";
    public String messege9 = "";
    public String messege10 = "";
    public String messege11 = "";
    public int confirmcheck = 0;

   
    
    private boolean isRedirect = false;
    
    public boolean getIsRedirect() {
        return isRedirect;
    }

    public void setIsRedirect(boolean isRedirect) {
        this.isRedirect = isRedirect;
    }
    
    /**
     * リダイレクトして、失敗したら例外を投げる
     * 
     * @param req
     * @param resp
     * @param path
     * @throws IOException 
     */
    private void pageRedirect(HttpServletRequest req, HttpServletResponse resp, String path) throws IOException{
        
        resp.sendRedirect(path);
    }

    
    @Override
    public void doBusinessLogic(HttpServletRequest req, HttpServletResponse resp){
    
            
          resp.setContentType("text/html; charset=UTF-8");
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EmployeeInsertConfirmModel.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        messegeInitialSet(req, resp);
        
        if(req.getParameter("confirm") != null){    
        String departmentid = req.getParameter("departmentid");
        String depLevel = req.getParameter("depLevel");
        String name = req.getParameter("name");
        String name_kana = req.getParameter("name_kana");
        String name_en = req.getParameter("name_en");
        String costcenter_id = req.getParameter("costcenter_id");
        String ceo_id = req.getParameter("ceo_id");
        String manager_id = req.getParameter("manager_id");
        String section_id = req.getParameter("section_id");
        
     try{    
            depLevelNullCheck(depLevel, req, resp);
            departmentidNullCheck(departmentid, req, resp);
            nameNullCheck(name, req, resp);
            namekanaNullCheck(name_kana, req, resp);
            nameenNullCheck(name_en, req, resp);
            costcenteridNullCheck(costcenter_id, req, resp);
            ceoidNullCheck(ceo_id, req, resp);
            manageridNullCheck(manager_id, req, resp);
            sectionidNullCheck(section_id, req, resp);
            System.out.println(confirmcheck);
            if(confirmcheck != 1){
                confirmSetAttribute(departmentid, depLevel, name, name_kana, name_en, costcenter_id, ceo_id, manager_id, section_id, req, resp);
            }
            }catch(Exception e){
            e.printStackTrace();
     }
    }
        
    }
    
    public void depLevelNullCheck(String depLevel,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(depLevel);
        }catch(EmptyStringException e){
            messege = "<font size=\"2\" color=\"#ff0000\">部門レベルが入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("depLevelNullCheckmessege", messege);
        }
    }
    public void departmentidNullCheck(String departmentid,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(departmentid);
        }catch(EmptyStringException e){
            messege1 = "<font size=\"2\" color=\"#ff0000\">部門IDが入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("departmentidNullCheckmessege", messege1);
        }
    }
    
    public void nameNullCheck(String name,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(name);
        }catch(EmptyStringException e){
            messege2 = "<font size=\"2\" color=\"#ff0000\">部門名が入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("nameNullCheckmessege", messege2);
        }
    }
    
    public void namekanaNullCheck(String name_kana,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(name_kana);
        }catch(EmptyStringException e){
            messege3 = "<font size=\"2\" color=\"#ff0000\">部門名のふりがなが入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("namekanaNullCheckmessege", messege3);
        }
    }
    
    public void nameenNullCheck(String name_en,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(name_en);
        }catch(EmptyStringException e){
            messege4 = "<font size=\"2\" color=\"#ff0000\">部門の英語名がなが入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("nameenNullCheckmessege", messege4);
        }
    }
    
    public void costcenteridNullCheck(String costcenter_id,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(costcenter_id);
        }catch(EmptyStringException e){
            messege5 = "<font size=\"2\" color=\"#ff0000\">コストセンターコードが入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("costcenteridNullCheckmessege", messege5);
        }
    }
    
     public void ceoidNullCheck(String ceo_id,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(ceo_id);
        }catch(EmptyStringException e){
            messege6 = "<font size=\"2\" color=\"#ff0000\">取締部門コードが入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("ceoidnullCheckmessege", messege6);
        }
    }
     
    public void manageridNullCheck(String manager_id,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(manager_id);
        }catch(EmptyStringException e){
            messege7 = "<font size=\"2\" color=\"#ff0000\">マネージャ社員コードが入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("manageridnullCheckmessege", messege7);
        }
    }
            
    
    
    public void sectionidNullCheck(String section_id,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(section_id);
        }catch(EmptyStringException e){
            messege8 = "<font size=\"2\" color=\"#ff0000\">セクションIDが入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("sectionidNullCheckmessege", messege8);
        }
    }        
            
    public void messegeInitialSet(HttpServletRequest req, HttpServletResponse resp){
        req.setAttribute("departmentidNullCheckmessege", messege);
        req.setAttribute("depLevelNullCheckmessege", messege1);
        req.setAttribute("nameNullCheckmessege", messege2);
        req.setAttribute("namekanaNullCheckmessege", messege3);
        req.setAttribute("nameenNullCheckmessege", messege4);
        req.setAttribute("costcenteridNullCheckmessege", messege5);
        req.setAttribute("ceoidnullCheckmessege", messege6);
        req.setAttribute("manageridnullCheckmessege", messege7);
        req.setAttribute("sectionidNullCheckmessege", messege8);
    }
    
    public void confirmSetAttribute(String departmentid,String depLevel,String name,String name_kana,String name_en,String costcenter_id, String ceo_id, String manager_id, String section_id,HttpServletRequest req, HttpServletResponse resp){
        
        
        try{
            
            /*
            ###############
            #取得コード一覧#
            ###############
            
            departmentid
            depLevel
            name
            name_kana
            name_en
            costcenter_id
            ceo_id
            manager_id
            section_id
            */
            
            req.setAttribute("departmentid", departmentid);
            req.setAttribute("depLevel", depLevel);
            req.setAttribute("name", name);
            req.setAttribute("name_kana", name_kana);
            req.setAttribute("name_en", name_en);
            req.setAttribute("costcenter_id", costcenter_id);
            req.setAttribute("ceo_id", ceo_id);
            req.setAttribute("manager_id", manager_id);
            req.setAttribute("section_id", section_id);
            
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/department_insert/department_confirm.jsp");
	rd.forward(req, resp);
        }catch(ServletException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
   
    }
