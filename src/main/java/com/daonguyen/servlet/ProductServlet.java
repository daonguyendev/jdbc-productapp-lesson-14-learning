package com.daonguyen.servlet;

import com.daonguyen.dao.CategoryDao;
import com.daonguyen.dao.ProductDao;
import com.daonguyen.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "productServlet", urlPatterns = {"/product", "/product/add", "/product/edit", "/product/remove"})
public class ProductServlet extends HttpServlet {

    private ProductDao productDao = null;
    private CategoryDao categoryDao = null;

	@Override
	public void init() throws ServletException {
        productDao = new ProductDao();
        categoryDao = new CategoryDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

		String action = req.getServletPath();
		switch (action) {
			case "/product":
			    req.setAttribute("products", productDao.findAllOfProducts());
				req.getRequestDispatcher("/WEB-INF/view/product/index.jsp").forward(req, resp);
				break;
			case "/product/add":
                req.setAttribute("categories", categoryDao.findAllOfCategories());
                req.getRequestDispatcher("/WEB-INF/view/product/add.jsp").forward(req, resp);
                break;
            case "/product/edit":
                req.setAttribute("product", productDao.findProductById(req.getParameter("id")));
                req.setAttribute("categories", categoryDao.findAllOfCategories());
                req.getRequestDispatcher("/WEB-INF/view/product/edit.jsp").forward(req, resp);
                break;
            case "/product/remove":
                productDao.remove(req.getParameter("id"));
                resp.sendRedirect(req.getContextPath() + "/product");
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
        int amount = Integer.valueOf(req.getParameter("amount"));
        float price = Float.valueOf(req.getParameter("price"));
        String cateId = req.getParameter("cateId");

        Product product = new Product(id, name, amount, price, cateId);

        switch (action) {
            case "/product/add":
                productDao.add(product);
                break;
            case "/product/edit":
                productDao.edit(product);
                break;
            default:
                break;
        }

		resp.sendRedirect(req.getContextPath() + "/product");
	}
}
