package com.hanwha.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hanwha.model.DeptDAO_Mybatis;
import com.hanwha.model.DeptDTO;
import com.hanwha.model.EmpDAO_Mybatis;
import com.hanwha.model.EmpService;
import com.hanwha.model.EmpVO;

//�� ��Ʈ�ѷ��߶�� �˷���
@Controller
public class MyController {

	// DeptDAO dao = new DeptDAO(); ���� Spring�� �ֱ�
	@Autowired
	DeptDAO_Mybatis dao;
	// DeptDAO dao;

	@Autowired
	EmpDAO_Mybatis e_dao;
	// EmpDAO e_dao;

	@Autowired
	EmpService service;

	@RequestMapping("/404")
	public String error404(Model model) {
		model.addAttribute("company", "Hanwha ICT");
		model.addAttribute("manager", "Smith");
		return "error404";
	}

	/*
	 * @RequestMapping("/500") public String error500(Model model) {
	 * model.addAttribute("company", "Hanwha ICT"); model.addAttribute("manager",
	 * "Smith"); model.addAttribute("phone", "010-1234-1234"); return "error500"; }
	 */

	@ExceptionHandler(Exception.class)
	public String error500(Exception ex, Model model) {
		model.addAttribute("company", "Hanwha ICT");
		model.addAttribute("manager", "Smith");
		model.addAttribute("phone", "010-1234-1234");
		model.addAttribute("errormessage", ex.getMessage());
		return "error500";
	}

	// ���� ��ü ��ȸ
	@RequestMapping("/emp/emplist")
	public String selectAll(Model model) {
		model.addAttribute("emplist", e_dao.selectAll());
		return "emp/emplist";
	}

	// �����߰�
	@RequestMapping(value = "emp/empinsert", method = RequestMethod.GET)
	public ModelAndView empInsertGet() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("managerlist", e_dao.selectAllManager());
		mv.addObject("deptlist", dao.selectAll());

		return mv;
	}

	@RequestMapping(value = "emp/empinsert", method = RequestMethod.POST)
	public String empInsertPost(EmpVO emp) {
		e_dao.insertEmp(emp);
		return "redirect:emplist";

	}

	// ���� ����ȸ
	@RequestMapping(value = "/emp/empdetail", method = RequestMethod.GET)
	public ModelAndView empSelectDetail(Integer empid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("emp", service.selectById(empid));
		mv.addObject("managerlist", service.selectAllManager());
		mv.addObject("joblist", service.selectAllJob());
		mv.addObject("deptlist", dao.selectAll());
		mv.setViewName("emp/empdetail");
		return mv;
	}

	@RequestMapping(value = "/emp/empdetail", method = RequestMethod.POST)
	public String empUpdate(EmpVO emp) {

		service.updateEmp(emp);

		return "redirect:emplist";
	}

	// ���� ����
	@RequestMapping(value = "/emp/empdelete", method = RequestMethod.GET)
	public String empDeletePost(int empid) {
		service.deleteEmp(empid);
		return "redirect:emplist";

	}

	@RequestMapping("/dept/deptlist") // ��û�� �ּ��� �̸�; myapp/dept/deptlist
	// �μ� ����Ʈ ���� ��ȸ
	public String deptlist3(Model model) { // �޼ҵ� �̸��� ��� ����. ������ϻ�

		model.addAttribute("deptlist", dao.selectAll());
		return "dept/deptlist"; // dept.deptlist.jsp
	}

	// �߰�
	@RequestMapping(value = "/dept/deptinsert", method = RequestMethod.GET)
	public String deptInsertGet() {

		return "dept/deptinsert";
	}

	@RequestMapping(value = "/dept/deptinsert", method = RequestMethod.POST)
	public String deptdetailPost(DeptDTO dept,  HttpServletRequest request) {
		
		System.out.println(dept);
		MultipartFile uploadfile = dept.getUploadfile();
		
		
		if (uploadfile == null) {
			return "redirect:deptinsert";
		}
		System.out.println("����");
		// ���� ��� ������
		String path = request.getSession().getServletContext().getRealPath("/resources");
		System.out.println("������ ���� ���" + path);

		String fileName = uploadfile.getOriginalFilename();
		String fpath = path + "\\" + fileName;
		dept.setFileName(fileName);

		try {
			File file = new File(fpath);
			uploadfile.transferTo(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dao.insertDept(dept);
		return "redirect:deptlist";

	}

	@RequestMapping("/dept/deptdownload")
	public void download(String folder, String file, HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setHeader("Content-Disposition", "attachment;filename=" + file);
		String fullPath = request.getSession().getServletContext().getRealPath(folder + "/" + file);
		FileInputStream fi = new FileInputStream(fullPath);
		ServletOutputStream sout = response.getOutputStream();
		byte[] buf = new byte[1024];
		int size = 0;
		while ((size = fi.read(buf, 0, 1024)) != -1) {
			sout.write(buf, 0, size);
		}
		fi.close();
		sout.close();
	}

	// ����
	@RequestMapping(value = "/dept/deptdetail", method = RequestMethod.GET)
	public String deptDetailGet(int deptid, Model model) {
		model.addAttribute("dept", dao.selectById(deptid));
		return "dept/deptdetail";

	}

	@RequestMapping(value = "/dept/deptdetail", method = RequestMethod.POST)
	public String deptDetailPost(DeptDTO dept) {
		dao.updateDept(dept);
		return "redirect:deptlist";

	}

	// ����
	@RequestMapping(value = "dept/deptdelete", method = RequestMethod.GET)
	public String deptDeletePost(int deptid) {
		dao.deleteDept(deptid);
		return "redirect:/dept/deptlist";

	}

}
