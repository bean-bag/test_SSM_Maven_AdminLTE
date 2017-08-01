package com.fang.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fang.dao.historyMapper;
import com.fang.dao.peopleMapper;
import com.fang.domain.dataTable;
import com.fang.domain.history;
import com.fang.domain.historyJson;
import com.fang.domain.people;

@RestController
@RequestMapping("/mvc")
public class RestContorl {
	@Autowired
	private peopleMapper peoplemapper;
	@Autowired
	private historyMapper historymapper;
	private final static Logger LOG = Logger.getLogger("RestContorl");

	// 注册时异步验证用户名是否已存在
	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public void checkUsername(HttpServletResponse resp,
			@RequestParam(value = "username", required = true) String name) {
		people p = peoplemapper.selectByUsername(name);
		StringBuilder sb = new StringBuilder();
		resp.setContentType("text/json");
		if (p != null) {
			sb.append("{\"result\":\"exist\"}");
		} else {
			sb.append("{\"result\": \"no-exist\"}");
		}
		try {
			resp.getWriter().append(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.warning(e.getMessage());
			e.printStackTrace();
		}
	}

	// 注册功能
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse resp) {
		people p = new people();
		p.setUsername((String) request.getParameter("username"));
		p.setPassword((String) request.getParameter("password"));
		p.setPhone((String) request.getParameter("phone"));
		try {
			if (peoplemapper.selectByUsername(p.getUsername()) == null) {
				// 插入此条信息 并跳转至主页面
				peoplemapper.insert(p);
				request.getSession().setAttribute("user", p);
				resp.sendRedirect(request.getContextPath() + "/index.html");

			} else {
				// 跳转回登陆页面
				resp.sendRedirect(request.getContextPath() + "/register.html");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.warning(e.getMessage());
		}
	}

	// 登陆功能
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		people p = peoplemapper.selectByUsername(username);
		try {
			if (p != null) {
				if (p.getPassword().equals(password)) {
					// 登陆成功 跳转至主页面
					request.getSession().setAttribute("user", p);
					response.sendRedirect(request.getContextPath() + "/index.html");
					return;
				}
			}
			// 登陆失败 跳转回登陆界面
			response.sendRedirect(request.getContextPath() + "/login.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.warning(e.getMessage());
		} // 主页地址
	}

	// 异步查表功能
	@RequestMapping(value = "/table", method = RequestMethod.GET)
	@ResponseBody
	public historyJson GetTable(HttpServletRequest request, HttpServletResponse response) {
		int draw;// 返回的draw
		List<history> hL = null;// 交易记录集合
		dataTable dt = new dataTable();// table排序类
		historyJson hj = new historyJson();// 返回的json数据
		people p = (people) request.getSession().getAttribute("user");// 当前用户
		String[] colcumns = { "id", "customerid", "deliveryid", "ordertime", "reachtime", "prizeid" };
		// 遍历器
		Enumeration<?> enum_ = request.getParameterNames();

		while (enum_.hasMoreElements()) {
			String name = (String) enum_.nextElement();
			System.out.println(name + ":" + request.getParameter(name));
		}

		// 空值验证
		if (request.getParameter("draw") == null)
			draw = 1;
		else
			draw = Integer.parseInt(request.getParameter("draw"));
		if (request.getParameter("length") == null)// 记录长度
			dt.setLength(10);
		else
			dt.setLength(Integer.parseInt(request.getParameter("length")));
		if (request.getParameter("start") == null)// 起始记录
			dt.setStart(0);
		else
			dt.setStart(Integer.parseInt(request.getParameter("start")));
		if (request.getParameter("order[0][column]") == null)// 哪一列需要排序
			dt.setColcumnTable("id");
		else
			dt.setColcumnTable(colcumns[Integer.valueOf(request.getParameter("order[0][column]"))]);
		if (request.getParameter("order[0][dir]") == null)// 排序方式
			dt.setSort("asc");
		else
			dt.setSort(request.getParameter("order[0][dir]"));
		if (p == null)// 若无people则强转至登录页面
		{
			System.out.println("people不存在");
		} else {
			// ID查询条件
			dt.setUserID(p.getId());
			// 获得所有记录的数量
			hj.setRecordsTotal(historymapper.countResult(p.getId()));
			hj.setRecordsFiltered(hj.getRecordsTotal());
		}
		// 获得用户交易的信息
		hL = historymapper.selectByTable(dt);
		hj.setDraw(draw);
		hj.setData(hL);
		// System.out.println(dt.toString());
		return hj;
	}

	@RequestMapping(value = "/name", method = RequestMethod.GET)
	@ResponseBody
	public people GetTable(HttpServletRequest request) {
		people p = (people) request.getSession().getAttribute("user");
		p.setPassword("");
		System.out.println(((people) request.getSession().getAttribute("user")).getPassword());
		return p;
	}
}
