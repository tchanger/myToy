package com.yan.web;

import com.yan.service.MTransferService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 使用mybatis实现银行转账
 */
@SuppressWarnings("all")
@WebServlet("/MTransfer")
public class MTransferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        double money = Double.parseDouble(request.getParameter("money"));
        MTransferService mts = new MTransferService();
        boolean b = mts.transfer(from,to,money);
        if(b){
            response.sendRedirect("success.jsp");
        }else {
            response.sendRedirect("fail.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
