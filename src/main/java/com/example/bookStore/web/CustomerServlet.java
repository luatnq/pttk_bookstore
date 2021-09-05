package com.example.bookStore.web;

import com.example.bookStore.dao.AccountDAO;
import com.example.bookStore.dao.CustomerDAO;
import com.example.bookStore.dao.impl.AccountDAOImpl;
import com.example.bookStore.dao.impl.CustomerDAOImpl;
import com.example.bookStore.model.Account;
import com.example.bookStore.model.Customer;
import lombok.RequiredArgsConstructor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/")
@RequiredArgsConstructor
public class CustomerServlet extends HttpServlet {
    private CustomerDAO customerDAO;
    private AccountDAO accountDAO;

    public void init() throws ServletException {
        super.init();
        customerDAO = new CustomerDAOImpl();
        accountDAO = new AccountDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();

        try {
            switch (action) {
                case "/register":
                    this.showRegisterForm(request, response);
                    break;
                case "/insert":
                    this.insertCustomer(request, response);
                    break;
                case "/login":
                    this.showLoginForm(request, response);
                    break;
                case "/auth":
                    this.login(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException{
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Customer newCustomer = new Customer(fullName, phoneNumber);

        customerDAO.createCustomer(newCustomer);
        Customer cus = customerDAO.getCustomerByPhoneNumber(phoneNumber);
        newCustomer.setId(cus.getId());
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        newCustomer.setAccount(account);
        accountDAO.createAccount(newCustomer);
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean auth = accountDAO.checkLogin(username, password);

        int a = 0;
    }
}
