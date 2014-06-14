
package jp.oracle.zoo.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 部門情報追加の確認ページ
 * /oracle-zoo/department_insert/confirmのModel
 *
 * @author kiaamaaio
 */
public class DepartmentInsertConfirmModel implements ZooModelInterface {

    /**
     * メッセージ変数初期化
     */
        
    
    public void doBusinessLogic(HttpServletRequest req, HttpServletResponse resp){
        
          resp.setContentType("text/html; charset=UTF-8");
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EmployeeInsertConfirmModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String departmentid = req.getParameter("departmentid");
        String depLevel = req.getParameter("depLevel");
        String name = req.getParameter("name");
        String name_kana = req.getParameter("name_kana");
        String name_en = req.getParameter("name_en");
        String costcenter_id = req.getParameter("costcenter_id");
        String ceo_id = req.getParameter("ceo_id");
        String manager_id = req.getParameter("manager_id");
        String section_id = req.getParameter("section_id");
        confirmSetAttribute(departmentid, depLevel, name, name_kana, name_en, costcenter_id, ceo_id, manager_id, section_id, req, resp);
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
            
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/department_insert/department_complete.jsp");
	rd.forward(req, resp);
        }catch(ServletException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
       
}
