package com.yan.web;

import com.yan.service.TTransferService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 使用ThreadLocal优化后实现银行转账
 */
@SuppressWarnings("all")
@WebServlet("/TTransfer")
public class TTransferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            double money = Double.parseDouble(request.getParameter("money"));
            TTransferService tts = new TTransferService();
            boolean b = tts.transfer(from,to,money);
            if(b){
                response.sendRedirect("success.jsp");
            }else {
                response.sendRedirect("fail.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
