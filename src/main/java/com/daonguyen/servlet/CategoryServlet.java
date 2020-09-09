package com.daonguyen.servlet;

import com.daonguyen.dao.CategoryDao;
import com.daonguyen.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "categoryServlet", urlPatterns = {"/category", "/category/add", "/category/edit", "/category/remove"})
public class CategoryServlet extends HttpServlet {

    private CategoryDao categoryDao = null;

    @Override
    public void init() throws ServletException {
        categoryDao = new CategoryDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String action = req.getServletPath();
        switch (action) {
            case "/category":
                req.setAttribute("categories", categoryDao.findAllOfCategories());
                req.getRequestDispatcher("/WEB-INF/view/category/index.jsp").forward(req, resp);
                break;
            case "/category/add":
                req.getRequestDispatcher("/WEB-INF/view/category/add.jsp").forward(req, resp);
                break;
            case "/category/edit":
                Category category = categoryDao.findCategoryById(req.getParameter("id"));
                req.setAttribute("category", category);
                req.getRequestDispatcher("/WEB-INF/view/category/edit.jsp").forward(req, resp);
                break;
            case "/category/remove":
                categoryDao.remove(req.getParameter("id"));
                resp.sendRedirect(req.getContextPath() + "/category");
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String action = req.getServletPath();

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String desc = req.getParameter("desc");

        Category category = new Category(id, name, desc);

        switch (action) {
            case "/category/add":
                categoryDao.add(category);
                break;
            case "/category/edit":
                categoryDao.edit(category);
                break;
            default:
                break;
        }
        resp.sendRedirect(req.getContextPath() + "/category");
    }
}
